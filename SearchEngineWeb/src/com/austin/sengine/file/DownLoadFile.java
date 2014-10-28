package com.austin.sengine.file;

import com.austin.sengine.util.ValidationUtil;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 下载网页文件并处理
 * Created by Austin.Wang on 10/15/2014.
 */
public class DownLoadFile
{

    /**
     * 根据URL和网页类型生成需要保存的网页文件名
     * 去除URL中的非文件名字符串
     * @param url
     * @param contentType
     * @return
     */
    public String getFileNameUrl(String url, String contentType)
    {
        //移除字符串 HTTP://
        if(ValidationUtil.isEmptyString(url))
        {
            url = url.substring(7);
        }

        //
        if(!ValidationUtil.isEmptyString(contentType)
                && contentType.indexOf("html") != -1)
        {
            url = url.replaceAll("[\\?/:*|<>\"]", "_")+".html";
        }
        //如 application/pdf 类型
        else
        {
            url = url.replaceAll("[\\?/:*|<>\"]", "_")+"."+
                    contentType.substring(contentType.lastIndexOf("/")+1);
        }
        return url;
    }

    public String downloadFile(String url)
    {
        String filePath = null;
        //使用HTTPClient模拟HTTP请求
        HttpClient httpClient = HttpClients.createDefault();

        //设置连接超时

        //GetMethod getMethod = new GetMethod(url);
        HttpGet httpGet = new HttpGet(url);

        //执行HTTP GET请求
//        try
//        {
//          //  CloseableHttpResponse response = httpClient.execute(httpGet);
//
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "";
    }


    /**
     * 保存网页字节数组到本地文件，filePath 为要保存的文件的相对地址
     */
    private void saveToLocal(byte[] data, String filePath) {
        try {
            DataOutputStream out = new DataOutputStream(new
                    FileOutputStream(new File(filePath)));
            for (int i = 0; i < data.length; i++)
                out.write(data[i]);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
