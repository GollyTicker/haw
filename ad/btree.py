

class BinTree():

	def __init__(self, root):
		self.root = root

	def inorderTreeWalk(self, node):
		if node:
			self.inorderTreeWalk(node.left)
			print node.data
			self.inorderTreeWalk(node.right)

	def search(self, node, k):
		if node == None or k == node.data:
			return node
		if k < node.data:
			return self.search(node.left, k)
		return self.search(node.right, k)

	def minimum(self, node):
		while node.left:
			node = node.left
		return node

	def maximum(self, node):
		while node.right:
			node = node.right
		return node

	def minimum_rec(self, node):
		if node.left:
			return self.minimum_rec(node.left)
		return node

	def maximum_rec(self, node):
		if node.right:
			return self.maximum_rec(node.right)
		return node

	def parentOf(self, node):
		x = self.root
		parent = None
		while x:
			if node.data == x.data:
				return parent
			parent = x
			if node.data < x.data:
				x = x.left
			else:
				x = x.right
		return parent

	def insert(self, node):
		y = self.parentOf(node)
		if not y:
			self.root = node
		elif node.data < y.data:
			y.setLeft(node)
		else:
			y.setRight(node)

	def successor_tree(self, node):
		if node.right:
			return self.minimum(node.right)
		y = self.parentOf(node)
		while y and node == y.right:
			node = y
			y = self.parentOf(y)
		return y

	def succ(self, k):
		node = self.search(self.root, k)
		if node.right:
			return self.minimum(node.right).data
		y = self.parentOf(node)
		while y and node == y.right:
			node = y
			y = self.parentOf(y)
		return y.data

	def getRoot(self):
		return self.root


class Node():

	left, right, data = None, None, None

	def __init__(self, data, left=None, right=None):
		self.left = left
		self.data = data
		self.right = right

	def __repr__(self):
		if self.left or self.right:
			return "Node(" + str(self.left) + ", " + str(self.data) + ", " + str(self.right) + ")"
		return "Leaf(" + str(self.data) + ")"

	def setLeft(self, left):
		self.left = left

	def setRight(self, right):
		self.right = right

	def setData(self, data):
		self.data = data



l = Node(4, Node(2), Node(5))
r = Node(7, Node(6), Node(8))
root = Node(6, l, r)
b = BinTree(root)

b.inorderTreeWalk(b.getRoot())
searched = b.search(b.getRoot(), 4)
print "search 4: " + str(searched)
mi = b.minimum(b.getRoot())
print "minimum: " + str(mi)
ma = b.maximum(b.getRoot())
print "maximum: " + str(ma)
mi = b.minimum_rec(b.getRoot())
print "minimum_rec: " + str(mi)
ma = b.maximum_rec(b.getRoot())
print "maximum_rec: " + str(ma)
b.insert(Node(10))
print root
ma = b.successor_tree(r)
print "successor_tree: " + str(ma)
ma = b.succ(8)
print "succ: " + str(ma)

