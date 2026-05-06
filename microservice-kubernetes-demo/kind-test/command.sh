#!/bin/bash

kind create cluster --config kind-sandbox-ingress.yml

kubectl cluster-info --context kind-sandbox-ingress

kubectl config get-contexts

helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
helm -n ingress-nginx install ingress-nginx ingress-nginx/ingress-nginx --create-namespace