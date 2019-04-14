# springboot整合lcn

#### 项目介绍
该项目是由springboot整合lcn 项目demo，此项目由meite-shop-parent项目和lcn项目组成，meite-shop-parent中有订单、会员、库存服务等。在该项目中主要使用订单和库存服务，业务场景如下，客户下单，订单服务会在数据库增加一条数据，然后在调用库存服务查询对应的商品库存，如果有库存会对该产品库存进行-1操作。如果订单服务下单成功之后，然后调用库存服务也成功了，接着程序程序出错了，这时候会出现订单服务事务回滚，但是库存服务却已经成功了，这种现象会出现少买的现象，当然这样的程序肯定是无法正常的投入使用的。那么接下来的这个项目就是整合了lcn框架来解决这个问题的。

   
#### 软件架构
该项目由结构图如下，


- 1. -------meite-shop-parent                           项目父工程
- 1. ----------meite-shop-basics                        项目基础服务模块父工程
- 1. -------------meite-shop-basics-springcloud-eureka  注册中心服务
- 1. -------------meite-shop-basics-springcloud-auul    网关服务
- 1. ----------meite-shop-common                        项目通用服务模块(常量、错误信息封装等)
- 1. ----------meite-shop-service-api                   项目接口服务模块父工程
- 1. -------------meite-shop-service-api-member         会员接口服务
- 1. -------------meite-shop-service-api-order          订单接口服务
- 1. -------------meite-shop-service-api-stock          库存接口服务
- 1. ----------meite-shop-service                       项目接口实现类服务模块父工程
- 1. -------------meite-shop-service-member             会员接口实现类服务
- 1. -------------meite-shop-service-order              订单接口实现类服务
- 1. -------------meite-shop-service-stock              库存接口实现类服务
- 1. 
- 1. ---------tx-lcn  lcn父工程
- 1. ------------transaction-springcloud  springcloud整合lcn demo
- 1. ------------transaction-dubbo        dubbo整合lcn demo
- 1. ------------transaction-motan        motan整合lcn demo
- 1. ------------tx-client                lcn 客户端
- 1. ------------tx-manager               lcn 管理模块
- 1. ------------tx-plugins-db            lcn 整合数据库模块


详细的lcn 项目结构请以github 为主。
lcn官网：http://www.txlcn.org/zh-cn/  
lcn github网址：https://github.com/codingapi/tx-lcn 

#### 安装教程

1. 通过码云下载项目meite-shop-parent、lcn二个项目，lcn项目下载地址：https://gitee.com/MingTian-NiHao/tx-lcn 。然后通过idea 将2个项目导入，如下图。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0414/112520_34597943_1729730.png "屏幕截图.png")
2. 将lcn项目中的tx-client模块、tx-manager模块、tx-plugins模块分别 打成jar包到自己的本地maven仓库中，否则后边项目启动会出错。
3. 修改 tx-manager 项目下的 application.properties 文件，修改对应的redis相关的配置信息。
4. 在mysql数据库运行sql文件，，将对应的数据库以及数据表建立在自己本地的数据库，sql 文件在meite-shop-parent 项目 db文件夹下。
5. 首先启动 eureka注册中心，然后启动 tx-manager 服务，在对应的启动订单服务、库存服务。
6.启动成功之后可以在eureka注册中心页面看到对应的服务已经注册到注册中心上去了。

eureka启动成功，访问 http://127.0.0.1:8080/。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0413/201734_36ad8f1b_1729730.png "屏幕截图.png")
tx-manager启动成功之后，访问 http://127.0.0.1:8899/ 
![输入图片说明](https://images.gitee.com/uploads/images/2019/0413/201754_00bd4cc1_1729730.png "屏幕截图.png")
查看tx-manager的在线模块结果如下，显示订单服务与库存服务信息。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0414/093555_157526a2_1729730.png "屏幕截图.png")

#### 使用说明
1.程序正常运行状态。项目各个模块启动成功之后，接下来进行项目的操作。首先访问订单服务的下单方法， http://127.0.0.1:8010/addOrderAndStock?i=1，
addOrderAndStock 方法就是下单及调用库存的方法，方法的参数 i=1 就是为了验证 int reuslt = 1 / i; 这行代码。可在方法中看改行的代码位置。
访问成功之后，页面如下。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0414/094528_5ef4d105_1729730.png "屏幕截图.png")
数据库中订单新增一条数据。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0414/094737_319633b5_1729730.png "屏幕截图.png")
库存表 对应商品库存数量-1，原本库存数量为100。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0414/094753_be806507_1729730.png "屏幕截图.png")
2.程序在下单成功之后，调用库存成功之后，程序出错。访问项目地址为 http://127.0.0.1:8010/addOrderAndStock?i=0，此时addOrderAndStock 方法对应的参数为i=0，这时候你就该明白addOrderAndStock 传参数i的意义所在了，页面如下。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0414/095126_36ab076b_1729730.png "屏幕截图.png")
对应的订单数据库如下，没有新增一条下单数据。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0414/095152_6a5698a1_1729730.png "屏幕截图.png")
对应的库存数据库，库存也没有进行-1 操作。
![输入图片说明](https://images.gitee.com/uploads/images/2019/0414/095231_2895dce0_1729730.png "屏幕截图.png")
这种下单、扣库存场景才是正确的，应该这个项目已经整合了lcn框架，在没有整合lcn框架之前，就会出现项目介绍中出现的那种场景。但是显然在没有整合lcn框架之前出现的场景是不符合我们真实的业务场景的，所以在这里给大家介绍了一下，springboot项目整合lcn框架解决分布式事务的问题，如果该项目有什么问题可在下方留言进行讨论。

#### 参与贡献

1. lcn官网：http://www.txlcn.org/zh-cn/  
2. lcn github网址：https://github.com/codingapi/tx-lcn 
3. 蚂蚁课堂 http://www.mayikt.com/