from graph import Graph
from graphparser import GraphParser
from vertice import Vertice
from edge import Edge
import sys

infinity = sys.maxint / 2 # 4611686018427387903

'''
def fordFulkerson(g, s, t, cmp_):
    edges = g.getEdges()
    for edge in edges:
        edge.setWeight("ff", 0)
        edge.setWeight("fb", 0)
    p = initPath(g)
    while p:
        cf = min(p, key=lambda x: x.getWeight(cmp_))
        for edge in p:
            edge.updateWeight("ff", cf)
            edge.updateWeight("fb", -cf)
        p = nextPath(g)
'''

def shortest_path(g, source, target, cmp_):
    bellmanFord(g, source, cmp_)

    def get_shortest_path(source, target, cmp_, accu):

        def inner_shortest(target, accu):
            if target.getWeight(cmp_) == infinity:
                return []
            pred = target.getWeight("pred")
            if pred == None:
                accu.insert(0, source)
                return accu
            accu.insert(0, target)
            return inner_shortest(pred, accu)

        return inner_shortest(target, accu)

    return get_shortest_path(source, target, cmp_, [])


def bellmanFord(g, source, cmp_):

    # Step 1: initialize graph
    vertices = g.getVertices()
    for vertex in vertices:
        if vertex == source:
            g.setWeight(vertex, "d", 0)
        else:
            g.setWeight(vertex, "d", infinity)
        g.setWeight(vertex, "pred", None)

    # Step 2: relax edges repeatedly
    edges = g.getEdges()
    for _ in range(0, len(vertices)):
        for edge in edges:# with weight w in edges:
            u, v = edge.getSrcDest()
            w = edge.getWeight(cmp_)
            if u.getWeight("d") + w < v.getWeight("d"):
                g.setWeight(v, "d", u.getWeight("d") + w)
                g.setWeight(v, "pred", u)

   # Step 3: check for negative-weight cycles
    for edge in edges:
        u, v = edge.getSrcDest()
        w = edge.getWeight(cmp_)
        if u.getWeight("d") + w < v.getWeight("d"):
           print "Graph contains a negative-weight cycle"
           return None




