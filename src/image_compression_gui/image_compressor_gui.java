package image_compression_gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class image_compressor_gui {
	private int width=800;
	private int height=600;
	String path;
	String path1;
	String input_image_type="jpg";
	String output_image_type="jpg";
	String Scaling="no";
	int value=50;
	String pixel_width;
	String pixel_height;
	String Aspect="no";
	Color bgcolor=Color.LIGHT_GRAY;
	Color border_color=Color.black;
	Color button_color=Color.gray;	//Color.DARK_GRAY;
	Color font_color=Color.black;
	Font f=new Font("arial",Font.PLAIN,20);//20
	Font h=new Font("arial",Font.PLAIN,25);//25
	 JTextPane display;//log writes
	 JFrame main_frame;///main back groudn frame
	public  image_compressor_gui()
	{
		//main frame		
	
		main_frame= new JFrame("Image Size Compressor");
		
		main_frame.setPreferredSize(new Dimension(width,height));
		main_frame.setResizable(false);
		main_frame.setBackground(bgcolor);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//sub panel for jframe
		 JPanel main_panel=new JPanel();
		main_panel.setPreferredSize(new Dimension(width,height));
		main_panel.setBackground(bgcolor);
		main_panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c =new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		JPanel sub1=new JPanel();
		JPanel sub2=new JPanel();
		JPanel sub3=new JPanel();
		JPanel sub4=new JPanel();
		JPanel sub5=new JPanel();
		sub1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, border_color));
		sub1.setPreferredSize(new Dimension(width,(int)height/5));
		sub2.setPreferredSize(new Dimension(width,(int)height/5));
		sub2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, border_color));
		//sub3.setBorder(BorderFactory.createLineBorder(Color.black));
		sub3.setPreferredSize(new Dimension(width,(int)height*2/5));
		sub4.setPreferredSize(new Dimension(width,(int)height/5));
		//sub5.setBorder(BorderFactory.createLineBorder(Color.black));
		//sub5.setPreferredSize(new Dimension(width,(int)height/5));
		JPanel sub31=new JPanel();
		JPanel sub32=new JPanel();
		sub31.setPreferredSize(new Dimension(width/2,(int)height*2/5));
		sub32.setPreferredSize(new Dimension(width/2,(int)height*2/5));
		//sub32 vertical
		sub3.setLayout(new GridLayout(1,2));
		sub3.add(sub31);
		sub3.add(sub32);//
		sub4.setBackground(bgcolor);
		sub4.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, border_color));
		sub4=sub_panel5(sub4);
		//TODO
		main_panel.add(sub1,c);
		c.gridy=1;
		main_panel.add(sub2,c);
		c.gridy=2;
		main_panel.add(sub3,c);
		c.gridy=3;
		main_panel.add(sub4,c);
		c.gridy=4;
		//main_panel.add(sub5,c);
		//add components to sub -panel 1
		sub1=sub_panel1(sub1);
		//add components to sub - panel2
		sub2=sub_panel2(sub2);
		//add components to sub -panel 3
		sub31=sub_panel3(sub31);
		sub32=sub_panel4(sub32);
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
	
	public void display_writer(String text)
	{
		display.setText(text);
	}
		
	public JPanel sub_panel5(JPanel sub5)
	
	{
		JButton Exit=new JButton();
		Exit.setPreferredSize(new Dimension(150,40));
		Exit.setText("Exit");
		Exit.setForeground(font_color);
		Exit.setFont(h);
		Exit.setBackground(button_color);
		Exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getActionCommand());
				if(e.getActionCommand().matches("Exit"))
				{
					//TODO CLose the GUI
//					/System.out.println("cloesd");
					main_frame.dispose();
				}
			}	
			
		});
		//Exit.setBorder(BorderFactory.createEmptyBorder(0, left, bottom, right));
		final JButton Submit=new JButton();
		Submit.setText("Submit");
		Submit.setBackground(button_color);
		Submit.setPreferredSize(new Dimension(150,40));
		Submit.setFont(h);
		Submit.setForeground(font_color);
		Submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getActionCommand());
				if(e.getActionCommand().matches("Submit"))
				{
					//TODO Call prog
					
					ArrayList<String> values= new ArrayList<String>(); 
					values.add(path);
					values.add(input_image_type);
					values.add(path1);
					values.add(output_image_type);
					values.add(String.valueOf(value));
					values.add(Scaling);
					values.add(Aspect);
					values.add(pixel_width);
					values.add(pixel_height);
					//TODO add width & height
					for (int i=0;i<values.size();i++)
					{
						//System.out.println(values.get(i));
					}
			//		System.out.println("started");
					if(validate_results(values))
					{
						//call the program
						Submit.setEnabled(false);
						try {
							display_writer(main_image_compressor.main(values));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							//	e1.printStackTrace();
						}
						Submit.setEnabled(true);
					}
					
				}
			}	
			
		});
		sub5.setLayout(new GridBagLayout());
		GridBagConstraints c1=new GridBagConstraints();
		c1.gridx=0;
		c1.gridy=0;
		c1.insets=new Insets(0, 100, 0, 100);
		//c1.ipadx=100;
		sub5.add(Exit,c1);
		c1.gridx=1;
		sub5.add(Submit,c1);
		
		return sub5;
	}
	
	public JPanel sub_panel4(JPanel sub4)
	{
		sub4.setBackground(bgcolor);
		
		sub4.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, border_color));
		JTextPane head=new JTextPane();
		head.setBackground(bgcolor);
		head.setFont(f);
		head.setText("Log :");
		head.setEditable(false);
		head.setForeground(font_color);
		head.setPreferredSize(new Dimension(width/2-10,40));
	    display = new JTextPane();
	    //display.setFont(f);
	    JScrollPane scroll = new JScrollPane(display);
	    scroll.setVisible(true);
		scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(width/2-20,height*2/5-60));
		display.setBackground(bgcolor);
		display.setForeground(font_color);
		display.setEditable(false);
		scroll.setWheelScrollingEnabled(true);
		display.setPreferredSize(new Dimension(width/2,height/20));
		//display.setText("JScrollPane is just another container that places scrollbars around your component when its needed and also has its own layout. All you need to do when you want to wrap anything into a scroll just pass it into JScrollPane constructor:");
		//sub4.add(display);
		sub4.add(head);
		sub4.add(scroll);
		return sub4;
		
	}
	
	public JPanel sub_panel3(JPanel sub3) {
		// TODO Auto-generated method stub
		GridBagConstraints c1=new GridBagConstraints();
		JPanel sub311=new JPanel();
		JPanel sub312=new JPanel();
		JPanel sub313=new JPanel();
		JPanel sub314=new JPanel();
		JPanel sub315=new JPanel();
		sub3.setLayout(new GridLayout(5,1));
		JTextPane input_type=new JTextPane();
		input_type.setFont(f);
		input_type.setForeground(font_color);
		input_type.setBackground(bgcolor);
		input_type.setText("Input Image type : ");
		input_type.setEditable(false);
		input_type.setPreferredSize(new Dimension(width/2-100,(height*2/25)-10));
		sub311.setPreferredSize(new Dimension(width/2,height*2/25));
		sub312.setPreferredSize(new Dimension(width/2,height*2/25));
		sub313.setPreferredSize(new Dimension(width/2,height*2/25));
		sub314.setPreferredSize(new Dimension(width/2,height*2/25));
		sub315.setPreferredSize(new Dimension(width/2,height*2/25));
		sub311.setBorder(BorderFactory.createMatteBorder(0, 0,1, 0, border_color));
		sub312.setBorder(BorderFactory.createMatteBorder(0, 0,1, 0, border_color));
		sub313.setBorder(BorderFactory.createMatteBorder(0, 0,1, 0, border_color));
		sub314.setBorder(BorderFactory.createMatteBorder(0, 0,1, 0, border_color));
		sub311.setBackground(bgcolor);
		sub312.setBackground(bgcolor);
		sub313.setBackground(bgcolor);
		sub315.setBackground(bgcolor);
		sub311.setLayout(new GridBagLayout());//1,2
		//input_type.setBackground(border_color);
		//sub31.setBackground(bgcolor);
		c1.gridx=0;
		c1.gridy=0;
		input_type.setBorder( BorderFactory.createEmptyBorder(5, 10, 0, 0));
		sub311.add(input_type,c1);
		
        JComboBox com = new JComboBox();    
        //com.setBackground(bgcolor);
        com.setForeground(font_color);
        com.setPreferredSize(new Dimension(80,height*2/25-20));
        com.addItem((Object)".jpg");        
        com.addItem((Object)".png");
        com.addItem((Object)".gif");              
        com.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				// TODO Auto-generated method stub
				  	int state = itemEvent.getStateChange();
				  	if(state==ItemEvent.SELECTED)
				  	{
				  		//System.out.println(String.valueOf(itemEvent.getItem()).replace(".", ""));
				  		input_image_type=String.valueOf(itemEvent.getItem()).replace(".","");
				  	}
			        /*System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
			        System.out.println("Item: " + itemEvent.getItem());
			        ItemSelectable is = itemEvent.getItemSelectable();
			        System.out.println(", Selected: " + is.toString());*/
			}
		
        	
        });
        c1.gridx=1;
       // com.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        sub311.add(com,c1);

        // second set sub:
        c1.gridx=0;
        c1.gridy=0;
        JTextPane output_type=new JTextPane();
        output_type.setText("Output Image type :");
        output_type.setEditable(false);
        output_type.setForeground(font_color);
        output_type.setFont(f);
        output_type.setBackground(bgcolor);
        output_type.setBorder( BorderFactory.createEmptyBorder(5, 10, 0, 0));
        output_type.setPreferredSize(new Dimension(width/2-100,height*2/25-10));
        JComboBox out=new JComboBox();
        out.setForeground(font_color);
        out.addItem(".jpg");
        //TODO future implementation
        out.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					//do something
					//set output_image_type;
				}
			}
        	
        });
        out.setPreferredSize(new Dimension(80,height*2/25-20));
        sub312.setLayout(new GridBagLayout());
        sub312.add(output_type,c1);
        c1.gridx=1;
        sub312.add(out,c1);
        
        
        //sub3 3rd phase !!
       
        final JFormattedTextField width_value = new JFormattedTextField();
        width_value.setEditable(false);
        final JFormattedTextField height_value = new JFormattedTextField();
        height_value.setEditable(false);
        width_value.setText("");
        width_value.setColumns(5);
        height_value.setColumns(5);
        width_value.setPreferredSize(new Dimension(100,20));
        sub313.setLayout(new GridLayout());        
        JCheckBox scalable=new JCheckBox();
        scalable.setPreferredSize(new Dimension(width/4-10,height*2/25-10));
        scalable.setBackground(bgcolor);
        final JCheckBox aspect=new JCheckBox();
        aspect.setEnabled(false);
        aspect.setBackground(bgcolor);
        aspect.setPreferredSize(new Dimension(width/4-10,height*2/25-10));
        scalable.setText("Apply Scaling   ");
        scalable.setForeground(font_color);
       // c1.gridwidth=width/4;
        c1.gridx=0;
        c1.gridy=0;
        JPanel sub3131=new JPanel();
        JPanel sub3132=new JPanel();
        sub3131.setPreferredSize(new Dimension(width/4,height*2/25));
        sub3132.setPreferredSize(new Dimension(width/4,height*2/25));
        sub313.add(sub3131);
        sub313.setBackground(bgcolor);
        sub3131.setBackground(bgcolor);
        sub3132.setBackground(bgcolor);
        sub3131.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1,border_color));
        sub3131.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1,border_color));
        sub313.add(sub3132);
        sub3131.add(scalable);
        scalable.setBorder(BorderFactory.createEmptyBorder(0, 10, 0,5));
        scalable.addItemListener(new ItemListener(){

			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					//System.out.println("seleted");
					width_value.setEditable(true);
					height_value.setEditable(true);
					Scaling="yes";
					aspect.setEnabled(true);
				}
				else
				{
					Scaling="no";
					aspect.setEnabled(false);
					width_value.setEditable(false);
					height_value.setEditable(false);
					//System.out.println("deseleted");
				}
			}
        	
        });
        aspect.setText("Maintain aspect ratio ");
        aspect.setForeground(font_color);
        aspect.setBorder(BorderFactory.createEmptyBorder(5, 10, 0,0));
        //c1.ipadx=75;
        c1.gridx=2;
        sub3132.add(aspect);
        aspect.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        aspect.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED)
				{
					Aspect="yes";
					height_value.setEnabled(false);
					
					//System.out.println("selected");
				}
				else
				{
					height_value.setEnabled(true);
					Aspect="no";
					//System.out.println("selected");
				}
			}
        	
        });

        
        
        //	fourth set sub      
        
        c1.ipadx=0;
        c1.gridwidth=1;
        JPanel sub3141=new JPanel();
        JPanel sub3142=new JPanel();
        sub3141.setPreferredSize(new Dimension(width/4,height*2/25));
        sub3141.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, border_color));
        sub3142.setPreferredSize(new Dimension(width/4,height*2/25));
        sub3141.setBackground(bgcolor);
        sub3142.setBackground(bgcolor);
        sub314.setLayout(new GridLayout(1,2));
        sub314.add(sub3141);
        sub314.add(sub3142);
        JTextPane width_text =new JTextPane();
        width_text.setPreferredSize(new Dimension(width/8,height*2/25-15));
        JTextPane height_text =new JTextPane();
        width_text.setText("Width:");
        width_text.setEditable(false);
        width_text.setForeground(font_color);
        width_text.setBackground(bgcolor);
        width_text.setFont(f);
        height_text.setText("Height:");
        height_text.setEditable(false);
        height_text.setForeground(font_color);
        height_text.setBackground(bgcolor);
        height_text.setFont(f);
        height_text.setPreferredSize(new Dimension(width/8,height*2/25-15));
        sub3141.setLayout(new GridBagLayout());
        sub3142.setLayout(new GridBagLayout());
        
        c1.gridx=0;
        c1.gridy=0;
        sub3141.add(width_text,c1);
        c1.gridx=1;
        width_value.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				// TODO Auto-generated method stub
				 Object source = e.getSource();
				 if(source==width_value){	
					 pixel_width=width_value.getText();
			         //System.out.println(width_value.getText());//e.getNewValue());
				 }
			       
			}
        	
        });
        height_value.addPropertyChangeListener(new PropertyChangeListener(){
        	@Override
			public void propertyChange(PropertyChangeEvent e) {
				// TODO Auto-generated method stub
				 Object source = e.getSource();
				 if(source==height_value){	
					 pixel_height=height_value.getText();
			         //System.out.println(width_value.getText());//e.getNewValue());
				 }
        	}
        });
        sub3141.add(width_value,c1);
        c1.gridx=0;
        sub3142.add(height_text,c1);
        c1.gridx=1;
        sub3142.add(height_value,c1);
        
        
        //set 5 
        sub315.setLayout(new GridBagLayout());
        
        JTextField quality_text=new JTextField();
        quality_text.setBackground(bgcolor);
        quality_text.setBorder(null);
        quality_text.setText("Image Quality :");
        quality_text.setForeground(font_color);
        quality_text.setFont(f);
        quality_text.setEditable(false);
        final JTextField value_text=new JTextField();
        value_text.setBackground(bgcolor);
        value_text.setForeground(font_color);
        value_text.setBorder(null);
        value_text.setColumns(3);
        value_text.setEditable(false);
        value_text.setText(String.valueOf(value));        
        JSlider quality = new JSlider(JSlider.HORIZONTAL,
                0, 100, value);
        quality.setForeground(font_color);
        quality.setBackground(bgcolor);
        quality.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider source = (JSlider)e.getSource();
			    if (!source.getValueIsAdjusting()) {
			        int fps = (int)source.getValue();
			        value=fps;
			        value_text.setText(String.valueOf(fps));
			        //System.out.println(fps);
			    }
			}
        	
        });
        c1.gridy=0;
        c1.gridx=0;
        sub315.add(quality_text,c1);
        c1.gridx=1;
        sub315.add(quality,c1);
        c1.gridx=2;
        sub315.add(value_text,c1);
        
		sub3.add(sub311);
		sub3.add(sub312);
		sub3.add(sub313);
		sub3.add(sub314);
		sub3.add(sub315);
		
		
		
		return sub3;
	}

	public JPanel sub_panel2(JPanel sub2)
	{
		JPanel sub21=new JPanel();
		JPanel sub22=new JPanel();
		sub21.setBackground(bgcolor);
		sub22.setBackground(bgcolor);
		sub22.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		sub21.setPreferredSize(new Dimension(width,(int)height/10));
		sub22.setPreferredSize(new Dimension(width,(int)height/10));
		sub2.setLayout(new GridLayout(2,1));
		sub2.add(sub21);
		sub2.add(sub22);
		JTextPane output_folder= new JTextPane();
		output_folder.setBackground(bgcolor);
		output_folder.setEditable(false);
		output_folder.setText("Select output folder : ");
		output_folder.setForeground(font_color);
		output_folder.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		output_folder.setPreferredSize(new Dimension(width,(int)height/10));
		JButton browse1=new JButton();
		final JTextPane path_text2=new JTextPane();
		path_text2.setBackground(bgcolor);	
		path_text2.setForeground(font_color);
		output_folder.setFont(h);
		sub21.add(output_folder);
		browse1.setPreferredSize(new Dimension(110,height/10-20));
		path_text2.setPreferredSize(new Dimension(width-110,height/10-20));
		path_text2.setFont(f);
		path_text2.setEditable(false);
		path_text2.setBorder(BorderFactory.createLineBorder(Color.black));
		sub22.setLayout(new GridBagLayout());
		GridBagConstraints c_sub2=new GridBagConstraints();
		c_sub2.gridx=0;
		c_sub2.gridy=0;
		sub22.add(path_text2,c_sub2);
		c_sub2.gridwidth=width;
		c_sub2.gridx=1;
		//c_sub1.gridy=0;
		sub22.add(browse1,c_sub2);
		browse1.setText("Browse");
		browse1.setForeground(font_color);
		browse1.setBackground(button_color);
		browse1.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {


				// TODO Auto-generated method stub
				SwingUtilities.invokeLater(new Runnable() {
					
					public void run() {
						// TODO Auto-generated method stub
						final JFrame x=new JFrame("Choose a folder directory");
		        		x.setPreferredSize(new Dimension(400,400));
		        		
		        		final JFileChooser j = new JFileChooser();
		        		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        		j.setApproveButtonText("Select");
		        		j.setPreferredSize(new Dimension(400,400));
		        		x.add(j);
		        		x.pack();
		        		x.setVisible(true);
		        		j.addActionListener(new ActionListener()
		        		{

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
						        		
									if(e.getActionCommand().matches("ApproveSelection"))
									{
										// TODO Auto-generated method stub

										File f=j.getSelectedFile();
										if(f.exists())
										{
											//System.out.println(f.getName());
											//System.out.println(f.getAbsolutePath());
											path1=f.getAbsolutePath();
											path_text2.setText(path1);
											x.dispose();
										}
									}
									if(e.getActionCommand().matches("CancelSelection"))
									{
										//	System.out.println("canceled");
										x.dispose();
									}
							}
		        		});
					}
				
				});
			
			};
		});
		return sub2;
		
	}
	
	public  JPanel sub_panel1(JPanel sub1)
	{
		JPanel sub11=new JPanel();
		JPanel sub12=new JPanel();
		sub11.setBackground(bgcolor);
		sub12.setBackground(bgcolor);
		sub11.setPreferredSize(new Dimension(width,(int)height/10));
		sub12.setPreferredSize(new Dimension(width,(int)height/10));
		sub12.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		sub1.setLayout(new GridLayout(2,1));
		sub1.add(sub11);
		sub1.add(sub12);
		sub12.setLayout(new GridBagLayout());
		GridBagConstraints c_sub1=new GridBagConstraints();				
		JTextPane input_folder= new JTextPane();
		input_folder.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		input_folder.setText("Select input folder :");
		input_folder.setEditable(false);
		input_folder.setForeground(font_color);
		input_folder.setFont(h);
		input_folder.setBackground(bgcolor);
		input_folder.setPreferredSize(new Dimension(width,(int)height/10));	
		JButton browse=new JButton();
		browse.setForeground(font_color);
		final JTextPane path_text=new JTextPane();
		sub11.add(input_folder);
		c_sub1.gridx=0;
		c_sub1.gridy=0;		
		path_text.setBorder(BorderFactory.createLineBorder(Color.black));
		path_text.setBackground(bgcolor);
		path_text.setForeground(font_color);
		sub12.add(path_text,c_sub1);
		c_sub1.gridwidth=width;
		c_sub1.ipadx=10;
		c_sub1.gridy=0;
		c_sub1.gridx=1;		
		sub12.add(browse,c_sub1);	
		//browse.setBackground(bgcolor);
		browse.setVisible(true);
		browse.setPreferredSize(new Dimension(100,height/10-20));
		path_text.setPreferredSize(new Dimension(width-110,height/10-20));
		//path_text.setBackground(border_color);
		path_text.setFont(f);
		path_text.setEditable(false);	
		browse.setText("Browse");		
		browse.setBackground(button_color);
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
		        						//System.out.println(f.getName());
		        						//System.out.println(f.getAbsolutePath());
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
		return sub1;
		
	}
	
	public boolean validate_results(ArrayList<String> a)
	{
		String out="";
		if(a.get(0)==null)
		{
			out+="Input file not set \n";
			
		}
		if(a.get(2)==null)
		{
			out+="Output file not set \n";
			//raise error
		}
		if(a.get(5).matches("yes"))
		{
			if(a.get(7).length()>0)//width
			{
				//pass
				if(a.get(7).matches("[0-9]+"))
				{
					//numbers only present
				}
				else
					out+="Width can include only numbers & no other characters\n";
				
			}
			else
			{
				//width not set
				out+= "Image width not set\n";
				//System.out.println("width not set");
			}
			if(a.get(6).matches("no"))
			{
				if(a.get(8).length()>0)//height
				{
					//pass
					if(!a.get(8).matches("[0-9]+"))
						out+="Height can include only numbers & no other characters\n";
				}
				else
				{
					//raise height error
					out+= "Image height not set\n";
					//System.out.println("height not set");
				}
			}
		}
		display_writer(out);
		if(out.length()>0)
			return false;//invalid
		else
			return true;//valid
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Main program started");
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {                  
						new image_compressor_gui();	                 
            }
        });
    }
	

}
