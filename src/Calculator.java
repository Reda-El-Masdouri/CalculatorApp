import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font myFont = new Font("Ink Free", Font.BOLD,30);
	
	double num1=0, num2=0, result=0;
	char operator='$';
	
	Calculator(){
		
		frame = new JFrame("Calculator App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(myFont);
		textField.setEditable(false);// we can't use the keyboard to text
		
		addButton = new JButton("+");
		mulButton = new JButton("*");
		subButton = new JButton("-");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		for(int i=0; i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for(int j=0;j<10;j++) {
			numberButtons[j] = new JButton(String.valueOf(j));
			numberButtons[j].addActionListener(this);
			numberButtons[j].setFont(myFont);
			numberButtons[j].setFocusable(false);
		}
		
		delButton.setBounds(150, 430, 100, 50);// because this buttons will not be in our panel
		clrButton.setBounds(250, 430, 100, 50);
		negButton.setBounds(50, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10)); //(rows,cols,xspace,yspace)
		
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(clrButton);
		frame.add(delButton);
		frame.add(textField);
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i =0; i<10;i++) {
			
			if(e.getSource()== numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()== decButton) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource()== addButton) {
			try {
			num1 = Double.parseDouble(textField.getText());
				}
			catch(Exception e1) {
				System.out.println("Your text field is emty");
			}
			operator = '+';
			textField.setText("");
		}
		if(e.getSource()== subButton) {
			try {
			num1 = Double.parseDouble(textField.getText());
				}
			catch(Exception e1) {
				System.out.println("Your text field is emty");
			}
			operator = '-';
			textField.setText("");
		}
		if(e.getSource()== mulButton) {
			try {
			num1 = Double.parseDouble(textField.getText());
				}
			catch(Exception e1) {
				System.out.println("Your text field is emty");
			}
			operator = '*';
			textField.setText("");
		}
		if(e.getSource()== divButton) {
			try {
			num1 = Double.parseDouble(textField.getText());
				}
			catch(Exception e1) {
				System.out.println("Your text field is emty");
			}
			operator = '/';
			textField.setText("");
		}
		if(e.getSource()== equButton) {
			try {
			num2 = Double.parseDouble(textField.getText());
				}
			catch(Exception e1) {
				System.out.println("You need an operation between two numbers");
			}
			
			switch(operator){
				case '+': result = num1+num2;
				break;
				case '-': result = num1-num2;
				break;
				case '*': result = num1*num2;
				break;
				case '/': result = num1/num2;
				break;
				case '$': result = num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = 0;
			//num1 = result; // repeat the same function when we press equButton
		}
		if(e.getSource()== clrButton) {
			textField.setText("");
			operator = '$';
			
		}
		if(e.getSource()== delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
		}
		if(e.getSource()== negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
		}
	}

}
