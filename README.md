**Serenity-RestAssured Junit5 - Project** 

to run tests
>mvn clean verify
test reports are generated in
site/serenity/index.html
> 


**dependencies**

<dependencies>
<!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-rest-assured -->
<dependency>
<groupId>net.serenity-bdd</groupId>
<artifactId>serenity-rest-assured</artifactId>
<version>4.2.16</version>
<scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/net.serenity-bdd/serenity-junit5 -->
<dependency>
<groupId>net.serenity-bdd</groupId>
<artifactId>serenity-junit5</artifactId>
<version>4.2.16</version>
<scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.assertj/assertj-core -->
<dependency>
<groupId>org.assertj</groupId>
<artifactId>assertj-core</artifactId>
<version>3.27.3</version>
<scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
<dependency>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<version>1.18.36</version>
<scope>provided</scope>
</dependency>
</dependencies>


**plugins**

<build>
<plugins>
<plugin>
<groupId>net.serenity-bdd.maven.plugins</groupId>
<artifactId>serenity-maven-plugin</artifactId>
<version>4.2.16</version>
<executions>
<execution>
<id>serenity-reports</id>
<phase>post-integration-test</phase>
<goals>
<goal>aggregate</goal>
<goal>check</goal>
</goals>
</execution>
</executions>
</plugin>
</plugins>
</build>

