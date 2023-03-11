package guis;
import java.util.ArrayList;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Alumno;

import java.awt.Color;
import java.awt.Dialog.ModalityType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 624, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 608, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alumno");
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
		menuBar.add(mnRegistro);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Matrícula");
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
		mnRegistro.add(mntmNewMenuItem_2_1);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmNewMenuItem_2_2 = new JMenuItem("Alumnos y cursos");
		mnConsulta.add(mntmNewMenuItem_2_2);
		
		JMenuItem mntmNewMenuItem_2_3 = new JMenuItem("Matriculas y Retiros");
		mnConsulta.add(mntmNewMenuItem_2_3);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		JMenuItem mntmNewMenuItem_2_4 = new JMenuItem("Alumnos con matricula pendiente");
		mnReporte.add(mntmNewMenuItem_2_4);
		
		JMenuItem mntmNewMenuItem_2_5 = new JMenuItem("Alumnos con matricula vigente");
		mnReporte.add(mntmNewMenuItem_2_5);
		
		JMenuItem mntmNewMenuItem_2_6 = new JMenuItem("Alumnos matriculados por curso");
		mnReporte.add(mntmNewMenuItem_2_6);
	}
}
