package global;

public class Constant {
	
	public enum Ebuttons{
		eAC("AC"),
		ePercent("%"),
		eDivide("/"),
		eCancle("Del"),
		e7("7"),
		e8("8"),
		e9("9"),
		eMultiplication("*"),
		e4("4"),
		e5("5"),
		e6("6"),
		eMinus("-"),
		e1("1"),
		e2("2"),
		e3("3"),
		ePlus("+"),
		eDot("."),
		e0("0"),
		eEqual("=");
		
		private String label;
		
		
		private Ebuttons(String label) {
			this.label = label;
		}
		public String getLabel() {
			return this.label; 
		}
	}
	

}
