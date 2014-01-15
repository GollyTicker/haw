


# edge_object = Edge(String, Vertice, Vertice, Bool=True, dict={Any : Any})
class Edge():

    def __init__(self, name, src, dest, isdirected=True, weight={}):
        self.name = name
        self.isdirected = isdirected
        self.src = src
        self.dest = dest
        self.weight = weight

    def __repr__(self):
        return "e{" + str(self.name) + ", =" + str(self.weight) + "}"

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
    def updateWeight(self, key, value):
        if key in self.weight:
            self.weight[key] += value
        else:
            self.setWeight(key, value)

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

    def getWeightMap(self):
        return self.weight

    def getWeight(self, cmp_):
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

    