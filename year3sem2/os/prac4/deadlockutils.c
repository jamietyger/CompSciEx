/*
 * Name: Jamie Southgate 3364309
 * Date: 14 October 2015
 * Title: Practical 4 - DeadLock Exercise -
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

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "deadlockutils.h"
#include "Node.h"
#include "graph.h"
#include <stdbool.h>
void Clear(Graph* graph)
{
	graph = newGraph();
}

void release(Graph* graph, int process, int resource)
{
	if (isEdge(graph, process, resource))
    	{
		deleteEdge(graph, process, resource);
		Node** nextProcess = &(graph->adjL[resource]);
        if (*nextProcess)
    	{
		int process = (*nextProcess)->data;
		insertEdge(graph, process, resource);
		deleteEdge(graph, resource, process);
	}
	}
	else
		 fprintf(stderr, "Input not valid\n");
}


int deadlock(Graph* graph){
    return isCyclic(graph);
}
void request(Graph* graph, int process, int resource)
{
   	int i;
	int n = graph->size;
	int free = 1;
	for (i = 0; i < n/2; i++)
    	{
		if (Find(&(graph->adjL[i]), resource)==0)
		{
			free = 0;
		}

	}
	if (!isEdge(graph, process, resource) && !isEdge(graph, resource, process))
    	{
		if(free)
		{
			insertEdge(graph, process, resource);
		}
		else
		{
			insertEdge(graph, resource, process);
        	}
	}
	else
		 fprintf(stderr, "Input not valid\n");

}


void kill(Graph* graph, int process)
{
	int i;
	int n = graph->size;
	Node** vert = &(graph->adjL[process]);
	if ( isConnected(graph, process) )
    	{
		while (*vert != NULL)
		{
			release(graph, process, (*vert)->data);
		}
		for (i = n/2; i < n; i++)
		{
			if (isEdge(graph, i, process))
			{
				deleteEdge(graph, i, process);
			}
		}
	}
	else
		 fprintf(stderr, "Input not valid\n");
}
