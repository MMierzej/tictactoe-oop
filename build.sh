#!/bin/bash

cd src
javac -d ../compiled ./*.java
javac -d ../compiled ./board/*.java
javac -d ../compiled ./gamemod/*.java
javac -d ../compiled ./player/*.java
javac -d ../compiled ./player/ai/*.java
