#!/bin/sh

./yeet.sh
git pull origin master

cd frontend
ng build --prod
./copy.sh

cd ../backend
./start-backend.sh &
