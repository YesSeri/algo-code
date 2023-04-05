// Exercise
//
// Josefine is currently setting up a new computer network at The University of Algorithms. The network consists of NN computers numbered from 00 to N−1N−1 that are initially not connected at all.
//
// She builds the network by adding network cables between pairs of computers one at a time. Two computers AA and BB are connected if there exists at least one series of cables that leads from computer AA to computer BB. As other students need to use connected computers while she is setting up the network, she needs to be able to answer if two specific computers are connected at a specific time.
//
// Given the sequence of "add cable" and "connected" operations, answer all the "connected" queries with a YES or NO.
// Example
//
// 4 5
// A 0 1
// C 0 1
// C 0 3
// A 1 3
// C 0 3
//
// Means the network consists of 4 computers. "A 0 1" means she adds a cable between computer 0 and 1. "C 0 3" asks if computer 0 and 3 are connected. The first time this question is asked, the answer is NO, but the second time they are connected by the cables between 0 and 1 and 1 and 3.
// Input format
//
// Line 1: The integer NN and MM (0≤M≤N≤1.000.0000≤M≤N≤1.000.000) where NN is the number of computers and MM is the total number of add/connected operations.
// Line 2..M+1: Either: "A c1 c2" meaning a cable is added between computers c1 and c2 (0≤0≤ c1, c2 <N<N). "C c1 c2" asks if computers c1 and c2 are connected (0≤0≤ c1, c2 <N<N).
//
// Output format
//
// Line i: YES or NO depending on the whether the computers in the iith connected operation were connected or not.


// Input (stdin)
//
// 4 5
// A 0 1
// C 0 3
// C 0 1
// A 1 3
// C 0 3
//
// Expected Output
//
// NO
// YES
// YES



public class JosephineCodeJudge {
}
