import re
import utils

class BinTree():

	def __init__(self, root):
		self.root = root

	def inorderTreeWalk(self, node):
		if node:
			self.inorderTreeWalk(node.left)
			print node.data
			self.inorderTreeWalk(node.right)

	def sortedList(self):
		acc = []
		def sort_walk(node):
			if node:
				sort_walk(node.left)
				acc.append(node.data)
				sort_walk(node.right)
		sort_walk(self.root)
		return acc

	def tree_map(self, node, f):
		def inner_map(node):
			if node:
				inner_map(node.left)
				node.setData(f(node.data))
				inner_map(node.right)
		return inner_map(node)

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

	# parent of not working
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
			temp = y.left
			if temp != None and temp.data > node.data:
				node.setRight(temp)
			else:
				node.setLeft(temp)
			y.setLeft(node)
		else:
			temp = y.right
			if temp != None and temp.data > node.data:
				node.setRight(temp)
			else:
				node.setLeft(temp)
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

	def __repr__(self):
		return "Root(" + str(self.root) + ")"

	def tokenize(self, str_repr):
		token = filter(lambda x: x, 
			map(lambda x: x.strip(), 
				re.split("(\(|\,|\))", str_repr)
				)
			)
		token.insert(0, "(")
		token.insert(0, "Root")
		return token

	def parse(self):
		token = self.tokenize(str(self.root))
		t_count, t_offset, t_offset2 = 0, "   ", "..."
		comma = 0
		idx = 0
		acc = "---------------\n"
		while idx < len(token):

			if token[idx] == "Leaf":
				idx += 2
				acc += "Leaf(" + token[idx] + ")"
				acc += "\n" + t_offset*t_count
				idx += 2

			if token[idx] == "(":
				t_count += 1
				acc += "(" + "\n" + t_offset2*t_count

			if token[idx] == ")":
				t_count -= 1
				acc += ")" + "\n" + t_offset*t_count
			
			if token[idx] == "None":
				acc += "None" + "\n" + t_offset*t_count
			
			if token[idx] == ",":
				comma += 1
				if comma % 2 == 0:
					acc += ",\n" + t_offset2*t_count
				else:
					acc += ","

			if token[idx] not in ["(", ")", ",", "Leaf", "None"]:	
				acc += token[idx]

			idx += 1

		acc += ")\n---------------"
		return acc


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
print l
#b.inorderTreeWalk(b.getRoot())
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
print b.parse()
print b

