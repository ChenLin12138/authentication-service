# authentication-service
Spring Cloud Learning authentication-service
## What Is It?
Spring cloud components learning.
## Spring Cloud components
### Spring boot 2.1.4.RELEASE
### Actuator
## Download & Installation
1. Download a Java SE Runtime Environment (JRE),release version 8 or later, from http://www.oracle.com/technetwork/java/javase/downloads/index.html
2. Download Apache maven
Download Apache maven 3.6.0 here
http://maven.apache.org/download.cgi
3. Set Java Home or JRE Home.
4. Set Maven Home.
5. Import project as Existing maven projects.
6. Use mvn clean install to install this project.
## Demo
- 通过以下url获取jwt token
```
http://localhost:5555/api/auth/token
```
![image](https://github.com/ChenLin12138/authentication-service/blob/master/demo/pic/%E8%8E%B7%E5%8F%96jwt.png)

通过
```
https://jtw.io
```
查看jwt净荷
![image](https://github.com/ChenLin12138/authentication-service/blob/master/demo/pic/%E6%9F%A5%E7%9C%8Bjwt%E5%86%85%E5%AE%B9.png)

通过jwt token访问组织服务器内容
```
http://localhost:5555/api/organization/v1/organizations/35690f33-71b1-4996-83f8-93b8ca411848
```
![image](https://github.com/ChenLin12138/authentication-service/blob/master/demo/pic/%E8%8E%B7%E5%8F%96jwt.png)




