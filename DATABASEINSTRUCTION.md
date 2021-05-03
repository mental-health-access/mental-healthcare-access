## How to set up database for app

* Open MySQL Workbench and connect to local instance 3306 under MySQL connections.

* Next, you will need to click on the cylinder icon to create a new schema.

* In the schema editor that appears next, name the schema after your current project and click on "apply"
  in the bottom right corner of the screen. Once the preview pops up, click "apply" once more.

* You'll need to create a new user to gain access to the database. Click on the Administration tab of your new schema and then
  click the Users & Privileges under the Management section.

* Next, click Add Account in the bottom left hand of the screen. Next add a login
  name in th login name field. A good practice is to give the login the
  same name as the database(or schema).
  
* In the "Limit to Hosts Matching" field, change the % sign to
  "localhost".
  
* Create a reasonable password for the "password" field.

* Next, click the Schema Privileges tab and click the Add Entry button. On the 
  next screen, click the Select Schema option and select the schema
  you've just created. Click OK to confirm your choice.
  
* Back at the Schema privileges tab, click the Select All button
  so the user can have all the base privileges for the schema.
  
* You'll need to configure springboot in IntelliJ next to connect to 
  your database. Go to your build.gradle file and add the MySQL
  and Spring data JPA in the dependencies section.

  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
  implementation 'mysql:mysql-connector-java'
  
* Now move to your application.properties file and add these settings.

Database connection settings
spring.datasource.url=jdbc:mysql://localhost:3306/schemaname 
spring.datasource.username=user
spring.datasource.password=yourpassword

# Specify the DBMS
spring.jpa.database = MYSQL

# Show or not log for each sql query
spring.jpa.show-sql = true

# Hibernate ddl auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto = update

# Use spring.jpa.properties.* for Hibernate native properties (the prefix is
# stripped before adding them to the entity manager)
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect

* All done!