## what is trie
1. it is a search tree, which is typically used to store/search strings in space/time efficient way
2. in it, any node can store non repetitive multiple characters
3. also, every node stores link of next character of the string
4. also, every node keeps a track of "end of string"

## creating trie
1. create black node with map and endOfString property

## inserting element in trie
insert operations with trie is easy
1. case : inserting element in try when try is empty (air)
2. case : new string prefix common with previous string prefix (air, aio) 
3. case : new string prefix is already present as complete string (airk)
4. case : string to be inserted is already present in trie

## deleting string from trie
deleting string from trie is complex
1. case : some other word prefix is same as this word (BCDE, BCKG) (remove D node from C)
2. case : this word if prefix of some other word (BCDE, BCDEF) (mark endOfString=false on E)
3. case : some other word is prefix of this word (BCDE, BC) (remove D from map)
4. case : no buddy depend on node (so just delete it :)