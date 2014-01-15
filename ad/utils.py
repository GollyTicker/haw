import random
import sys
import math

def random_list(size, _from, _to):
	return [random.randint(_from, _to) for _ in xrange(size)]

def sorted_list(_from, _to):
	return [_ for _ in xrange(_from, _to)]

def reversed_sorted_list(_from, _to):
	return sorted_list(_from, _to)[::-1]

def max_list(size, _from, _to, max_elem):
	collection = random_list(size, _from, _to)
	return random_insert(collection, max_elem)

def random_insert(collection, elem):
	size = len(collection)
	rdm_idx = random.randint(0,size)
	collection.insert(rdm_idx, elem)
	return collection

def findNextPotenceOfTwoBy(size):
	return int(2**math.ceil(math.log(size, 2)))

def createPotenceOfTwoSequence(seq):
	seq_size = len(seq)
	size = findNextPotenceOfTwoBy(seq_size) - seq_size
	min_val = -sys.maxint - 1
	for _ in xrange(size+1):
		seq.append(min_val)
	return seq

def buildPotenceOfTwoLists(n):
	base = "0b1"
	table = []
	for i in xrange(n):
		base+="1"
		int_base = int(base, 2) + 2
		table.append(int_base)
	return table

