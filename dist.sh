#!/bin/sh
git diff-index --quiet HEAD -- || { echo "Uncommmitted changes detected- please run this script from a clean working directory."; exit; }
mvn clean package
mkdir -p target/dotenv/library
cp library.properties target/dotenv
mv -f target/dotenv.jar target/dotenv/library
cd target
zip -r dotenv.zip dotenv
