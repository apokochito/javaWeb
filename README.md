# javaWebBasics

- Java Servlets (**servlet branch**)

    - Overview
    
        - This application works as a library database, you can GET all the existing books, ADD a new book, UPDATE an existing book and DELETE an existing book.
    
    - Steps
    
        - To run this Servlet application use the following maven commands: run **clean** maven command before run the server with this **tomcat7:run** maven command.
        - Go to http://localhost:9090/Servlet/ViewServlet to see all the available books.
    
    - TIPS
    
        - Make sure that you have war packaging tag on your POM file to run tomcat.
        - To create a base project structure like this you can use this maven command - mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4  
