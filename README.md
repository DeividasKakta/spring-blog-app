# spring-blog-app
Simple blog application made using Spring MVC

# how to run(Intellij)
* Clone git repository
* run BlogApplication to start up with database in memory
* OR
* Run docker command to start up a postgresql database
* * docker run --detach --name blog_postgres --env POSTGRES_PASSWORD=password --env POSTGRES_USER=blog --publish 5432:5432 postgres
* * Change profile to 'prod' and run BlogApplication

# accessing admin privileges
Log in as:
* username : admin
* password : admin
