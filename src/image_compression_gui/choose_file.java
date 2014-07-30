package image_compression_gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class choose_file {
	public static String path=null;
	public choose_file()
	{
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
	public static String getString()
	{
		return path;
	}

}
