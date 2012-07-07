package com.optimizenow.gui.components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class STDSTextField extends JTextField {

	private static final long serialVersionUID = 814398392844806372L;

	public STDSTextField(int len) {
		super(len);
		adicionarEventoEnter();
	}

	public STDSTextField() {
		adicionarEventoEnter();
	}

	private void adicionarEventoEnter() {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				final int key = evt.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					transferFocus();
				}
			}
		});
	}
}
