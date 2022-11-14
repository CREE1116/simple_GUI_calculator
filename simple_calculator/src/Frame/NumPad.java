package Frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import global.Calculating;
import global.Constant.Ebuttons;

public class NumPad extends JPanel{

	private static final long serialVersionUID = 1L;

	private Indicator indicator;
	private String buffer;
	private Calculating cal;
	
	public NumPad() {
		this.buffer = "";
		GridLayout layoutManager = new GridLayout(5,4);
		this.setLayout(layoutManager);
		ActionHandler actionHandler = new ActionHandler();
		for(Ebuttons ebutton : Ebuttons.values() ) {
			JButton button = new JButton(ebutton.getLabel());
			button.addActionListener(actionHandler);
			this.add(button);	
		}
		
	}
	public void initialize() {
		this.cal = new Calculating(this);
	}
	
	private void AC_Action() {
		this.buffer = "";
		this.indicator.setText("");
		this.cal.initialize();
	}
	
	private void addString(String string) {
		if(buffer.length() > 20) {
			this.indicator.setText("E");
		}else {
		this.buffer += string;
		this.indicator.setText(buffer);
		}
	}
	
	public void setString(float flo) {
		if(flo != -1) {
		this.buffer = remove0(flo);
		if(buffer.length() > 20) {
			this.indicator.setText("E");
		}else {
		this.indicator.setText(buffer);
		}
		
		}
	}
	private void sendString(String Operator) {
		cal.input(buffer,Operator);
		buffer = "";
		this.indicator.setText(buffer);
	}
	
	private void deleteString() {
		this.buffer = this.buffer.substring(0, this.buffer.length()-1);
		this.indicator.setText(buffer);
	}
	
	private void percent() {
		buffer = ""+Float.parseFloat(buffer)/100;
		this.indicator.setText(buffer);
	}
	
	private String remove0 (float d)
	{
	    if(d == (long) d)
	        return String.format("%d",(long)d);
	    else
	        return String.format("%s",d);
	}
	private void getAns() {
		cal.output();
	}
	

	class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(Ebuttons.eAC.getLabel())) {
				AC_Action();
			}else if(e.getActionCommand().equals(Ebuttons.ePercent.getLabel())) {
				percent();
			}else if(e.getActionCommand().equals(Ebuttons.eCancle.getLabel())) {
				deleteString();
			}else if(e.getActionCommand().equals(Ebuttons.eMultiplication.getLabel())||e.getActionCommand().equals(Ebuttons.eMinus.getLabel())||e.getActionCommand().equals(Ebuttons.ePlus.getLabel())||e.getActionCommand().equals(Ebuttons.eEqual.getLabel())||e.getActionCommand().equals(Ebuttons.eDivide.getLabel())) {
				sendString(e.getActionCommand());
				getAns();
			}else {
				addString(e.getActionCommand());
			}
		}
	}
	
	public void associate(Indicator indicator) {
		this.indicator = indicator;
	}
}