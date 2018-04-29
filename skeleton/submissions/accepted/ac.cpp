#include<iostream>
#include<unordered_set>
#include<unordered_map>
#include<algorithm>
using namespace std;
const long long MOD = 1000000007;
struct Node {
	long long numNodes;
	Node *up;
	long long rank;
	Node() {
		up = nullptr;
		rank = 0;
		numNodes = 1;
	}
};

Node *findRoot(Node *node) {

	if (node == nullptr) {
		return nullptr;
	}
	if (node->up == nullptr) {
		return node;
	}
	node->up = findRoot(node->up);

	return node->up;

}

long long unionNodes(Node *one, Node *two) {

	Node *rootOne = findRoot(one);
	Node *rootTwo = findRoot(two);
	Node *newRoot;
	Node* oldRoot;
	if (rootOne->rank == rootTwo->rank) {
		rootTwo->up = rootOne;
		rootTwo->rank++;
		newRoot = rootOne;
		oldRoot = rootTwo;
	}
	else if (rootOne->rank > rootTwo->rank) {
		rootTwo->up = rootOne;
		newRoot = rootOne;
		oldRoot = rootTwo;
	}
	else {
		rootOne->up = rootTwo;
		newRoot = rootTwo;
		oldRoot = rootOne;
	}
	newRoot->numNodes += oldRoot->numNodes;
	return newRoot->numNodes;
}

//got modInverse idea from GeeksForGeeks
long long modInverse(long long a, long long m)
{	
	long long y = 0;
	long long modCopy = m;
	long long returnInverseValue = 1;	
	if(m!=1)
	{

		while (a > 1)
		{
			long long quotient = a / m;long long mC = m;

			m = a % m;
			a = mC;
			mC = y;
			y = returnInverseValue - quotient * y;
			returnInverseValue = mC;
		}

		if (returnInverseValue < 0)
			returnInverseValue += modCopy;

		return returnInverseValue;
	}
	return 0;
}

int main() {


	ios_base::sync_with_stdio(false);
	long long tCases;cin >> tCases;
	for (long long i = 0;i < tCases;i++) {
		long long n, m;cin >> n >> m;
		long long numPeople = n;
		vector<Node*> nodes(n + 1);
		for (long long i = 0;i <= n;i++) {
			nodes[i] = new Node();
		}
		long long totalWays = 1;
		for (long long k = 0; k < m;k++) {
			long long i, j;cin >> i >> j;
			long long currOne = findRoot(nodes[i])->numNodes;
			long long currTwo = findRoot(nodes[j])->numNodes;
			if (findRoot(nodes[i]) == findRoot(nodes[j])) {
				cout << totalWays << endl;
			}
			else {
				long long newFamilyCount = unionNodes(nodes[i], nodes[j]);
				numPeople--;
				long long oneModInv = modInverse(currOne, MOD);
				long long twoModInv = modInverse(currTwo, MOD);
				totalWays = ((totalWays % MOD) * (oneModInv % MOD) % MOD);
				totalWays = ((totalWays % MOD) * (twoModInv % MOD) % MOD);
				totalWays = ((totalWays%MOD)*(newFamilyCount%MOD)) % MOD;
				cout << totalWays << endl;
			}

		}
		cout << numPeople << " " << totalWays << endl;
		for (int i = 0;i < nodes.size();i++) {
			delete nodes[i];
		}

	}

}
