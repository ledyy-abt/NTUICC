package cn.ledyyer.config;

public class ConnectionConfig {
    private String user_account;//账户
    private String password;//密码
    private Integer Operators;//运营商
    private String ip;//本地Ip
    private Boolean route;//是否使用路由器

    public ConnectionConfig(){}

    public ConnectionConfig(String user_account, String password, Integer operators, String ip, Boolean route) {
        this.user_account = user_account;
        this.password = password;
        Operators = operators;
        this.ip = ip;
        this.route = route;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getOperators() {
        return Operators;
    }

    public void setOperators(Integer operators) {
        Operators = operators;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Boolean getRoute() {
        return route;
    }

    public void setRoute(Boolean route) {
        this.route = route;
    }
}
