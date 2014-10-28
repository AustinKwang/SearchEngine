package com.austin.sengine.internet;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Austin.Wang on 10/15/2014.
 */
public class VisitedURLQueue
{
    /**已访问的Url集合*/
    private static Set visitedUrl = new HashSet();

    private static Queue<String> unVisiteUrl = new LinkedList<String>();

    /**
     * 获得未访问的URL队列
     * @return
     */
    public static Queue<String> getUnVisiteUrl()
    {
        return unVisiteUrl;
    }

    /**
     * 添加URL到访问过的队列中
     * @param url
     */
    public static void addVisitedUrl(String url)
    {
        visitedUrl.add(url);
    }

    /**
     * 移除访问过的URL
     * @param url
     */
    public static void removeVisitedUrl(String url)
    {
        visitedUrl.remove(url);
    }

    public static String unVisitedUrlDeQueue()
    {
        return unVisiteUrl.poll();
    }

    /**
     *保证每个URL，只被访问一次
     * @param url
     */
    public static void addUnVisitedUrl(String url)
    {
        if(url != null && !"".equals(url.trim())
                && !visitedUrl.contains(url)
                && !unVisiteUrl.contains(url))
        {
            unVisiteUrl.add(url);
        }
    }

    /**
     *  获得已经访问的URL的数目
     * @return
     */
    public static int getVisitedUrlNum()
    {
        return visitedUrl.size();
    }

    /**
     * 判断未访问的URL队列是否为空
     * @return
     */
    public static boolean unVisitedUrlsEmpty()
    {
        return unVisiteUrl.isEmpty();
    }
}

