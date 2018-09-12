package fr.istic.master1.sir;

import org.jdesktop.swingx.JXBusyLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JXBusyLabelTest extends JFrame implements ActionListener {
	
	JXBusyLabel bLabel1;
	JComboBox comboBackground, comboForeground;
	JButton btnStart, btnStop;
	Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.GRAY, Color.YELLOW};
	
	public JXBusyLabelTest() {
		bLabel1 = new JXBusyLabel(new Dimension(60, 60));
		bLabel1.setBusy(true);
		
		String[] colorsName = {"Choose a color", "BLACK", "WHITE", "RED", "BLUE", "GREEN", "GRAY", "YELLOW"};
		comboBackground = new JComboBox(colorsName);
		comboForeground = new JComboBox(colorsName);
		btnStart = new JButton("Start");
		btnStop = new JButton("Stop");
		
		comboBackground.addActionListener(this);
		comboForeground.addActionListener(this);
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		
		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		panelSouth.add(new JLabel("Background"));
		panelSouth.add(comboBackground);
		panelSouth.add(new JLabel("Foreground"));
		panelSouth.add(comboForeground);
		panelNorth.add(btnStart);
		panelNorth.add(btnStop);
		
		add(panelNorth, BorderLayout.NORTH);
		add(bLabel1, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);
		
		setSize(400, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Listener actionPerformed
	 * Ceci est un commentaire
	 *
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == comboBackground) {
			bLabel1.getBusyPainter().setBaseColor(colors[comboBackground.getSelectedIndex() - 1]);
		} else if (e.getSource() == comboForeground) {
			bLabel1.getBusyPainter().setHighlightColor(colors[comboForeground.getSelectedIndex() - 1]);
		} else if (e.getSource() == btnStart) {
			bLabel1.setBusy(true);
		} else if (e.getSource() == btnStop) {
			bLabel1.setBusy(false);
		}
	}
	
	public static void main(String[] args) {
		new JXBusyLabelTest();
	}
	
}
