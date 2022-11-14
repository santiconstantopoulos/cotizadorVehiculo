package tiposvehiculos;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class App {

    public static void modelarVehiculo( Vehiculo miVehiculo ){
        miVehiculo.setResultadoCotizacion();
        switch(miVehiculo.getNombreVehiculo()){

            case "Auto": 
                almacenarPieza(miVehiculo, 1);
                break;
            case "Minibus":
                almacenarPieza(miVehiculo, 2);
                break;

            case "Camion":
                almacenarPieza(miVehiculo, 3);
                break;

            case "Furgoneta":
                almacenarPieza(miVehiculo, 4);
                break;

            default:
                break;

        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static void menuTipo(int respuesta) {
        System.out.print("Ingresa la cantidad de dias: ");
        Integer cantDias = scanner.nextInt();
        switch (respuesta) {
            case 1:
                Auto auto = new Auto("Auto", 2000, cantDias);
                modelarVehiculo(auto);
                //modelar llama al de almacenar
                break;
            case 2:
                System.out.println("Has elegido Minibus.");
                Minibus minibus = new Minibus("Minibus", 2000, cantDias);
                modelarVehiculo(minibus);

                break;
            case 3:

                System.out.println("Has elegido Camion.");
                Camion camion = new Camion("Camion", 2000, cantDias);
                modelarVehiculo(camion);

                break;
            case 4:
                System.out.println("Has elegido Furgoneta.");
                Furgoneta furgoneta = new Furgoneta("Furgoneta", 2000, cantDias);
                modelarVehiculo(furgoneta);

                break;
        }
    }

    public static void almacenarPieza(Vehiculo mivehiculo, int tipoVehiculo) {
        
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
                    + "(idTipoVehiculo, cantidadDias, precioCotizacion, Fecha_Creacion)" //faltaria la fecha
                    + " VALUES(?,?,?,?)";

            sentencia = con.prepareStatement(insertScript);

            sentencia.setInt(1, tipoVehiculo);
            sentencia.setInt(2, mivehiculo.getCantDias());
            sentencia.setDouble(3, mivehiculo.getResultadoCotizacion());
            sentencia.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

            // execute insert SQL statement
            sentencia.executeUpdate();

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

    public static void main(String[] args) throws Exception {


        
        int respuesta;
       

        System.out.println("Bienvenido al cotizador de vehiculos.");

        do {
            System.out.println("Ingrese la opción que corresponda: ");
            System.out.println("1. Auto");
            System.out.println("2. Minibus");
            System.out.println("3. Camion");
            System.out.println("4. Furgoneta");
            System.out.println("0. Salir");
            respuesta = scanner.nextInt();
            if (respuesta != 0)
                menuTipo(respuesta);
        } while (respuesta != 0);


        //ListadoDeVehiculos();
        System.out.println("Gracias por utilizar el cotizador de vehiculos");
    }
}
