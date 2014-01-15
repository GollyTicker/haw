

# vertice_object = Vertice(String, dict={Any : Any})
class Vertice():

    # Creation
    def __init__(self, name):
        self.name = name
        self.weight = {}

    def __repr__(self):
        return "v{" + str(self.name) + "}"

    # Mutators
    def updateWeight(self, key, value):
        if key in self.weight:
            self.weight[key] += value
        else:
            self.setWeight(key, value)

    def setWeight(self, key, value):
        self.weight[key] = value

    # Selectors
    def getWeight(self, cmp_=""):
        if cmp_ in self.weight:
            return self.weight[cmp_]
        return None

    def getWeightMap(self):
        return self.weight
            
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

