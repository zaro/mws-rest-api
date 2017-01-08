package co.amasel.misc;

import java.util.regex.Pattern;

/**
 * Created by zaro on 9/11/16.
 */
public class LocaleMisc {
    public static Pattern isNumber =  Pattern.compile("^\\s*-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?\\s*$");

}
