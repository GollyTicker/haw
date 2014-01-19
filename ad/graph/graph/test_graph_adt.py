#!/usr/bin/python
# -*- coding: utf-8 -*-

import unittest
from graph import Graph
from graphparser import GraphParser

class TestGraph(unittest.TestCase):

    # Workflow of a Graph
    def test_graph_integration(self):
        g = Graph("Euclid", "multigraph")
        self.assertEqual("Euclid", g.getName())
        self.assertEqual("multigraph", g.getDirection())
        self.assertTrue(g.empty())
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
        e10 = g.addEdge("e10", v7, v1, False, weight={"d" : 50})
        # Adding only edges shall result in a populated Graph with edges + vertices
        self.assertEqual(set([v2,v3,v4,v7]), g.neighbours(v1))
        self.assertEqual(set([e9, e10]), g.adjacent(v7))
        # removing an edge results in removing the whole history
        g.removeEdge(e10)
        self.assertEqual(set([v2,v3,v4]), g.neighbours(v1))
        self.assertEqual(set([e9]), g.adjacent(v7))
        self.assertEqual(set([v8]), g.neighbours(v7))
        v9 = g.addVertice("v9")
        e11 = g.addEdge("e11", v1, v9, True, weight={"d" : 50})
        # removing a vertice results in removing tthis vertice from the space +
        # removing all edges depending on it
        g.removeVertice(v9)
        self.assertEqual(None, g.getEdge("e11"))
        self.assertEqual(set([v2,v3,v4]), g.neighbours(v1))
        self.assertEqual(set([e9]), g.adjacent(v7))
        self.assertEqual(set([v8]), g.neighbours(v7))
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
        name = "graph1"
        p = "/Users/sacry/dev/uni/s3/WS1314/GKA/graphs/"+name+".graph"
        gp = GraphParser(p, name)
        g = gp.createGraph()
        self.assertTrue(not g.empty())
        actual_neighbours = set(["Neumünster","Hannover","Lüneburg","Lübeck"])
        expected_neighbours = g.neighbours("Hamburg")
        self.assertEqual(actual_neighbours, expected_neighbours)
        hamburg = g.getVertice("Hamburg")
        self.assertTrue("Hamburg", hamburg.getName())
        print g


if __name__ == '__main__':
    unittest.main()




