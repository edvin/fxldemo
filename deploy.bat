@echo off

mvn clean package
mvn exec:exec@deploy-app