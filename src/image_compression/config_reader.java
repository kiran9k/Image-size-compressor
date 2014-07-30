package image_compression;

/* Developer Info :
 * Author : KIRAN
 * Creation date : 29-07-2014
 * Name : Image Compressor
 *  
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;
/**
 * @author Kiran K 
 */
public class config_reader {

	public config_reader() {
		// TODO Auto-generated constructor stub
	}
	 public static ArrayList<String> get_prop()
	    {
	    	Properties prop = new Properties();
	    	ArrayList<String> s= new ArrayList<String>();
	    	try {
	               //load a properties file
	    		prop.load(new FileInputStream("image_compressor.config"));    			
	    		//get the property value and print it out
	    		s.add(prop.getProperty("input_folder"));
	    		s.add(prop.getProperty("input_file_type"));
	    		s.add(prop.getProperty("output_folder"));	            
	            s.add(prop.getProperty("output_file_type"));            
	            s.add(prop.getProperty("image_quality"));	         
	            
	            s.add(prop.getProperty("apply_scaling"));
	            s.add(prop.getProperty("maintain_aspect_ratio"));
	            s.add(prop.getProperty("image_width"));
	            s.add(prop.getProperty("image_height"));
	            
	            
	    	} catch (IOException ex) {
	    		System.out.println("Config file not found :image_compressor.config ");
	    		System.out.println("Please place the image_compressor.config file in same directory as that of the jar !");
	    		ex.printStackTrace();
	        }
			return s;
	    }
	 public static boolean validate_config(ArrayList<String> prop)
	 {
		 if(!new File(prop.get(0)).exists())
		 {
			 System.out.println("Specified input folder doesnt exist ");
			 return false;
		 }
		 if(prop.get(1).contains("jpg")||prop.get(1).contains("png")||prop.get(1).contains("gif"))
		 {
			 ;
		 }
		 else
		 {
			 System.out.println("incorrect file type menitioned in input file type");
			 return false;
		 }
		 if(!new File(prop.get(2)).exists())
		 {
			 System.out.println("Specified output folder doesnt exist ");
			 return false;
		 }
		 if(prop.get(3).contains("jpg")||prop.get(3).contains("jpeg"))
		 {
			 ;
		 }
		 else
		 {
			 System.out.println("incorrect file type menitioned in input file type");
			 //return false;
		 }
		 return true;
	 }
}
