#!/usr/bin/python
# -*- coding: utf-8 -*-
from vertice import Vertice
from edge import Edge
from graph_module import generateDescription

# graph_object = Graph(String, String="Description", dict={String : Edge}, dict={String : Vertice})
class Graph():

    # Creation
    def __init__(self, name):
        self.name = name
        self.description = "None"
        self.edges = {}
        self.vertices = {}

    def nullgraph(self):
        return (not self.vertices) and (not self.edges)

    def empty(self):
        return not self.edges

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

    def hasSling(self, vertice):
        if not vertice in self.vertices:
            return False
        edges = self.getVertice(vertice).getEdges()
        return any(self.getEdge(edge).isSling() for edge in edges)

    # Selectors Graph
    def getName(self):
        return self.name

    # Selectors Graph Components
    def verticeDegree(self, vertice):
        return len(self.getVertice(vertice).getEdges())

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

    def getEdgeSrcDestList(self, source, target):
        edges = self.getVertice(source).getEdges()
        result = []
        for ename in edges:
            edge = self.getEdge(ename)
            if edge.inBetween(source, target):
                result.append(edge)
        return result

    def __eq__(self, other):
        if isinstance(other, Graph):
            return self.name == other.name
        else:
            return False

    def __ne__(self, other):
        return (not self.__eq__(other))

    def __hash__(self):
        return hash(self.name)

    # Sorted Alphabetical Order by Vertice.name
    # srcVertice.name, srcVertice.weightMap 
    #       - Edge.name, Edge.weightMap -> 
    #           destVertice.name, destVertice.weightMap
    def __repr__(self):

        indentation = "\n\t"

        def nameMap(comp):
            return "(" + comp.getName() + ", " + str(comp.getWeightMap()) + ")"

        def edge_s(edge):
            direction = "  " if edge.isDirected() else "  <"
            return direction + "--" + nameMap(edge) + "-->  "

        # Extracting Rows from components
        rows = []
        for vname, vertice in self.vertices.items():
            for ename in self.adjacent(vname):
                edge = self.getEdge(ename)
                src, dest = self.getSrcDest(edge)
                row = (vname, nameMap(src) + edge_s(edge) + nameMap(dest))
                rows.append(row)

        # Sorting, Concatenation       
        sorted_by_name = sorted(rows, key=lambda vname: vname[0])
        reduced_string = reduce(lambda accu, row: accu + row[1] + indentation, sorted_by_name, "")

        paranthesis = indentation + "<(" + indentation
        return "Graph(" + self.description + ")" + paranthesis + reduced_string + ")>"


    def updateDescription(self):
        self.description = generateDescription(self)

    def getDescription(self):
        return self.description






