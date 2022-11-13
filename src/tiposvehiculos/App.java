package tiposvehiculos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class App {



    static Scanner scanner = new Scanner(System.in);

    public static void menuTipo(int respuesta) {
        System.out.print("Ingresa la cantidad de dias: ");
        Integer cantDias = scanner.nextInt();
        switch (respuesta) {
            case 1:
                System.out.println("Has elegido Auto. ");
                Auto auto = new Auto("Auto", 2000, cantDias);
                // System.out.println("El precio por la cantidad de dias " + cantDias + " y
                // considerandose de "
                // + auto.getCantPlazas() + " plazas el auto, el total es :"
                // + auto.calculoAlquiler(cantDias));
                almacenarPieza(auto, cantDias, auto.calculoAlquiler(cantDias));
                break;
            case 2:
                System.out.println("Has elegido Minibus.");
                Minibus minibus = new Minibus();
                // System.out.println("El precio por la cantidad de dias " + cantDias
                // + " y considerandose de " + minibus.getCantPlazas() + " plazas el minibus, el
                // total es :"
                // + minibus.calculoAlquiler(cantDias));
                almacenarPieza(minibus, cantDias, minibus.calculoAlquiler(cantDias));

                break;
            case 3:

                System.out.println("Has elegido Camion.");
                Camion camion = new Camion();
                // System.out.println("El precio por la cantidad de dias " + cantDias + " y
                // considerandose de "
                // + camion.getCantPlazas() + " plazas el camion, el total es de : $"
                // + camion.calculoAlquiler(cantDias));
                almacenarPieza(camion, cantDias, camion.calculoAlquiler(cantDias));

                break;
            case 4:
                System.out.println("Has elegido Furgoneta.");
                Furgoneta furgoneta = new Furgoneta();
                // System.out.println("El precio por la cantidad de dias " + cantDias
                // + " y considerandose de " + furgoneta.getCantPlazas() + " plazas la
                // furgoneta, el total es :"
                // + furgoneta.calculoAlquiler(cantDias));
                almacenarPieza(furgoneta, cantDias, furgoneta.calculoAlquiler(cantDias));

                break;
        }
    }

    public static void almacenarPieza(Vehiculo mivehiculo, int cantDias, Double precioCotizacion) {
        
         

        Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("Auto", 1);
		map.put("Minibus", 2);
		map.put("Camion", 3);
		map.put("Furgoneta", 4);


        
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

            sentencia.setInt(1, map.get(mivehiculo.getNombreVehiculo()));
            sentencia.setInt(2, cantDias);
            sentencia.setDouble(3, precioCotizacion);
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
