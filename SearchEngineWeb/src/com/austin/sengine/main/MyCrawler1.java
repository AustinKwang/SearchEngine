package com.austin.sengine.main;

import com.austin.sengine.file.DownLoadFile;
import com.austin.sengine.file.HtmlParserTool;
import com.austin.sengine.file.LinkFilter;
import com.austin.sengine.internet.VisitedURLQueue;

import java.util.Set;

/**
 * Created by Austin.Wang on 10/16/2014.
 */
public class MyCrawler1
{
    /**
     *
     * @param seeds
     */
    private void initCrawlerWithSeeds(String[] seeds)
    {
        for(String seed : seeds)
        {
            VisitedURLQueue.addUnVisitedUrl(seed);
        }
    }


    /**
     * 抓取过程
     * @param seeds
     */
    public void crawling(String[] seeds)
    {
        //定义过滤器，提取以 http://www.lietu.com 开头的链接
        LinkFilter filter = new LinkFilter(){
            public boolean accept(String url) {
                if(url.startsWith("http://www.baidu.com"))
                    return true;
                else
                    return false;
            }
        };
        //初始化 URL 队列
        initCrawlerWithSeeds(seeds);
        //循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while(!VisitedURLQueue.unVisitedUrlsEmpty()
                &&VisitedURLQueue.getVisitedUrlNum()<=1000)
        {
            //队头 URL 出队列
            String visitUrl=(String)VisitedURLQueue.unVisitedUrlDeQueue();
            if(visitUrl==null)
                continue;
            DownLoadFile downLoader=new DownLoadFile();
            //下载网页
            downLoader.downloadFile(visitUrl);
            //该 URL 放入已访问的 URL 中
            VisitedURLQueue.addVisitedUrl(visitUrl);
            //提取出下载网页中的 URL
            Set<String> links= HtmlParserTool.extracLinks(visitUrl, filter);
                //新的未访问的 URL 入队
            for(String link:links)
            {
                VisitedURLQueue.addUnVisitedUrl(link);
            }
        }
    }

    public static void main(String[] args)
    {
        MyCrawler1 myCrawler = new MyCrawler1();
        myCrawler.crawling(new String[]{"www.baidu.com"});
    }
}
