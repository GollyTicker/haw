#!/bin/sh
python -m unittest discover
rm *.pyc
cd graph/graph
python -m unittest discover
rm *.pyc
cd ../../
