package guis;

import arreglos.*;
import entidades.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloAlumno;
import arreglos.ArregloCurso;
import arreglos.ArregloMatricula;
import arreglos.ArregloRetiro;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class DlgConsultaMatriculas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cboMatricula, cboRetiro;
	private JTextArea txtMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaMatriculas dialog = new DlgConsultaMatriculas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaMatriculas() {
		setTitle("Matriculas y Retiros");
		setBounds(100, 100, 944, 661);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N° Matricula");
		lblNewLabel.setBounds(84, 33, 97, 14);
		contentPanel.add(lblNewLabel);
		
		cboMatricula = new JComboBox();
		cboMatricula.setBounds(191, 29, 144, 22);
		contentPanel.add(cboMatricula);
		cboMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codMatricula = Integer.parseInt(cboMatricula.getSelectedItem().toString());
				listarMatricula(codMatricula);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("N° Retiro");
		lblNewLabel_1.setBounds(559, 33, 60, 14);
		contentPanel.add(lblNewLabel_1);
		
		cboRetiro = new JComboBox();
		cboRetiro.setBounds(676, 29, 144, 22);
		cboRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codRetiro= Integer.parseInt(cboRetiro.getSelectedItem().toString());
				listarRetiro(codRetiro);
			}
		});
		contentPanel.add(cboRetiro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 908, 533);
		contentPanel.add(scrollPane);
		
		txtMatricula = new JTextArea();
		txtMatricula.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtMatricula.setEditable(false);
		scrollPane.setViewportView(txtMatricula);
		insertData();
	}
	
	void insertData() {
		cboMatricula.removeAllItems();
		cboRetiro.removeAllItems();
		for (int i = 0; i <ArregloMatricula.tamanio(); i++) {
				cboMatricula.addItem(""+ArregloMatricula.getMatricula(i).getNumMatricula());
			};
		for(int i = 0;i < ArregloRetiro.getRetiroLen();i++) {
			cboRetiro.addItem(""+ArregloRetiro.getRetiro(i).getNumRetiro());
		}
		
	}
	
	void listarMatricula(int codMatricula) {
		txtMatricula.setText("");
		Matricula matricula = ArregloMatricula.getMatriculaById(codMatricula);
		Alumno alumno = ArregloAlumno.getAlumnoByCode(matricula.getCodAlumno());
		Curso curso = ArregloCurso.getCursoByCode(matricula.getCodCurso());
		txtMatricula.append("\nINFORMACION DE MATRICULA");
		txtMatricula.append("\nNumero de matricula: "+matricula.getNumMatricula()
			+ "\nFecha de matricula: "+matricula.getFechaMatricula()+" - "+matricula.getHoraMatricula()
			+"\n\nALUMNO MATRICULADO"
			+"\nNombre: "+alumno.getNombres()+" "+alumno.getApellidos()
			+"\nDNI: "+alumno.getDni()
			+"\nEdad: "+alumno.getEdad()
			+"\nCelular: "+alumno.getCelular()
			+ "\n\nCURSO MATRICULADO"
			+"\nNombre Asignatura: "+curso.getAsignatura()
			+"\nCiclo: "+curso.getCiclo()
			+"\nCreditos: "+curso.getCreditos()
			+"\nHoras: "+curso.getHoras()
		);
	}
	void listarRetiro(int codRetiro) {
		txtMatricula.setText("");
		Retiro retiro = ArregloRetiro.getRetiroByCode(codRetiro);
		Matricula matricula = ArregloMatricula.getMatriculaById(retiro.getNumMatricula());
		Alumno alumno = ArregloAlumno.getAlumnoByCode(matricula.getCodAlumno());
		Curso curso = ArregloCurso.getCursoByCode(matricula.getCodCurso());
		txtMatricula.append("INFORMACIO DE RETIRO");
		txtMatricula.append("\nNumero de retiro: "+retiro.getNumRetiro()
			+"\nFecha de retiro: "+retiro.getFecha()
			+"\n\nINFORMACION ALUMNO"
			+"\nNombre: "+alumno.getNombres()+" "+alumno.getApellidos()
			+"\nDNI: "+alumno.getDni()
			+"\nEdad: "+alumno.getEdad()
			+"\nCelular: "+alumno.getCelular()
			+"\n\nINFORMACION CURSO"
			+"\nNombre Asignatura: "+curso.getAsignatura()
			+"\nCiclo: "+curso.getCiclo()
			+"\nCreditos: "+curso.getCreditos()
			+"\nHoras: "+curso.getHoras()
		);
	}
}
