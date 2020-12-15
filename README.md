# Nhom5_Software-License-Management-System

## My team

- Minh <-- Me
- Phùng văn Hoàng
- Trần văn Lượng
- Lê văn Quang
## Description
Server có nhiệm vụ lưu trữ thông tin về các giấy phép sử dụng các phần mềm của người dùng cụ thể.

### Sever

Server kết nối đến 1 database lưu trữ thông tin, cung cấp các hàm cho Client thông qua RMI của Java

### Client

Client gọi các hàm từ Server thông qua RMI

### RMIService

Định nghĩa các interface cho các service để triển khai qua RMI.

Định nghĩa các model lưu thông tin Server trả về cho Client

## What are those ?

```
/Root Project Folder/
|   .gitignore
|   Dockerfile
|   folder structure.txt
|   mysql-connector-java-8.0.22.jar
|   README.md
|   Software-Licence-Management-System.iml
|   
+---.idea //ide config
|           
+---client
|   |   client.iml
|   |   Dockerfile
|   |               
|   +---src
|   |   +---META-INF
|   |   |       MANIFEST.MF
|   |   |       
|   |   \---yuhnim
|   |       \---client
|   |               Client.java
|   |               
|   \---webserver
|       |   .gitignore
|       |   folder structure.txt
|       |   HELP.md
|       |   mvnw
|       |   mvnw.cmd
|       |   pom.xml
|       |   webserver.iml
|       |   
|       +---.mvn
|       |           
|       +---src
|          +---main
|              +---java
|              |   \---webserver
|              |       \---web
|              |           |   WebApplication.java
|              |           |   
|              |           +---config
|              |           |       MvcConfig.java
|              |           |       WebSecurityConfig.java
|              |           |       
|              |           +---model
|              |           |       MyUserDetails.java
|              |           |       
|              |           +---mvc
|              |           |       LicenceInfoController.java
|              |           |       LoginController.java
|              |           |       
|              |           \---service
|              |                   UserService.java
|              |                   
|              \---resources
|                  |   application.properties
|                  |   
|                  +---META-INF
|                  |       MANIFEST.MF
|                  |       
|                  +---public
|                  |   \---css
|                  |           bootstrap-full.css
|                  |           
|                  +---static
|                  |   \---css
|                  \---templates
|                          index.html
|                          LicenceInfo.html
|                          login.html
|
+---RMIService
|   |   RMIService.iml
|   |   
|   \---src
|       \---yuhnim
|           \---rmi
|               |   
|               +---model
|               |       Licence.java
|               |       Product.java
|               |       User.java
|               \---service
|                       LicenceService.java
|                       UserService.java
|
\---server
    |   Dockerfile
    |   server.iml
    |           
    \---src
        +---META-INF
        |       MANIFEST.MF
        |       
        \---yuhnim
            \---server
                |   ConnectionFactory.java
                |   LicenceServiceImp.java
                |   Server.java
                |   UserServiceImp.java
                |   
                \---DAL
                        DAO.java
                        LicenceDAO.java
                        ProductDAO.java
                        UserDAO.java
```




## How to build this

Clone project này về

Mở project trong intellij

## Test

### Tạo 1 network cho 2 container connect

docker network create RMInetwork

### Build server docker image

Mở teminal trong thư mục chứa project, chạy:

```bash
docker build --tag yuhnim/server:1.0 ./server
```

### Build client docker image

Mở teminal trong thư mục chứa project, chạy:

```bash
docker build --tag yuhnim/client:1.0 ./client
```

### Run client images

```bash
docker run -d -p 8080:8080 --network RMInetwork --name running-client yuhnim/client:1.0
```

### Run server images

```bash
docker run -d -p 1234:1234 --network RMInetwork --name running-server yuhnim/server:1.0
```



## Licence

None

