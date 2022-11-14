package global;

import Frame.NumPad;

public class Calculating {
	
	private float[] inputBuffer = new float[2];
	private boolean check;
	private String[] Operator = new String[2];
	private NumPad numPad;
	
	
	public Calculating(NumPad N) {
		this.numPad = N;
		this.initialize();
	}
	
	public void initialize() {
		check = false;
		inputBuffer[0] = 0;
		inputBuffer[1] = 0;
		Operator[0]="";
		Operator[1]="";
	}
	
	public void input(String string,String Operator) {
		
		if(!check) {
			inputBuffer[0] = Float.parseFloat(string);
			this.Operator[0]= Operator;
			check = true;
		}else {
			inputBuffer[1]=  inputBuffer[0];
			inputBuffer[0] = Float.parseFloat(string);
			this.Operator[1]=this.Operator[0];
			this.Operator[0]= Operator;
		}
		toPrint(inputBuffer);
		System.out.println(", 	"+check+", 부호: "+this.Operator[0]+", "+this.Operator[1]);
		
	}
	private void toPrint(float[] a) {
		for(float b:a) {
			System.out.print(b+", ");
		}
	}
	
	public Float plus() {
		return inputBuffer[1]+inputBuffer[0];
	}
	public Float minus() {
		return inputBuffer[1]-inputBuffer[0];
	}
	public Float multiplication() {
		return inputBuffer[1]*inputBuffer[0];
	}
	public Float divide() {
		return inputBuffer[1]/inputBuffer[0];
	}
	
	public void output() {
		if(!(this.Operator[1].equals(""))) {
			float temp = -1;
		switch(this.Operator[1]) {
		case "+":temp = plus();
		break;
		case "-":temp = minus();
		break;
		case "*":temp = multiplication();
		break;
		case "/":temp = divide();
		break;
		case "=":
		break;
		}
		numPad.setString(temp);
		System.out.println(temp);
		}else {
			System.out.println("non"+", "+Operator[1]);
		}
	}
}

