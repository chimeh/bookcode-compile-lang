#!/bin/bash

cd shopfront
mvn clean install
if docker build -t apetrovya/djshopfront . ; then
  docker push apetrovya/djshopfront
fi
cd ..

cd productcatalogue
mvn clean install
if docker build -t apetrovya/djproductcatalogue . ; then
  docker push apetrovya/djproductcatalogue
fi
cd ..

cd stockmanager
mvn clean install
if docker build -t apetrovya/djstockmanager . ; then
  docker push apetrovya/djstockmanager
fi
cd ..
