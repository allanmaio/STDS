package com.optimizenow.gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.optimizenow.datasource.HibernateUtil;
import com.optimizenow.util.Util;


public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 8954000587453924101L;

	private JMenuItem mnuAcesso;

	private JMenu mnuAjuda;

	private JMenuBar mnuBar;

	private JMenuItem mnuCInformacoesFinanceiras;

	private JMenuItem mnuCLojista;

	private JMenuItem mnuCPonto;

	private JMenuItem mnuCLoja;

	private JMenuItem mnuCUnidadeComercial;

	private JMenu mnuCadastro;

	private JMenuItem mnuManual;

	private JMenuItem mnuRInformacoesFinanceiras;

	private JMenuItem mnuRLoja;

	private JMenuItem mnuRUnidade;

	private JMenuItem mnuRLojista;

	private JMenu mnuRelatorios;

	private JMenu mnuSair;

	private JMenuItem mnuSobre;

	private JMenu mnuUtilitarios;

	private JMenuItem mnuVPlantaBaixa;

	private JMenu mnuVisualizacao;

	private JMenu mnuTrocarTema;

	private JSeparator jSeparator10;

	private static JDesktopPane desktopPane;

	private HashMap<String,String> lafs;

	public TelaPrincipal() {
		initComponents();
		Util.maximizarJanela(this);
	}

	private void initComponents() {
		Toolkit toolkit = this.getToolkit();
		Image iconeSTDS = toolkit.getImage("images/LOGO32X32.gif");
		this.setIconImage(iconeSTDS);
		mnuBar = new JMenuBar();
		mnuCadastro = new JMenu();
		mnuCLoja = new JMenuItem();
		mnuCLojista = new JMenuItem();
		mnuCPonto = new JMenuItem();
		mnuCInformacoesFinanceiras = new JMenuItem();
		mnuCUnidadeComercial = new JMenuItem();
		mnuRelatorios = new JMenu();
		mnuRUnidade = new JMenuItem();
		mnuRLoja = new JMenuItem();
		mnuRLojista = new JMenuItem();
		mnuRInformacoesFinanceiras = new JMenuItem();
		mnuVisualizacao = new JMenu();
		mnuVPlantaBaixa = new JMenuItem();
		mnuUtilitarios = new JMenu();
		mnuAcesso = new JMenuItem();
		mnuAjuda = new JMenu();
		mnuManual = new JMenuItem();
		mnuSobre = new JMenuItem();
		mnuSair = new JMenu();
		mnuTrocarTema = new JMenu();
		jSeparator10 = new JSeparator();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("STDS - Sistema de Tomada de Decis\u00f5es em Shoppings");

		mnuCadastro.setMnemonic('C');
		mnuCadastro.setText("Cadastros");

		mnuCLojista.setMnemonic('L');
		mnuCLojista.setText("Lojistas");
		mnuCLojista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuActions(new FrameCadastrarLojista().getJInternalFrame());
			}
		});

		mnuCadastro.add(mnuCLojista);
		mnuCadastro.add(new JSeparator());
		
		
		mnuCLoja.setMnemonic('o');
		mnuCLoja.setText("Lojas");
		mnuCLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuActions(new FrameCadastrarLoja().getJInternalFrame());
			}
		});

		mnuCadastro.add(mnuCLoja);
		mnuCadastro.add(new JSeparator());

		mnuCUnidadeComercial.setMnemonic('U');
		mnuCUnidadeComercial.setText("Unidades Comerciais");
		mnuCUnidadeComercial
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						mnuActions(new FrameCadastrarUnidadeComercial().getJInternalFrame());
					}
				});

		mnuCadastro.add(mnuCUnidadeComercial);
		mnuCadastro.add(new JSeparator());

		mnuCPonto.setMnemonic('P');
		mnuCPonto.setText("Pontos");
		mnuCPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuActions(new FrameCadastrarPonto().getJInternalFrame());
			}
		});

		mnuCadastro.add(mnuCPonto);
		mnuCadastro.add(new JSeparator());

		mnuCInformacoesFinanceiras.setMnemonic('I');
		mnuCInformacoesFinanceiras.setText("Informa\u00e7\u00f5es Financeiras");
		mnuCInformacoesFinanceiras
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						mnuActions(new FrameCadastrarInformacoesFinanceiras().getJInternalFrame());
					}
				});
		mnuCadastro.add(mnuCInformacoesFinanceiras);
		mnuBar.add(mnuCadastro);

		mnuRelatorios.setMnemonic('R');
		mnuRelatorios.setText("Relat\u00f3rios");

		mnuRLoja.setMnemonic('R');
		mnuRLoja.setText("Lojas");
		mnuRLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuActions(new FrameRLoja());
			}
		});

		mnuRelatorios.add(mnuRLoja);
		mnuRelatorios.add(new JSeparator());

		mnuRLojista.setMnemonic('L');
		mnuRLojista.setText("Lojistas");
		mnuRLojista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuActions(new FrameRLojista());
			}
		});

		mnuRelatorios.add(mnuRLojista);
		mnuRelatorios.add(new JSeparator());

		mnuRUnidade.setMnemonic('U');
		mnuRUnidade.setText("Unidades Comerciais");
		mnuRUnidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuActions(new FrameRUnidade());
			}
		});

		mnuRelatorios.add(mnuRUnidade);
		mnuRelatorios.add(jSeparator10);

		mnuRInformacoesFinanceiras.setMnemonic('I');
		mnuRInformacoesFinanceiras.setText("Informa\u00e7\u00f5es Financeiras");
		mnuRInformacoesFinanceiras
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						mnuActions(new FrameRInformacoes());
					}
				});
		mnuRelatorios.add(mnuRInformacoesFinanceiras);
		mnuBar.add(mnuRelatorios);

		mnuVisualizacao.setMnemonic('V');
		mnuVisualizacao.setText("Visualiza\u00e7\u00e3o");

		mnuVPlantaBaixa.setMnemonic('P');
		mnuVPlantaBaixa.setText("Planta Baixa");
		mnuVisualizacao.add(mnuVPlantaBaixa);
		mnuVPlantaBaixa.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				mnuActions(new FrameVisualizarPlanta());
				
			}
			
		});
		mnuBar.add(mnuVisualizacao);

		mnuUtilitarios.setMnemonic('U');
		mnuUtilitarios.setText("Utilit\u00e1rios");
		mnuAcesso.setMnemonic('A');
		mnuAcesso.setText("Acesso ao Sistema");
		mnuAcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuActions(new FrameAcessoSistema().getJInternalFrame());
			}
		});

		mnuTrocarTema.setMnemonic('T');
		mnuTrocarTema.setText("Trocar Tema");

		lafs = new HashMap<String, String>();
		lafs.put("com.birosoft.liquid.LiquidLookAndFeel", "LiquidLookAndFeel");
		lafs.put("com.sun.java.swing.plaf.windows.WindowsLookAndFeel", "WindowsLookAndFeel");
		lafs.put("com.jgoodies.looks.plastic.PlasticXPLookAndFeel", "PlasticXPLookAndFeel");
		lafs.put("com.sun.java.swing.plaf.gtk.GTKLookAndFeel", "GTKLookAndFeel");
		lafs.put("javax.swing.plaf.metal.MetalLookAndFeel", "MetalLookAndFeel");
		lafs.put("com.sun.java.swing.plaf.motif.MotifLookAndFeel", "MotifLookAndFeel");
		lafs.put("javax.swing.plaf.mac.MacLookAndFeel", "MacLookAndFeel");
		lafs.put("com.l2fprod.gui.plaf.skin.SkinLookAndFeel", "SkinLookAndFeel");

		for (final String laf : lafs.keySet()) {
			JMenuItem mnuLaf = new JMenuItem(lafs.get(laf));
			mnuLaf.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					setLookAndFeel(laf, e);
				}
			});
			mnuTrocarTema.add(mnuLaf);
		}

		mnuUtilitarios.add(mnuAcesso);
		mnuUtilitarios.add(mnuTrocarTema);
		mnuBar.add(mnuUtilitarios);

		mnuAjuda.setMnemonic('A');
		mnuAjuda.setText("Ajuda");
		mnuManual.setText("Manual");
		//mnuAjuda.add(mnuManual);
		//mnuAjuda.add(new JSeparator());

		mnuSobre.setText("Sobre");
		mnuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuActions(new FrameSobre());
			}
		});
		mnuAjuda.add(mnuSobre);
		mnuBar.add(mnuAjuda);

		mnuSair.setMnemonic('S');
		mnuSair.setText("Sair");
		mnuSair.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				mnuSairMouseClicked(evt);
			}
		});

		mnuBar.add(mnuSair);

		this.setJMenuBar(mnuBar);

		setLayout(new BorderLayout());
		desktopPane = new DecoredJDesktopPane("images/LOGO.gif");
		desktopPane.setOpaque(true);
		add(desktopPane, BorderLayout.CENTER);
		pack();
		
		this.addWindowListener(new WindowListener() {

			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosed(WindowEvent e) {
				HibernateUtil.shutdown();
			}

			public void windowClosing(WindowEvent e) {
				HibernateUtil.shutdown();
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
			}
			
		});		
	}

	protected void setLookAndFeel(final String laf, ActionEvent e) {
		try {
			UIManager.setLookAndFeel(laf);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (InstantiationException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} catch (UnsupportedLookAndFeelException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	private void mnuSairMouseClicked(java.awt.event.MouseEvent evt) {
		HibernateUtil.shutdown();
		System.exit(0);
	}

	private void mnuActions(JInternalFrame internalFrame) {
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);

	}

	static void addInternalFrame(JInternalFrame frameResultado) {
		desktopPane.add(frameResultado);
		frameResultado.setVisible(true);
		
	}

}
