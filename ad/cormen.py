import math

def inversion_of(seq):

	result = []
	for idx1, e1 in enumerate(seq):

		for idx2, e2 in enumerate(seq):

			t1, t2 = seq[idx1], seq[idx2]
			if idx1 < idx2 and t1 > t2: 
				result.append((t1, t2))

	return result

def subset_sum(seq, x):
	idx1 = 0
	while idx1 < len(seq):
		idx2 = 0
		while idx2 < len(seq):
			if idx1 != idx2:
				s = seq[idx1] + seq[idx2]
				if s == x:
					return True
			idx2 += 1
		idx1 += 1
	return False

def sort_and_count(l):
	if len(l) <= 1:
		return (0, l)
	else:
		middle = len(l) / 2
		a = l[:middle]
		b = l[middle:]
		ca = sort_and_count(a)
		cb = sort_and_count(b)
		cl = merge_and_count(a, b)
	return (ca[0] + cb[0] + cl[0], l)

def merge_and_count(a, b):
	merged = []
	count, a_size = 0, len(a)
	aidx, bidx = 0, 0
	while aidx < a_size and bidx < len(b):
		if a[aidx] <= b[bidx]:
			merged.append(a[aidx])
			aidx += 1
		else:
			merged.append(b[bidx])
			bidx += 1
			count += (a_size - aidx)
	merged.extend(a[aidx:])
	merged.extend(b[bidx:])
	return (count, merged)


# A[x]-A[y] | x>y
def gordonGecko(A):
	res = -1
	min_idx, max_idx = 0, 1
	min_value = A[0]
	for i in range(1, len(A)):
	    tmp_max = max(res, A[i] - min_value)
	    if tmp_max > res:
	    	max_idx = i
	    	res = tmp_max
	    min_value = min(min_value, A[i])
	    i += 1
	if res <= 0:
		return (-1, -1, -1)
	min_idx = min(enumerate(A[:max_idx]), key=lambda x: x[1])[0]
	return (min_idx, max_idx, res)


# TEST
def assertEquPrice(expected, was):
	a = expected
	b = was
	if a == b:
		return True
	print "Was expected: %s" % str(a)
	print "Actually was: %s" % str(b)
	raise Exception("False! Error")

def shouldBeAnOptimalOf(expected, course):
	assertEquPrice(expected, gordonGecko(course))

def positive_test():
	shouldBeAnOptimalOf((0,3,7), [2,5,2,9,3,4,0,2])

	shouldBeAnOptimalOf((0,7,17), [3,5,7,9,4,4,7,20])

	shouldBeAnOptimalOf((5,7,18), [3,19,7,9,4,2,7,20])

	shouldBeAnOptimalOf((0,1,1), [1,2])

	shouldBeAnOptimalOf((0,1,9), [1,10,2,2,1,1,0,0])
	
	shouldBeAnOptimalOf((5,6,6), [5,3,7,5,6,2,8,5,1])

	shouldBeAnOptimalOf((0,4,9), [1,2,3,4,10,6,7,8,9,10])

def negative_test():
	shouldBeAnOptimalOf((-1,-1,-1), [2,1])

	shouldBeAnOptimalOf((-1,-1,-1), [2,2])

	shouldBeAnOptimalOf((-1,-1,-1), [3,3,2,2,1,1,0,0])


positive_test()
negative_test()





def fun1(n):
	if n < 3:
		return 43
	return 2*fun1(n-1) + 4*fun1(n-2) + 8*fun1(n-3)

