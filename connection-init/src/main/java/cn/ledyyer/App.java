package cn.ledyyer;

import cn.ledyyer.init.InitConfigFile;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        InitConfigFile.createFile();
        InitConfigFile.createStartServiceFile();
        InitConfigFile.createCloseServiceFile();
        InitConfigFile.createClientFile();
        InitConfigFile.createLogFile();
    }
}
