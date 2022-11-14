package tiposvehiculos;

public class Minibus extends Vehiculo {

    private int cantPlazas = 20;
    private int cantDias;
    public double resultado;

    public Minibus(String tipoVehiculo, int i, Integer cantDias2) {
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
        // TODO Auto-generated method stub
        super.resultado = (double) ((2000 * this.cantDias) + (100 * this.cantDias * 20) + (120 * 20));
    }
    public double getResultadoCotizacion() {
        return super.resultado;
    }

}
