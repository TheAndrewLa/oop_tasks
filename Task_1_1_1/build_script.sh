#!/usr/bin/env bash

FILE = src/main/java/andrew_la/SortingAlgorithms.java

javac $(FILE)
javadoc $(FILE)
java -classpath andrew_la.SortingAlgorithms
