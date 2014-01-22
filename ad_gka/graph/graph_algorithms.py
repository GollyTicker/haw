from graph import Graph
from graphparser import GraphParser
from vertice import Vertice
from edge import Edge
import sys


''' 4611686018427387903 '''
infinity = sys.maxint / 2 

def shortestBellman(g, source, target, cmp_):

    source = g.getVertice(source)
    target = g.getVertice(target)
    bellmanFord(g, source, cmp_)

    def inner_shortest(target, accu):
        if target.getWeight(cmp_) == infinity:
            return []
        pred = target.getWeight("pred")
        if pred == None:
            accu.insert(0, source)
            return accu
        accu.insert(0, target)
        return inner_shortest(pred, accu)

    return inner_shortest(target, [])


def bellmanFord(g, source, cmp_):
    vertices = g.getVertices()
    edges = g.getEdges()

    # Step 1: initialize graph
    for vertex in vertices:
        if vertex == source:
            vertex.setWeight("d", 0)
        else:
            vertex.setWeight("d", infinity)
        vertex.setWeight("pred", None)

    # Step 2: relax edges repeatedly
    for _ in range(0, len(vertices)):
        for edge in edges:
            u, v = g.getSrcDest(edge)
            w = edge.getWeight(cmp_)
            if u.getWeight("d") + w < v.getWeight("d"):
                v.setWeight("d", u.getWeight("d") + w)
                v.setWeight("pred", u)

   # Step 3: check for negative-weight cycles
    for edge in edges:
        u, v = g.getSrcDest(edge)
        w = edge.getWeight(cmp_)
        if u.getWeight("d") + w < v.getWeight("d"):
           print "Graph contains a negative-weight cycle"
           return None


def shortestDijkstra(g, source, target, cmp_):
    dijkstra(g, source, cmp_)
    S = []
    u = g.getVertice(target)
    while u.getWeight("prev") != None:
        S.insert(0, u)
        u = g.getVertice(u.getWeight("prev"))
    S.insert(0, g.getVertice(source))
    return S


def dijkstra(g, source, cmp_):
    for vertice in g.getVertices():
        vertice.setWeight("d", infinity)
        vertice.setWeight("prev", None)
    g.getVertice(source).setWeight("d", 0)

    Q = g.getVertices()
    while Q:
        u = min(Q, key=lambda x: x.getWeight("d"))
        Q.remove(u)
        if u.getWeight("d") == infinity:
            break
        for vname in g.neighbours(u.getName()):
            v = g.getVertice(vname)
            dist_between = g.getEdgeSrcDest(u.getName(), vname).getWeight(cmp_)
            alt = u.getWeight("d") + dist_between
            if alt < v.getWeight("d"):
                v.setWeight("d", alt)
                v.setWeight("prev", u.getName())
                Q.remove(v)
                Q.append(v)



def fordFulkerson(g, s, t, cmp_):

    raise Error("Not Implemented!")
    
    def inner_ford(s_, t_,):
        edges = g.getEdges()
        for edge in edges:
            edge.setWeight("c", 10)
            edge.setWeight("ff", 0)
            edge.setWeight("fb", 0)
        p = find(g, s_, t_, [])
        while p:
            cf = min(p, key=lambda x: x.getWeight(cmp_)).getWeight(cmp_)
            for edge in p:
                edge.updateWeight("ff", cf)
                edge.updateWeight("fb", -cf)
            p = find(g, s_, t_, [])


    def find(g, s, t, p):
        return p

    inner_ford(s, t)

