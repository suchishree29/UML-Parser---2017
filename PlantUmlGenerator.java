import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;


public class PlantUmlGenerator {
	
	public void classUML(StringBuilder plantUmlSource){
		
		SourceStringReader reader;
		try{
		reader = new SourceStringReader(plantUmlSource.toString());

        FileOutputStream output = new FileOutputStream(new File("E:/SJSU/202Paul/202UMLParser/SampleJavaFiles/output.png"));

        reader.generateImage(output, new FileFormatOption(FileFormat.PNG, false));
        
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}
}
