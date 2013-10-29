#!/usr/bin/env bash

apt-get update
apt-get install -y scala
wget http://repo.scala-sbt.org/scalasbt/sbt-native-packages/org/scala-sbt/sbt/0.13.0/sbt.deb
dpkg -i sbt.deb