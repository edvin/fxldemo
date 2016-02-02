@echo off

mvn clean package
mvn exec:exec@installer