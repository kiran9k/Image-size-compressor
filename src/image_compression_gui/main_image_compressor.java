package image_compression_gui;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.IIOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class main_image_compressor {
	
	public static  ArrayList<String>  prop;
	
	
	
	public static  BufferedImage scale(BufferedImage img, int targetWidth, int targetHeight) {

	    int type = (img.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
	    BufferedImage ret = img;
	    BufferedImage scratchImage = null;
	    Graphics2D g2 = null;

	    int w = img.getWidth();
	    int h = img.getHeight();

	    int prevW = w;
	    int prevH = h;

	    do {
	        if (w > targetWidth) {
	            w /= 2;
	            w = (w < targetWidth) ? targetWidth : w;
	        }

	        if (h > targetHeight) {
	            h /= 2;
	            h = (h < targetHeight) ? targetHeight : h;
	        }

	        if (scratchImage == null) {
	            scratchImage = new BufferedImage(w, h, type);
	            g2 = scratchImage.createGraphics();
	        }

	        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2.drawImage(ret, 0, 0, w, h, 0, 0, prevW, prevH, null);

	        prevW = w;
	        prevH = h;
	        ret = scratchImage;
	    } while (w != targetWidth || h != targetHeight);

	    if (g2 != null) {
	        g2.dispose();
	    }

	    if (targetWidth != ret.getWidth() || targetHeight != ret.getHeight()) {
	        scratchImage = new BufferedImage(targetWidth, targetHeight, type);
	        g2 = scratchImage.createGraphics();
	        g2.drawImage(ret, 0, 0, null);
	        g2.dispose();
	        ret = scratchImage;
	    }

	    return ret;

	}

	public static String main(ArrayList<String> p) throws IOException {
		// TODO Auto-generated method stub
		//System.out.println("Program Started");
		//get config elements
		prop=p;
		String out="";
		//get list of files from the input folder :
		ArrayList<String> input_files=file_lister.list_files(prop.get(0),prop.get(1));
		BufferedImage input_img;// = ImageIO.read(path);
		BufferedImage output_img = null;
		String f_name;
		String f_type;
		int h,w;
		int scaled_width,scaled_height;
		float aspect_ratio;
		int quality=Integer.parseInt(prop.get(4));
		float q_value=((float)quality)/100;
		
		File output_file;
		ImageOutputStream ios;
		boolean small_img=false;
		out+="Total number of files present in input directory : "+input_files.size()+"\n";
		for(String i:input_files)
		{
			//System.out.println(i);
			//individual files
			small_img=false;
			f_name=new File(i).getName().replace("."+prop.get(1),"");
			f_type=prop.get(3);
			
			//get image 
			input_img=ImageIO.read(new File(i));		
			
			if(prop.get(5).contains("yes"))
			{
				//appply scaling !
				
				//get image height & width
				h=input_img.getHeight();
				w=input_img.getWidth();
				aspect_ratio=w/(float)h;
				//call scale !
				scaled_width=Integer.parseInt(prop.get(7));
				if(scaled_width>w)
				{
					scaled_width=w;
					small_img=true;
				}
				if(prop.get(6).contains("yes"))
				{
					scaled_height=(int)(scaled_width/aspect_ratio);
					
				}
				else
				{
					scaled_height=Integer.parseInt(prop.get(8));
					
				}
				if(scaled_height>h)
				{
					small_img=true;
					scaled_height=h;
				}
									
				output_img=scale(input_img,scaled_width,scaled_height);
				if(small_img)
				{
					//output_img=scale(input_img,scaled_width,scaled_height);
					out+="Input image : "+f_name+ " is already smaller than the required scaling width & height!\n";
					//System.out.println("Input image : "+f_name+ " is already smaller than the required scaling width & height! ");
					//System.out.println(scaled_width+" "+scaled_height+" "+w+" "+h);
					//output_img=input_img;
					//continue;
				}
				
				
			}
			else if(prop.get(5).contains("no"))
			{
				// dont apply scaling!
				output_img=input_img;
			}			
			//save the image !
			ImageWriter writer = (ImageWriter) ImageIO.getImageWritersByFormatName("jpg").next();
			ImageWriteParam param = writer.getDefaultWriteParam();
			param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			param.setCompressionQuality(q_value);			
			output_file=new File(prop.get(2)+File.separator+f_name+"."+f_type);			
			ios = ImageIO.createImageOutputStream(output_file);
			writer.setOutput(ios);
			try
			{
				
				writer.write(null, new IIOImage(output_img, null, null), param);
			}
			catch (IIOException e)
			{
				//delete the files created if file is usupported !
				output_file.delete();
				out+="Unable to process the file! : "+f_name+"."+f_type+"\n";
				System.out.println( "Unable to process the file : "+f_name+"."+f_type);
				//System.out.println(f_type);
				//e.printStackTrace();
			}
			
		}
		out+="Program completed";
		return out;
		
	}

}
