图书管理系统

#项目介绍
此项目为图书管理系统的后端工程，基于Springboot+MyBatis+MySQL 框架搭建，使用Spring security+redis实现用户登录验证及session管理

#功能介绍
- 实现图书信息的增加、修改、删除、按条件分页查询
- 用户登录身份验证
- 基于环境的配置文件分离
- 基于swagger的api接口管理

#工程结构
主要分为：图书业务包book，公用包common，配置包config，用户信息包user，核心包core，明细如下：

- src/main/java
  - com.luojs.bookmanagesystem
    - book / 图书业务包
	- controller
  	- dao
  	- dto
  	- entity
	-service
	    -impl
    - common / 公共包
  	  - domain / 公共域对象
  	  - response / 响应结果封装
  	  - utils / 工具类
    - config / 配置包
    - user/ 用户信息包
	- controller
  	- dao
  	- entity
	-service
	    -impl
    - core / 核心包 
      - handle / 用户登录验证
    - BookManageSystemApplication.java / 项目启动类
- src/main/resources
  - mapper / MyBatis映射文件
  - application.properties / 应用配置文件
  - application-dev.properties / 开发环境配置
  - application-prod.properties / 测试环境配置
- src/test
  - com.luojs.bookmanagesystem / 单元测试

