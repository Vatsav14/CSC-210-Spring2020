README File for PA11: TravelingSalesperson

Author: Vatsav Sethupathi

Following are the times for 10 consecutive runs of each of the 3 approaches
**Average times listed below these**

heuristic: cost = 3.3969307170000005, 1 milliseconds
mine     : cost = 1.670312525, 6 milliseconds
backtrack: cost = 1.3566775349999998, 134 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 0 milliseconds
backtrack: cost = 1.3566775349999998, 92 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 0 milliseconds
backtrack: cost = 1.3566775349999998, 75 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 0 milliseconds
backtrack: cost = 1.3566775349999998, 75 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 1 milliseconds
backtrack: cost = 1.3566775349999998, 95 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 0 milliseconds
backtrack: cost = 1.3566775349999998, 73 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 0 milliseconds
backtrack: cost = 1.3566775349999998, 79 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 0 milliseconds
backtrack: cost = 1.3566775349999998, 76 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 0 milliseconds
backtrack: cost = 1.3566775349999998, 75 milliseconds


heuristic: cost = 3.3969307170000005, 0 milliseconds
mine     : cost = 1.670312525, 0 milliseconds
backtrack: cost = 1.3566775349999998, 66 milliseconds

On average, the time taken for these functions are listed below
(The costs remained the same, refer above)

heuristic: 0 milliseconds
mine     : 0.5 milliseconds
backtrack: 84 milliseconds

The heuristic approach has the least run-time since it is a simple algorithm that follows
an n^2 time complexity. It simply searches for the least distance between two connected
nodes.

The backtracking approach has the highest run-time out of all the functions. This is 
because it is a brute force method that searches through every single permutation of 
the nodes in the graph to find which would provide the most optimal solution. This is
roughly an n! operation. Although this has a horrible run-time, this assures to find 
best solution to the problem, that is, the shortest path for the salesperson to follow.

My approach is in between both these approaches. It operates in a slightly higher time
frame than the first heuristic approach, and is much faster than the backtracking
approach, but the solution it provides is not as optimal as the one provided by it. 
However, this solution mostly always proves to be better than or equal to that provided
by the heuristic approach. This method doesn't assume that the first node will always
be 1. Therefore, it is able to find a more optimal path by abandoning this assumption.
This is roughly an n^3 algorithm which is still leaps and bouds better than the n!
efficiency possessed by the backtracking algorithm.
