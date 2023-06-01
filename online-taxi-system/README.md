# online-taxi-platform
## 介绍

懒洋网约车平台

+ 项目环境使用 JDK 1.8 + win 10 + Cent OS 7 + mysql 8.0.28 + maven 3.8.4

+ 项目后端使用nacos + Redis + mybatis plus + Redisson + JWT + sse
+ 项目前端使用uni-app做跨平台app，有可能会单独写一个Android的app,项目前端在编写中
+ 项目模块包括：用户模块、司机模块、地图功能模块、验证码模块、订单模块、价格模块、订单支付模块、订单消息推送模块和后台模块
+ 项目token采用双token设计，避免了token被盗，用户信息泄露等风险，其中accessToken为正常使用的token,设置过期时间30天，refreshToken为备用token,设置过期时间31天

#### 注意事项

1. 项目所使用的Redis数据库安装在CentOS里面，启动的时候注意防火墙端口放行，和redis.conf

   ```
   # 允许任何主机连接、访问
   bind 127.0.0.1 改为 bind 0.0.0.0
    
   # 关闭保护模式
   protected-mode yes 改为 protected-mode no
    
   # 允许启动后在后台运行，即关闭命令行窗口后仍能运行
   daemonize no 改为 daemonize yes
   ```

2. service-map调用高德地图web服务api，需要自己申请高德地图web服务api的key，然后生成sid

   + 后续看情况增加百度地图和腾讯地图web服务的调用以优化路径

3. 本项目接口测试工具是apifox，想要了解项目接口详细信息可以点击此链接

   + 【Apifox】欧ིྀ⃮⃖ͯ⃠⃕阳ིྀ⃮⃖ͯ⃠⃕邀请你加入懒洋出行 https://app.apifox.com/invite?token=w7Sk4Su53V45ysP86zA9x
   + 如链接提示过期请联系QQ：1746595240 ，并做好备注

4. 项目跨域调用都是使用openfeign调用

5. 目前项目还没有密码功能，在追加中

6. 

#### 项目目录结构

```
online-taxi-platform
├─ api-boss (后台)
│  ├─controller 控制层
│  ├─remote 接口层
│  ├─service 服务层
│  └─ApiBossApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
├─ api-driver
│  ├─controller 控制层
│  ├─interceptor 拦截器
│  ├─remote 接口层
│  ├─service 服务层
│  └─ApiDriverApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
├─ api-passenger
│  ├─controller 控制层
│  ├─interceptor 拦截器
│  ├─remote 接口层
│  ├─service 服务层
│  └─ApiPassengerApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
├─ internal-common (公共类库)
│  ├─constant 常量类库
│  ├─dto 数据传输层
│  ├─request 请求参数类库
│  ├─responese 响应参数(返回值)类库
│  └─util 工具类库
│
├─ service-driver-user
│  ├─controller 控制层
│  ├─generator mapper层代码生成器
│  ├─mapper 数据库持久化操作层
│  ├─  ├─xml sql对应xml文件
│  ├─remote 接口层
│  ├─service 服务层
│  └─ServiceDriverUserApplication 项目启动类
│  ├─resources
│  ├─ ├─mapper SQL对应的XML文件
│  └──application.yml 项目配置文件
│
├─ service-map
│  ├─controller 控制层
│  ├─generator mapper层代码生成器
│  ├─mapper 数据库持久化操作层
│  ├─remote 接口层
│  ├─service 服务层
│  └─ServiceMapApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
├─ service-order
│  ├─config redis配置类
│  ├─controller 控制层
│  ├─generator mapper层代码生成器
│  ├─mapper 数据库持久化操作层
│  ├─remote 接口层
│  ├─service 服务层
│  └─ServiceOrderApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
├─ service-passenger-user
│  ├─controller 控制层
│  ├─remote 接口层
│  ├─service 服务层
│  └─ServicePassengerUserApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
├─ service-pay
│  ├─config alipay配置类
│  ├─controller 控制层
│  ├─remote 接口层
│  ├─service 服务层
│  └─ServicePayApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
├─ service-price
│  ├─controller 控制层
│  ├─generator mapper层代码生成器
│  ├─mapper 数据库持久化操作层
│  ├─remote 接口层
│  ├─service 服务层
│  └─ServicePriceApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
├─ service-sse-push
│  ├─controller 控制层
│  └─ServicePriceApplication 项目启动类
│  ├─resources
│  ├─ ├─statis 测试用例静态资源文件
│  └──application.yml 项目配置文件
│
├─ service-verificationcode
│  ├─controller 控制层
│  └─ServiceVerificationcodeApplication 项目启动类
│  ├─resources
│  └──application.yml 项目配置文件
│
```

### 项目服务调用情况说明

+ online-taxi-platform

  + api-boss

    + 调用 service-driver-user服务

  + api-driver

    + 调用service-driver-user服务

    + 调用service-verificationcode服务
    + 调用service-map服务
    + 调用service-order服务
    + 调用service-sse-push服务

  + api-passenger

    + 调用service-passenger-user服务
    + 调用service-verificationcode服务
    + 调用service-price服务
    + 调用service-order服务

  + internal-common (公共类库)

  + service-driver-user

    + 调用service-map服务

  + service-map

  + service-order

    + 调用service-driver-user服务
    + 调用service-map服务
    + 调用service-price服务
    + 调用service-sse-push服务

  + service-passenger-user

  + service-pay

    + 调用service-order服务

  + service-price

    + 调用service-map服务

  + service-sse-push

  + service-verificationcode

#### 更新日志

+ 修复一些请求转发问题
+ 
