package guis;

import arreglos.*;
import entidades.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConsultaAlumnosyCursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cboCodAlumno;
	private JTextArea txtAlumno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaAlumnosyCursos dialog = new DlgConsultaAlumnosyCursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaAlumnosyCursos() {
		setBounds(100, 100, 980, 671);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo de Alumno");
		lblNewLabel.setBounds(37, 36, 125, 14);
		contentPanel.add(lblNewLabel);
		
		cboCodAlumno = new JComboBox();
		cboCodAlumno.setBounds(190, 32, 182, 22);
		contentPanel.add(cboCodAlumno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 944, 541);
		contentPanel.add(scrollPane);
		
		txtAlumno = new JTextArea();
		txtAlumno.setFont(new Font("Consolas", Font.PLAIN, 13));
		scrollPane.setViewportView(txtAlumno);
		cboCodAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codAlumno = Integer.parseInt(cboCodAlumno.getSelectedItem().toString());
				listar(codAlumno);
			}
		});
		insertData();
	}
	
	void insertData() {
		cboCodAlumno.removeAllItems();
		for (int i = 0; i <ArregloAlumno.getListaAlumnosLen(); i++) {
			if(ArregloAlumno.getAlumno(i).getEstado()==0) {
				cboCodAlumno.addItem(""+ArregloAlumno.getAlumno(i).getCodAlumno());
			};
		}
		
	}
	
	void listar(int codAlumno) {
		txtAlumno.setText("");
		Alumno alumno = ArregloAlumno.getAlumnoByCode(codAlumno);
		txtAlumno.setText("\n	INFORMACION DEL ALUMNO");
		txtAlumno.append("\n	Nombre(s): "+alumno.getNombres());
		txtAlumno.append("\n	Apellido(s): "+alumno.getApellidos());
		txtAlumno.append("\n	Nro. Celular: "+alumno.getCelular());
		txtAlumno.append("\n	Codigo: "+alumno.getCodAlumno());
		txtAlumno.append("\n	DNI: "+alumno.getDni());
		txtAlumno.append("\n	Edad: "+alumno.getEdad());
		txtAlumno.append("\n	Estado: "+alumno.getEstadoName());
		if(alumno.getEstado() == 1) {
			txtAlumno.append("\n\n	INFORMACION CURSO MATRICULADO");
			Matricula matricula = ArregloMatricula.getMatriculaByAlumnoCode(alumno.getCodAlumno());
			Curso curso = ArregloCurso.getCursoByCode(matricula.getCodCurso());
			txtAlumno.append("\n 	Curso: "+curso.getAsignatura());
			txtAlumno.append("\n    Codigo: "+curso.getCodCurso());
			txtAlumno.append("\n    Creditos: "+curso.getCreditos());
			txtAlumno.append("\n    Horas:"+curso.getHoras());
		}
	}
	
}
