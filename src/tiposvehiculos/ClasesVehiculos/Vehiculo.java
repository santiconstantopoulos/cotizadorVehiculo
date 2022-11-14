package tiposvehiculos.ClasesVehiculos;

public abstract class Vehiculo {
    private String patente;
    private int precioBase = 2000;
    private String nombreVehiculo;
    public Integer cantDias;
    protected double resultado;

    public Vehiculo() {
    }

    public Vehiculo(String nombreVehiculo, int precioBase, Integer cantDias) {
        this.nombreVehiculo = nombreVehiculo;
        this.precioBase = precioBase;
        this.cantDias = cantDias;

    }

    public String getNombreVehiculo() {
        return nombreVehiculo;
    }

    public void setNombreVehiculo(String nombreVehiculo) {
        this.nombreVehiculo = nombreVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getCantDias() {
        return cantDias;
    }

    public void setCantDias(Integer cantDias) {
        this.cantDias = cantDias;
    }

    public double getResultadoCotizacion() {
        return this.resultado;
    }

    public void setResultadoCotizacion() {
        this.resultado = this.cantDias;
    }

}
