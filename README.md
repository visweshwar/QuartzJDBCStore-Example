This example is to illustrate how we can use Quartz JDBCJobStore to ensure that we have only one instance of the job being executed at any given time.
To illustrate that, we execute 4 instance of the application and print the port number of the instance of the application running

# Run the Applicaiton

## Start the Docker Process to start MySQL Database

```shell
(base) Visweshwar-Ganeshs-MacBook-Pro-2:SingleRunner visweshwarganesh$ pwd
/Users/visweshwarganesh/Development/SingleRunner
(base) Visweshwar-Ganeshs-MacBook-Pro-2:SingleRunner visweshwarganesh$ docker compose up
```


==Review the configuraiton file== 

## Build the application

```shell
./gradlew clean build jar
```

## Run multiple instances of the application

```shell
java -jar SingleRunner-0.0.1-SNAPSHOT.jar --server.port=8081 & \
java -jar SingleRunner-0.0.1-SNAPSHOT.jar --server.port=8082 & \
java -jar SingleRunner-0.0.1-SNAPSHOT.jar --server.port=8083 & \
java -jar SingleRunner-0.0.1-SNAPSHOT.jar --server.port=8084 &
```

#### See the output
```shell
Executing Job: Application Name - MyApp, Port - 8082
Executing Job: Application Name - MyApp, Port - 8081
Executing Job: Application Name - MyApp, Port - 8081
Executing Job: Application Name - MyApp, Port - 8081
Executing Job: Application Name - MyApp, Port - 8081
Executing Job: Application Name - MyApp, Port - 8081
Executing Job: Application Name - MyApp, Port - 8081
Executing Job: Application Name - MyApp, Port - 8081
```
### Check the ports on which the process is running
```shell
lsof -ti tcp:8081,8082,8083,8084
```

#### kill 1 app at a time

```shell
lsof -ti tcp:8081| xargs kill
```

Notice the Output changing

```shell
Executing Job: Application Name - MyApp, Port - 8081
Executing Job: Application Name - MyApp, Port - 8084
Executing Job: Application Name - MyApp, Port - 8084
Executing Job: Application Name - MyApp, Port - 8084
Executing Job: Application Name - MyApp, Port - 8084
Executing Job: Application Name - MyApp, Port - 8084
Executing Job: Application Name - MyApp, Port - 8084
Executing Job: Application Name - MyApp, Port - 8084

```
