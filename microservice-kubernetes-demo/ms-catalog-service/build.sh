#!/bin/bash

docker build -t ms-demo-catalog-service:1.0 ./catalog-service/
kind load docker-image ms-demo-catalog-service:1.0
kind load docker-image ms-demo-catalog-service:1.0 --name sandbox-ingress