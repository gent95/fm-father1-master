**项目说明** 
- 采用SpringBoot、MyBatis、Shiro框架。
- 提供了代码生成器，只需编写30%左右代码。
<br>

**数据权限设计思想** 
- 管理员管理、角色管理、部门管理，可操作本部门及子部门数据
- 菜单管理、定时任务、参数管理、字典管理、系统日志，没有数据权限
- 业务功能，按照用户数据权限，查询、操作数据【没有本部门数据权限，也能查询本人数据】

<br> 

**项目结构** 
```
fm-farmer
├─fm-common     公共模块
│ 
├─fm-admin      管理后台
│    ├─db  数据库SQL脚本
│    │ 
│    ├─modules  模块
│    │    ├─job 定时任务
│    │    ├─oss 文件存储
│    │    └─sys 系统管理(核心)
│    │ 
│    └─resources 
│        ├─mapper   MyBatis文件
│        ├─statics  静态资源
│        ├─template 系统页面
│        │    ├─modules      模块页面
│        │    ├─index.html   AdminLTE主题风格（默认主题）
│        │    └─index1.html  Layui主题风格
│        └─application.yml   全局配置文件
│       
│ 
├─fm-api        API服务
│ 
├─fm-generator  代码生成器
│        └─resources 
│           ├─mapper   MyBatis文件
│           ├─template 代码生成器模板（可增加或修改相应模板）
│           ├─application.yml    全局配置文件
│           └─generator.properties   代码生成器，配置文件
│
```

<br>

 **技术选型：** 
- 核心框架：Spring Boot 1.5
- 安全框架：Apache Shiro 1.3
- 视图框架：Spring MVC 4.3
- 持久层框架：MyBatis 3.3
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.1
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x

<br>

 **软件需求** 
- JDK1.8
- MySQL5.5+
- Tomcat8.0+
- Maven3.0+

<br>

 **本地部署**
- 创建数据库fm_father，数据库编码为UTF-8
- 执行db/mysql.sql文件，初始化数据【按需导入表结构及数据】
- 修改application-dev.yml文件，更新MySQL账号和密码
- 在fm-security目录下，执行mvn clean install
<br>

- Eclipse、IDEA运行AdminApplication.java，则可启动项目【fm-admin】
- fm-admin访问路径：http://localhost:8080/fm-admin
- swagger文档路径：http://localhost:8080/fm-admin/swagger/index.html
                  - 账号密码：admin/admin

<br>

- Eclipse、IDEA运行ApiApplication.java，则可启动项目【fm-api】
- fm-api访问路径：http://localhost:8081/fm-api/swagger-ui.html

<br>

- Eclipse、IDEA运行GeneratorApplication.java，则可启动项目【fm-generator】
- fm-generator访问路径：http://localhost:8082/fm-generator

<br>