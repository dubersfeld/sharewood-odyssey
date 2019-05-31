#!/bin/sh

#rm -r /home/photos

while ! `nc -z $CONFIGSERVER_HOST $CONFIGSERVER_PORT`; do 
    echo "********************************************************"
    echo "Waiting for the configuration server to start on port 8888"
    echo "********************************************************"
    sleep 8
done

echo "Config Server up and running at $CONFIGSERVER_HOST:$CONFIGSERVER_PORT"


while ! `nc -z $PHOTO_DATABASE_HOST $PHOTO_DATABASE_PORT`; do 
    echo "********************************************************"
    echo "Waiting for $PHOTO_DATABASE_HOST server to start on port $PHOTO_DATABASE_PORT"
    echo "********************************************************"
    sleep 8 
done

echo "MySQL server up and running at $PHOTO_DATABASE_HOST:$PHOTO_DATABASE_PORT"


while ! `nc -z $TOKEN_DATABASE_HOST $TOKEN_DATABASE_PORT`; do 
    echo "********************************************************"
    echo "Waiting for $TOKEN_DATABASE_HOST server to start on port $TOKEN_DATABASE_PORT"
    echo "********************************************************"
    sleep 8 
done

echo "MySQL server up and running at $TOKEN_DATABASE_HOST:$TOKEN_DATABASE_PORT"

java -Djava.security.egd=file:/dev/./urandom -Dspring.cloud.config.uri=$SHAREWOOD_CONFIG_URI -Dspring.profiles.active=$PROFILE -jar /app.jar
