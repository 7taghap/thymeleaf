# Asia Inspection Exam

This sample application for the asia inspection coding assignment.
Libraries or framework used ( spring-boot, spring-web, spring-data, spring-security,)
In order to run this sample application.

PRE-REQUISITES:

Mysql Server 5+
Maven
Java 1.8

Database configuration:
please create a schema name "aiexam" 
current mysql credentials use:
user: root
password : root

To adjust the database configuration based on your Mysql Server configuration,
connection configuration can be located in src/main/resources/application.properties.


Steps:
1. create a database schema name "aiexam";
2. build and run the source using maven 3.0+
  command:
  clean install spring-boot:run
  
Features:
-CRUD products.
-Sorting

Spring security (Users not in database, hardcoded)
user  | password
admin  | password.

ROLES:
USER role can create, edit product. 
ADMIN role can create, edit, delete product.  
