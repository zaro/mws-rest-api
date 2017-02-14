package co.amasel.client.misc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zaro on 11/24/15.
 */
public class BeanAccess {
    public static Object callMethod(Object bean, String methodName, Object... args){
        Method method = null;
        try {
            method = bean.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
        Object  o = null;
        try {
            o = method.invoke(bean, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return o;
    }
    public static boolean hasMethod(Object bean, String methodName){
        Method method = null;
        try {
            method = bean.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            return false;
        }
        return method != null;
    }

    public static boolean hasMethod(Class beanClass, String methodName){
        Method method = null;
        try {
            method = beanClass.getMethod(methodName);
        } catch (NoSuchMethodException e) {
            return false;
        }
        return method != null;
    }

    public static Object getProperty(Object bean, String property){
        return callMethod(bean, "get" + property);
    }
    public static boolean hasProperty(Object bean, String property){
        return hasMethod(bean, "get" + property);
    }

    public static Object setProperty(Object bean, String property, Object value){
        return callMethod(bean, "get" + property, value);
    }
}
