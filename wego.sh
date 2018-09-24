#!/bin/bash

#sudo docker build -t wego .
sudo docker network rm 'wego-network'
sudo docker network create 'wego-network'

sudo docker kill database
sudo docker rm database
sudo docker run --network='wego-network' --name database \
        -v '/home/michel/mysql-data':'/var/lib/mysql' \
        -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=wego \
        --publish=3306:3306 -d mysql:5.7.23
sudo docker run --publish 8080:8080 --network='wego-network' -d wego:latest
docker run --network='wego-network' -d -p 8080:80 \ 
        -v /var/run/docker.sock:/tmp/docker.sock -t jwilder/nginx-proxy
