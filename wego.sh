#!/bin/bash

# Nettoyage
kill_container() {
    id=$(docker run $1)
    if docker top $id &>/dev/null
    then
      sudo docker stop $1 
      sudo docker network disconnect 'wego-network' $1  
    fi
}


kill_container wego
kill_container database
sudo docker network rm 'wego-network' 2>/dev/null

# Construction des images

sudo docker build -t wego .

# Démarrage du réseau et des applications
sudo docker network create 'wego-network'

sudo docker run --network='wego-network' --name database \
        -v '/home/michel/mysql-data':'/var/lib/mysql' \
        -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=wego \
        --publish=3306:3306 -d mysql:5.7.23
sudo docker run --publish 8080:8080 --network='wego-network' -d wego:latest
docker run --network='wego-network' -d -p 8080:80 \ 
        -v /var/run/docker.sock:/tmp/docker.sock -t jwilder/nginx-proxy
