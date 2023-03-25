package guis;

import arreglos.ArregloAlumno;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import entidades.Alumno;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class DlgAlumno extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codAlumno;
	private JTextField nomAlumno;
	private JTextField apeAlumno;
	private JTextField dniAlumno;
	private JTextField edadAlumno;
	private JTextField celAlumno;
	private JTable table;
	private JComboBox comboBox;

	DefaultTableModel model = new DefaultTableModel();
	private Alumno modAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAlumno dialog = new DlgAlumno();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();//
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAlumno() {
		setTitle("Mantenimiento Alumno");
		setBounds(100, 100, 886, 677);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(593, 281, 89, 32);
		contentPanel.add(btnCancelar);
		btnCancelar.setEnabled(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(202, 211, 217));
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 50, 850, 220);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(202, 211, 217));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 19, 830, 190);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Código:");
		lblNewJgoodiesLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel.setBounds(472, 19, 53, 14);
		panel_1.add(lblNewJgoodiesLabel);

		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Nombres:");
		lblNewJgoodiesLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_1.setBounds(6, 19, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_1);

		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Apellidos:");
		lblNewJgoodiesLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_2.setBounds(6, 57, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_2);

		JLabel lblNewJgoodiesLabel_3 = DefaultComponentFactory.getInstance().createLabel("DNI:");
		lblNewJgoodiesLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_3.setBounds(6, 94, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_3);

		JLabel lblNewJgoodiesLabel_4 = DefaultComponentFactory.getInstance().createLabel("Edad:");
		lblNewJgoodiesLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_4.setBounds(472, 57, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_4);

		JLabel lblNewJgoodiesLabel_5 = DefaultComponentFactory.getInstance().createLabel("Celular:");
		lblNewJgoodiesLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_5.setBounds(6, 128, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_5);

		JLabel lblNewJgoodiesLabel_6 = DefaultComponentFactory.getInstance().createLabel("Estado");
		lblNewJgoodiesLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewJgoodiesLabel_6.setBounds(472, 128, 92, 14);
		panel_1.add(lblNewJgoodiesLabel_6);

		codAlumno = new JTextField();
		codAlumno.setBounds(545, 16, 86, 20);
		panel_1.add(codAlumno);
		codAlumno.setEditable(false);
		codAlumno.setColumns(10);

		nomAlumno = new JTextField();
		nomAlumno.setBounds(108, 54, 220, 20);
		panel_1.add(nomAlumno);
		nomAlumno.setColumns(10);

		apeAlumno = new JTextField();
		apeAlumno.setBounds(108, 16, 220, 20);
		panel_1.add(apeAlumno);
		apeAlumno.setColumns(10);

		dniAlumno = new JTextField();
		dniAlumno.setBounds(108, 91, 86, 20);
		panel_1.add(dniAlumno);
		dniAlumno.setColumns(10);
		
		celAlumno = new JTextField();
		celAlumno.setBounds(108, 125, 86, 20);
		panel_1.add(celAlumno);
		celAlumno.setColumns(10);
		
		edadAlumno = new JTextField();
		edadAlumno.setBounds(545, 54, 86, 20);
		panel_1.add(edadAlumno);
		edadAlumno.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(545, 124, 114, 22);
		panel_1.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"REGISTRADO", "MATRICULADO", "RETIRADO"}));
		comboBox.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 334, 850, 293);
		contentPanel.add(scrollPane);
		
		
		table = new JTable(model) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		scrollPane.setViewportView(table);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(390, 281, 89, 32);
		contentPanel.add(btnModificar);
		
				JButton btnAdicionar = new JButton("Adicionar");
				btnAdicionar.setBounds(201, 281, 89, 32);
				contentPanel.add(btnAdicionar);
				
						JButton btnAceptar = new JButton("Aceptar");
						btnAceptar.setBounds(10, 281, 89, 32);
						contentPanel.add(btnAceptar);
						btnAceptar.setEnabled(false);
						
						JButton btnEliminar = new JButton("Eliminar");
						btnEliminar.setBounds(771, 281, 89, 32);
						contentPanel.add(btnEliminar);
						
						JLabel lblAlumno = new JLabel("Alumno");
						lblAlumno.setVerticalAlignment(SwingConstants.TOP);
						lblAlumno.setOpaque(true);
						lblAlumno.setHorizontalAlignment(SwingConstants.CENTER);
						lblAlumno.setForeground(new Color(128, 0, 0));
						lblAlumno.setFont(new Font("Arial Black", Font.PLAIN, 20));
						lblAlumno.setBackground(new Color(202, 211, 217));
						lblAlumno.setBounds(0, 0, 870, 638);
						contentPanel.add(lblAlumno);
						
						btnEliminar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int row = table.getSelectedRow();
								if(row == -1) {
									mensaje("Necesita escoger un alumno");
								}else {
									int opt = confirmDlg("Seguro que desea eliminar al alumno?");
									if( table.getValueAt(row,4).toString() == "REGISTRADO" && opt == 0) {
										ArregloAlumno.deleteAlumnoByCode(Integer.parseInt(table.getValueAt(row,0).toString()));
										listarAlumnos();
									}else if(table.getValueAt(row,4) == "MATRICULADO"){
										mensaje("El alumno no puede ser eliminado porque está matriculado");
									}
									else if(table.getValueAt(row, 4) == "RETIRADO") {
										mensaje("El alumno no puede ser eliminado porque está retirado");
									}										
								}
							}
						});
						
						
						btnAceptar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dniAlumno.setEditable(true);
								modAlumno.setNombres(nomAlumno.getText()); 
								modAlumno.setApellidos(apeAlumno.getText());
								modAlumno.setDni(dniAlumno.getText());
								modAlumno.setCelular(Integer.parseInt(celAlumno.getText()));
								modAlumno.setEdad(Integer.parseInt(edadAlumno.getText()));
								listarAlumnos();
								btnAceptar.setEnabled(false);
								btnCancelar.setEnabled(false);
								btnAdicionar.setEnabled(true);
								btnEliminar.setEnabled(true);
								limpiarFormulario();
							}
						});
				
				btnAdicionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!nomAlumno.getText().isEmpty() && !apeAlumno.getText().isEmpty() && !dniAlumno.getText().isEmpty() && !edadAlumno.getText().isEmpty() && !celAlumno.getText().isEmpty()) {
							// VERIFICANDO QUE NO SE REPITA DNI
							for(int i = 0;i<ArregloAlumno.getListaAlumnosLen();i++) {
								if(ArregloAlumno.getAlumno(i).getDni().equals(dniAlumno.getText())) {
									mensaje("Este dni ya está registrado");
									return;
								}
							}
							// VALIDACIONES
							
							Alumno nuevoAlumno = new Alumno(
									nomAlumno.getText(), 
									apeAlumno.getText(), 
									dniAlumno.getText(), 
									Integer.parseInt(edadAlumno.getText()),
									Integer.parseInt(celAlumno.getText())
									);
							ArregloAlumno.setListaAlumnos(nuevoAlumno);
							listarAlumnos();
							limpiarFormulario();
						}else {
							mensaje("Faltan datos");
						}
					}
				});
		
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int row = table.getSelectedRow();
						if(row == -1) {
							mensaje("Necesita escojer un alumno");
						}else {
							btnAdicionar.setEnabled(false);
							btnEliminar.setEnabled(false);
							btnAceptar.setEnabled(true);
							btnCancelar.setEnabled(true);
							dniAlumno.setEditable(false);
							modAlumno = ArregloAlumno.getAlumnoByCode(Integer.parseInt(table.getValueAt(row, 0).toString()));
							nomAlumno.setText(modAlumno.getNombres());
							apeAlumno.setText(modAlumno.getApellidos());
							dniAlumno.setText(modAlumno.getDni());
							edadAlumno.setText(String.valueOf(modAlumno.getEdad()));
							codAlumno.setText(String.valueOf(modAlumno.getCodAlumno()));
							celAlumno.setText(String.valueOf(modAlumno.getCelular()));
							comboBox.setSelectedIndex(modAlumno.getEstado());
						}
					}
				});
		
		// creating columns
		model.addColumn("Codigo");
		model.addColumn("DNI");
		model.addColumn("Nombres");
		model.addColumn("Apellidos");
		model.addColumn("Estado");
		
		listarAlumnos();

		
	}
	
	public void listarAlumnos() {
		int rowsNumber = model.getRowCount();
		for(int i = 0;i<rowsNumber;i++) {
			model.removeRow(0);
		}
		for (int i = 0; i < ArregloAlumno.getListaAlumnosLen(); i++) {
			Alumno aa = ArregloAlumno.getAlumno(i);
			model.addRow(new Object[] { 
					aa.getCodAlumno(),
					aa.getDni(), 
					aa.getNombres(),
					aa.getApellidos(), 
					aa.getEstadoName() });
		}
	}
	
	public void limpiarFormulario() {
		nomAlumno.setText("");
		comboBox.setSelectedIndex(0);
		apeAlumno.setText("");
		dniAlumno.setText("");
		edadAlumno.setText("");
		celAlumno.setText("");
		codAlumno.setText("");
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this,s);
	}
	
	int confirmDlg(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}
}
