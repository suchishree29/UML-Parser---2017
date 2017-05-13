# UML-Parser---2017

This Project aims at creating a Parser which converts Java Source Code into a UML Class Diagram.

# Tools and Libraries Used:

● <b>Eclipse IDE(Kepler Service Release 2):</b>
 Used to write, compile, and test project code.
 
 ● <b>JavaParser:</b>
 https://github.com/javaparser/javaparser/wiki/Manual
 
 Using Visitor classes like InterfaceFirstVisitor ,FieldVisitor and its visit methods, parsed Java source code to get an Abstract Syntax Tree (AST) from Java code. 
 
 ● <b>Plant UML</b>
 http://plantuml.com
 
 Make a file containing PlantUML commands, either with an editor or when running other software which calls PlantUML.
 Run (or have the software call) PlantUML with this file as input. The output is an image, which either appears in the other software,  or is written to an image file on disk.
 For example,

 java -jar plantuml.jar classDiagram.txt 
 
 and the result is a nice diagram in classeDiagram.png.
 
 ● <b>GraphViz</b>
http://www.graphviz.org/
Graphviz is open source graph visualization software. Graph visualization is a way of representing structural information as diagrams of  abstract graphs and networks. It has important applications in networking, bioinformatics,  software engineering, database and web     design, machine learning, and in visual interfaces for other technical domains. 
Graphviz must be installed in the default directory of your system. c:\Program Files\GraphvizX.XX (Windows) or /usr/bin/do.

## Steps to run the project using command line in Windows:
1. Go to Java Bin folder and set the path using following command:
    set path=%path%;C:\Program Files\Java\jdk1.8.0_121\bin
2. To Compile:
   javac -cp "../javaparser-1.0.8.jar;../plantuml.jar;" *.java 
3. To Run:
   java -cp "../javaparser-1.0.8.jar;../plantuml.jar;" UMLParser <source folder> <output file name>
   <source folder> is a folder name where all the .java source files will be.
   <output file name> is the name of the output image file your program will generate ( .jpg, .png or .pdf format)
  
 
 
 
 

