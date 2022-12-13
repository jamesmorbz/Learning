package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddAsset extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public AddAsset() {
		setTitle("Add Investment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddStock = new JButton("Add Stock");
		btnAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!GUIForm.addstock.isVisible()) {
					GUIForm.addstock.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
				dispose();
			}
		});
		btnAddStock.setBounds(118, 56, 193, 38);
		contentPane.add(btnAddStock);

		JButton btnAddCommodity = new JButton("Add Commodity");
		btnAddCommodity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!GUIForm.addcommodity.isVisible()) {
					GUIForm.addcommodity.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
			}
		});
		btnAddCommodity.setBounds(118, 124, 193, 38);
		contentPane.add(btnAddCommodity);

		JButton btnAddCash = new JButton("Add Cash");
		btnAddCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!GUIForm.addcash.isVisible()) {
					GUIForm.addcash.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(getComponent(0), "Already Opened", "Warning", 0);
				}
			}
		});
		btnAddCash.setBounds(118, 190, 193, 38);
		contentPane.add(btnAddCash);

		JLabel lbladdInvestment = new JLabel("Add Account");
		lbladdInvestment.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbladdInvestment.setHorizontalAlignment(SwingConstants.CENTER);
		lbladdInvestment.setBounds(108, 11, 210, 34);
		contentPane.add(lbladdInvestment);
	}
}
