
import Debug.Trace

hp1 = mkHeap [1..10]

data Heap a = Heap {iheap::[a]} --deriving (Show, Eq)

instance Show a => Show (Heap a) where
	show = show . tail . iheap

instance Eq a => Eq (Heap a) where
	hp1 == hp2 = asList hp1 == asList hp2

mkHeap :: (Ord a) => [a] -> Heap a
mkHeap = Heap . (undefined:)

father, left, right :: Int -> Int

father idx = idx `div` 2
left idx = idx * 2
right idx = idx * 2 + 1

size = length . asList
asList = tail . iheap
get hp n = iheap hp !! n

heapify :: (Ord a) => Heap a -> Heap a
heapify hp = trace ("index:" ++ show midx) foldl maxHeapify hp [midx, midx-1..1]
		where
			midx = father . size $ hp


maxHeapify :: (Ord a) => Heap a -> Int -> Heap a
maxHeapify hp idx
		| bigger > h = swapped idx bgrIdx hp
		| otherwise = hp
		where
			h = get hp idx
			lUnsafe = left idx
			l = if size hp < lUnsafe then idx else lUnsafe
			lElem = get hp l
			rUnsafe = right idx
			r = if size hp < rUnsafe then idx else rUnsafe
			rElem = get hp r
			(bigger, bgrIdx) = if lElem > rElem then (lElem, l) else (rElem, r)
--
swapped :: Ord a => Int -> Int -> Heap a -> Heap a
swapped a b = mkHeap . swapInList a b . asList

swapInList i j ls = [get k x | (k, x) <- zip [0..length ls - 1] ls]
    where get k x | k == i = ls !! j
                  | k == j = ls !! i
                  | otherwise = x
-- 
{-swap i1 i2 (x:xs)

  | n == x = m : (swap n m xs)
  | m == x = n : (swap n m xs)
  | otherwise = x : (swap n m xs)
  where
  	s1 = get hp i1
  	s2 = get hp i2

 # Mutators
	def heapify(self):
		midx = self.father(self.size)
		while midx >= 0:
			self.maxHeapify(midx)
			midx -= 1

	def maxHeapify(self, idx):
		l = self.left(idx)
		r = self.right(idx)

		if l <= self.size-1 and self.heap[l] > self.heap[idx]:
			m = l 
		else:	
			m = idx

		if r <= self.size-1 and self.heap[r] > self.heap[m]:
			m = r

		if m != idx:
			self.swap(idx, m)
			self.maxHeapify(m)



-}