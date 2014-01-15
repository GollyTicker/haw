#!/usr/bin/python
# -*- coding: utf-8 -*-


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
        src, dest = edge.getSrc(), edge.getDest()
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

    def createVertice(self, name, weight={}):
        return Vertice(name, weight)

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


# vertice_object = Vertice(String, dict={Any : Any})
class Vertice():

    # Creation
    def __init__(self, name, weight={}):
        self.name = name
        self.weight = weight

    def __repr__(self):
        return "v{" + str(self.name) + "}"

    # Mutators
    def setWeight(self, key, value):
        self.weight[key] = value

    # Selectors
    def getWeight(self):
        return self.weight

    def getWeightByCmp(self, cmp_):
        if cmp_ in self.weight:
            return self.weight[cmp_]
        return None

    def getName(self):
        return self.name

    # Built in
    def __eq__(self, other):
        if isinstance(other, Vertice):
            return self.name == other.name
        else:
            return False

    def __ne__(self, other):
        return (not self.__eq__(other))

    def __hash__(self):
        return hash(self.name)


# edge_object = Edge(String, Vertice, Vertice, Bool=True, dict={Any : Any})
class Edge():

    def __init__(self, name, src, dest, isdirected=True, weight={"d" : 1}):
        self.name = name
        self.isdirected = isdirected
        self.src = src
        self.dest = dest
        self.weight = weight

    def __repr__(self):
        return "e{" + str(self.name) + ", w=" + str(self.weight) +"}"

    # Functions
    def inBetween(self, v1, v2):
        same_source = self.src == v1 and self.dest == v2
        if self.isdirected:
            return same_source
        not_same = self.dest == v1 and self.src == v2
        return same_source or not_same

    def isVerticeSrc(self, vertice):
        same = self.src == vertice
        if self.isdirected:
            return same
        return same or self.dest == vertice

    def isVerticeDest(self, vertice):
        same = self.dest == vertice
        if self.isdirected:
            return same
        return same or self.src == vertice

    def getDestBySrc(self, vertice):
        if self.src == vertice:
            return self.dest
        if not self.isdirected and self.dest == vertice:
            return self.src
        return None

    def getSrcByDest(self, vertice):
        if self.dest == vertice:
            return self.src
        if not self.isdirected and self.src == vertice:
            return self.dest
        return None

    # Mutators
    def setWeight(self, key, value):
        self.weight[key] = value

    def setSrc(self, src):
        self.src = src

    def setDest(self, dest):
        self.dest = dest

    # Selectors
    def isSling(self):
        return self.src == self.dest

    def isDirected(self):
        return self.isdirected

    def getSrcDest(self):
        return (self.src, self.dest)

    def getSrc(self):
        return self.src

    def getDest(self):
        return self.dest

    def getName(self):
        return self.name

    def getWeight(self):
        return self.weight

    def getWeightByCmp(self, cmp_):
        if cmp_ in self.weight:
            return self.weight[cmp_]
        return None

    # Built in
    def __eq__(self, other):
        if isinstance(other, Edge):
            is_in = self.inBetween(other.getSrc(), other.getDest())
            return (self.name == other.name and is_in)
        else:
            return False

    def __ne__(self, other):
        return (not self.__eq__(other))

    def __hash__(self):
        return hash(self.name)


# gp = GraphParser(String, String)
# g = gp.createGraph()
class GraphParser():

    def __init__(self, apath, name="xxx"):
        self.path = apath
        self.dict = {"name" : name, "directed" : "gerichtet"}
        self.isdirected = None
        self.g = Graph(self.dict["name"])

    def setDirection(self):
        if self.dict["directed"] == "ungerichtet":
            self.isdirected = False
        elif self.dict["directed"] == "gerichtet":
            self.isdirected = True

    def createGraph(self):
        readl = self.split()
        self.addEdges(readl)
        self.g.setDirection(self.isdirected)
        return self.g

    def getGraph(self):
        return self.g

    def addEdges(self, seq):
        for idx, sublist in enumerate(seq):
            src = Vertice(sublist[0])
            dest = Vertice(sublist[1])
            w = int(sublist[2])
            ename = "e" + str(idx)
            self.g.addCreateEdge(ename, src, dest, self.isdirected, weight={"d" : w})

    def split(self):
        readl = []
        for line in open(self.path, 'r'):
            temp = line.strip().split(",")
            if temp:
                readl.append(temp)
        self.dict["directed"] = readl[0][0][1:]
        self.setDirection()
        return readl[1:]



