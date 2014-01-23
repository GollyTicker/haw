#!/usr/bin/python
# -*- coding: utf-8 -*-

class GraphString():

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
        #return "Graph(" + str(self.name) + ", " + self.direction + ") <<\n\t" + "".join(sorted_by_key) + ">>"
        return "Graph(" + self.description + ") <<\n\t" + "".join(sorted_by_key) + ">>"

    def __generateDescription__(self):
        calling = direction = "none"
        if self.isDirected():
            calling = direction = "directed"
        if self.isUndirected():
            calling = direction = "undirected"
        if self.isMixed():
            calling = direction = "mixed"
        if self.isQuiver():
            calling = "Quiver"
        if self.isMultigraph():
            calling = "MultiGraph"
        if self.isSimpleGraph():
            calling = "SimpleGraph"
        if calling == direction:
            return self.name + ", " + direction
        return self.name + ", " + calling + ", " + direction



        