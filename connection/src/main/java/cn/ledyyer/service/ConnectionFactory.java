package cn.ledyyer.service;

import cn.ledyyer.config.ConnectionConfig;

import java.net.UnknownHostException;

public class ConnectionFactory {

    private static String user_account;
    private static String password;
    private static String ip;

    public static String newConnectionUrl(ConnectionConfig config){

        String url = "http://210.29.79.141:801/eportal/?c=Portal&a=login&callback=dr1003&login_method=1&user_account=%s&user_password=%s&wlan_user_ip=%s&wlan_user_ipv6=&wlan_user_mac=000000000000&wlan_ac_ip=&wlan_ac_name=&jsVersion=3.3.2";

        switch (config.getOperators()){
            case 1:
                user_account = ",0,"+config.getUser_account();
                break;
            case 2:
                user_account = user_account = ",0,"+config.getUser_account()+"@cmcc";
                break;
            case 3:
                user_account = user_account = ",0,"+config.getUser_account()+"@telecom";
                break;
            case 4:
                user_account = user_account = ",0,"+config.getUser_account()+"@unicom";
                break;
        }

        password = config.getPassword();

        ip = "IPADDRESS";

        url = String.format(url, user_account,password,ip);
        return url;
    }
}
