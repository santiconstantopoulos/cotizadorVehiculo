package tiposvehiculos.ClasesVehiculos;

public class Furgoneta extends Vehiculo {

    public double resultado;
    private Integer cantDias;
    private int cantPlazas = 12;

    public Furgoneta(String tipoVehiculo, int i, Integer cantDias2) {
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

    public Integer getCantPlazas() {
        return this.cantPlazas;
    }

    public void setCantPlazas(int cantPlazasNueva) {
        this.cantDias = cantPlazasNueva;
    }

    @Override
    public void setResultadoCotizacion() {
        super.resultado = (double) ((2000 * this.cantDias + (800 * 2.5)));
    }
    public double getResultadoCotizacion() {
        return super.resultado;
    }

}
