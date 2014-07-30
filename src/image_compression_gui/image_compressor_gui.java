package image_compression_gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import image_compression_gui.choose_file;
public class image_compressor_gui {
	private int width=800;
	private int height=600;
	String path;
	public  image_compressor_gui()
	{
		//main frame
		
		Font f=new Font("arial",Font.PLAIN,15);
		Font h=new Font("arial",Font.BOLD,20);
		JFrame main_frame= new JFrame("Image Size Compressor");
		main_frame.setPreferredSize(new Dimension(width,height));
		main_frame.setResizable(false);
		main_frame.setBackground(Color.white);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sub panel for jframe
		 JPanel main_panel=new JPanel();
		main_panel.setPreferredSize(new Dimension(width,height));
		main_panel.setBackground(Color.white);
		main_panel.setLayout(new GridBagLayout());
		GridBagConstraints c =new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		JPanel sub1=new JPanel();
		JPanel sub2=new JPanel();
		JPanel sub3=new JPanel();
		JPanel sub4=new JPanel();
		JPanel sub5=new JPanel();
		//sub1.setBorder(BorderFactory.createLineBorder(Color.black));
		sub1.setPreferredSize(new Dimension(width,(int)height/5));
		sub2.setPreferredSize(new Dimension(width,(int)height/5));
		sub3.setBorder(BorderFactory.createLineBorder(Color.black));
		sub3.setPreferredSize(new Dimension(width,(int)height/5));
		sub4.setPreferredSize(new Dimension(width,(int)height/5));
		sub5.setBorder(BorderFactory.createLineBorder(Color.black));
		sub5.setPreferredSize(new Dimension(width,(int)height/5));
		main_panel.add(sub1,c);
		c.gridy=1;
		main_panel.add(sub2,c);
		c.gridy=2;
		main_panel.add(sub3,c);
		c.gridy=3;
		main_panel.add(sub4,c);
		c.gridy=4;
		main_panel.add(sub5,c);
		
		// first sub panel 
		sub1.setLayout(new GridBagLayout());
		GridBagConstraints c_sub1=new GridBagConstraints();		
		c_sub1.gridx=0;
		c_sub1.gridy=0;
		c_sub1.gridwidth=width;
		//c_sub1.gridheight=height/10;	
		
		JTextPane input_folder= new JTextPane();
		input_folder.setText("Select input folder :");
		input_folder.setFont(h);
		input_folder.setPreferredSize(new Dimension(width-10,(int)height/10));
		JButton browse=new JButton();
		final JTextPane path_text=new JTextPane();
		c_sub1.fill=GridBagConstraints.CENTER;
		sub1.add(input_folder,c_sub1);
		c_sub1.gridwidth=width/2;
		c_sub1.gridy=1;
		c_sub1.gridx=0;
		sub1.add(path_text,c_sub1);
		c_sub1.gridwidth=90;
		c_sub1.gridx=1;		
		sub1.add(browse,c_sub1);
		c_sub1.fill=1;
		
		browse.setPreferredSize(new Dimension(width/2,height/10));
		path_text.setPreferredSize(new Dimension(width/2,height/10));
		//path_text.setBackground(Color.gray);
		path_text.setFont(f);
		path_text.setEditable(false);
		
		browse.setText("Browse");		
		//button action 
		browse.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {  
		            	final JFrame x=new JFrame("Choose a folder directory");
		        		x.setPreferredSize(new Dimension(400,400));
		        		
		        		final JFileChooser j = new JFileChooser();
		        		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        		j.setApproveButtonText("Select");
		        		j.setPreferredSize(new Dimension(400,400));
		        		j.addActionListener(new ActionListener(){

		        			@Override
		        			public void actionPerformed(ActionEvent e) {
		        				//System.out.println(e.getActionCommand());
		        				if(e.getActionCommand().matches("ApproveSelection"))
		        				{
		        					// TODO Auto-generated method stub
		        					File f=j.getSelectedFile();
		        					if(f.exists())
		        					{
		        						System.out.println(f.getName());
		        						System.out.println(f.getAbsolutePath());
		        						path=f.getAbsolutePath();
		        						path_text.setText(path);
		        						x.dispose();
		        					}
		        					
		        				}
		        				if(e.getActionCommand().matches("CancelSelection"))
		        				{
		        					//System.out.println("canceled");
		        					x.dispose();
		        				}
		        			}   		
		        		});
		        		x.add(j);
		        		x.setVisible(true);
		        		//	x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        		x.pack();
		            }
				});		            
			
				
			}
		});
			
		//add sub components
		//main_panel.add();
		//Integer opt = j.showOpenDialog(this);
		//main_panel.add(browse);
		//main_panel.add(path_text);
		main_frame.add(main_panel);
		main_frame.setVisible(true);
		main_frame.setFocusable(true);
		main_frame.pack();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main program started");
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {                  
						new image_compressor_gui();	                 
            }
        });
    }
	

}
