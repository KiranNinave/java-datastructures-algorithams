
## hashing is a method of sorting and indexing large amount of data
## the idea behind hasing is to allow large amount of data to be index using keys comanly created by formulas

# time complexity of search operation
# best and ideal case O(1)
# worst case O(n) (in case of collision)

### hashing terminologies

hash function: hash function is a function that can used to map data of arbitrary size to fixed size

key: data given by user (ex: employee_id)

hash value: the value return by hash function called hash value or hash code, digest or simply hashes

hash table : it is a data structure which implements associative array abstract data type, a structure that can map keys to values

collision : collision occurs when two keys to the hash function produce same hash value

### hashing function
characteristics of good hash function
1. it distributes hash values uniformly across the hash table (should produce always unique hash key)
2. the hash function should use all input data to it

## collision
collision resolution methods
1. direct chaining 
    we use linked list to store collision at same location
2. open addressing
    types
    1. linear probing
    2. quadratic probing
    3. double hashing