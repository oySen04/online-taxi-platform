# 工程简介
### 对外后台管理功能接口(供公司内部使用)
公司后台管理接口，提供对外调用接口，通过此项目对外接口调用内部功能，使用openfeign调用
# 延伸阅读
### 接口说明
##### api-boss http://localhost:8087

+ 通过openfeign调用service-driver-user服务插入司机信息
    + 接口 /driver-user (post)
+ 通过openfeign调用service-driver-user服务修改司机信息
    + 接口 /driver-user (put)

