package tiposvehiculos;
public class Minibus extends Vehiculo {
    
    private int cantPlazas= 20;
    private int cantDias;
    public double resultado;

    public Minibus(){
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
        resultado = (2000 * cantDias) + (100 * cantDias * 20) + (120*20);
        return resultado;
    }
    


}