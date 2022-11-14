package Frame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Indicator extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private NumPad numPad;
	
	public Indicator() {
		this.textField = new JTextField(15);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		this.textField.setEditable(false);
		this.textField.setFont(new Font(textField.getFont().getName(),Font.BOLD,20));
		this.add(this.textField);
		this.setSize(300,200);
		this.textField.setText("");
	}
	public void initialize() {
		
	}
	public void setText(String string) {
		this.textField.setText(string);
	}
	
	public void associate(NumPad numPad) {
		this.numPad = numPad;
	}
}
