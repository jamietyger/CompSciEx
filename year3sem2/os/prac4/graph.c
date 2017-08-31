/*
 * Name: Jamie Southgate 3364309
 * Date: 14 October 2015
 * Title: Practical 4 - DeadLock Exercise - graph.c
 * Description:
 * This is my fourth program written in C ever. This program reads a file, takes a command and char value A-Z input from the file ie. Push A
 * and then processes the command.
 * Inputs:
 * The program takes input as argument file path.
 *
 * Outputs:
 * This program outputs only outputs Deadlock if a deadlock occurs or input not valid if an error
 *
 * Caveats
 * The program only assumes one command per line and one piece of data 'type char'. I am still unsure as to whether 2 chars after each other
 * will output an error.
 *
 */

#include "graph.h"
#include "Node.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
 * New Graph Method:
 *
 * Algorithm
 * The method creates a struct graph with 52 nodes (array size) and assigns memory. It then sets all the nodes to null.
 * Inputs
 * None
 * Outputs
 * We would like to return the Graph
 *
 *Caveats: None so far
 */

Graph* newGraph()
{

	Graph* graph = malloc(sizeof(Graph)); /*Create instance of Graph and assign memory*/
	graph->size = 52; /*set size to 52 - 26 letters in alphabet *2*/
	int i;
	for(i=0;i<52;i++) /*for every item in array*/
	{
		graph->adjL[i] = NULL; /*set the linkedlist of each node to NULL*/
	}

	return graph; /*return the graph*/
}

/*
 * Insert Edge Method:
 *
 * Algorithm
 * The method appends a node to the LinkedList Node specified in the array. Basically connecting two Nodes together. More explained in LinkedList
 * Inputs
 * The Graph, A source node as type int and a destination node type int
 * Outputs
 * None
 *
 *Caveats: None so far
 */


void insertEdge(Graph* graph, int src, int dest)
{
    append(&(graph->adjL[src]),dest); /*append destintion the linkedlist which has the source as its head*/
}
/*
 * Delete Edge Method:
 *
 * Algorithm
 * The method finds and deletes a node in the LinkedList Node specified in the array. Basically disconnecting two Nodes. More explained in LinkedList
 * Inputs
 * The Graph, A source node as type int and a destination node type int
 * Outputs
 * None
 *
 *Caveats: None so far
 */

void deleteEdge(Graph* graph, int src, int dest)
{
	findNode(&(graph->adjL[src]), dest);

}

/*
 *  isConnectedEdge Method:
 *
 * Algorithm
 * The method finds and checks if a node exists in the graph
 * Inputs
 * The Graph,and a node type int
 * Outputs
 * 1 if yes, 0 if no.
 *
 *Caveats: None so far
 */

int isConnected(Graph* graph, int node)
{

	if (graph->adjL[node]) /*if the graph does not point to null at the vertex then it is connected*/
		return 1; /*return true*/
    int i;
	int n = graph->size;
	for (i = 0; i < n; i++){ /*loop for every node in graph*/
		if (isEdge(graph, i, node)==1) /*check if an edge exists between the node wanted and the node looping through*/
			return 1; /*return 1 if yes*/
	}
	return 0; /*else return 0*/
}

/*
 * isEdge Method:
 *
 * Algorithm
 * The method finds  a node in the LinkedList at Node specified in the array.It uses the Find function. More explained in LinkedList
 * Inputs
 * The Graph, A source node as type int and a destination node type int
 * Outputs
 * 1 if yes, 0 if no.
 *
 *Caveats: None so far
 */

int isEdge(Graph* graph, int src, int dest)
{
	if ( Find(&(graph->adjL[src]), dest)==1 ) /*if find returns true then*/
		return 1; /* yes*/
	return 0; /*no*/

}

/*
 * isEdge Method:
 *
 * Algorithm
 * The method finds  a node in the LinkedList at Node specified in the array.It uses the Find function. More explained in LinkedList
 * Inputs
 * The Graph, A source node as type int and a destination node type int
 * Outputs
 * 1 if yes, 0 if no.
 *
 *Caveats: None so far
 */

/*
 * isCyclicUtil Method:
 *Referenced: *http://www.geeksforgeeks.org/detect-cycle-in-a-graph/*
              *http://stackoverflow.com/questions/19113189/detecting-cycles-in-a-graph-using-dfs-2-different-approaches-and-whats-the-dif*
 * Algorithm
 * The method uses 2 arrays, visited and revisited (recStack). If the current node v has not been visited then you mark it in both
 * arrays. You then create a node temp which points to the current Root Node. You then check recursively if temp was not visited and
 * if a cycle was detected. If temp is revisited then a cycle has been found.
 * Inputs
 * The Graph, a node v, an array for visited and revisited.
 * Outputs
 * 1 if yes, 0 if no.
 *
 *Caveats: None so far
 */

int isCyclicUtil(int v, int visited[], int recStack[],Graph* graph){

if(visited[v]==0){ /*if node is not visited*/

    visited[v]=1; /*mark it*/
    recStack[v]=1; /*mark it*/
    Node* temp; /*create node temp*/
    temp = graph->adjL[v];/*point temp to the root node of array list*/
        while(temp!=NULL) /*while temp is not null*/
		{
			int tempdata = temp->data; /*get int value of Process/Resource*/
		    /*check if temp has NOT been visited AND that there was a cycle(recursively)*/
			if (visited[tempdata]==0 && isCyclicUtil(tempdata, visited, recStack, graph)==1)
				return 1; /*a cycle has occured*/
            /*check if temp was revisited*/
			else if (recStack[tempdata]==1)
				return 1; /*a cycle has occured*/
            temp = temp->next; /*move to next node*/
		}
	}
	recStack[v] = 0;/*unmark the current root*/
	return 0;
}

/*
 * isCyclic Method:
 *Referenced: *http://www.geeksforgeeks.org/detect-cycle-in-a-graph/*
              *http://stackoverflow.com/questions/19113189/detecting-cycles-in-a-graph-using-dfs-2-different-approaches-and-whats-the-dif*
 * Algorithm
 * The method creates two arrays. One for visited and another for revisited nodes and populates them with 0's.
 * It then uses the Utility method on each node to check if a cycle exists.
 * Inputs
 * The Graph.
 * Outputs
 * 1 if yes, 0 if no.
 *
 *Caveats: None so far
 */


int isCyclic(Graph* graph){

int visited[52]; /*create visited array*/
int recStack[52]; /*create revisited nodes - Stack*/
int i;
for(i=0; i<52;i++){ /*populate each with 0 - unmarked*/
    visited[i]=0;
    recStack[i]=0;
}

for(i=0; i<52;i++){ /*go through each node in graph and check if cycle has occured*/
    if(isCyclicUtil(i,visited,recStack,graph)==1)
        return 1;
}
return 0;
}


