package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class ClientPanel {

	private JFrame clientFrame;
	private JPanel buttonPanel;
	private JPanel displayPanel;
	private JPanel selectPanel;
	private JPanel controlPanel;
	private JPanel receiveControlPanel;
	private JPanel receivePanel;
	private JPanel statusPanel;
	private JPanel receiveSubPanel1;
	private JPanel receiveSubPanel2;
	private JButton input;
	private JButton output;
	private JButton receive;
	private JTextArea showResults;
	private JTextArea showStatus;
	private JComboBox<String> fileToGet;
	private JProgressBar progressBar;
	private static final String GET_FILE = "Please choose a file to retrieve";

	public static void main(String args[]) {
		ClientPanel clientPanel = new ClientPanel();
	}

	public ClientPanel() {
		loadGUI();
	}

	private void loadGUI() {
		clientFrame = new JFrame("Client File Transfer Control Panel");
		clientFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		clientFrame.setMaximumSize(new Dimension(1920, 1080));
		buttonPanel = new JPanel();
		selectPanel = new JPanel();
		controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		displayPanel = new JPanel();
		displayPanel.setLayout(new BorderLayout());
		receivePanel = new JPanel();
		receivePanel.setLayout(new BorderLayout());
		receiveControlPanel = new JPanel();
		receiveControlPanel.setLayout(new BorderLayout());
		statusPanel = new JPanel();
		statusPanel.setLayout(new BorderLayout());

		setUpButtonPanel();
		setUpSelectBox();
		setUpDisplayPanel();
		setUpStatusPanel();
		setUpReceivePanel();

		receiveControlPanel.add(receivePanel, BorderLayout.WEST);
		receiveControlPanel.add(displayPanel, BorderLayout.CENTER);
		controlPanel.add(buttonPanel, BorderLayout.NORTH);
		controlPanel.add(receiveControlPanel, BorderLayout.CENTER);
		clientFrame.add(controlPanel, BorderLayout.CENTER);

		clientFrame.validate();
		clientFrame.pack();
		clientFrame.setVisible(true);
		
		// add action listener
		input.addActionListener(new InputDirectoryChooser());
		output.addActionListener(new OutputDirectoryChooser());
		
	}

	private void setUpSelectBox() {
		fileToGet = new JComboBox<String>();
		fileToGet.setEditable(false);
		fileToGet.addItem(GET_FILE);
		selectPanel.setLayout(new BorderLayout());
		selectPanel.add(fileToGet, BorderLayout.CENTER);
	}

	private void setUpDisplayPanel() {
		showResults = new JTextArea();
		showResults.setLineWrap(true);
		showResults.setEditable(false);
		JScrollPane scrollTextArea = new JScrollPane(showResults,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		displayPanel.add(scrollTextArea, BorderLayout.CENTER);
	}
	
	private void setUpStatusPanel() {
		showStatus = new JTextArea();
		showStatus.setLineWrap(true);
		showStatus.setEditable(false);
		JScrollPane scrollTextArea = new JScrollPane(showStatus,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		statusPanel.add(scrollTextArea, BorderLayout.CENTER);
	}

	private void setUpButtonPanel() {
		buttonPanel.setLayout(new GridLayout(1, 2));
		input = new JButton("Add input files or directory to share");
		output = new JButton("Choose output directory");
		buttonPanel.add(input);
		buttonPanel.add(output);
	}

	private void setUpReceivePanel() {
		receive = new JButton("Receive");
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		receiveSubPanel1 = new JPanel();
		receiveSubPanel1.setLayout(new BorderLayout());
		receiveSubPanel2 = new JPanel();
		receiveSubPanel2.setLayout(new BorderLayout());
		receiveSubPanel1.add(progressBar, BorderLayout.NORTH);
		receiveSubPanel1.add(statusPanel, BorderLayout.CENTER);
		receiveSubPanel2.add(receive, BorderLayout.NORTH);
		receiveSubPanel2.add(receiveSubPanel1, BorderLayout.CENTER);
		receivePanel.add(selectPanel, BorderLayout.NORTH);
		receivePanel.add(receiveSubPanel2, BorderLayout.CENTER);
	}
	
	private class InputDirectoryChooser implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setDialogTitle("Please choose a directory to share");
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				System.out.println(chooser.getCurrentDirectory());
				System.out.println(chooser.getSelectedFile());
			// need to have a class that update the input directory.
			// TODO
			}
		}
	}
	
	private class OutputDirectoryChooser implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File("."));
			chooser.setDialogTitle("Please choose a output directory");
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				// TODO
				System.out.println(chooser.getCurrentDirectory());
				System.out.println(chooser.getSelectedFile());
			}
		}
		
	}
	
	private class Transfer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}

}
