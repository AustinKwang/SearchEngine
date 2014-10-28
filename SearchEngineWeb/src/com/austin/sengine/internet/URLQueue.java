package com.austin.sengine.internet;

import java.util.LinkedList;

/**
 * Created by Austin.Wang on 10/9/2014.
 */
public class URLQueue
{
    private LinkedList<String> urlQueue = new LinkedList<String>();

    /**
     * Add url to current queue
     * */
    public void enQueue(String url)
    {
        urlQueue.add(url);
    }

    /**
     * Remove from url Queue
     * */
    public Object deQueue()
    {
        return urlQueue.removeFirst();
    }

    //判断队列是否为空
    public boolean isQueueEmpty()
    {
        return urlQueue.isEmpty();
    }



    /**
     * 判断队列是否包含
     * @param t
     * @return
     */
    public boolean contians(Object t)
    {
        return urlQueue.contains(t);
    }

    /**
     * 判断当前是否包含Url
     * @return
     */
    public boolean empty()
    {
        return urlQueue.isEmpty();
    }
}
