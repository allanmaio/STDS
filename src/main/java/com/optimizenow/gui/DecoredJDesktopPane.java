package com.optimizenow.gui;

import java.awt.Graphics;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class DecoredJDesktopPane extends JDesktopPane {

	private static final long serialVersionUID = -7979753716612071997L;

	private final ImageIcon image;

	private final MediaTracker tracker;

	public DecoredJDesktopPane(final String caminhoImagem) {

		image = new ImageIcon(caminhoImagem);

		tracker = new MediaTracker(this);
		tracker.addImage(image.getImage(), 0);

		try {
			tracker.waitForID(0);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

	}

	public void paintComponent(final Graphics graphics) {

		super.paintComponent(graphics);

		graphics.drawImage(image.getImage(), this.getWidth() / 2
				- image.getImage().getWidth(this) / 2, this.getHeight() / 2
				- image.getImage().getHeight(this) / 2, this.getBackground(),
				this);

	}

}