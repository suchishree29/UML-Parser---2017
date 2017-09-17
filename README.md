# UML-Parser---2017

This Project aims at creating a Parser which converts Java Source Code into a UML Class Diagram.

# Tools and Libraries Used:

● <b>Eclipse IDE(Kepler Service Release 2):</b>
 Used to write, compile, and test project code.
 
 ● <b>JavaParser:</b>
 https://github.com/javaparser/javaparser/wiki/Manual
 
 JAR -> javaparser-1.0.8.jar
 Using Visitor classes like InterfaceFirstVisitor ,FieldVisitor and its visit methods, parsed Java source code to get intermediate code.
 This library is used to parse the input java files and get the ASTs. javaparser.jar uses libraries and functions that follow the   Visitor pattern. Same pattern is followed in the project code to parse the input java files and create the intermediate code(ASTs). The intermediate language is formed as is accepted by the plantUML.
 
 ● <b>Plant UML</b>
 http://plantuml.com
 
 JAR -> plantuml.jar
 
 PlantUml generates  the final class diagram. The generateImage() method takes the input intermediate code(generated in previous step) and converts it to the Class Diagram Image. 
 
 Make a file containing PlantUML commands, either with an editor or when running other software which calls PlantUML.
 Run (or have the software call) PlantUML with this file as input. The output is an image, which either appears in the other software,  or is written to an image file on disk.
 For example,

 java -jar plantuml.jar classDiagram.txt 
 
 and the result is a nice diagram in classDiagram.png as shown below :
 
 ![alt tag](https://github.com/suchishree29/UML-Parser---2017/blob/master/Sample%20Java%20File/TestCase4/outfile.png)
 
 ● <b>GraphViz</b>
http://www.graphviz.org/

Graphviz is open source graph visualization software. Graph visualization is a way of representing structural information as diagrams of  abstract graphs and networks. It has important applications in networking, bioinformatics,  software engineering, database and web     design, machine learning, and in visual interfaces for other technical domains. 
Graphviz must be installed in the default directory of your system. c:\Program Files\GraphvizX.XX (Windows) or /usr/bin/do.

## Steps to run the project using command line in Windows without class.jar file:
1. Go to Java Bin folder and set the path using following command:
    set path=%path%;C:\Program Files\Java\jdk1.8.0_121\bin
2. To Compile:
   javac -cp "../javaparser-1.0.8.jar;../plantuml.jar;" *.java 
3. To Run:
   java -cp "../javaparser-1.0.8.jar;../plantuml.jar;" UMLParser <source folder> <output file name>
   <source folder> is a folder name where all the .java source files will be.
   <output file name> is the name of the output image file your program will generate ( .jpg, .png or .pdf format)
 
 
 ## Steps to run the project using command line in Windows with <class.jar> file:
 1. Go to the path where the class jar file is located.
 2. Run the following command to execute the file:
    java -jar UMLParser.jar <Testcases_Input_Source_Folder> <Output_Image_Name>
