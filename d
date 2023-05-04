warning: in the working copy of 'pom.xml', LF will be replaced by CRLF the next time Git touches it
warning: in the working copy of 'src/main/resources/application.properties', LF will be replaced by CRLF the next time Git touches it
[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex 1cd92b6..354ba83 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -142,6 +142,9 @@[m
             <plugin>[m
                 <groupId>org.springframework.boot</groupId>[m
                 <artifactId>spring-boot-maven-plugin</artifactId>[m
[32m+[m[32m                <configuration>[m
[32m+[m[32m                    <mainClass>com.example.poetry.PoetryApplication</mainClass>[m
[32m+[m[32m                </configuration>[m
             </plugin>[m
         </plugins>[m
     </build>[m
[1mdiff --git a/src/main/java/com/example/poetry/controller/PManagerController.java b/src/main/java/com/example/poetry/controller/PManagerController.java[m
[1mindex e918be4..69c6a00 100644[m
[1m--- a/src/main/java/com/example/poetry/controller/PManagerController.java[m
[1m+++ b/src/main/java/com/example/poetry/controller/PManagerController.java[m
[36m@@ -63,7 +63,7 @@[m [mpublic class PManagerController {[m
      */[m
     @PostMapping("/login")[m
     @SaCheckLogin[m
[31m-    public Result login2(@RequestBody PManager pManager){[m
[32m+[m[32m    public Result login(@RequestBody PManager pManager){[m
         String username = pManager.getUsername();[m
         String password = pManager.getPassword();[m
         if (Validator.isEmpty(username)||Validator.isEmpty(password)){[m
[1mdiff --git a/src/main/resources/application.properties b/src/main/resources/application.properties[m
[1mindex 54ebc1d..caad210 100644[m
[1m--- a/src/main/resources/application.properties[m
[1m+++ b/src/main/resources/application.properties[m
[36m@@ -28,8 +28,8 @@[m [mspring.datasource.name=defaultDataSource[m
 # 数据库连接地址[m
 spring.datasource.url=jdbc:mysql://localhost:3306/poetry?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false[m
 # 数据库用户名&密码：[m
[31m-spring.datasource.username=root[m
[31m-spring.datasource.password=root[m
[32m+[m[32mspring.datasource.username=fauchard[m
[32m+[m[32mspring.datasource.password=TfFsdcS3CZp4wAZ4[m
 # 应用服务 WEB 访问端口[m
 server.port=8081[m
 spring.devtools.restart.enabled=true[m
