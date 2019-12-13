#!/bin/sh
rm -f database*
rm -f backend/target/*.jar
git reset --hard
git pull origin maste
