package co.amasel.codegen

import org.jboss.forge.roaster.Roaster
import org.jboss.forge.roaster.model.JavaType
import org.jboss.forge.roaster.model.source.JavaClassSource

import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlType
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by zaro on 11/24/15.
 */
class Codegen {
    static def mwsSourcesDir

    Codegen() {
    }

    static def getPackageConfig(String className) {
        def cls = ClassEnumerator.loadClass(className);
        def cfg = cls.newInstance()
        String serviceVersion = cfg.getServiceVersion()
        String servicePath = ""
        cfg.setServiceURL("https://mws.amazonservices.co.uk");
        try {
            URI endPoint = new URI(cfg.getServiceURL());
            // No leading '/' in path, fucks up MwsConnection later
            servicePath = endPoint.getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        if (servicePath.isEmpty()) {
            servicePath = "/";
        }
        return [
                servicePath   : servicePath,
                serviceVersion: serviceVersion
        ]
    }

    static def getSourceFileForClass(Class<?> cls, String srcDir) {
        return new File(new File(mwsSourcesDir, srcDir), cls.getName().replaceAll("\\.", "/") + ".java");
    }


    static def addMethods(JavaClassSource javaC, templateMethodMap, binding) {
        javaC.setSuperType("AmaselMwsObject")
        for (e in templateMethodMap) {
            def method = e.key
            def templateDef = e.value
            if (templateDef == null) continue
            if (templateDef.makePublic) {
                if (!javaC.hasMethodSignature(method, templateDef.args.toArray(new String[templateDef.args.size()]))) continue
                def mm = javaC.getMethod(method, templateDef.args.toArray(new String[templateDef.args.size()]))
                mm.setPublic()
                continue
            }
            def template = new groovy.text.StreamingTemplateEngine().createTemplate(templateDef.template)
            if (templateDef.field) {
                if (javaC.hasField(method)) continue
                String t = template.make(binding)
                javaC.addField(t)
            } else {
                if (javaC.hasMethodSignature(method, templateDef.args.toArray(new String[templateDef.args.size()]))) continue
                String t = template.make(binding)
                String methodArgs = "()"
                if (templateDef.args.size() > 0) {
                    methodArgs = "(" + ((0..<templateDef.args.size).collect {
                        templateDef.args[it] + " " + templateDef.argsName[it] + " "
                    }).join(",") + ")"
                }
                String methodSource = "public " + templateDef.returns + " " + method + methodArgs + " {\n" + t + "}"
                //println(methodSource)
                javaC.addMethod(methodSource)
            }


        }
    }

    static void main(String[] args) {

        if(args.length < 2) {
            println( "Use like this : ")
            println( " amasel-codegen mws_lib_sources output_dir ")
            System.exit(1)
        }

        mwsSourcesDir = args[0]
        def outDir = args[1]
        println("mwsSourcesDir:" + mwsSourcesDir)
        println("outDir:" + outDir)

        def dir = new File(outDir)
        dir.mkdirs()
        def packNames = [
                'amazon-mws-feeds-reports': [
                        model       : "com.amazonaws.mws.model",
                        templateName: "feeds_reports",
                        outputModel : { String className ->
                            if (className.indexOf("Feed") >= 0) {
                                return ["feeds"];
                            }
                            if (className.indexOf("Report") >= 0) {
                                return ["reports"];
                            }
                            return ["feeds", "reports"];
                        },
                        configClass : "com.amazonaws.mws.MarketplaceWebServiceConfig",
                        srcDir      : "amazon-mws-feeds-reports/src/",
                ],
                'amazon-mws-products'     : [
                         model      : "com.amazonservices.mws.products.model",
                         outputModel: "products",
                         configClass: "com.amazonservices.mws.products.MarketplaceWebServiceProductsConfig",
                         srcDir     : "amazon-mws-products/src/",
                 ],
                 'amazon-mws-orders'       : [
                         model      : "com.amazonservices.mws.orders._2013_09_01.model",
                         outputModel: "orders",
                         configClass: "com.amazonservices.mws.orders._2013_09_01.MarketplaceWebServiceOrdersConfig",
                         srcDir     : "amazon-mws-orders/src/",
                 ],
                 "amazon-mws-sellers"      : [
                         model      : "com.amazonservices.mws.sellers.model",
                         outputModel: "sellers",
                         configClass: "com.amazonservices.mws.sellers.MarketplaceWebServiceSellersConfig",
                         srcDir     : "amazon-mws-sellers/src/",
                 ],
                "amazon-mws-recommendations"      : [
                        model      : "com.amazonservices.mws.recommendations.model",
                        outputModel: "recommendations",
                        configClass: "com.amazonservices.mws.recommendations.MarketplaceWebServiceSellersConfig",
                        srcDir     : "amazon-mws-recommendations/src/",
                ],
        ]
        for (url in ClassEnumerator.getClassPath()) {
            def fileName = url.getPath().split('/')[-1]
            for (pack in packNames) {
                //println("Test: " + fileName)
                if (fileName.startsWith(pack.key)) {
                    println("Procesing: " + fileName)
                    def sourcePackageName = pack.value.model
                    def javaSourcesDir = pack.value.srcDir
                    def reqRespMap = [:]
                    def modelName = pack.value.outputModel
                    def outModelNamesFun = null
                    if (pack.value.outputModel instanceof Closure) {
                        modelName = pack.value.templateName
                        outModelNamesFun = pack.value.outputModel
                    }

                    def templateMethodMap = ModelTemplate.get(modelName)


                    for (cls in ClassEnumerator.processJarfile(url, sourcePackageName)) {
//                        if (cls.isInterface() || cls.isEnum()) {
//                            continue
//                        }
                        if (["package-info", "MWSResponse", "FeedProcessingStatus", "ResponseMetadata", "ResponseHeaderMetadata", "ObjectFactory", "ProductsUtil"].contains(cls.getSimpleName()) || cls.getName().contains('$')) {
                            continue
                        }
                        def classSimpleName = cls.getSimpleName()
                        String methodName = null
                        if (classSimpleName.endsWith("Request") || classSimpleName.endsWith("Response")) {
                            methodName = classSimpleName.replaceAll("Request\$|Response\$", "")
                        }
                        XmlType[] xmlTypes = cls.getAnnotationsByType(XmlType)
                        def props = []
                        if (xmlTypes.length) {
                            def xmlElementTypeName = xmlTypes[0].name()
                            for (property in xmlTypes[0].propOrder()) {
                                if (property.length() == 0)
                                    continue
                                def field = cls.getDeclaredField(property)
                                def elementName = property
                                def attirbute = false
                                Type parameterizedType = field.getGenericType();
                                String pType = null
                                String pTypeSimple = null
                                if (parameterizedType != null && parameterizedType instanceof ParameterizedType) {
                                    pType = ((ParameterizedType) parameterizedType).getActualTypeArguments()[0].getTypeName()
                                    def l = pType.split("\\.")
                                    pTypeSimple = l[l.length - 1]
                                }

                                XmlElement[] elementAnnotations = field.getAnnotationsByType(XmlElement)
                                if (elementAnnotations.length) {
                                    elementName = elementAnnotations[0].name()
                                }
                                XmlAttribute[] attributeAnnotations = field.getAnnotationsByType(XmlAttribute)
                                if (attributeAnnotations.length) {
                                    attirbute = true
                                    if (attributeAnnotations[0].name())
                                        elementName = attributeAnnotations[0].name()
                                }
                                if (field.getType().getSimpleName().endsWith("Stream")) {
                                    continue
                                }
                                props.push([
                                        type       : field.getType().getSimpleName(),
                                        name       : property,
                                        elementName: elementName,
                                        attribute  : attirbute,
                                        enum       : field.getDeclaringClass().isEnum(),
                                        pType      : pType,
                                        pTypeSimple: pTypeSimple
                                ])
                            }
                        }


                        def outModelNames;
                        if (outModelNamesFun != null) {
                            outModelNames = outModelNamesFun(cls.getSimpleName())
                        } else {
                            outModelNames = [modelName]
                        }
                        for (outModelName in outModelNames) {
                            if (!reqRespMap.containsKey(outModelName)) {
                                reqRespMap[outModelName] = [:]
                            }
                            if (methodName) {
                                reqRespMap[outModelName][methodName] = 1 + (reqRespMap[outModelName][methodName] ? reqRespMap[outModelName][methodName] : 0)
                            }
                            def binding = [
                                    packageName      : 'co.amasel.model.' + outModelName,
                                    sourcePackageName: sourcePackageName,
                                    fullClassName    : cls.getName(),
                                    className        : cls.getSimpleName(),
                                    props            : props
                            ]

                            def modelDir = new File(new File(dir, "model"), outModelName)
                            modelDir.mkdirs()
                            def outFile = new File(modelDir, cls.getSimpleName() + ".java")
                            // Modify source class
                            File javaSourceFile = getSourceFileForClass(cls, javaSourcesDir)
                            String javaSource = javaSourceFile.text
                            println javaSourceFile
                            javaSource = javaSource.replaceAll("(?s)" + cls.getName() + "\\s*\\[.*\\]\\s*\\n", "")
                            def javaClass = Roaster.parse(javaSource);
                            javaClass.addImport("co.amasel.model.common.AmaselMwsObject")
                            javaClass.addImport("co.amasel.model.common.ResponseHeaderMetadata")
                            javaClass.addImport("co.amasel.model.common.ResponseMetadata")
                            javaClass.addImport("com.amazonservices.mws.client.MwsReader")
                            javaClass.addImport("com.amazonservices.mws.client.MwsWriter")
                            javaClass.addImport("com.amazonservices.mws.client.MwsResponseHeaderMetadata")

                            if (javaClass.hasInterface("MWSResponse")) {
                                javaClass.removeInterface("MWSResponse")
                            }

                            javaClass.setPackage(binding.packageName)
                            if (javaClass.isClass()) {
                                JavaClassSource javaC = (JavaClassSource) javaClass
                                addMethods(javaC, templateMethodMap, binding)
                                //println javaC.getNestedTypes()
                                for (JavaType nestedType : javaC.getNestedTypes()) {
                                    if (nestedType.isClass()) {
                                        JavaClassSource nestedC = (JavaClassSource) nestedType
                                        println "Nested Class: " + nestedC.getName() + "(" + nestedC.getSuperType() + ")"
                                        if (nestedC.getSuperType().equals("com.amazonservices.mws.client.AbstractMwsObject")) {
                                            println "Changing super type"
                                            javaC.removeNestedType(nestedC)
                                            nestedC.setSuperType("AmaselMwsObject")
                                            addMethods(nestedC, templateMethodMap, binding)
                                            javaC.addNestedType(nestedC)
                                        }
                                    }
                                }
                            }

                            println "Write to:" + outFile
                            FileOutputStream out = new FileOutputStream(outFile)
                            //out.write(t.bytes)
                            out.write(javaClass.toString().bytes)
                            out.close()
                        }
                    }


                    def templateString = MethodMapTemplate.get(modelName)
                    def template = new groovy.text.StreamingTemplateEngine().createTemplate(templateString)
                    for (clientModelName in reqRespMap.keySet()) {
                        def apiMethods = []
                        println("--- Generating model " + clientModelName + "---")
                        reqRespMap[clientModelName].each { k, v ->
                            if (v != 2) {
                                println "Mismatched req/res : " + k + "  : " + v
                                return
                            }
                            apiMethods.push([methodName: k])
                        }

                        def modelDir = new File(new File(dir, "client"), clientModelName)
                        modelDir.mkdirs()
                        def outFile = new File(modelDir, "MethodMap.java")
                        FileOutputStream out = new FileOutputStream(outFile)
                        String t = template.make([
                                packageName      : 'co.amasel.client.' + clientModelName,
                                modelPackage     : 'co.amasel.model.' + clientModelName + '.*',
                                sourcePackageName: sourcePackageName,
                                apiMethods       : apiMethods
                        ] << getPackageConfig(pack.value.configClass))
                        out.write(t.bytes)
                        out.close()

                        println("--- Generating client " + clientModelName + "---")
                        def clientTemplateString = ClientTemplate.get(modelName)
                        def clientTemplate = new groovy.text.StreamingTemplateEngine().createTemplate(clientTemplateString)
                        for (method in apiMethods) {
                            outFile = new File(modelDir, method.methodName + ".java")
                            out = new FileOutputStream(outFile)
                            t = clientTemplate.make([
                                    packageName : 'co.amasel.client.' + clientModelName,
                                    modelPackage: 'co.amasel.model.' + clientModelName + '.*',
                                    className   : method.methodName,
                            ] << getPackageConfig(pack.value.configClass))
                            out.write(t.bytes)
                            out.close()
                        }

                    }
                }
            }

        }

        //println ClassLoader.forName(pack + ".Error").getPackage().getMetaClass()

    }
}