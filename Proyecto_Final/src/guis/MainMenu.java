package guis;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import entidades.Alumno;
import entidades.Curso;

import java.awt.Color;
import java.awt.Dialog.ModalityType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;
import javax.swing.UIManager;
import java.awt.Frame;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setBackground(new Color(255, 255, 255));
		setTitle("Registro y Matricula de Alumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 621);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 71, 836, 52);
		contentPane.add(scrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		scrollPane.setColumnHeaderView(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento");
		mnNewMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnNewMenu.setBorder(null);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu.setPreferredSize(new Dimension(209, 50));
		mnNewMenu.setOpaque(true);
		mnNewMenu.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mnNewMenu.setBackground(new Color(153, 181, 181));
		mnNewMenu.setIconTextGap(50);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alumno");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem.setOpaque(true);
		mntmNewMenuItem.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem.setBorder(null);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAlumno dlgAlumno = new DlgAlumno();
				dlgAlumno.setModalityType(ModalityType.APPLICATION_MODAL);
				dlgAlumno.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dlgAlumno.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Curso");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_1.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem_1.setOpaque(true);
		mntmNewMenuItem_1.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem_1.setBorder(null);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgCurso dlgCurso = new DlgCurso();
				dlgCurso.setModalityType(ModalityType.APPLICATION_MODAL);
				dlgCurso.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dlgCurso.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnRegistro = new JMenu("Registro");
		mnRegistro.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnRegistro.setBorder(null);
		mnRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		mnRegistro.setHorizontalTextPosition(SwingConstants.CENTER);
		mnRegistro.setPreferredSize(new Dimension(209, 50));
		mnRegistro.setOpaque(true);
		mnRegistro.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mnRegistro.setBackground(new Color(153, 181, 181));
		mnRegistro.setIconTextGap(70);
		menuBar.add(mnRegistro);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Matrícula");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem_2.setOpaque(true);
		mntmNewMenuItem_2.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem_2.setBorder(null);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgMatricula dlgMatricula = new DlgMatricula();
				dlgMatricula.setModalityType(ModalityType.APPLICATION_MODAL);
				dlgMatricula.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dlgMatricula.setVisible(true);
			}
		});
		mnRegistro.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Retiro");
		mntmNewMenuItem_2_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2_1.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem_2_1.setOpaque(true);
		mntmNewMenuItem_2_1.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem_2_1.setBorder(null);
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			DlgRetiro dlgRetiro = new DlgRetiro();
			dlgRetiro.setModalityType(ModalityType.APPLICATION_MODAL);
			dlgRetiro.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dlgRetiro.setVisible(true);
		}
	});
		mnRegistro.add(mntmNewMenuItem_2_1);
		
		
		JMenu mnConsulta = new JMenu("Consulta");
		mnConsulta.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnConsulta.setBorder(null);
		mnConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		mnConsulta.setHorizontalTextPosition(SwingConstants.CENTER);
		mnConsulta.setPreferredSize(new Dimension(209, 50));
		mnConsulta.setOpaque(true);
		mnConsulta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mnConsulta.setBackground(new Color(153, 181, 181));
		mnConsulta.setIconTextGap(70);
		menuBar.add(mnConsulta);
		
		JMenuItem mntmNewMenuItem_2_2 = new JMenuItem("Alumnos y cursos");
		mntmNewMenuItem_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgConsultaAlumnosyCursos dlgConsultaAlumnosyCursos = new DlgConsultaAlumnosyCursos(); 
				dlgConsultaAlumnosyCursos.setModalityType(ModalityType.APPLICATION_MODAL);
				dlgConsultaAlumnosyCursos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dlgConsultaAlumnosyCursos.setVisible(true);
			}
		});
		mntmNewMenuItem_2_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2_2.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem_2_2.setOpaque(true);
		mntmNewMenuItem_2_2.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem_2_2.setBorder(null);
		mnConsulta.add(mntmNewMenuItem_2_2);
		
		JMenuItem mntmNewMenuItem_2_3 = new JMenuItem("Matriculas y Retiros");
		mntmNewMenuItem_2_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2_3.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem_2_3.setOpaque(true);
		mntmNewMenuItem_2_3.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem_2_3.setBorder(null);
		mnConsulta.add(mntmNewMenuItem_2_3);
		
		JMenu mnReporte = new JMenu("Reporte");
		mnReporte.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mnReporte.setBorder(null);
		mnReporte.setHorizontalAlignment(SwingConstants.CENTER);
		mnReporte.setHorizontalTextPosition(SwingConstants.CENTER);
		mnReporte.setPreferredSize(new Dimension(209, 50));
		mnReporte.setOpaque(true);
		mnReporte.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		mnReporte.setBackground(new Color(153, 181, 181));
		mnReporte.setIconTextGap(70);
		menuBar.add(mnReporte);
		
		JMenuItem mntmNewMenuItem_2_4 = new JMenuItem("Alumnos con matricula pendiente");
		mntmNewMenuItem_2_4.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2_4.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem_2_4.setOpaque(true);
		mntmNewMenuItem_2_4.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem_2_4.setBorder(null);
		mntmNewMenuItem_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgReporteAlumnosMatriculaPendiente dlgReporteAlumnosMatriculaPendiente = new DlgReporteAlumnosMatriculaPendiente();
				dlgReporteAlumnosMatriculaPendiente.setModalityType(ModalityType.APPLICATION_MODAL);
				dlgReporteAlumnosMatriculaPendiente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dlgReporteAlumnosMatriculaPendiente.setVisible(true);
			}
		});
		mnReporte.add(mntmNewMenuItem_2_4);
		
		JMenuItem mntmNewMenuItem_2_5 = new JMenuItem("Alumnos con matricula vigente");
		mntmNewMenuItem_2_5.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_2_5.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2_5.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem_2_5.setOpaque(true);
		mntmNewMenuItem_2_5.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem_2_5.setBorder(null);
		mntmNewMenuItem_2_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgReporteAlumnosMatriculaVigente dlgReporteAlumnosMatriculaVigente = new DlgReporteAlumnosMatriculaVigente();
				dlgReporteAlumnosMatriculaVigente.setModalityType(ModalityType.APPLICATION_MODAL);
				dlgReporteAlumnosMatriculaVigente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dlgReporteAlumnosMatriculaVigente.setVisible(true);
			}
		});
		mnReporte.add(mntmNewMenuItem_2_5);
		
		JMenuItem mntmNewMenuItem_2_6 = new JMenuItem("Alumnos matriculados por curso");
		mntmNewMenuItem_2_6.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewMenuItem_2_6.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2_6.setPreferredSize(new Dimension(200, 40));
		mntmNewMenuItem_2_6.setOpaque(true);
		mntmNewMenuItem_2_6.setBackground(new Color(0, 128, 255));
		mntmNewMenuItem_2_6.setBorder(null);
		mnReporte.add(mntmNewMenuItem_2_6);

		
		JTextPane txtpnSistemaDeMatrculas = new JTextPane();
		txtpnSistemaDeMatrculas.setBounds(102, 0, 734, 34);
		txtpnSistemaDeMatrculas.setBackground(new Color(0, 128, 255));
		txtpnSistemaDeMatrculas.setForeground(new Color(255, 255, 255));
		txtpnSistemaDeMatrculas.setEditable(false);
		txtpnSistemaDeMatrculas.setFont(new Font("Calibri Light", Font.BOLD, 23));
		txtpnSistemaDeMatrculas.setText("SISTEMA DE MATRÍCULAS\r\n");
		contentPane.add(txtpnSistemaDeMatrculas);
		
		JTextPane txtpnVersinAutor = new JTextPane();
		txtpnVersinAutor.setBounds(102, 31, 734, 40);
		txtpnVersinAutor.setForeground(new Color(255, 255, 255));
		txtpnVersinAutor.setBackground(new Color(0, 128, 255));
		txtpnVersinAutor.setEditable(false);
		txtpnVersinAutor.setText("Versión: 1.0.0\r\nAutor: GRUPO A");
		contentPane.add(txtpnVersinAutor);
		
		JLabel iconSystem = new JLabel("");
		iconSystem.setBackground(new Color(0, 128, 255));
		iconSystem.setOpaque(true);
		iconSystem.setHorizontalAlignment(SwingConstants.CENTER);
		iconSystem.setIcon(new ImageIcon("C:\\Users\\User\\git\\repository\\Proyecto_Final\\img\\icons\\folder_system_15426 (1).png"));
		iconSystem.setBounds(0, 0, 102, 71);
		contentPane.add(iconSystem);
	}
	
}
