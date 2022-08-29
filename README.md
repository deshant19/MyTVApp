# MyTVApp

## Steps to run the database(MySQL)

    1. Goto the root directory ./MyTVApp
    2. run command, docker-compose up -d --build (Make sure you have docker installed)
    3. This is to bring up Mysql cluster at port 3307

## Steps to run the application

    1. Make sure you have Java 17 and maven installed.
    2. Goto the root directory ./MyTVApp
    3. Run, mvn clean package (It will build and package the application is necessary jars required to run the application)
    4. Goto target folder.
    5. Run the application using command, java -jar MyTVApp-0.0.1-SNAPSHOT.jar
