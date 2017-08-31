#ifndef NODE_H_INCLUDED
#define NODE_H_INCLUDED

typedef struct node {
            char data;
            struct node *next;
}Node;

void insertBefore(Node **hp,char listnode,char input);
void insertAfter(Node **hp,char listnode,char input);
void findNode(Node **hp,char input);
void removeNode(Node **hp);
void append(Node **hp, char input);
void push(Node **hp,char input);
void printList(Node **hp);
void getLength();
void getHead();
void getTail();
Node **Find(Node **hp, char input);
Node * Head;
Node * Tail;
#endif // NODE_H_INCLUDED
