package tiposvehiculos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ListadoDeVehiculos extends JFrame implements ActionListener, MouseListener, ItemListener {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelo;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoDeVehiculos frame = new ListadoDeVehiculos();
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
	public ListadoDeVehiculos() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		modelo = new DefaultTableModel(new Object[][] {,}, new String[] {
				"FECHA DE CREACION",
				"TIPO DE VEHICULO",
				"DIAS DE ALQUILER",
				"PRECIO DE COTIZACION" }) {
			public boolean isCellEditable(int row, int column) {
				return true;// Esta sentencia hace que todas las celdas no permitan edicion
			}
		};

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 640, 282);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setShowVerticalLines(false);
		table.setFocusable(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBackground(Color.WHITE);
		table.setModel(modelo);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(267, 318, 89, 23);
		contentPane.add(btnSalir);

		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent elevento) {
				// Implementa el evento para el boton Salir
				if (elevento.getSource() == btnSalir)
					System.exit(0);

			}
		});

		table.addMouseListener(this);
		cargarGrillaVehiculos();
	}

	protected void cargarGrillaVehiculos() {
		AccesoDatos accesoBD = null;
		Connection con = null;
		PreparedStatement sentencia = null;
		ResultSet rs = null;

		this.modelo.setRowCount(0);
		Object detalle[] = new Object[9];

		/*
		 * CREATE TABLE `cotizacion` (
		 * `idCotizacion` int unsigned NOT NULL AUTO_INCREMENT,
		 * `idTipoVehiculo` int NOT NULL,
		 * `cantidadDias` int unsigned NOT NULL,
		 * `precioCotizacion` float NOT NULL,
		 * `Fecha_Creacion` date DEFAULT NULL,
		 */

		String query = "SELECT "
				+ "Fecha_Creacion"
				+ "tipoVehiculo"
				+ "cantidadDias"
				+ "precioCotizacion"
				+ "FROM cotizacion";
		// Cargar datos en la tabla
		try {
			// Instancio un objeto de acceso a datos
			accesoBD = new AccesoDatos("localhost", "root", "Santi!", 3306, "cotizador");
			// Preparar la llamada
			con = accesoBD.getConexion();
			sentencia = con.prepareStatement(query);

			// Ejecuta la consulta y procesa el resultado
			rs = sentencia.executeQuery();
			// Procesa el resultSet y agrega los registros al ArrayList detalleListaPrecio
			// que contendra la informacion obtenida desde la BD
			while (rs.next()) {
				detalle[0] = String.valueOf(rs.getInt("FECHACREACION"));
				detalle[1] = rs.getString("TIPOVEHICULO");
				detalle[2] = rs.getString("DIASDEALQUILER");
				detalle[3] = rs.getString("PRECIOCOTIZACION");

				this.modelo.addRow(detalle);

			}
			this.table.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error al CARGAR DATOS");
		} finally {
			try {
				// Cierra el ResultSet
				if (rs != null)
					rs.close();
				// Cierra la sentencia
				if (sentencia != null)
					sentencia.close();
				// Cierra la conexion
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.err.println("Error al cerrar conexion");
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}
}
