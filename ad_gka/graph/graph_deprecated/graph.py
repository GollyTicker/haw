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
        self.edges = set([])
        self.ver_to_edg = {}

    def __repr__(self):
        acc = ""
        for edge in self.edges:
            emap = str(edge.getWeightMap())
            ename = str(edge.getName()) 
            src = edge.getSrc()
            dest = edge.getDest()
            direction = " " if edge.isDirected() else " <"
            str_edge = direction + "= (" + ename + ", " + emap + ") => "
            str_src = "(" + src.getName() + ", " + str(src.getWeightMap()) + ")"
            str_dest = "(" + dest.getName() + ", " + str(dest.getWeightMap()) + ")"
            acc += str_src + str_edge + str_dest + "\n\t"
        return "Graph(" + str(self.name) + ", " + self.direction + ") <<\n\t" + acc + ">>"

    def empty(self):
        return (not self.ver_to_edg) and (not self.edges)

    # Mutators
    def updateWeight(self, comp, key, value):
        if isinstance(comp, Edge):
            comp.updateWeight(key, value)
        if isinstance(comp, Vertice):
            comp.updateWeight(key, value)
            self.__update_edges__(comp)

    def setWeight(self, comp, key, value):
        if isinstance(comp, Edge):
            comp.setWeight(key, value)
        if isinstance(comp, Vertice):
            comp.setWeight(key, value)
            self.__update_edges__(comp)

        # Bulk Operations
    def removeEdges(self, edges):
        for edge in edges:
            self.removeEdge(edge)

    def removeVertices(self, vertices):
        for vertice in vertices:
            self.removeVertice(vertice)

    def addEdges(self, edges):
        for edge in edges:
            self.addEdge(edge)

    def addVertices(self, vertices):
        for vertice in vertices:
            self.addVertice(vertice)

        # Single Operations
    def removeEdge(self, edge):
        if edge in self.edges:
            self.edges.remove(edge)
        for edgelist in self.ver_to_edg.values():
            if edge in edgelist:
                edgelist.remove(edge)

    def removeVertice(self, vertice):
        if vertice in self.ver_to_edg:
            edges = self.ver_to_edg[vertice]
            del self.ver_to_edg[vertice]
            for edge in edges:
                self.removeEdge(edge)

    def addEdge(self, edge):
        src, dest = edge.getSrcDest()
        self.edges.add(edge)
        self.__add_edges__(edge, src)
        self.__add_edges__(edge, dest)

    def addVertice(self, vertice):
        if vertice not in self.ver_to_edg:
            self.ver_to_edg[vertice] = []

    def setName(self, name):
        self.name = name

    def setDirection(self, direction):
        self.direction = direction

    # Creation of Parts
    def addCreateEdge(self, name, src, dest, isdirected=True, weight={}):
        newedge = self.createEdge(name, src, dest, isdirected, weight)
        self.addEdge(newedge)
        return newedge

    # String, Vertice/String, Vertice/String, Bool, Dict={Any : Any}
    def createEdge(self, name, src, dest, isdirected=True, weight={}):
        if not isinstance(src, Vertice):
            src = self.createVertice(src)
        if not isinstance(dest, Vertice):
            dest = self.createVertice(dest)
        return Edge(name, src, dest, isdirected, weight)

    def createVertice(self, name):
        return Vertice(name)

    # Functions
    def adjacent(self, vertice):
        edges = self.ver_to_edg[vertice]
        adja = set([])
        for edge in edges:
            if edge.isVerticeSrc(vertice):
                adja.add(edge.getDestBySrc(vertice))
        if not self.hasSling(vertice) and vertice in adja:
            adja.remove(vertice)
        return adja

    def incident(self, vertice):
        edges = self.ver_to_edg[vertice]
        inci = set([])
        for edge in edges:
            src, dest = edge.getSrc(), edge.getDest()
            inci.add(src)
            inci.add(dest)
        if not self.hasSling(vertice) and vertice in inci:
            inci.remove(vertice)
        return inci

    def hasSling(self, vertice):
        if not vertice in self.ver_to_edg:
            return False
        edges = self.ver_to_edg[vertice]
        return any(edge.isSling() for edge in edges)

    # Selectors
    def getDirection(self):
        return self.direction

    def getName(self):
        return self.name

    def getEdges(self):
        return self.edges

    def getVertices(self):
        vertices = set([])
        for k in self.ver_to_edg:
            vertices.add(k)
        return vertices

    def getVerticeDict(self):
        return self.ver_to_edg

    def getEdgeByName(self, name):
        for edge in self.edges:
            if edge.getName() == name:
                return edge
        return None

    def getVerticeByName(self, name):
        for vertice in self.ver_to_edg:
            if vertice.getName() == name:
                return vertice
        return None

    def getVerticesByName(self, names):
        collect = []
        for vertice in self.ver_to_edg:
            if vertice.getName() in names:
                collect.append(vertice)
        return collect

    # Built in
    def __update_edges__(self, vertice):
        for edge in self.ver_to_edg[vertice]:
            if edge.getSrc().getName() == vertice.getName():
                edge.setSrc(vertice)
            if edge.getDest().getName() == vertice.getName():
                edge.setDest(vertice)

    def __add_edges__(self, edge, vertice):
        if vertice in self.ver_to_edg:
            if edge not in self.ver_to_edg[vertice]:
                 self.ver_to_edg[vertice].append(edge) 
        else:
            self.ver_to_edg[vertice] = [edge]

    def __eq__(self, other):
        if isinstance(other, Graph):
            return self.name == other.name
        else:
            return False

    def __ne__(self, other):
        return (not self.__eq__(other))

    def __hash__(self):
        return hash(self.name)
