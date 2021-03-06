package image_compression;

/* Developer Info :
 * Author : KIRAN
 * Creation date : 14-05-2014
 * Name : Jaccardian Simalrity
 *  
 */


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
/**
 * @author Kiran K 
 */
public class file_lister {
	public static ArrayList<String> list_files(String f,String extension)
	{
		
		File f1=new File(f);
		//System.out.println("main :"+f1.getAbsolutePath());
		List<String> output=new ArrayList<String>();		
		if(f1.exists())
		{
			for(File file:f1.listFiles())
			{
				if(file.getName().endsWith("."+extension))
				{
					output.add(file.getAbsolutePath());
				}
				else if(file.getName().endsWith("."+extension))
				{
					output.add(file.getAbsolutePath());
				}
				else if(file.getName().endsWith("."+extension))
				{
					output.add(file.getAbsolutePath());
				}
				else
				{
					//System.out.println("format not supported");
				}
			}
			Collections.sort(output, new Comparator<String>() {
		       
				@Override
				public int compare(String arg0, String arg1) {
					// TODO Auto-generated method stub
					//if(arg0.split(".")[0].contains("\\d+"))
					return arg0.compareTo(arg1);
					//return 1;
				}
		    });
			
		}		
		return (new ArrayList<String>(output));
		
	}
}
