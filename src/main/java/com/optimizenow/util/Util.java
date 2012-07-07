package com.optimizenow.util;

import javax.swing.JFrame;

public class Util {
	
	private Util() {
		
	}
	
	public static void configuraAberturaJanelaCentralizada(final JFrame frame) {
		frame.setLocationRelativeTo(null);
	}
	
	public static void maximizarJanela(final JFrame frame) {
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
		.getScreenSize();
		frame.setSize(screenSize);

	}
	
	public static void main(String args[]) {
		
	}

}
