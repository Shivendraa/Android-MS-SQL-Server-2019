# Android-MS-SQL-Server-2019

Hello There, In this ReadMe i will tell you what is the main working of ConnectionHelper and MainActivity Files

ConnectionHelper.java
* Above File connects app with SQL Server instance. 
* All we need to do is the enter the server name/IP, Database Name, Username and Password of the SQL server instance correct.
* here function named connection class will return the Connection object (Which we will use later to check whether app is connnected or not)

MainActivity.java
* This file interacts with MainActivity Consists of 2 EditText, 1 Button
* Firstly We will call the connectionClass method here and then store it to The Connection object
* If Connection Object is null then counnection is failed (And you may check log for errors)
* If Connection object is not null toast will generate Connected with SQL Server 
* Then there is executeStatements() methd which insert records feature using simple JDBC procedure.
