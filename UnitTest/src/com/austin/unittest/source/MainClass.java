package com.austin.unittest.source;

/**
 * Created by Austin.Wang on 10/11/2014.
 */
public class MainClass
{
    public int add(int a, int b)
    {
        return a + b;
    }

    public int devide(int a, int b) throws Exception {
        if(b == 0)
        {
            throw new Exception("the Devide cannot as 0");
        }
        else
        {
            return a/b;
        }
    }
}
