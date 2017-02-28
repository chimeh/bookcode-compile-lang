package ui.panels;

import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class ButtonPanel extends Panel {
	private Button btnClear;
	
	public ButtonPanel(final Model model) {
		btnClear = new Button("Clear");
				
		class ButtonListener implements ActionListener {			
			public void actionPerformed(ActionEvent arg0) {
				model.resetComponents();
				model.repaint();
            }
		}
		
		btnClear.addActionListener(new ButtonListener());
		add(btnClear);
	}
}
