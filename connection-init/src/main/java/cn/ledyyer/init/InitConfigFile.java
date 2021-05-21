package cn.ledyyer.init;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InitConfigFile {
    public static void createFile() throws IOException {
        File file  = new File(System.getProperty("user.dir")+File.separator+"temp");
        String root = System.getProperty("user.dir");//项目根目录
        new File(root+"/config").mkdirs();
        File configFile = new File(root+"/config","Connection.xml.example");
        configFile.createNewFile();
        FileWriter fileWriter = new FileWriter(configFile);
        fileWriter.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<connectionConfig>\n" +
                "    <connection>\n" +
                "        <userAccount>USERACCOUNT</userAccount>\n" +
                "\n" +
                "        <password>PASSWORD</password>\n" +
                "\n" +
                "        <operators>1</operators>\n" +
                "    </connection>\n" +
                "</connectionConfig>");
        fileWriter.flush();
        fileWriter.close();
    }

    public static void createStartServiceFile() throws IOException {
        File file  = new File(System.getProperty("user.dir")+File.separator+"temp");

        String root = System.getProperty("user.dir");//项目根目录
        File configFile = new File(root,"ntuConnectionService-start.bat");
        configFile.createNewFile();

        FileWriter fileWriter = new FileWriter(configFile);
        fileWriter.write("@echo off \n" +
                "START \"ntuConnectionService\" javaw -jar connection-1.0.0.jar");
        fileWriter.flush();
        fileWriter.close();
    }

    public static void createCloseServiceFile() throws IOException {
        File file  = new File(System.getProperty("user.dir")+File.separator+"temp");

        String root = System.getProperty("user.dir");//项目根目录
        File configFile = new File(root,"ntuConnectionService-stop.bat");
        configFile.createNewFile();

        FileWriter fileWriter = new FileWriter(configFile);
        fileWriter.write("@echo off \n" +
                "taskkill /f /im javaw.exe\n" +
                "exit");
        fileWriter.flush();
        fileWriter.close();
    }

    public static void createClientFile() throws IOException {
        File file  = new File(System.getProperty("user.dir")+File.separator+"temp");

        String root = System.getProperty("user.dir");//项目根目录
        File configFile = new File(root,"ntuConnectionClient.bat");
        configFile.createNewFile();

        FileWriter fileWriter = new FileWriter(configFile);
        fileWriter.write("java -jar connection-1.0.0.jar");
        fileWriter.flush();
        fileWriter.close();
    }

    public static void createLogFile() throws IOException {
        File file  = new File(System.getProperty("user.dir")+File.separator+"temp");

        String root = System.getProperty("user.dir");//项目根目录
        new File(root+"/log").mkdirs();
        File configFile = new File(root+"/log","ConnectionLog.txt");
        configFile.createNewFile();
    }
}
