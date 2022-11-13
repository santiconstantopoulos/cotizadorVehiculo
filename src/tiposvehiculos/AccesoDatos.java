package tiposvehiculos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDatos {

	public AccesoDatos(){
		
	}

	private String maquina;
	private String usuario;
	private String clave;
	private int puerto;
	private String bd;
	private String servidor;
	private Connection conexion;

	public AccesoDatos(String maquina, String usuario, String clave, int puerto, String bd) {

		this.maquina = maquina;
		this.usuario = usuario;
		this.clave = clave;
		this.puerto = puerto;
		this.bd = bd;
		this.servidor = "jdbc:mysql://" + this.maquina + ":" + this.puerto + "/" + this.bd;

		// Carga el driver mysql en memoria
		/*try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException error) {

			error.printStackTrace();
			System.out.println(error.getMessage());
			System.err.println("ERROR AL REGISTRAR EL DRIVER");

			System.exit(0); // parar la ejecuci�n
		} */

		// Establecer la conexi�n con el servidor y almacenarla en el atributo conexion
		try {
			conexion = DriverManager.getConnection(this.servidor,
					this.usuario, this.clave);
		} catch (SQLException error) { // dfdfdsf
			System.err.println("ERROR AL CONECTAR CON EL SERVIDOR");
			error.printStackTrace();
			System.exit(0); // parar la ejecuci�n
		}
		// System.out.println("Conectado a ajedrez");
	}

	// Devuelve el objeto Connection que se usar� en la clase Controlador
	public Connection getConexion() {
		return conexion;
	}

}
