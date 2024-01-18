#! /bin/bash
mvn -B clean package -Dvaadin.productionMode=true
java -jar target/ichiro-family-tree-viewer-0.0.13.jar &