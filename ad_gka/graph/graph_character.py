#!/usr/bin/python
# -*- coding: utf-8 -*-

class GraphCharacter():
    
    def nullgraph(self):
        return (not self.vertices) and (not self.edges)

    def empty(self):
        return not self.edges

    def isQuiver(self):
        return self.isDirected() and self.isMultigraph()

    def isMixed(self):
        return len(
            filter(lambda x: x.isDirected(), self.getEdges())
            ) != len(self.getEdges())

    def isDirected(self):
        return all(edge.isDirected() for edge in self.getEdges())

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

    def isUndirected(self):
        return all(not edge.isDirected() for edge in self.getEdges())

    def isSimpleGraph(self):
        return not (self.isMultigraph() or self.anyHasSling())

    def verticeDegree(self, vertice):
        return len(self.getVertice(vertice).getEdges())

    # Dirac - if G is a (1) simple graph with n edges, (2) with 3 <= n ∈ N and
    # the degree of (3) each vertice v of G d(v) >= n/2 then G has the attribute 
    # Hamiltonian.
    def isDirac(self):
        n = len(self.edges)
        return (n >= 3 and 
                self.isSimpleGraph() and 
                all(self.verticeDegree(v) >= (n / 2) for v in self.vertices)
                )