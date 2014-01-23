#!/usr/bin/python
# -*- coding: utf-8 -*-
from vertice import Vertice
from edge import Edge

# graph_object = Graph(String, String="Description", dict={String : Edge}, dict={String : Vertice})
class Graph():

    # Creation
    def __init__(self, name, direction="Description"):
        self.name = name
        self.direction = direction
        self.edges = {}
        self.vertices = {}

    # Sorted Alphabetical Order by Vertice.name
    # srcVertice.name, srcVertice.weightMap 
    #       - Edge.name, Edge.weightMap -> 
    #           destVertice.name, destVertice.weightMap
    def __repr__(self):
        vname_tostr = []
        for vname, vertice in self.vertices.items():
            edges = self.adjacent(vname)
            for ename in edges:
                edge = self.getEdge(ename)
                emap = str(edge.getWeightMap())
                src = self.getVertice(edge.getSrc())
                dest = self.getVertice(edge.getDest())
                direction = "  " if edge.isDirected() else "  <"
                str_edge = direction + "--(" + ename + ", " + emap + ")-->  "
                str_src = "(" + src.getName() + ", " + str(src.getWeightMap()) + ")"
                str_dest = "(" + dest.getName() + ", " + str(dest.getWeightMap()) + ")"
                vname_tostr.append((vname, str_src + str_edge + str_dest + "\n\t"))
        sorted_by_key = map(lambda x: x[1], sorted(vname_tostr, key=lambda x: x[0]))
        return "Graph(" + str(self.name) + ", " + self.direction + ") <<\n\t" + "".join(sorted_by_key) + ">>"

    def nullgraph(self):
        return (not self.vertices) and (not self.edges)

    def empty(self):
        return not self.edges

    # Dirac - if G is a (1) simple graph with n edges, (2) with 3 <= n ∈ N and
    # the degree of (3) each vertice v of G d(v) >= n/2 then G has the attribute 
    # Hamiltonian.
    def isDirac(self):
        n = len(self.edges)
        return (n >= 3 and 
                self.isSimpleGraph() and 
                all(self.verticeDegree(v) >= (n / 2) for v in self.vertices)
                )

    def isSimpleGraph(self):
        return not (self.isMultigraph() or self.anyHasSling())

    def isMultigraph(self):
        for vname, vertice in self.vertices.items():
            count = []
            for ename in self.adjacent(vname):
                edge = self.getEdge(ename)
                dest = edge.getDest()
                if dest in count:
                    return True
                else:
                    count.append(dest)
        return False

    def verticeDegree(self, vertice):
        return len(self.getVertice(vertice).getEdges())

    # Removal
    def removeEdges(self, edges):
        for edge in edges:
            self.removeEdge(edge)

    def removeVertices(self, vertices):
        for vertice in vertices:
            self.removeVertice(vertice)

    def removeEdge(self, edge):
        if edge in self.edges:
            for _, vertice in self.vertices.items():
                vertice.removeEdge(edge)
            del self.edges[edge]
            return True
        return False

    def removeVertice(self, vertice):
        if vertice in self.vertices:
            for name, edge in self.edges.items():
                if edge.getSrc() == vertice or edge.getDest() == vertice:
                    self.removeEdge(name)
            del self.vertices[vertice]
            return True
        return False

    # Creation 
    def addVertices(self, vertices):
        for vertice in vertices:
            self.addVertice(vertice)

    def addEdge(self, name, src, dest, isdirected=True, weight={}):
        src_name = self.addVertice(src)
        dest_name = self.addVertice(dest)
        self.getVertice(src_name).addEdge(name)
        self.getVertice(dest_name).addEdge(name)
        self.edges[name] = Edge(name, src_name, dest_name, isdirected, weight)
        return name

    def addVertice(self, vertice):
        if not vertice in self.vertices and isinstance(vertice, basestring):
            self.vertices[vertice] = Vertice(vertice)
        return vertice

    def setName(self, name):
        self.name = name

    def setDirection(self, direction):
        self.direction = direction

    # Functions
    def neighbours(self, vertice):
        edges = self.getVertice(vertice).getEdges()
        adja = set([])
        for edge in edges:
            edge = self.getEdge(edge)
            if edge.isVerticeSrc(vertice):
                adja.add(edge.getDestBySrc(vertice))
        if not self.hasSling(vertice) and vertice in adja:
            adja.remove(vertice)
        return adja # -> Set(Vertice.name)

    def adjacent(self, vertice):
        edges = self.getVertice(vertice).getEdges()
        adja = set([])
        for edge in edges:
            if self.getEdge(edge).isVerticeSrc(vertice):
                adja.add(edge)
        return adja # -> Set(Edge.name)

    def incident(self, vertice):
        return self.getVertice(vertice).getEdges() # -> Set(Edge.name)

    def anyHasSling(self):
        return any(edge.isSling() for edge in self.edges.values())

    def hasSling(self, vertice):
        if not vertice in self.vertices:
            return False
        edges = self.getVertice(vertice).getEdges()
        return any(self.getEdge(edge).isSling() for edge in edges)

    # Selectors Graph
    def getDirection(self):
        return self.direction

    def getName(self):
        return self.name

    # Selectors Graph Components
    def getVertice(self, name):
        if name in self.vertices:
            return self.vertices[name]
        return None

    def getEdge(self, name):
        if name in self.edges:
            return self.edges[name]
        return None

    def getEdges(self):
        return self.edges.values()

    def getVertices(self):
        return self.vertices.values()

    def getVerticesByName(self, names):
        return [v for n, v in self.vertices.items() if n in names]

    def getEdgesByName(self, names):
        return [e for n, e in self.edges.items() if n in names]

    # Delegation
    def getSrcDest(self, edge):
        if not isinstance(edge, Edge):
            edge = self.getEdge(edge)
        return map(self.getVertice, edge.getSrcDest())

    def getEdgeSrcDest(self, source, target):
        edges = self.getVertice(source).getEdges()
        for ename in edges:
            edge = self.getEdge(ename)
            if edge.inBetween(source, target):
                return edge
        return None

    def __eq__(self, other):
        if isinstance(other, Graph):
            return self.name == other.name
        else:
            return False

    def __ne__(self, other):
        return (not self.__eq__(other))

    def __hash__(self):
        return hash(self.name)


    