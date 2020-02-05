# Maven中pom.xml常见的参数

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.isshudu</groupId>
  <artifactId>maven_test</artifactId>
  <version>1.0</version>
  <packaging>war</packaging>
  <dependencies>
    <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
  
  </dependencies>               
    <!-- 👆需要servlet依赖，否则index.jsp中会抛异常  -->

  
    <build>
		<finalName>hello-maven-web</finalName>
		<plugins>
			<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.1</version>
    <configuration>
        <source>1.6</source> <!-- 源代码使用的开发版本 -->
        <target>1.6</target> <!-- 需要生成的目标class文件的编译版本 -->
				</configuration>
			</plugin>
            <!-- 👆配置maven所必需的配置-->
<plugin>
	<groupId>org.apache.tomcat.maven</groupId>
	<artifactId>tomcat7-maven-plugin</artifactId>
	<version>2.2</version>
	<configuration>
		<path>/test</path>
		<port>9090</port>
		<uriEncoding>UTF-8</uriEncoding>
	</configuration>
</plugin>
     <!-- 👆配置网站所必需的配置，path是网站的访问路径，port是端口，上述访问路径为localhost:9090/test-->
			</plugins>
			</build>
</project>
```

![](C:\Users\lyh\Desktop\Github同步笔记\图片\maven_打包成war_网站形式.png)

**<font color = 'red'>如果打包成war格式时：需要注意以下几点👇</font>**

- 在webapp下面建一个文件夹，名称为**WEB-INF**，里面放**web.xml**（从普通web项目复制就行）
- 每次改变pom.xml的时候，更新maven，强制更新就可以。
- 将网站（jsp文件）放到webapp下

