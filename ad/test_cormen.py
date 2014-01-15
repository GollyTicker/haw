import unittest
import utils
import cormen

class TestStack(unittest.TestCase):

    def test_subset_sum(self):
        collection = [5,4,3,2,1]
        result = cormen.subset_sum(collection, 9)
        self.assertEqual(True, result)
        result = cormen.subset_sum(collection, 11)
        self.assertEqual(False, result)

    def test_sort_and_count(self):
        collection = [5,4,3,2,1]
        result = cormen.sort_and_count(collection)[0]
        self.assertEqual(10, result)
        collection = [4,3,2,1]
        result = cormen.sort_and_count(collection)[0]
        self.assertEqual(6, result)

    def test_inversion_of(self):
        collection = [4,3,2,1]
        result = cormen.inversion_of(collection)
        self.assertEqual([(4,3),(4,2),(4,1),(3,2),(3,1),(2,1)], result)


if __name__ == '__main__':
    unittest.main()