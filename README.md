# springboot整合lcn

#### 项目介绍
该项目是由springboot整合lcn 项目demo，此项目由meite-shop-parent项目和lcn项目组成。

   
#### 软件架构
该项目由结构图如下，
-------meite-shop-parent                           项目父工程
----------meite-shop-basics                        项目基础服务模块父工程
-------------meite-shop-basics-springcloud-eureka  注册中心服务
-------------meite-shop-basics-springcloud-auul    网关服务
----------meite-shop-common                        项目通用服务模块(常量、错误信息封装等)
----------meite-shop-service-api                   项目接口服务模块父工程
-------------meite-shop-service-api-member         会员接口服务
-------------meite-shop-service-api-order          订单接口服务
-------------meite-shop-service-api-stock          库存接口服务
----------meite-shop-service                       项目接口实现类服务模块父工程
-------------meite-shop-service-member             会员接口实现类服务
-------------meite-shop-service-order              订单接口实现类服务
-------------meite-shop-service-stock              库存接口实现类服务

---------tx-lcn  lcn父工程
------------transaction-springcloud  springcloud整合lcn demo
------------transaction-dubbo        dubbo整合lcn demo
------------transaction-motan        motan整合lcn demo
------------tx-client                lcn 客户端
------------tx-manager               lcn 管理模块
------------tx-plugins-db            lcn 整合数据库模块
详细的lcn 项目结构请以github 为主。
lcn官网：http://www.txlcn.org/zh-cn/  
lcn github网址：https://github.com/codingapi/tx-lcn 

#### 安装教程以及使用说明

1. 通过码云下载项目meite-shop-parent、lcn二个项目，然后通过idea 将2个项目导入。
2. 将lcn项目中的tx-client模块、tx-manager模块、tx-plugins模块分别 打成jar包到自己的本地maven仓库中，否则后边项目启动会出错。
3. 修改 tx-manager 项目下的 application.properties 文件，修改对应的redis相关的配置信息。
4. 首先启动 eureka注册中心，然后启动 tx-manager 服务，在对应的启动订单服务、库存服务。

eureka启动成功，访问 http://127.0.0.1:8080/。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0413/201734_36ad8f1b_1729730.png "屏幕截图.png")
tx-manager启动成功之后，访问 http://127.0.0.1:8899/ 
![输入图片说明](https://images.gitee.com/uploads/images/2019/0413/201754_00bd4cc1_1729730.png "屏幕截图.png")
#### 参与贡献

1. lcn官网：http://www.txlcn.org/zh-cn/  
2. lcn github网址：https://github.com/codingapi/tx-lcn 
3. 蚂蚁课堂 http://www.mayikt.com/