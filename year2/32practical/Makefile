# The name assigned to 
#         OBJ  is hanoi so that $(OBJ) ==> hanoi,
#         DS   is other         $(DS) ==> other and
#         DATA is input.data    $(DATA) ==> input.data
#         
#         The capitals are a convention, lower case also works.
#                      
# Running:
# make
#         Creates $(OBJ).java == DFA.java and
#         sends all compilation errors to errors and
#         and then executes DFA with input.data as input and 
#         sends all output to the file output.
#
# make clean 
#         Removes all 
#         
#         .class files, 
#         files ending in ~, 
#         the errors file and
#         the output file.
#

OBJ = dprac3
DS = other
DATA = in.data

all:
	-touch $(DATA)
	-touch output
	-rm errors
	javac -deprecation $(OBJ).java 2> errors
	-rm output
	java $(OBJ) $(DATA) > output

$(DS).java: 
	javac -deprecation $(DS).java

clean:
	-rm *~ *.class errors output
	-rm *.code *.plain *.txt
