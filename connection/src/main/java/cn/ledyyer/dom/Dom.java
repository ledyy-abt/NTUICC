package cn.ledyyer.dom;

import cn.ledyyer.config.ConnectionConfig;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class Dom {

    public static ConnectionConfig ReadConfig() throws ParserConfigurationException, IOException, SAXException {
        ConnectionConfig connectionConfig = new ConnectionConfig();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();

        String root = System.getProperty("user.dir");//项目根目录
        Document doc = db.parse(root+"/config/Connection.xml");

        NodeList nl = doc.getElementsByTagName("connection");

        for (int i = 0; i < nl.getLength(); i++) {

            Node node = nl.item(i);
            Element element = (Element) node;


            String userAccount = element.getElementsByTagName("userAccount").item(0).getTextContent();
            connectionConfig.setUser_account(userAccount);

            String password = element.getElementsByTagName("password").item(0).getTextContent();
            connectionConfig.setPassword(password);

            Integer operators = Integer.valueOf(element.getElementsByTagName("operators").item(0).getTextContent());
            connectionConfig.setOperators(operators);

        }

        return connectionConfig;
    }
}
