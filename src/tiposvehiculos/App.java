package tiposvehiculos;

import java.util.Scanner;

import tiposvehiculos.ClasesVehiculos.Auto;
import tiposvehiculos.ClasesVehiculos.Camion;
import tiposvehiculos.ClasesVehiculos.Furgoneta;
import tiposvehiculos.ClasesVehiculos.Minibus;
import tiposvehiculos.ClasesVehiculos.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void ConfigurarDatosVehiculo(Vehiculo miVehiculo) {
        //Realiza la llamada al metodo que almacena en la DB
        //Devuelve la impresion de la cotizacion
        miVehiculo.setResultadoCotizacion();
        int tipoV=0;
        switch (miVehiculo.getNombreVehiculo()) {

            case "Auto":
                tipoV=1;
                break;
            case "Minibus":
                tipoV=2;
                break;
            case "Camion":
                tipoV=3;
                break;
            case "Furgoneta":
                tipoV=4;
                break;
            default:
                break;
        }
        AlmacenarVehiculo(miVehiculo, tipoV);
        System.out.println("El resultado de la cotizacion es: $ "+ miVehiculo.getResultadoCotizacion() + "\n");

        return;
    }

    public static void InstanciarVehiculo() {

        int respuesta;
        System.out.println("Ingrese la opción que corresponda: ");
        System.out.println("1. Auto");
        System.out.println("2. Minibus");
        System.out.println("3. Camion");
        System.out.println("4. Furgoneta");

        respuesta = scanner.nextInt();

        System.out.print("Ingresa la cantidad de dias: ");
        Integer cantDias = scanner.nextInt();

        switch (respuesta) {
            case 1:
                Auto auto = new Auto("Auto", 2000, cantDias);
                ConfigurarDatosVehiculo(auto);
                break;
            case 2:
                Minibus minibus = new Minibus("Minibus", 2000, cantDias);
                ConfigurarDatosVehiculo(minibus);
                break;
            case 3:
                Camion camion = new Camion("Camion", 2000, cantDias);
                ConfigurarDatosVehiculo(camion);
                break;
            case 4:
                Furgoneta furgoneta = new Furgoneta("Furgoneta", 2000, cantDias);
                ConfigurarDatosVehiculo(furgoneta);
                break;
            default:
                break;

        }
        return;
    }

    public static void AlmacenarVehiculo(Vehiculo mivehiculo, int tipoVehiculo) {

        // Objeto para ejecutar el alta/actualizacion en la base de datos
        AccesoDatos accesoBD = null;
        Connection con = null;
        PreparedStatement sentencia = null;

        try {
            // Instancio un objeto de acceso a datos
            accesoBD = new AccesoDatos("localhost", "root", "Santi!", 3306, "Cotizador");

            // Obtener la conexion para poder generar la sentencia de consulta
            con = accesoBD.getConexion();

            String insertScript = "INSERT INTO cotizacion"
                    + "(idTipoVehiculo, cantidadDias, precioCotizacion, Fecha_Creacion)"
                    + " VALUES(?,?,?,?)";

            sentencia = con.prepareStatement(insertScript);

            sentencia.setInt(1, tipoVehiculo);
            sentencia.setInt(2, mivehiculo.getCantDias());
            sentencia.setDouble(3, mivehiculo.getResultadoCotizacion());
            sentencia.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

            // execute insert SQL statement
            sentencia.executeUpdate();
            System.out.println("Se ha agregado con exito a la BD \n");

        } catch (SQLException error) {
            System.err.println("Error al insertar los datos.");
            error.printStackTrace();
        } finally {
            try {
                // Cierra la sentencia
                if (sentencia != null)
                    sentencia.close();
                // Cierra la conexion
                if (con != null)
                    con.close();

            } catch (SQLException error) {
                System.err.println("Error al cerrar conexion");
            }
        }
    }

    public static void ListarVehiculo() {

        ListadoDeVehiculos listar = new ListadoDeVehiculos();
        listar.main(null);

    }

    public static void main(String[] args) throws Exception {

        int respuestaMenu;

        System.out.println("Bienvenido al cotizador de vehiculos.");

        do {
            System.out.println("Ingrese la opción que corresponda: ");
            System.out.println("1. Insertar Vehiculo a la BD");
            System.out.println("2. Listar Vehiculos por interfaz desde la BD");
            System.out.println("0. Salir");
            System.out.println("\n");

            respuestaMenu = scanner.nextInt();

            if (respuestaMenu == 1) {
                InstanciarVehiculo();
            } else {
                if(respuestaMenu==2)
                    ListarVehiculo();
            }
        } while (respuestaMenu != 0);
        System.out.println("Gracias por utilizar el cotizador de vehiculos");
    }
}
