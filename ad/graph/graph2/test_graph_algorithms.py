#!/usr/bin/python
# -*- coding: utf-8 -*-

import unittest
import graph2
from graphparser import GraphParser
import graph_algorithms

class TestGraphAlgorithms(unittest.TestCase):

    # Workflow of a Graph
    def test_bellman_ford(self):
        name = "graph3"
        p = "/Users/sacry/dev/uni/s3/WS1314/GKA/graphs/"+name+".graph"
        gp = GraphParser(p, name)
        g = gp.createGraph()
        l = graph_algorithms.shortest_path(g, "y", "u", "d")
        shortest_path_as_names = map(lambda x: x.getName(), l)
        self.assertEqual(["y","s","x","u"], shortest_path_as_names)


if __name__ == '__main__':
    unittest.main()