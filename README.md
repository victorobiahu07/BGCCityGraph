# BGCCityGraph
This project illustrated connected graphs taking in model cities to see if train routes were possible between them
AUTHOR: VICTOR OBIAHU
Title: Connectivity Graph Problem
DATE: MAY 24TH 2018

*PROMPT*
Suppose you are given a text file containing pairs of city names, one pair per line, with the names
on each line separated by a comma. Write a java program, called Connected, that reads in such a file and outputs whether two specified cities are connected. The program will be invoked from the command line as
>java Connected cities.txt Boston Hartford
>yes

*ELEMENTS OF THE CODE, COMPILATION INSTRUCTIONS AND COMMENTS
I have included all the vital program files in the directory BGCPartners/src/bgcGraph/ 

The logic is simple for this program. I have the ConnectedHelper class which contains a constructor for the graph, an addEdge method that helps link two cities and most importantly
the isConnected method that does the BFS traversal of the graph checking what city nodes have been visited then enqueuing and dequeuing accordingly. The isConnected method tells the user when the routes are connected or not

The Connected class contains a readFile method that handles the input text file which I have included in the project folder as "cities.txt". 
The readFile method contains essential exception handling for I/O
Connected then calls the readFile method and parses lines of the input text file with the ',' delimiter. 

Finally it takes in two cities as arguments and checks if connected.

To run this program from command line while in the correct directory run the command 
javac Connected.java ConnectedHelper.java 
to compile both classes then 
java Connected Boston Tampa (whatever two cities you desired and wait for output)
 To run the program within Eclipse IDE, you can run the program and pass in two arguments by going to Eclipse--> Run Configurations--> Arguments tab and enter the desired city route to test
    
