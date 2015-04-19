import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ProfileGUI extends JPanel{
	private Dimension dim;
	private File pictureFile;
	private ImageIcon profilePic;
	private JButton saveButton;
	private JButton cancelButton;
	private JLabel name;
	private JLabel email;
	private JTextArea bio;
	private Set<JButton> followersButtons;
	private Set<JButton> followingButtons;
	private Set<JButton> favoritesButtons;
	private JScrollPane jspFollowers;
	private JScrollPane jspFollowing;
	private JScrollPane jspFavorites;
	private JPanel jpFollowers;
	private JPanel jpFollowing;
	private JPanel jpFavorites;
	private JPanel buttonP;
	private JButton edit;
	private JButton unFollow;
	private JButton follow;
	private JPanel picture;
	private JPanel namePanel;
	private JPanel emailPanel;
	private JTextField editName;
	private JTextField editEmail;
	private JFileChooser jfl;
	private JLabel picturePic;
	private JButton pictureButton;
	
	private String key;
	public ProfileGUI(Dimension d, String key)
	{
		dim = d;
		this.key = key;
		profilePic = new ImageIcon("data/MomAndMoose.jpg");
		this.setPreferredSize(dim);
		initializeComponents();
		setEventHandlers();
		setVisible(true);
		
	}
	
	private void initializeComponents()
	{
		name = new JLabel("Name");
		email = new JLabel("Email");
		bio = new JTextArea("My Bio");
		picturePic = new JLabel("");
		picturePic.setIcon(profilePic);
		//buttons depending on user
		edit = new JButton("Edit Profile");
		unFollow = new JButton("UnFollow");
		follow = new JButton("Follow");
		saveButton = new JButton("Save Changes");
		cancelButton = new JButton("Cancel");
		pictureButton = new JButton("");
		editName = new JTextField();
		editEmail = new JTextField();
		jfl = new JFileChooser();
		//jfl = new JFileChooser();
	    jfl.setCurrentDirectory(new File("."));
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	            "jpg", "jpeg", "png");
	     	jfl.setFileFilter(filter);
	    
	    editEmail.setPreferredSize(new Dimension(dim.width/3, dim.height/14));
	    editName.setPreferredSize(new Dimension(dim.width/3, dim.height/14));
	    cancelButton.setPreferredSize(new Dimension(dim.width/3, dim.height/16));
	    editEmail.setPreferredSize(new Dimension(dim.width/3, dim.height/16));
	    editEmail.setPreferredSize(new Dimension(dim.width/3, dim.height/14));
	    email.setPreferredSize(new Dimension(dim.width/3, dim.height/14));
	    name.setPreferredSize(new Dimension(dim.width/3, dim.height/14));
	    follow.setPreferredSize(new Dimension(dim.width/3, dim.height/16));
	    edit.setPreferredSize(new Dimension(dim.width/3, dim.height/16));
	    saveButton.setPreferredSize(new Dimension(dim.width/3, dim.height/16));
	    unFollow.setPreferredSize(new Dimension(dim.width/3, dim.height/16));
		followersButtons = new HashSet<JButton>();
		followingButtons = new HashSet<JButton>();
		favoritesButtons = new HashSet<JButton>();
		jpFollowers = new JPanel();
		jpFollowing = new JPanel();
		jpFavorites = new JPanel();
		jpFollowers.setBackground(FirstPageGUI.white);
		jpFollowing.setBackground(FirstPageGUI.white);
		jpFavorites.setBackground(FirstPageGUI.white);
		jspFollowing = new JScrollPane(jpFollowing);
		jspFollowers = new JScrollPane(jpFollowers);
		jspFavorites = new JScrollPane(jpFavorites);
		jpFollowers.setLayout(new BoxLayout(jpFollowers, BoxLayout.Y_AXIS));
		jpFollowing.setLayout(new BoxLayout(jpFollowing, BoxLayout.Y_AXIS));
		jpFavorites.setLayout(new BoxLayout(jpFavorites, BoxLayout.Y_AXIS));
		populate();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 3));
		JPanel buttonLabelsPanel = new JPanel();
		buttonLabelsPanel.setPreferredSize(new Dimension(dim.width, dim.height/16));
		buttonLabelsPanel.setLayout(new GridLayout(1, 3));
		JLabel followers = new JLabel("Followers");
		JLabel following = new JLabel("Following");
		JLabel favorites = new JLabel("Favorites");
		followers.setHorizontalAlignment(SwingConstants.CENTER);
		following.setHorizontalAlignment(SwingConstants.CENTER);
		favorites.setHorizontalAlignment(SwingConstants.CENTER);
		buttonLabelsPanel.add(followers);
		buttonLabelsPanel.add(following);
		buttonLabelsPanel.add(favorites);
		bottomPanel.setPreferredSize(new Dimension(dim.width, 7*dim.height/16));
		bottomPanel.add(jspFollowers);
		bottomPanel.add(jspFollowing);
		bottomPanel.add(jspFavorites);
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		middlePanel.add(bio);
		bio.setPreferredSize(new Dimension(dim.width, dim.height/5));
		bio.setEditable(false);
		bio.setBackground(FirstPageGUI.color);
		bio.setForeground(FirstPageGUI.white);
		edit.setBorder(new RoundedBorder());
		edit.setBackground(FirstPageGUI.green);
		follow.setBorder(new RoundedBorder());
		unFollow.setBorder(new RoundedBorder());
		follow.setForeground(FirstPageGUI.white);
		unFollow.setForeground(FirstPageGUI.white);
		follow.setBackground(FirstPageGUI.green);
		unFollow.setBackground(FirstPageGUI.green);
		edit.setForeground(FirstPageGUI.white);
		saveButton.setBorder(new RoundedBorder());
		cancelButton.setBorder(new RoundedBorder());
		saveButton.setBackground(FirstPageGUI.green);
		cancelButton.setBackground(FirstPageGUI.color);
		saveButton.setForeground(FirstPageGUI.white);
		cancelButton.setForeground(FirstPageGUI.white);
		editEmail.setBorder(new RoundedBorder());
		editName.setBorder(new RoundedBorder());
		cancelButton.setOpaque(true);
		saveButton.setOpaque(true);
		edit.setOpaque(true);
		unFollow.setOpaque(true);
		follow.setOpaque(true);
		topPanel.setPreferredSize(new Dimension(dim.width, 2*dim.height/5));
		picture = new JPanel();
		picture.setPreferredSize(new Dimension(dim.width/2, dim.height/4));
		picture.add(picturePic);
		JPanel info = new JPanel();
		info.setPreferredSize(new Dimension(dim.width/2, dim.height/4));
		buttonP = new JPanel();
		buttonP.setPreferredSize(new Dimension(dim.width, dim.height/14));
		emailPanel = new JPanel();
		emailPanel.setPreferredSize(new Dimension(dim.width, dim.height/14));
		namePanel = new JPanel();
		namePanel.setPreferredSize(new Dimension(dim.width, dim.height/14));
		namePanel.add(name);
		emailPanel.add(email);
		//JPanel allInfoP = new JPanel();
		info.setPreferredSize(new Dimension(new Dimension(dim.width/2, dim.height/4)));
		//picture.add()
		if (key.equals("not friends"))
		{
			buttonP.add(follow);
		}
		else if (key.equals("friends"))
		{
			buttonP.add(unFollow);
		}
		else if (key.equals("current user"))
		{
			buttonP.add(edit);
			
		}
		info.add(namePanel);
		info.add(emailPanel);
		info.add(buttonP);
		topPanel.add(picture, BorderLayout.WEST);
		topPanel.add(info, BorderLayout.EAST);
		add(info, BorderLayout.NORTH);
		add(middlePanel, BorderLayout.CENTER);
		setBackground(FirstPageGUI.white);
		JPanel mid = new JPanel();
		mid.setPreferredSize(new Dimension(dim.width, dim.height/2));
		mid.add(buttonLabelsPanel, BorderLayout.NORTH);
		mid.add(bottomPanel, BorderLayout.CENTER);
		add(mid, BorderLayout.SOUTH);//, BorderLayout.SOUTH);
		//add(new JLabel("OHAI!!!!!"));
		repaint();
		setVisible(true);
		
	}
	
	private void populate()
	{
		for (int i = 0; i<100; i++)
		{
			JButton temp = new JButton("User");
			followersButtons.add(temp);
			JButton temp3 = new JButton("User");
			followingButtons.add(temp3);
			JButton temp2 = new JButton("Song");
			favoritesButtons.add(temp2);
		}
		
		Iterator<JButton> it = followersButtons.iterator();
		Iterator<JButton> it2 = followingButtons.iterator();
		Iterator<JButton> it3 = favoritesButtons.iterator();
		while (it.hasNext())
		{
			JButton temp = it.next();
			jpFollowers.add(temp);
		}
		while (it2.hasNext())
		{
			JButton temp = it2.next();
			jpFollowing.add(temp);
		}
		while (it3.hasNext())
		{
			JButton temp = it3.next();
			jpFavorites.add(temp);
		}
		
	}
	
	private void setEventHandlers()
	{
		edit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				bio.setEditable(true);
				namePanel.remove(name);
				name.setVisible(false);
				emailPanel.remove(email);
				email.setVisible(false);
				buttonP.remove(edit);
				edit.setVisible(false);
				buttonP.add(saveButton);
				saveButton.setVisible(true);
				buttonP.add(cancelButton);
				cancelButton.setVisible(true);
				emailPanel.add(editEmail);
				editEmail.setVisible(true);
				namePanel.add(editName);
				editName.setVisible(true);
			//	picture.remove();
				picture.add(pictureButton);
				pictureButton.setVisible(true);
				
			}
			
		});
		pictureButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int temp1 = jfl.showOpenDialog(pictureButton);
				if (temp1 == JFileChooser.APPROVE_OPTION)
				{
					//get the file
					pictureFile = jfl.getSelectedFile();
					
				}
			}
			
		});
		
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				bio.setEditable(false);
				namePanel.remove(editName);
				editName.setVisible(false);
				emailPanel.remove(editEmail);
				editEmail.setVisible(false);
				buttonP.remove(saveButton);
				saveButton.setVisible(false);
				buttonP.remove(cancelButton);
				cancelButton.setVisible(false);
				buttonP.add(edit);
				edit.setVisible(true);
				emailPanel.add(email);
				email.setVisible(true);
				namePanel.add(name);
				name.setVisible(true);
			//	picture.remove();
				picture.remove(pictureButton);
				pictureButton.setVisible(false);
			}

		});
	}
}