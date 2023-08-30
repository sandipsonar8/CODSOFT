import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;

public class ATM extends JFrame {
	private JTextField input_Amt;
	private BankAccount userAccount;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM frame = new ATM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	public ATM() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sandip Sonar\\Downloads\\atm-machine_2792101.png"));
		setTitle("ATM Machine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 366);
		getContentPane().setLayout(new BorderLayout());
		
		//INPUT Text.........
		JTextArea outputMsg = new JTextArea();
		outputMsg.setAlignmentY(1.0f);
		outputMsg.setEditable(false);
		outputMsg.setTabSize(5);
		outputMsg.setForeground(new Color(0, 0, 0));
		outputMsg.setFont(new Font("Tahoma", Font.PLAIN, 20));
		outputMsg.setRows(6);
		outputMsg.setColumns(10);
		getContentPane().add(outputMsg, BorderLayout.NORTH);
		
		//Buttons set..............
		JPanel Buttons = new JPanel();
		getContentPane().add(Buttons, BorderLayout.SOUTH);
		
		//Starting A\c Balance...........
		userAccount = new BankAccount(1000);
		
		JButton withdraw_Btn = new JButton("Withdraw");
		withdraw_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount=Double.parseDouble(input_Amt.getText());
				boolean success=userAccount.withdraw(amount);
				if (success) {
					outputMsg.setText("Withdrawal of ₹" + amount + " successful.");
                } else {
                	outputMsg.setText("Withdrawal failed. Insufficient balance.");
                }
			}
		});
		Buttons.add(withdraw_Btn);
		
		//Deposit Button.....
		JButton deposit_Btn = new JButton("Deposit");
		deposit_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount=Double.parseDouble(input_Amt.getText());
				userAccount.deposit(amount);
				outputMsg.setText("Deposit of ₹"+amount+" successful.");
			}
		});
		Buttons.add(deposit_Btn);
		
		//Check Balance Button...... 
		JButton check_Balance_Btn = new JButton("Check Balance");
		check_Balance_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double balance=userAccount.getBalance();
				outputMsg.setText("Current Balance: ₹"+balance);
			}
		});
		Buttons.add(check_Balance_Btn);
		
		//OUTPUT Text.............
		input_Amt = new JTextField();
		input_Amt.setForeground(new Color(75, 27, 49));
		input_Amt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(input_Amt, BorderLayout.CENTER);
		input_Amt.setColumns(5);
		
		JLabel lblNewLabel = new JLabel(" ₹");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(75, 27, 49));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel, BorderLayout.WEST);
		
		
	}
	
	//User account......
	public class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public double getBalance() {
            return balance;
        }
    }
}
