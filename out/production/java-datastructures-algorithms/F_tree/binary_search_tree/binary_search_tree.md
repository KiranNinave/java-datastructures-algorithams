## binary tree
1. can perform insrtions, deletions, and retrievals in O(logn) time
2. the left child always has a smaller value than its parent
3. the right child always has a larger value than its parent
4. this means everything to the left of the root is less than the value of the root
5. and everything to the right of the root is greater than the value of the root
6. because of that we can do binary search

## insert operation
1. first insert is a root node
2. then after inserts if value is less than node value then we insert left to the node
3. if value is greater than node then we insert it right to the node
4. we continue this process recursively

## delete operation
hint : call delete function with root node and return it ex this.root = delete(this.root, value) { write delete function so that it returns whole tree except deleted value }
hint: please check source code
delete operation is slightly complex in case of binary tree

there three possible cases
1. deleting node with no children
2. deleting node with one children
3. deleting node with two children

## deleting node with no children or one children
1. this two cases are equal if left is null then just replace with right
2. if right is null then replace with left
3. if both null then above two conditions automatically handle it :)

## deleting node with two children
1. if the deleted node has two children then we need to replace it with either one children
2. if we intent to replace it with left subtree then we need to choose max node from left subtree 
3. if we intent to replace it with right subtree then we need to choose min node from right subtree


