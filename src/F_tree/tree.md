
## tree
1. Every item in a tree is a node
2. The node at top of tree is root
3. Every non-root node has only one and one parent
4. A leaf node has not children
5. A singleton tree has only one node - the root

## path
is a sequence of node require to go from one node to another node

## node depth
the depth of node is number of edges from node to root
1. the root node have depth of 0
2. the leaf node have max depth
3. the depth of tree is depth of leaves

## node height
the height of tree is the number of edges on the longest path from node to a leaf
the height of tree is never more than logN 
( ex if tree have 10 nodes then the height of tree is log2(10) = log2(2^3.x) = |3.x| = 4
so height of tree is 4 )

1. the root node have max height
2. the leaf node have height of 0
3. the height of the tree is height of root

## ancestors
the ancestors of perticular node is nodes that code in path travel from root node to that node

