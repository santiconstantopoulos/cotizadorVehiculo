package tiposvehiculos;
public class Camion extends Vehiculo {
    
    public double resultado;
    private Integer cantDias;
    private int cantPlazas = 3;
    
    public Camion(){
    }

    public Integer getCantDias(){
        return this.cantDias;
    }
    public void setCantDias(Integer cantDiasNueva){
        this.cantDias=cantDiasNueva;
    }
    public int getCantPlazas(){
        return this.cantPlazas;
    }
    public void setCantPlazas(int cantPlazasNueva){
        this.cantDias=cantPlazasNueva;
    }


    @Override
    public double calculoAlquiler(Integer cantDias) {
        resultado = 1600 + (2000 * cantDias)  + (800 * 10);
        return resultado;
    }
}
