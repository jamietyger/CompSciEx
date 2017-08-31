/*
 * Name: Jamie Southgate 3364309
 * Date: 18 September 2015
 * Title: Practical 2 - LinkedList Exercise - LinkedList.C
 * Description:
 * This is my third program written in C ever. This C program is for a LinkedList. The methods are for the LinkedList implementation can be found here.
 *   
 * Inputs: The various mostly do not have any input requirements however the Push and Remove methods require a character input.
 * 
 *
 * Outputs:
 * This program outputs only on certain commands. Printlist which displays the list, Head which displays the front of the list and Tail which displays the back of the list.
 * length displays the length of the List
 *
 * Caveats
 * The LinkedList does not cater for data arguments other than a char from A-Z. 
 * 
 */


#include <stdio.h>
#include <stdlib.h>
#include "Node.h"
/*Global Variables*/
struct node Head; /*Head Node - acts as dummy*/
struct node Tail; /*Tail Node - acts as dummy*/
int length=0; /*length of list*/


/* Method to Print List
 * Takes in no arguments and Prints the List to StdOut. 
 */

void printList(){

    if(length==0){ /*if the length is 0 print a dash*/
       printf("-\n"); 
       return ;
    }
    struct node * current = Head.next; /*create a pointer node current - set to head*/

    printf("%c",current->data); /*print the data at the head*/
    current = current->next; /*move current to the next node*/
    while(current!=NULL){ /*while current is not null*/

        printf("-%c", current->data); /*print a dash followed by the data in the current Node*/
        current = current->next; /*move current to the next node*/
}
printf("\n",""); /*print a new line char to set bash correctly*/

return;
}

/* Method to push Char value to the List
 * Takes in a character as Input and outputs nothing
 */


void push(char val) {
    struct node * newNode; /*create a new Node*/
    newNode = malloc(sizeof(newNode)); /*assign memeory*/

    if(length==0){ 
        Tail.next=newNode; /*if the list is empty set the new node as tail*/
    }

    newNode->data = val; /*set the data in new node to the char inout*/
    newNode->next = Head.next; /*set the next of the node to the same as the next Head*/
    Head.next= newNode; /*Set the head of the head to point to the new node*/
    length++; /*Increase the length of the list by 1*/
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
    if(Head.next==NULL){ /*IF the head node points to nothing*/
        fprintf(stderr,"Input not valid\n");
    }
    else{
        char out = (Head.next->data); /*set char out variable to the head pointer data*/
        printf("%c\n",out); /*print head*/
    }
}
/* Method to print the Tail of the List
 * Void method with no arguments that prints out the tail of the list
 */

void getTail(){
     if(Head.next==NULL){ /*If the head is null list is empty therefore error*/
        fprintf(stderr,"Input not valid\n");
    }
    else{
        printf("%c\n",Tail.next->data); /*Print the Value in the Tail*/
    }
}

/* Method to remove Char value from the List
 * Takes in a character as Input and outputs 1 if succesful and -1 if failed
 */


int removeNode(char input){
     if(length==0){ /*if length =0 nothing so Fail*/
       return -1;
    }
    struct node * currntNode = Head.next; /* create pointer for current Node*/
    struct node * prevNode=NULL; /*create pointer for node previous to current Node*/

    while(currntNode!=NULL){ /*while current node is not null*/
            /*printf("%s\n","SEARCHING");*/

     if(currntNode->data==input){ /*if the data in node matches the char input*/

       
        if(prevNode==NULL){ /* if the Node is the First element in the List*/
            Head.next =(currntNode->next); /*Set the Head to point to the node after the current node*/
            /*printf("%s\n","IT IS THE FIRST ELEMENT OF LIST");*/
        }
        else{
            /*printf("%s\n","IT IS IN THE LIST JUST DELETING NOW");*/
            prevNode->next = currntNode->next; /*Else set the previous Node next to point to the next of the current node*/
            if(Tail.next==currntNode){ /*if the the current node is the Tail*/
                Tail.next=prevNode; /*set the previous Node to be the Tail*/
            }
        }

        length--; /*shorten the length by 1*/
        return 1;
     }
        prevNode = currntNode; /*update previous node - move on 1 node*/
        currntNode = currntNode->next; /*update current node - move on 1 node*/

    }
    return -1; /*Else Fail*/
}


