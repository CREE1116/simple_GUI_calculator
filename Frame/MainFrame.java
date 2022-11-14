package Frame;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	private Indicator indicator;
	private NumPad numPad;
	
	public MainFrame(){
		this.setSize(300,500);
		this.setResizable(false);
		BorderLayout layoutManager = new BorderLayout();
		this.setLayout(layoutManager);
		this.setTitle("GUI Cal");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.indicator = new Indicator();
		this.add(this.indicator, layoutManager.NORTH);
		
		this.numPad = new NumPad();
		this.add(this.numPad, layoutManager.CENTER);
		
		indicator.associate(numPad);
		numPad.associate(indicator);
	}
	public void initialize() {
		numPad.initialize();
		indicator.initialize();
	}
	

}
