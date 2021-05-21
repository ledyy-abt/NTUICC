package cn.ledyyer;


import cn.ledyyer.config.ConnectionConfig;
import cn.ledyyer.dom.Dom;
import cn.ledyyer.service.Connection;
import cn.ledyyer.service.ConnectionFactory;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

        File file  = new File(System.getProperty("user.dir")+File.separator+"temp");
        String root = System.getProperty("user.dir");//项目根目录
        String filePath = root+"/log/ConnectionLog.txt";

        ConnectionConfig config = Dom.ReadConfig();
        String url = ConnectionFactory.newConnectionUrl(config);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    Connection.getConnectionService(url,filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Calendar calendar = Calendar.getInstance();
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(task, firstTime, 1*1000);
    }
}
