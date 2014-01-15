from graph import Graph
from vertice import Vertice
from edge import Edge

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
            self.g.addCreateEdge(ename, src, dest, self.isdirected, {"d" : w})

    def split(self):
        readl = []
        for line in open(self.path, 'r'):
            temp = line.strip().split(",")
            if temp:
                readl.append(temp)
        self.dict["directed"] = readl[0][0][1:]
        self.setDirection()
        return readl[1:]