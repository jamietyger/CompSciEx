#ifndef DEADLOCKUTILS_H_INCLUDED
#define DEADLOCKUTILS_H_INCLUDED
#include "graph.h"
void request(Graph* graph, int process, int resource);
void release(Graph* graph, int process, int resource);
void Clear(Graph* graph);
int deadlock(Graph* graph);
void kill(Graph* graph, int process);

#endif // DEADLOCKUTILS_H_INCLUDED
