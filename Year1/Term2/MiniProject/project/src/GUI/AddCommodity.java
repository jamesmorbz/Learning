package GUI;

import javax.swing.JFrame;
import Data.FileIO;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddCommodity extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public AddCommodity() {
		setTitle("Add Commodity");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddCurrentAccount = new JLabel("Add Commodity ");
		lblAddCurrentAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAddCurrentAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCurrentAccount.setBounds(10, 11, 414, 34);
		contentPane.add(lblAddCurrentAccount);

		JLabel lblName = new JLabel("Material:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(10, 72, 124, 14);
		contentPane.add(lblName);

		textField = new JTextField();
		textField.setBounds(144, 69, 254, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblBalance = new JLabel("Current Value:");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblBalance.setBounds(10, 118, 124, 14);
		contentPane.add(lblBalance);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 115, 254, 20);
		contentPane.add(textField_1);

		JLabel lblMaximumWithdrawLimit = new JLabel("Quantity");
		lblMaximumWithdrawLimit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaximumWithdrawLimit.setBounds(10, 163, 135, 14);
		contentPane.add(lblMaximumWithdrawLimit);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(144, 160, 254, 20);
		contentPane.add(textField_2);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String material = textField.getText();
				double currentValue = Double.parseDouble(textField_1.getText());
				int quantity = Integer.parseInt(textField_2.getText());
				if (currentValue < 0) {
					JOptionPane.showMessageDialog(getComponent(0), "Value must be greater than 0", "Warning", 0);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
				} else {
					if (material == null || currentValue <= 0 || quantity <= 0) {
						JOptionPane.showMessageDialog(getComponent(0), "Typing Mismatch!! Try Again");
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
					} else {

						int ch = JOptionPane.showConfirmDialog(getComponent(0), "Confirm?");
						if (ch == 0) {
							int index = 0;
							try {
								index = FileIO.Investment.addInvestment(material, currentValue, quantity);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							DisplayList.arr.addElement(FileIO.Investment.getInvestments()[index].toString());
							JOptionPane.showMessageDialog(getComponent(0), "Success");
							dispose();
						} else {
							JOptionPane.showMessageDialog(getComponent(0), "Failed");
							textField.setText(null);
							textField_1.setText(null);
							textField_2.setText(null);
						}

					}
				}

			}
		});
		btnAdd.setBounds(86, 209, 89, 23);
		contentPane.add(btnAdd);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);

			}
		});
		btnReset.setBounds(309, 209, 89, 23);
		contentPane.add(btnReset);
	}
}
