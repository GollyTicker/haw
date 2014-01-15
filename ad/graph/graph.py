#!/usr/bin/python
# -*- coding: utf-8 -*-
from vertice import Vertice
from edge import Edge

# graph_object = Graph(String, Bool=True, dict={Edge : [Vertice]}, dict={Vertice : [Edge]})
class Graph():

    # Creation
    def __init__(self, name, isdirected=None, edg_to_ver={}, ver_to_edg={}):
        self.name = name
        self.isdirected = isdirected
        self.edg_to_ver = edg_to_ver
        self.ver_to_edg = ver_to_edg

    def __repr__(self):
        acc = ""
        for v, e in self.ver_to_edg.items():
            acc += "{" + str(v) + ", " + str(e) + "}\n\t"
        dire = ""
        if self.isdirected:
            dire = ", directed"
        if self.isdirected == False:
            dire = ", undirected"
        if self.isdirected == None:
            dire = ", no direction"
        return "Graph(" + str(self.name) + dire + ")\n\t" + acc

    def empty(self):
        return (not self.ver_to_edg) and (not self.edg_to_ver)

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
        if edge in self.edg_to_ver:
            del self.edg_to_ver[edge]
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
        if src in self.ver_to_edg:
            edge.setSrc(src)
        if dest in self.ver_to_edg:
            edge.setDest(dest)
        self.edg_to_ver[edge] = [src, dest]
        self.__add_key__(edge, src)
        self.__add_key__(edge, dest)

    def addVertice(self, vertice):
        if vertice not in self.ver_to_edg:
            self.ver_to_edg[vertice] = []

    def setName(self, name):
        self.name = name

    def setDirection(self, isdirected):
        self.isdirected = isdirected

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

    # Selectors
    def isDirected(self):
        return self.isdirected

    def getName(self):
        return self.name

    def getEdges(self):
        edges = set([])
        for k in self.edg_to_ver:
            edges.add(k)
        return edges

    def getVertices(self):
        vertices = set([])
        for k in self.ver_to_edg:
            vertices.add(k)
        return vertices

    def getEdgeDict(self):
        return self.edg_to_ver

    def getVerticeDict(self):
        return self.ver_to_edg

    def getEdgeByName(self, name):
        for edge in self.edg_to_ver:
            if edge.getName() == name:
                return edge
        return None

    def getVerticeByName(self, name):
        for vertice in self.ver_to_edg:
            if vertice.getName() == name:
                return vertice
        return None

    # Built in
    def __update_edges__(self, vertice):
        for edge in self.ver_to_edg[vertice]:
            if edge.getSrc().getName() == vertice.getName():
                edge.setSrc(vertice)
            if edge.getDest().getName() == vertice.getName():
                edge.setDest(vertice)

    def __add_key__(self, edge, vertice):
        if vertice in self.ver_to_edg:
            if edge not in self.ver_to_edg[vertice]:
                 self.ver_to_edg[vertice].append(edge) 
        else:
            self.ver_to_edg[vertice] = [edge]

    def __eq__(self, other):
        if isinstance(other, Vertice):
            return self.name == other.name
        else:
            return False

    def __ne__(self, other):
        return (not self.__eq__(other))

    def __hash__(self):
        return hash(self.name)



