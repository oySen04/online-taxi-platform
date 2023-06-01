# 工程简介
### 价格模块
# 延伸阅读
### 接口说明
##### service-price  http://localhost:8084

+ 通过openfeign调用service-map服务计算预估价格
    + 接口 /forecast-price (post)
+ service-price添加计价规则
    + 接口 /price-rule/add (post)
+ 修改计价规则
    + 接口  /price-rule/edit (post)
+ 查找最新版本计价规则
    + 接口  /price-rule/get-newest-version (get)
+ 判断计价规则是否是最新的
    + 接口 /price-rule/is-new (post)
+ 根据城市编码和车辆信息查询计价规则
    + 接口 /price-rule/if-exists (get)
+ 计算实际价格
    + 接口 /calculate-price (post)
