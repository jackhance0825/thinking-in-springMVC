#### IDEA 社区版环境部署
1. 创建web项目
New -> Module... -> Maven -> Create from archetype -> ...maven-archetype-webapp ->...
   
2. 集成tomcat plugin
File -> Settings -> Plugins -> download Smart Tomcat
   
3. Run/Debug Configurations
+Smart Tomcat 
   Tomcat Server: Tomcat安装根目录
   Deployment Directory：web项目的webapp目录