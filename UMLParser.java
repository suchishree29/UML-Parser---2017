import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class UMLParser {
	
	static String[] ClassList ;
	static String[] params;
	static String[] paramsConstructor;
	static String class_type;
	static ArrayList<String> java_class_name = new ArrayList<String>();
	static ArrayList<String> class_names = new ArrayList<String>();
	static ArrayList<String> interface_names = new ArrayList<String>();
	static ArrayList<String> method_names = new ArrayList<String>();
	static ArrayList<String> field_names = new ArrayList<String>();
	static ArrayList<String> constructor_names = new ArrayList<String>();
	static ArrayList<String> modifiers = new ArrayList<String>();
	static ArrayList<String> rel_class = new ArrayList<String>();
	static ArrayList<String> params_list = new ArrayList<String>();
	static ArrayList<String> curr_param_list = new ArrayList<String>();
	static ArrayList<String> interface_name = new ArrayList<String>();
	static StringBuilder sb = new StringBuilder();
	static FileInputStream in;
	static CompilationUnit cu;

	public static void main(String[] args) throws Exception{
		
		String classNames;
		//String input_dir_name = args[0];
		String input_dir_name = "E:/SJSU/202Paul/202UMLParser/SampleJavaFiles/TestCase5";
		//System.out.println("Input Path: " + input_dir_name);
		
		//String outfile = args[1];
		//String out_file = input_dir_name + "/" + outfile +".txt";
		//System.out.println("Output File:" + out_file);
		
		sb.append("@startuml\n");
		sb.append("skinparam classAttributeIconsize 0\n");
		
		PlantUmlGenerator classDiagramUML = new PlantUmlGenerator();
		
		//Create new file
		File f = new File(input_dir_name);
		
		//List the files in the input directory
		File[] ipFiles = f.listFiles();

		for(File fList: ipFiles)
		{
			if (fList.isFile()) {
				classNames = fList.getName();
				ClassList = classNames.split("[.]");
				//System.out.println(ClassList[0]);
				if (ClassList[1].equals("java")){
					//java_class_name.add(ClassList[0]);	
					String filename = input_dir_name + "/" + classNames;
				
					try {
						// creates an input stream for the file to be parsed
						in = new FileInputStream(filename);
				
						// parse the file
						cu = JavaParser.parse(in);
						JavaParser.setCacheParser(false);
						
						new InterfaceFirstVisitor().visit(cu,null);
					
					}catch (Exception e) {
						e.printStackTrace();
					}
					finally {
						try {
							in.close();

						} catch (IOException e) {

							e.printStackTrace();
						}
					}
				}
				
			}
		}
		
			for(File fList: ipFiles)
			{
				if (fList.isFile()) {
					classNames = fList.getName();
					ClassList = classNames.split("[.]");
					//System.out.println(ClassList[0]);
					if (ClassList[1].equals("java")){
						java_class_name.add(ClassList[0]);	
						//for (String j:java_class_name){
							//System.out.println(j);
						//}
						String filename = input_dir_name + "/" + classNames;
					
						try {
							// creates an input stream for the file to be parsed
							in = new FileInputStream(filename);
					
							// parse the file
							cu = JavaParser.parse(in);
							System.out.println(cu);
							JavaParser.setCacheParser(false);
							
						
						}catch (Exception e) {
							e.printStackTrace();
						}
						finally {
							try {
								in.close();

							} catch (IOException e) {

								e.printStackTrace();
							}
						}
						//determine if its a class or interface

						//visit and print the methods names
						new MethodVisitor().visit(cu, null);
						new FieldVisitor().visit(cu, null);
						new ConstructorTypeVisitor().visit(cu, null);
						new ClassOrInterfaceVisitor().visit(cu,null);
						write();

					}
					
				}
			}
			sb.append("@enduml\n");
			classDiagramUML.classUML(sb);
			System.out.println(sb);	

	}
	private static class InterfaceFirstVisitor extends VoidVisitorAdapter<Void>{
		public void visit(ClassOrInterfaceDeclaration c,Void arg){

			if(c.isInterface() == true){
				interface_names.add(c.getName());
			}else {
				
				all_class_names.add(c.getName());
			}
		}
	}
	
		private static class ClassOrInterfaceVisitor extends VoidVisitorAdapter<Void>{
		@Override
		public void visit(ClassOrInterfaceDeclaration c,Void arg){
			java.util.List<ClassOrInterfaceType> type;

			if (c.isInterface() == false ){
				class_names.add(c.getName());
				class_type = "class";
			}else{
				interface_name.add(c.getName());
				class_type = "interface";
			}
			
			if (c.getExtends()!= null) {
				
				type = c.getExtends();

				for(int i=0;i < type.size();i++) {
					String var = type.get(i).toString().replace("[,]","") +  "<|--" +" " +ClassList[0];
					//System.out.println(var);
					rel_class.add(var);
				}				
			}
			//System.out.println(c.getImplements());
			if (c.getImplements() != null){
				type = c.getImplements();
				//System.out.println(type);
				for(int i =0; i<type.size();i++) {
					String var = type.get(i).toString().replace("[,]","") + "<|.." + " " + ClassList[0];
					//System.out.println(var);
					rel_class.add(var);
				}
				
			}
			verifyDependency();
		
		}
	}
