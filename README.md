# NTUICC
NTU网络自动连接插件

####  1. 插件运行环境

本插件使用`java`语言开发，所以需要在本地安装`java`

`Java`版本需求：`1.8`或更高

 <img src="https://github.com/262412-leddy/NTUICC/blob/main/picture/image-20210521135205092.png" alt="image-20210521135205092" style="zoom:80%;" />

#### 2. 使用步骤

- 解压压缩包`ntuConnectionPlugs.zip`到`Windows`系统任意位置

     ![image-20210419004324945](https://github.com/262412-leddy/NTUICC/blob/main/picture/image-20210419004324945.png)

- 打开解压文件，会有三个文件

     <img src="https://github.com/262412-leddy/NTUICC/blob/main/picture/image-20210417180209813.png" alt="image-20210417180209813"/>

* 点击`init.bat`,执行插件初始化命令

* 初始化成功后根目录会出现几个新建的文件和文件夹

     <img src="https://github.com/262412-leddy/NTUICC/blob/main/picture/image-20210417180706793.png" alt="image-20210417180706793"  />

* 打开`config`文件夹，复制一份里面的`Connection.xml.example`文件，重命名为`Connection.xml`

     <img src="https://github.com/262412-leddy/NTUICC/blob/main/picture/image-20210417180921862.png" alt="image-20210417180921862"  />

* 修改`Connection.xml`文件中的配置信息

  ``` xml
  <?xml version="1.0" encoding="utf-8" ?>
  <connectionConfig>
      <connection>
          <userAccount>USERACCOUNT</userAccount>
          <password>PASSWORD</password>
          <operators>OPERATORS</operators>
      </connection>
  </connectionConfig>
  ```
  
  下面对上述`xml`文件做出解释

  * `USERACCOUNT`，此处填写校园网的账号，即自己的学号
  
  * `PASSWORD`，此处填写密码
  * `OPERATORS`，此处填写运营商编号，1：校园网、2：中国移动、3：中国电信、4：中国联通
  
  修改完成后便可以保存退出
  
  
  
* 以上步骤完成后，点击`ntuConnectionClient`或者`ntuConnectionService-start`开启自动连接，并且以后的连接也只用这两个功能连接

   * `ntuConnectionClient`打开客户端窗口，前台运行，如果关闭窗口服务就会停止，不会监控自动重连
   * `ntuConnectionService-start`后台运行，自动连接
   * `ntuConnectionService-close`关闭后台运行的此次服务
   
    <img src="https://github.com/262412-leddy/NTUICC/blob/main/picture/image-20210419003645559.png" alt="image-20210419003645559"  />
   
   

#### 3. 配置开机自启动

* `win + R` 打开 `运行` 窗口，输入`shell:startup`，打开启动文件夹

​       ![image-20210521122013604](https://github.com/262412-leddy/NTUICC/blob/main/picture/image-20210521122013604.png)



* 将我们的自动连接启动脚本`ntuConnectionService-start.bat`创建一个快捷方式，然后复制快捷方式到刚刚用`shell:startup`打开的文件中，下次开机就会自动启动并且连接了

    <img src="https://github.com/262412-leddy/NTUICC/blob/main/picture/image-20210521122309576.png" alt="image-20210521122309576" style="zoom: 67%;" />

  
