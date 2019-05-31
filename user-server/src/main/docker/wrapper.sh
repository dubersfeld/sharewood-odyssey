#!/bin/sh

while ! `nc -z $DATABASE_HOST $DATABASE_PORT`; do 
    echo "********************************************************"
    echo "Waiting for the MySQL server to start on port 3306"
    echo "********************************************************"
    sleep 20; 
done

echo "MySQL server $DATABASE_HOST up and running at $DATABASE_PORT"

while ! `nc -z $CONFIGSERVER_HOST $CONFIGSERVER_PORT`; do 
    echo "********************************************************"
    echo "Waiting for the config server to start on $CONFIGSERVER_HOST:$CONFIGSERVER_PORT"
    echo "********************************************************"
    sleep 20; 
done

echo "Config server up and running at $CONFIGSERVER_HOST:$CONFIGSERVER_PORT"

java -Djava.security.egd=file:/dev/./urandom -Dspring.cloud.config.uri=$SHAREWOOD_CONFIG_URI -Dspring.profiles.active=$PROFILE -jar /app.jar

