package guis;
import arreglos.ArregloAlumno;
import entidades.Alumno;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DlgReporteAlumnosMatriculaPendiente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporteAlumnosMatriculaPendiente dialog = new DlgReporteAlumnosMatriculaPendiente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteAlumnosMatriculaPendiente() {
		setTitle("Alumnos con matricula pendiente");
		setBounds(100, 100, 723, 523);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 687, 426);
		contentPanel.add(scrollPane);
		
		table = new JTable(model) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		model.addColumn("Codigo");
		model.addColumn("Nombres");
		model.addColumn("Apellidos");
		model.addColumn("DNI");
		model.addColumn("Edad");
		model.addColumn("Celular");
		model.addColumn("Estado");
		scrollPane.setViewportView(table);
		listarAlumnosRegistrados();
	}
	
	public void listarAlumnosRegistrados() {
		ArrayList<Alumno> registrados = ArregloAlumno.getAlumnosRegistrados();
		for(int i = 0;i<registrados.size();i++) {
			Alumno a = registrados.get(i);
			model.addRow(new Object[] {
					a.getCodAlumno(),
					a.getNombres(),
					a.getApellidos(),
					a.getDni(),
					a.getEdad(),
					a.getCelular(),
					a.getEstadoName()
			});
		}
	}
}
