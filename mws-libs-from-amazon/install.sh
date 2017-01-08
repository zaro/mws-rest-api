#!/bin/bash

GROUP_ID=co.amasel
LOCAL_MAVEN_DIR=`mvn help:evaluate -Dexpression=settings.localRepository | grep -v '\[INFO\]'`
UNPACKED_SOURCES_DIR=$(cd `dirname $0`; pwd)/sources/


GRADLE_DEPS=()

function install {
  ZIP_FILE=$1
  JAR_FILE=$2
  ARTIFACT_ID=$3
  ARTIFACT_VERSION=$4
  SRC_DIR=$5

  mkdir tmp/
  pushd tmp/

  unzip -o ../$ZIP_FILE $JAR_FILE

  mvn deploy:deploy-file \
    -DgroupId=$GROUP_ID \
    -DartifactId=$ARTIFACT_ID \
    -Dversion=$ARTIFACT_VERSION \
    -Dfile=$JAR_FILE \
    -Dpackaging=jar \
    "-Durl=file://$LOCAL_MAVEN_DIR"

  if [ "$SRC_DIR" ]; then
    unzip -o ../$ZIP_FILE "$SRC_DIR/*"

    jar cf src.jar -C $SRC_DIR `cd $SRC_DIR; echo *`

    mvn deploy:deploy-file \
      -DgroupId=$GROUP_ID \
      -DartifactId=$ARTIFACT_ID \
      -Dversion=$ARTIFACT_VERSION \
      -Dfile=src.jar \
      -Dpackaging=jar \
      "-Durl=file://$LOCAL_MAVEN_DIR" \
      -Dclassifier=sources

     if [ "$UNPACKED_SOURCES_DIR" ]; then
        mkdir -p "$UNPACKED_SOURCES_DIR/$ARTIFACT_ID"
        rm -r "$UNPACKED_SOURCES_DIR/$ARTIFACT_ID/src"
        mv $SRC_DIR "$UNPACKED_SOURCES_DIR/$ARTIFACT_ID/src"
     fi
  fi

  popd
  rm -r tmp/

  GRADLE_DEPS+=("$GROUP_ID:$ARTIFACT_ID:$ARTIFACT_VERSION")
}

install "amazon-mws-v20090101-java-2016-09-21._V278445245_.zip" "dist/MaWSJavaClientLibrary-1.1.jar" "amazon-mws-feeds-reports" "1.1" "src"
install "MWSOrdersJavaClientLibrary-2013-09-01._V293334172_.zip" "dist/MWSClientJavaRuntime-1.0.jar" "amazon-mws-runtime" "1.0" "runtime-src"
install "MWSOrdersJavaClientLibrary-2013-09-01._V293334172_.zip" "dist/MWSOrders_2013-09-01_v2015-09-24.jar" "amazon-mws-orders" "v2015-09-24" "src"
install "MWSProductsJavaClientLibrary-2011-10-01._V269521071_.zip" "dist/MWSProducts_2011-10-01_v2016-06-01.jar" "amazon-mws-products" "v2016-06-01" "src"
install "MWSSellersJavaClientLibrary-2011-07-01._V325005493_.zip" "dist/MWSSellers_2011-07-01_v2014-09-30.jar" "amazon-mws-sellers" "v2014-09-30" "src"
install "MWSRecommendationsJavaClientLibrary-2013-04-01._V323647919_.zip" "dist/MWSRecommendations_2013-04-01_v2014-10-01.jar" "amazon-mws-recommendations" "v2014-10-01" "src"


echo Add this to your gradle build section:
for dep in "${GRADLE_DEPS[@]}"
do
   echo "compile '$dep'"
done
