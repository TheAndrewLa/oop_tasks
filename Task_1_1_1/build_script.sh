#!/usr/bin/bash

FILE=src/main/java/andrewla/SortingAlgorithms.java

javac -d myclasses $FILE
javadoc -d docfiles $FILE
java -cp myclasses andrewla.SortingAlgorithms
