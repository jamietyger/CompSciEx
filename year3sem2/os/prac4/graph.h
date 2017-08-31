#ifndef GRAPH_H_INCLUDED
#define GRAPH_H_INCLUDED
typedef struct Graph
{
	int size;
	struct Node* adjL[52];
}Graph;
Graph* newGraph();
void insertEdge( Graph* graph, int src, int dest);
void deleteEdge(Graph* graph, int src, int dest);
int isConnected(Graph* graph, int node);
int isEdge(Graph* graph, int src, int dest);
int isCyclic(Graph* graph);
int isCyclicUtil(int v, int visited[], int recStack[],Graph* graph);

#endif
