package com.austin.sengine.util;

/**
 * Created by Austin.Wang on 10/15/2014.
 */
public class ValidationUtil
{
    public static boolean isEmptyString(String str)
    {
        boolean result = false;
        if (null == str || "".equals(str.trim()))
        {
            result = true;
        }
        return result;
    }
}
