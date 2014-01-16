#!/usr/bin/python
# -*- coding: utf-8 -*-
from vertice import Vertice
from edge import Edge

# graph_object = Graph(String, Bool=True, dict={Edge : [Vertice]}, dict={Vertice : [Edge]})
class Graph():

    # Creation
    def __init__(self, name, direction="None"):
        self.name = name
        self.direction = direction
        self.edges = {}
        self.vertices = {}

    def __repr__(self):
        acc = ""
        for ename, edge in self.edges.items():
            emap = str(edge.getWeightMap())
            src = self.vertices[edge.getSrc()]
            dest = self.vertices[edge.getDest()]
            direction = " " if edge.isDirected() else " <"
            str_edge = direction + "= (" + ename + ", " + emap + ") => "
            str_src = "(" + src.getName() + ", " + str(src.getWeightMap()) + ")"
            str_dest = "(" + dest.getName() + ", " + str(dest.getWeightMap()) + ")"
            acc += str_src + str_edge + str_dest + "\n\t"
        return "Graph(" + str(self.name) + ", " + self.direction + ") <<\n\t" + acc + ">>"

    def empty(self):
        return (not self.vertices) and (not self.edges)

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
    def addEdges(self, edges):
        for edge in edges:
            self.addEdge(edge)

    def addVertices(self, vertices):
        for vertice in vertices:
            self.addVertice(vertice)

    def addEdge(self, name, src, dest, isdirected=True, weight={}):
        src_name = self.addVertice(src)
        dest_name = self.addVertice(dest)
        self.vertices[src_name].addEdge(name)
        self.vertices[dest_name].addEdge(name)
        e = Edge(name, src_name, dest_name, isdirected, weight)
        self.edges[name] = e
        return name

    def addVertice(self, vertice):
        if not vertice in self.vertices:
            self.vertices[vertice] = Vertice(vertice)
        return vertice

    def setName(self, name):
        self.name = name

    def setDirection(self, direction):
        self.direction = direction

    # Functions
    def adjacent(self, vertice):
        edges = self.vertices[vertice].getEdges()
        adja = set([])
        for edge in edges:
            edgeobj = self.getEdge(edge)
            if edgeobj.isVerticeSrc(vertice):
                adja.add(edgeobj.getDestBySrc(vertice))
        if not self.hasSling(vertice) and vertice in adja:
            adja.remove(vertice)
        return adja

    def incident(self, vertice):
        edges = self.vertices[vertice].getEdges()
        inci = set([])
        for edge in self.getEdgesByName(edges):
            src, dest = edge.getSrc(), edge.getDest()
            inci.add(src)
            inci.add(dest)
        if not self.hasSling(vertice) and vertice in inci:
            inci.remove(vertice)
        return inci

    def hasSling(self, vertice):
        if not vertice in self.vertices:
            return False
        edges = self.vertices[vertice].getEdges()
        return any(self.getEdge(edge).isSling() for edge in edges)

    # Selectors
    def getVertice(self, name):
        if name in self.vertices:
            return self.vertices[name]
        return None

    def getEdge(self, name):
        if name in self.edges:
            return self.edges[name]
        return None

    def getDirection(self):
        return self.direction

    def getName(self):
        return self.name

    def getEdges(self):
        collect = []
        for _, edge in self.edges.items():
            collect.append(edge)
        return collect

    def getVertices(self):
        collect = []
        for _, vertice in self.vertices.items():
            collect.append(vertice)
        return collect

    def getVerticesByName(self, names):
        collect = []
        for name, vertice in self.vertices.items():
            if name in names:
                collect.append(vertice)
        return collect

    def getEdgesByName(self, names):
        collect = []
        for name, edge in self.edges.items():
            if name in names:
                collect.append(edge)
        return collect

    # Delegation

    def __eq__(self, other):
        if isinstance(other, Graph):
            return self.name == other.name
        else:
            return False

    def __ne__(self, other):
        return (not self.__eq__(other))

    def __hash__(self):
        return hash(self.name)


    