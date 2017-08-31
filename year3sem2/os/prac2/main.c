/*
 * Name: Jamie Southgate 3364309
 * Date: 18 September 2015
 * Title: Practical 2 - LinkedList Exercise - main.C
 * Description:
 * This is my third program written in C ever. This program reads a file, takes a command and char value A-Z input from the file ie. Push A 
 * and then processes the command.  
 * Inputs:
 * The program takes input as argument file path.
 *
 * Outputs:
 * This program outputs only on certain commands. Printlist which displays the list, Head which displays the front of the list and Tail which displays the back of the list.
 * length displays the length of the List
 *
 * Caveats
 * The program only assumes one command per line and one piece of data 'type char'. I am still unsure as to whether 2 chars after each other
 * will output an error.
 * 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "LinkedList.c"

/*
 * The main routine handles the LinkedList and ReadFile
 *
 * Algorithm
 * The method fist opens the file declared in the arguments and then reads a line of the file.
 * The method then splits the line by space and validates the commands and data. if not valid display error.
 * The method then processes the command and if the command has a data requirement processes the data requirement
 * through character validation and then processes the command. 
 * Outputs
 * We would like to return 0 so the program is successful and print any errors regarding inputs.
 *
 *  
 */

int main(int argc, char *argv[])
{
	char *ptr; /*declare character pointer for splitting string*/
	char *filename = argv[1]; /* declare string for file name*/
	char *Input[256]; /* declare array for Commands and Data*/
	FILE *file = fopen(filename, "r"); /*Open File*/

	if ( file != NULL ) /*Check if File is not NULL*/
	{
    char line[256]; /*delcare char array for line*/
    while (fgets(line, sizeof line, file) != NULL) /* read the file line by line until EOF*/
    {
            if(strlen(line)<4){ /*If length of line is less than 4, too short error*/
                fprintf(stderr,"Input not valid\n");
            }
            else{

                ptr = strtok(line, " "); /*split line by space*/
                int count=0;		/*declare counter variable*/
                while(ptr != NULL)  /*while there is more to the string pointer*/
                    {
                        int len = strlen(ptr); /* get length of string*/
                        if (ptr[len - 1] == '\n'){ /*check if last character is a new line character*/
                                ptr[len - 1] = '\0'; /* replace with null terminator*/
                        }
                        Input[count]=(ptr);   /*place the splitted string into the input array*/
                        ptr = strtok(NULL, " "); /* and keep splitting the line*/
                        count++; /*increment count to place data element at position 1 in Input Array*/
                    }

                    if(strcmp(Input[0],"Push") == 0){ /*If the command is Push*/

                        char *varb=Input[1]; /*pointer points towards data*/
                        if(isChar(varb[0])==1){ /*check if the data is a valid character A-Z*/
                            push(varb[0]); /*Push to LinkedList*/
                        }
                    else{
                        fprintf(stderr,"Input not valid\n"); /*Print Error*/
                    }
                    }
                    else if(strcmp(Input[0],"PrintList") == 0){ /*If the command is printList output list*/
                        printList();
                    }
                    else if(strcmp(Input[0],"Remove") == 0){ /*If the command is Remove*/

                        char *varb1=Input[1]; /* pointer points towards data part*/

                        if(isChar(varb1[0])==1){ /*if the data is a character*/
                            if(removeNode(varb1[0])!=1){ /*try and remove the character from list and if failed print error*/
                                 fprintf(stderr,"Input not valid\n");
                            }

                        }
                        else{
                            fprintf(stderr,"Input not valid\n"); /*else print error*/

                        }
                        }
                    else if(strcmp(Input[0],"Head") == 0){ /*if command is Head print Head of LinkedList*/
                        getHead();
                    }
                    else if(strcmp(Input[0],"Tail") == 0){ /*if command is Tail print back of LinkedList*/
                        getTail();
                    }
                    else if(strcmp(Input[0],"Length") == 0){ /*if command is Length print the length of LinkedList*/
                        getLength();
                    }
                    else{
                        fprintf(stderr,"Input not valid\n"); /*otherwise the command is not valid*/


                    }

                }

        }

    }
    fclose(file); /*close the file*/

    return 0;
}
/*
 * The isChar method checks wether the data argument of the line is valid
 *
 * Algorithm
 * The method takes in a character pointer and then compares the value of the pointer to the characters in the Array and returns 1 if successful.
 * Inputs
 * Character pointer
 *
 * Outputs
 * We would like to return 1 if the character is in the array else return 0 as it does not exist.
 *
 *  
 */


int isChar(char * in){
	char letters[26] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    char cmp = (int)in;
    int i = 0;
   for(i;i<26;i++){
	if(cmp == letters[i]){
    return 1;
   }
}
   
    return 0;
   
}







