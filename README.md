# BloodSystem README



## Libraries & versions 

#### Web

+ `spring-boot-starter-data-jpa`  (version: 2.7.2)
+ `spring-boot-starter-web`  (version: 2.7.2)

#### Database

+ `postgresql`   (version: 2.7.2)

#### Jsp

+ `tomcat-embed-jasper `    (version: 2.7.2)
+ `jstl`    (version: 2.7.2)

#### Security

+ `spring-boot-starter-security `   (version: 2.7.2)
+ `spring-security-config`  (version: 2.7.2)

#### Oauth2

+ `spring-security-oauth2-jose`     (version: 2.7.2)
+ `spring-boot-starter-oauth2-client `   (version: 2.7.2)

#### Swagger

+ `springfox-swagger2 ` (version: 2.6.1)
+ `springfox-swagger-ui` (version: 2.6.1)

#### Gmail

+ `spring-boot-starter-mail` (version: 2.7.3)

#### Others

+ `com.google.guava` (version: 28.1-jre)





## Functionalities

1. Register & Login

   ![image-20221004215858950](README.assets/image-20221004215858950.png)

   + Normal 

     ![image-20221004215915470](README.assets/image-20221004215915470.png)

     ![image-20221004215934178](README.assets/image-20221004215934178.png)

     ​	

   + Login using Google Account

     <img src="README.assets/image-20221004215954725.png" alt="image-20221004215954725" style="zoom: 33%;" />

   + Remember me

     <img src="README.assets/image-20221004221342835.png" alt="image-20221004221342835" style="zoom: 50%;" />

     

2. FAQ & About 

   ![image-20221004220040996](README.assets/image-20221004220040996.png)

   ![image-20221004220102691](README.assets/image-20221004220102691.png)

3. User can view and edit their basic information

   + Profile

     <img src="README.assets/image-20221004220241647.png" alt="image-20221004220241647" style="zoom: 25%;" />

   + Health Information

     <img src="README.assets/image-20221004220303802.png" alt="image-20221004220303802" style="zoom:25%;" />

     + Upload file

       <img src="README.assets/image-20221004220336141.png" alt="image-20221004220336141" style="zoom: 25%;" />

4. User can request / donate blood

   + The website should be able to match donors for the demanders by their blood type
     and location

     <img src="README.assets/image-20221004220403279.png" alt="image-20221004220403279" style="zoom:50%;" />

     ![image-20221004220428816](README.assets/image-20221004220428816.png)

     ![image-20221004220447714](README.assets/image-20221004220447714.png)

   + User can send messages through requesting

     ![image-20221004220603627](README.assets/image-20221004220603627.png)

     + Message notification

       <img src="README.assets/image-20221004220652542.png" alt="image-20221004220652542" style="zoom:50%;" />

     + Message can not only viewed in website but also through your email (sent by official account)

       <img src="README.assets/image-20221004220735925.png" alt="image-20221004220735925" style="zoom:50%;" />

     + Urgent records which haven't been matched will be displayed in the home page

       <img src="README.assets/image-20221004221255731.png" alt="image-20221004221255731" style="zoom:50%;" />

5. The system shall allow users to manage their message and reply to someone.

   <img src="README.assets/image-20221004220808375.png" alt="image-20221004220808375" style="zoom:50%;" />

   <img src="README.assets/image-20221004220850260.png" alt="image-20221004220850260" style="zoom: 25%;" />

   

   ​	

6. The system shall allow users to manage their records.

   ![image-20221004220956041](README.assets/image-20221004220956041.png)

7. Admin can view all users and delete inappropriate message 

   ![image-20221004221022313](README.assets/image-20221004221022313.png)

   ![image-20221004221037886](README.assets/image-20221004221037886.png)

8. The website has Swagger page to show available APIs

   ![image-20221004221059815](README.assets/image-20221004221059815.png)







## How to run 

+ Make sure you have installed Postgres, maven

+ Create a database called `bloodsystem`

+ Your local Postgres should open the port 5432 and create a user granted all the permissions to `bloodsystem` (username = "postgres", password = "password")

  + You can edit these in `application.properties`

  ![image-20221004215448465](README.assets/image-20221004215448465.png)

+ If you run the project by intellj, configure this application as spring boot, then just click the green button on the top right

  ![image-20221004221539867](README.assets/image-20221004221539867.png)

  Otherwise, you can run our application by ` mvn spring-boot:run`

  ![image-20221004221611985](README.assets/image-20221004221611985.png)