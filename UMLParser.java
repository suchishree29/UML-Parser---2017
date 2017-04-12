import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class UMLParser {
	static String[] ClassList ;
	static ArrayList<String> java_class_name = new ArrayList<String>();
	static ArrayList<String> class_names = new ArrayList<String>();
	static ArrayList<String> interface_names = new ArrayList<String>();
	static ArrayList<String> method_names = new ArrayList<String>();
	static ArrayList<String> field_names = new ArrayList<String>();
	static ArrayList<String> modifiers = new ArrayList<String>();
	static ArrayList<String> rel_class = new ArrayList<String>();
	static StringBuilder sb = new StringBuilder();
	static FileInputStream in;
	static CompilationUnit cu;

	public static void main(String[] args) throws Exception{
		
		String classNames;
		
		String input_dir_name = args[0];
		//String input_dir_name = "E:/SJSU/202Paul/202UMLParser/SampleJavaFiles";
		String outfile = args[1];
		String out_file = input_dir_name + "/" + outfile +".txt";
		System.out.println("Output File:" + out_file);
		
		
			//Create new file 
			File f = new File(input_dir_name);
		
			//List the files in the input directory
			File[] ipFiles = f.listFiles();
		
			//for every file in ipFiles
			for(File fList: ipFiles)
			{
				if (fList.isFile()) {
					classNames = fList.getName();
					ClassList = classNames.split("[.]");
					System.out.println(classNames);
          				System.out.println(java_class_name);
					
					String filename = input_dir_name + "/" + classNames;
					//System.out.println(filename);
					}
					try {
						
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


