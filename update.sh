#!/bin/sh
sudo rm -rf $(find backend/src/main/resources/ -type d -name "*[2-9]*")
rm -f database*
rm -f backend/target/*.jar
git reset --hard
git pull origin master
