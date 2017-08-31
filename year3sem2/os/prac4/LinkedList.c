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


#include "Node.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

Node * Head;
Node * Tail;
int length=0;

void insertBefore(Node **hp,char listnode,char input){
    Node **scanner = hp;
    while(*scanner!=NULL && *(&(*scanner)->data)!=listnode){
        scanner = &(*scanner)->next;
    }
    if(*scanner!=NULL){
    Node * newNode; /*create a new Node*/
    newNode = malloc(sizeof(newNode)); /*assign memeory*/
    newNode->data=input;
    newNode->next=*scanner;
    *scanner = newNode;
    length++;
    }
    else{
        fprintf(stderr,"Input not valid\n");
    }

}
void insertAfter(Node **hp,char listnode,char input){

    Node **scanner = hp;
    while(*scanner!=NULL && *(&(*scanner)->data)!=listnode){
        scanner = &(*scanner)->next;
    }
    if(*scanner!=NULL){
    Node * newNode; /*create a new Node*/
    newNode = malloc(sizeof(newNode)); /*assign memeory*/
    newNode->data=input;
    newNode->next=(*scanner)->next;
    (*scanner)->next = newNode;
    length++;
    }
    else{
        fprintf(stderr,"Input not valid\n");
    }
}
void findNode(Node **hp,char input){
    Node **scanner = hp;
    while(*scanner!=NULL && *(&(*scanner)->data)!=input){
        scanner = &(*scanner)->next;
    }
    if(*scanner!=NULL){
    removeNode(scanner);
    length--;
    }
    else{
        fprintf(stderr,"Input not valid\n");
    }
}
Node **Find(Node **hp, char input){
    Node **scanner = hp;                    /*Create a temporary **Node */
	while(*scanner != NULL )/*Loop until correct Pointer Pointer is found*/
    {
        if(*(&(*scanner)->data) == input){
            return &(*scanner);
        }
		scanner = &(*scanner)->next;              /*Update the Pointer Pointer*/
	}
    return NULL;
}

void removeNode(Node **hp){
    Node *temp=(*hp)->next;
    if((*hp)->next==NULL){
        (*hp)=NULL;
        free(*hp);
        return;
    }
    else if((*hp)->next!=NULL){
        (*hp)->data=temp->data;
        (*hp)->next=temp->next;
        free(temp);
        return;
    }
    /*
    Node *temp = (*scanner)->next;
    printf("TEMP CHAR %c\n",(temp->data));

    return 1;*/
}
void append(Node **hp, char input){

    Node **scanner = hp;
    while(*scanner!=NULL){
        scanner = &(*scanner)->next;
    }

    Node * newNode; /*create a new Node*/
    newNode = malloc(sizeof(newNode)); /*assign memeory*/
    newNode->data=input;

    newNode->next = NULL;
    *scanner = newNode;
    Tail=newNode;
    if(length==0){
        Head=newNode; /*if the list is empty set the new node as tail*/
    }
    length++;
}

void push(Node **hp,char input){
    Node * newNode; /*create a new Node*/
    newNode = malloc(sizeof(newNode)); /*assign memeory*/
    newNode->data=input;
    newNode->next=*hp;
    *hp = newNode;
    if(length==0){
        Tail=newNode; /*if the list is empty set the new node as tail*/
    }
    length++;
}

void printList(Node **hp){

    if(length==0){ /*if the length is 0 print a dash*/
       printf("-\n");
       return ;
    }
    Node **current = hp; /*create a pointer node current - set to head*/

    printf("%c",(*current)->data); /*print the data at the head*/
    current = &(*current)->next; /*move current to the next node*/
    while(*current!=NULL){ /*while current is not null*/

        printf("-%c", (*current)->data); /*print a dash followed by the data in the current Node*/
        current = &(*current)->next; /*move current to the next node*/
}
printf("\n"); /*print a new line char to set bash correctly*/

return;
}

/* Method to print the global variable length
 * Void method with no arguments that prints out the length of the list
 */

void getLength(){
    printf("%i\n",length);
}

/* Method to print the Head of the List
 * Void method with no arguments that prints out the head of the list
 */

void getHead(){
    if(Head==NULL){ /*IF the head node points to nothing*/
        fprintf(stderr,"Input not valid\n");
    }
    else{
        /*set char out variable to the head pointer data*/
        printf("%c\n",(Head->data)); /*print head*/
    }
}
/* Method to print the Tail of the List
 * Void method with no arguments that prints out the tail of the list
 */

void getTail(){
     if(Head==NULL){ /*If the head is null list is empty therefore error*/
        fprintf(stderr,"Input not valid\n");
    }
    else{
        Node *current = Head; /*create a pointer node current - set to head*/

    while(current->next!=NULL){ /*while current is not null*/
        current = current->next; /*move current to the next node*/
    }
    Tail=current;
        printf("%c\n",(Tail->data)); /*Print the Value in the Tail*/
    }
}
