package com.austin.sengine.file;

import com.austin.sengine.util.ValidationUtil;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Austin.Wang on 10/15/2014.
 */
public class HtmlParserTool
{


    /**
     * 获取一个网站上的链接，filter 用来过滤链接
     * @param url
     * @return
     */
    public static Set<String> extracLinks(String url, LinkFilter filter)
    {
        Set<String> links = new HashSet<String>();

        try {
            Parser parser = new Parser();
            parser.setEncoding("utf-8");
            NodeFilter frameFilter = new NodeFilter() {
                @Override
                public boolean accept(Node node) {
                    if(node.getText().startsWith("frame src="))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            };

            // OrFilter 来设置过滤 <a> 标签和 <frame> 标签
            OrFilter orFilter = new OrFilter(new NodeClassFilter(LinkTag.class), frameFilter);

            NodeList nodeList = parser.extractAllNodesThatMatch(orFilter);
            String linkurl;
            for (int i = 0; i < nodeList.size(); i ++)
            {
                Node tag = nodeList.elementAt(i);
                if(tag instanceof LinkTag)
                {
                    LinkTag linkTag = (LinkTag)tag;
                    linkurl = linkTag.getLink();
                }
                else //ifram src=
                {
                    String frameText = tag.getText();
                    int startIndex = frameText.indexOf("src=");
                    int endIndex = frameText.indexOf(" ");
                    if(endIndex == -1)
                    {
                        endIndex = frameText.indexOf(">");
                    }
                    linkurl = frameText.substring(startIndex + 5, endIndex - 1);
                }

                if(!ValidationUtil.isEmptyString(linkurl) && filter.accept(linkurl))
                {
                    links.add(linkurl);
                }
            }

        } catch (ParserException e) {
            e.printStackTrace();
        }
        return links;
    }
}
