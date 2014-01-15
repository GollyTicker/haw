#!/usr/bin/python
# -*- coding: utf-8 -*-

import unittest
import graph
from graphparser import GraphParser

class TestGraph(unittest.TestCase):

    # Workflow of a Graph
    def test_graph_integration(self):
        g = graph.Graph("Euclid")
        self.assertEqual("Euclid", g.getName())
        self.assertEqual(None, g.isDirected())
        self.assertTrue(g.empty())
        v1,v2,v3,v4,v5,v6,v7,v8 = [g.createVertice("v"+str(x)) for x in xrange(1, 8 + 1)]
        e1 = g.createEdge("e1", v1, v2, True, weight={"d" : 1})
        e2 = g.createEdge("e2", v1, v3, True, weight={"d" : 10})
        e3 = g.createEdge("e3", v1, v4, True, weight={"d" : 10})
        e4 = g.createEdge("e4", v2, v8, True, weight={"d" : 1})
        e5 = g.createEdge("e5", v3, v5, True, weight={"d" : 10})
        e6 = g.createEdge("e6", v4, v6, True, weight={"d" : 10})
        e7 = g.createEdge("e7", v5, v8, True, weight={"d" : -10})
        e8 = g.createEdge("e8", v6, v7, True, weight={"d" : 10})
        e9 = g.createEdge("e9", v7, v8, True, weight={"d" : -20})
        e10 = g.createEdge("e10", v7, v1, False, weight={"d" : 50})
        # Adding only edges shall result in a populated Graph with edges + vertices
        g.addEdges([e1,e2,e3,e4,e5,e6,e7,e8,e9,e10])
        self.assertEqual(set([v2,v3,v4,v7]), g.adjacent(v1))
        self.assertEqual(set([v2,v3,v4,v7]), g.incident(v1))
        self.assertEqual(set([v1,v8]), g.adjacent(v7))
        self.assertEqual(set([v1,v8,v6]), g.incident(v7))
        # removing an edge results in removing the whole history
        g.removeEdge(e10)
        self.assertEqual(set([v2,v3,v4]), g.adjacent(v1))
        self.assertEqual(set([v2,v3,v4]), g.incident(v1))
        self.assertEqual(set([v8]), g.adjacent(v7))
        self.assertEqual(set([v8,v6]), g.incident(v7))
        v9 = g.createVertice("v9")
        e11 = g.createEdge("e11", v1, v9, True, weight={"d" : 50})
        g.addEdge(e11)
        # removing a vertice results in removing tthis vertice from the space +
        # removing all edges depending on it
        g.removeVertice(v9)
        self.assertEqual(None, g.getEdgeByName("e11"))
        self.assertEqual(set([v2,v3,v4]), g.adjacent(v1))
        self.assertEqual(set([v2,v3,v4]), g.incident(v1))
        self.assertEqual(set([v8]), g.adjacent(v7))
        self.assertEqual(set([v8,v6]), g.incident(v7))
        # Removing all Vertices is equal to emptyness
        g.removeVertices([v1,v2,v3,v4,v5,v6,v7,v8])
        self.assertTrue(g.empty())

    # Certain typical Edge Cases
    def test_edge_cases(self):
        pass

    def test_vertice(self):
        pass

    def test_edge(self):
        pass

    def test_graph_parser(self):
        p = "/Users/sacry/dev/uni/s3/WS1314/GKA/graphs/graph1.graph"
        gp = GraphParser(p, "graph1")
        g = gp.createGraph()
        self.assertTrue(not g.empty())
        hamburg = g.getVerticeByName("Hamburg")
        print g
        print g.getEdges()
        self.assertEqual(g.incident(hamburg), g.adjacent(hamburg))
        self.assertTrue("Hamburg", hamburg.getName())


if __name__ == '__main__':
    unittest.main()




