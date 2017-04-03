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

	public static void main(String[] args) throws Exception{
		
		String classNames;
		
		String input_dir_name = "E:/SJSU/202Paul/202UMLParser/SampleJavaFiles";

		
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
					System.out.println(filename);
					}
					try {
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					
			}
	}

}


