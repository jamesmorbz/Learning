
/**
* ECS414U - Object Oriented Programming
* Queen Mary University of London, 2021/22.
* <p>
* Week 5 lab session.
*/

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BankingApp extends Frame {

	private static TextArea infoArea = new TextArea("BankingApp 0.5");

	public static void print(String text) {
		infoArea.setText(text);
	}

	private Agent agent;
	private Panel clientButtonsPanel;
	private ArrayList<String> listOfClientNames = new ArrayList<String>();

	public void printClients() {
		String text = agent.getListOfClientNames();
		print(text);
	}

	public void printClientInfo(int index) {
		String text = agent.getClientInfo(index);
		print(text);
	}

	public void addClient(String name) {
		agent.addClient(new Client(name));
		listOfClientNames.add(name);
		int numClients = agent.getNumberOfClients();
		Button btn = new Button("Client " + numClients);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				printClientInfo(numClients - 1);
			}
		});

		clientButtonsPanel.add(btn);
	}

	public BankingApp() {

		this.agent = new Agent();
		this.setLayout(new FlowLayout());

		Button reportButton = new Button("Print client list");
		reportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				printClients();
			}
		});
		this.add(reportButton);

		Button addClientButton = new Button("Add client");
		addClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Frame prompt = new Frame();
				prompt.setLayout(new GridLayout(0, 2));

				Label l1 = new Label("Enter Name");
				TextField t1 = new TextField(20);
				Button submit = new Button("Submit");

				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addClient(t1.getText());
						print("Success: " + t1.getText() + " has been added");
						prompt.dispose();
					}
				});

				prompt.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						((Frame) (evt.getSource())).dispose();
					}
				});

				prompt.add(l1);
				prompt.add(t1);
				prompt.add(submit);
				prompt.setVisible(true);
				prompt.pack();
				prompt.setLocationRelativeTo(null);

			}
		});
		this.add(addClientButton);

		Button depositButton = new Button("Deposit");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				Frame prompt = new Frame();
				prompt.setLayout(new GridLayout(0, 2));

				Label l1 = new Label("Enter Name");
				TextField t1 = new TextField(20);
				Label l2 = new Label("Enter Amount £");
				TextField t2 = new TextField(20);
				Button submit = new Button("Submit");

				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (agent.deposit(t1.getText(), Integer.parseInt(t2.getText()))) {
							print("Success: £" + t2.getText() + " has been deposited to " + t1.getText());
						} else {
							print("Error: Account name does not exist");
						}

						prompt.dispose();
					}
				});

				prompt.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						((Frame) (evt.getSource())).dispose();
					}
				});

				prompt.add(l1);
				prompt.add(t1);
				prompt.add(l2);
				prompt.add(t2);
				prompt.add(submit);
				prompt.setVisible(true);
				prompt.pack();
				prompt.setLocationRelativeTo(null);
			}
		});
		this.add(depositButton);

		Button withdrawButton = new Button("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				Frame prompt = new Frame();
				prompt.setLayout(new GridLayout(0, 2));

				Label l1 = new Label("Enter Name");
				TextField t1 = new TextField(20);
				Label l2 = new Label("Enter Amount £");
				TextField t2 = new TextField(20);
				Button submit = new Button("Submit");

				submit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (agent.deposit(t1.getText(), Integer.parseInt(t2.getText()) * -1)) {
							print("Success: £" + t2.getText() + " has been withdrawn from " + t1.getText());
						} else {
							print("Error: Account name does not exist");
						}

						prompt.dispose();
					}
				});

				prompt.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						((Frame) (evt.getSource())).dispose();
					}
				});

				prompt.add(l1);
				prompt.add(t1);
				prompt.add(l2);
				prompt.add(t2);
				prompt.add(submit);
				prompt.setVisible(true);
				prompt.pack();
				prompt.setLocationRelativeTo(null);
			}
		});
		this.add(withdrawButton);

		Button removeButton = new Button("Remove Client");
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				Frame prompt = new Frame();
				prompt.setLayout(new GridLayout(0, 2));

				Label l1 = new Label("Enter Name");
				TextField t1 = new TextField(20);
				Button remove = new Button("Remove");

				remove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (agent.removeClient(t1.getText())) {
							print("Success: " + t1.getText() + " has been removed");
							int index = listOfClientNames.indexOf(t1.getText());
							listOfClientNames.remove(index);
							clientButtonsPanel.remove(index);
						} else {
							print("Error: Account name does not exist");
						}

						prompt.dispose();
					}
				});

				prompt.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent evt) {
						((Frame) (evt.getSource())).dispose();
					}
				});

				prompt.add(l1);
				prompt.add(t1);
				prompt.add(remove);
				prompt.setVisible(true);
				prompt.pack();
				prompt.setLocationRelativeTo(null);
			}
		});
		this.add(removeButton);

		infoArea.setEditable(false);
		this.add(infoArea);

		clientButtonsPanel = new Panel();
		clientButtonsPanel.setLayout(new GridLayout(0, 1));
		clientButtonsPanel.setVisible(true);
		this.add(clientButtonsPanel);

		this.addClient("Alice Alison");
		this.addClient("Bob Robertson");

		WindowCloser wc = new WindowCloser();
		this.addWindowListener(wc);

		this.setSize(500, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BankingApp();
	}
}
