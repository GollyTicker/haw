#!/usr/bin/python
# -*- coding: utf-8 -*-

import unittest
from graph import Graph
from graph_matrix import GraphMatrix

class TestGraphMatrix(unittest.TestCase):

    # Workflow of a Graph
    def test_adj_undirected_matrix(self):
        g = Graph("Euclid")
        v1,v2,v3,v4,v5,v6,v7,v8 = [g.addVertice("v"+str(x)) for x in xrange(1, 8 + 1)]
        e1 = g.addEdge("e1", v1, v2, False, weight={"d" : 1})
        e2 = g.addEdge("e2", v1, v3, False, weight={"d" : 10})
        e3 = g.addEdge("e3", v1, v4, False, weight={"d" : 10})
        e4 = g.addEdge("e4", v2, v8, False, weight={"d" : 1})
        e5 = g.addEdge("e5", v3, v5, False, weight={"d" : 10})
        e6 = g.addEdge("e6", v4, v6, False, weight={"d" : 10})
        e7 = g.addEdge("e7", v5, v8, False, weight={"d" : -10})
        e8 = g.addEdge("e8", v6, v7, False, weight={"d" : 10})
        e9 = g.addEdge("e9", v7, v8, False, weight={"d" : -20})
        e10 = g.addEdge("e10", v7, v1, False, weight={"d" : 50})
        #print g
        gm = GraphMatrix(g)
        gm.toAdjacentMatrix()
        print gm
        #inciMatrix = graph_matrix.toIncidentMatrix(g)
        #print inciMatrix

    def test_adj_directed_matrix(self):
        g = Graph("Euclid")
        v1,v2,v3,v4,v5,v6,v7,v8 = [g.addVertice("v"+str(x)) for x in xrange(1, 8 + 1)]
        e1 = g.addEdge("e1", v1, v2, True, weight={"d" : 1})
        e2 = g.addEdge("e2", v1, v3, True, weight={"d" : 10})
        e3 = g.addEdge("e3", v1, v4, True, weight={"d" : 10})
        e4 = g.addEdge("e4", v2, v8, True, weight={"d" : 1})
        e5 = g.addEdge("e5", v3, v5, True, weight={"d" : 10})
        e6 = g.addEdge("e6", v4, v6, True, weight={"d" : 10})
        e7 = g.addEdge("e7", v5, v8, True, weight={"d" : -10})
        e8 = g.addEdge("e8", v6, v7, True, weight={"d" : 10})
        e9 = g.addEdge("e9", v7, v8, True, weight={"d" : -20})
        e10 = g.addEdge("e10", v7, v1, True, weight={"d" : 50})
        #print g
        gm = GraphMatrix(g)
        gm.toAdjacentMatrix()
        print gm
        #inciMatrix = graph_matrix.toIncidentMatrix(g)
        #print inciMatrix

if __name__ == '__main__':
    unittest.main()




