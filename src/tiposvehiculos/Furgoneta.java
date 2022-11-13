package tiposvehiculos;

public class Furgoneta extends Vehiculo {

    public double resultado;
    private Integer cantDias;
    private int cantPlazas= 12;

    public Furgoneta(){
    }

    public Integer getCantDias(){
        return this.cantDias;
    }
    public void setCantDias(Integer cantDiasNueva){
        this.cantDias=cantDiasNueva;
    }

    public Integer getCantPlazas(){
        return this.cantPlazas;
    }
    public void setCantPlazas(int cantPlazasNueva){
        this.cantDias=cantPlazasNueva;
    }
 
    @Override
    public double calculoAlquiler( Integer cantDias) {
        resultado = (2000 * cantDias + (800 * 2.5)) ;
        return resultado;
    }
}