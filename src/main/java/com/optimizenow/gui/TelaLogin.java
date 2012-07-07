package com.optimizenow.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import org.hibernate.cfg.Configuration;


import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.optimizenow.datasource.HibernateUtil;
import com.optimizenow.gui.components.STDSTextField;
import com.optimizenow.util.Util;

public final class TelaLogin extends JFrame {

	private static final long serialVersionUID = -2751233215818095185L;
	
	//private static Logger log = org.apache.log4j.Logger.getLogger(TelaLogin.class);

	private final JButton btnCancelar = new JButton("Cancelar");

	private final JButton btnOk = new JButton("OK");

	private final JLabel lblLogin = new JLabel("Login");

	private final JLabel lblSenha = new JLabel("Senha");

	private final JPasswordField pwdSenha = new JPasswordField(15);

	private final JTextField txtLogin = new STDSTextField(15);

	public TelaLogin() {
		//log.debug("entrou no construtor");
		initComponents();
		Util.configuraAberturaJanelaCentralizada(this);
	}

	private void initComponents() {

		pwdSenha.addKeyListener(new KeyListener() {

			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					//log.debug("enter pressionado");
					btnOkActionPerformed(null);
				}
			}

			// Obrigatorio por causa da interface KeyListener
			public void keyReleased(final KeyEvent e) {
			}

			// Obrigatorio por causa da interface KeyListener
			public void keyTyped(final KeyEvent e) {
			}
		});

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("STDS - Login");
		setResizable(false);
		btnOk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				btnOkActionPerformed(evt);
			}
		});

		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		final FormLayout layout = new FormLayout("r:pref, 3dlu, pref", // Colunas
				"pref, 3dlu, pref, 3dlu, pref"); // Linhas

		final CellConstraints cc = new CellConstraints();
		final DefaultFormBuilder builder = new DefaultFormBuilder(layout);
		builder.setDefaultDialogBorder();

		builder.add(lblLogin, cc.xy(1, 1));
		builder.add(txtLogin, cc.xy(3, 1));
		builder.add(lblSenha, cc.xy(1, 3));
		builder.add(pwdSenha, cc.xy(3, 3));

		builder.add(ButtonBarFactory.buildCenteredBar(btnOk, btnCancelar), cc
				.xyw(1, 5, 3));
		this.getContentPane().add(builder.getPanel());

		pack();
	}

	private void btnCancelarActionPerformed(final ActionEvent evt) {
		System.exit(0);
	}

	private void btnOkActionPerformed(final ActionEvent evt) {
		try {
			final Configuration cfg = HibernateUtil.getConfiguration();
			cfg.setProperty("hibernate.connection.username", txtLogin.getText());
			cfg.setProperty("hibernate.connection.password", String.valueOf(pwdSenha.getPassword()));
			HibernateUtil.rebuildSessionFactory(cfg);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaPrincipal().setVisible(true);
			}
		});
		this.dispose();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Problema no acesso ao banco de dados.", "Erro",
					JOptionPane.ERROR_MESSAGE);
		} catch (ExceptionInInitializerError e) {
			JOptionPane.showMessageDialog(null,
					"Problema no acesso ao banco de dados.", "Erro",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	public static void main(String args[]) {
		//PropertyConfigurator.configure("conf/log4j.properties");
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
			//log.debug("Setou o Look and Feel");
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			ex.printStackTrace();
		} catch (UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				//log.debug("Chamou a tela login");
				new TelaLogin().setVisible(true);
			}
		});
	}
}
