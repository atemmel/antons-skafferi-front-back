#!/bin/sh

# Starta frontend
cd frontend
ng build --prod
./copy.sh

# Starta backend
cd ../backend
./start-backend.sh &
