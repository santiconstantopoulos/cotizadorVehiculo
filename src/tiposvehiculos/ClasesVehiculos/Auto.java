package tiposvehiculos.ClasesVehiculos;

public class Auto extends Vehiculo {

    private int cantDias;
    private int cantPlazas = 5;
    public double resultado;

    public Auto(String tipoVehiculo, int precioBase, Integer cantDias) {
        this.setNombreVehiculo(tipoVehiculo);
        this.setPrecioBase(precioBase);
        this.setCantDias(cantDias);
    }

    public Integer getCantDias() {
        return this.cantDias;
    }

    public void setCantDias(Integer cantDiasNueva) {
        this.cantDias = cantDiasNueva;
    }

    public int getCantPlazas() {
        return this.cantPlazas;
    }

    public void setCantPlazas(int cantPlazasNueva) {
        this.cantDias = cantPlazasNueva;
    }

    @Override
    public void setResultadoCotizacion() {
        
        super.resultado = (double) ((2000 * this.cantDias) + (100 * this.cantDias * 5));

    }

    public double getResultadoCotizacion() {
        return super.resultado;
    }

}