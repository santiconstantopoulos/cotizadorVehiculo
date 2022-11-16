package tiposvehiculos.ClasesVehiculos;

public class Camion extends Vehiculo {

    public double resultado;
    private Integer cantDias;
    private int cantPlazas = 3;

    public Camion(String tipoVehiculo, int i, Integer cantDias2) {
            this.setNombreVehiculo(tipoVehiculo);
            this.setPrecioBase(i);
            this.setCantDias(cantDias2);
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
        super.resultado = (double) (1600 + (2000 * this.cantDias) + (800 * 10));
    }

    public double getResultadoCotizacion() {
        return super.resultado;
    }

}
