package cn.ledyyer.service;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Connection {
    private static String res = null;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void getConnectionService(String url,String filePath) throws IOException {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file,true);


        res = HttpUtil.get("http://www.baidu.com");
        if (res.length()==0){

            HttpResponse response = HttpRequest.get("http://2.2.2.2/?isReback=1").execute();
            String IpStr = response.header("Location");
            String ipAddress = IpStr.split("=")[1].split("&")[0];
            url = url.replace("IPADDRESS",ipAddress);


            HttpUtil.get(url);
            Calendar calConnection = Calendar.getInstance();
            System.out.println(calConnection.get(Calendar.YEAR)+"年"+(calConnection.get(Calendar.MONTH)+1)+"月"+calConnection.get(Calendar.DATE)+"日"+" "+calConnection.get(Calendar.HOUR_OF_DAY)+":"+calConnection.get(Calendar.MINUTE)+":"+calConnection.get(Calendar.SECOND)+" 连接中...");
            fileWriter.write(calConnection.get(Calendar.YEAR)+"年"+(calConnection.get(Calendar.MONTH)+1)+"月"+calConnection.get(Calendar.DATE)+"日"+" "+calConnection.get(Calendar.HOUR_OF_DAY)+":"+calConnection.get(Calendar.MINUTE)+":"+calConnection.get(Calendar.SECOND)+" 连接中...\n");
            fileWriter.flush();

            res = HttpUtil.get("http://www.baidu.com");
            if (res.length()!=0){
                Calendar calSuccess = Calendar.getInstance();
                System.out.println(calSuccess.get(Calendar.YEAR)+"年"+(calSuccess.get(Calendar.MONTH)+1)+"月"+calSuccess.get(Calendar.DATE)+"日"+" "+calSuccess.get(Calendar.HOUR_OF_DAY)+":"+calSuccess.get(Calendar.MINUTE)+":"+calSuccess.get(Calendar.SECOND)+" 连接成功！");
                fileWriter.write(calConnection.get(Calendar.YEAR)+"年"+(calConnection.get(Calendar.MONTH)+1)+"月"+calConnection.get(Calendar.DATE)+"日"+" "+calConnection.get(Calendar.HOUR_OF_DAY)+":"+calConnection.get(Calendar.MINUTE)+":"+calConnection.get(Calendar.SECOND)+" 连接成功！\n");
                fileWriter.flush();
                fileWriter.close();
            }else {
                Calendar claError = Calendar.getInstance();
                System.out.println(claError.get(Calendar.YEAR)+"年"+(claError.get(Calendar.MONTH)+1)+"月"+claError.get(Calendar.DATE)+"日"+" "+claError.get(Calendar.HOUR_OF_DAY)+":"+claError.get(Calendar.MINUTE)+":"+claError.get(Calendar.SECOND)+" 连接失败，请手动连接！");
                fileWriter.write(calConnection.get(Calendar.YEAR)+"年"+(calConnection.get(Calendar.MONTH)+1)+"月"+calConnection.get(Calendar.DATE)+"日"+" "+calConnection.get(Calendar.HOUR_OF_DAY)+":"+calConnection.get(Calendar.MINUTE)+":"+calConnection.get(Calendar.SECOND)+" 连接失败，请手动连接！\n");
                fileWriter.flush();
                fileWriter.close();
            }
        }
    }
}
