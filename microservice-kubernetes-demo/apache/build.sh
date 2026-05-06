#!/bin/bash

docker build -t ms-demo-apache:1.0 .
kind load docker-image ms-demo-apache:1.0
kind load docker-image ms-demo-apache:1.0 --name sandbox-ingress

kubectl port-forward service/apache 8081:80

kubectl apply -f https://kind.sigs.k8s.io/examples/ingress/deploy-ingress-nginx.yaml
kubectl delete -f https://kind.sigs.k8s.io/examples/ingress/deploy-ingress-nginx.yaml

helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm -n ingress-nginx install ingress-nginx ingress-nginx/ingress-nginx --create-namespace

