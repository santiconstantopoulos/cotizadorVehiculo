package tiposvehiculos;

public class Auto extends Vehiculo {

    private int cantDias;
    private int cantPlazas= 5 ;
    public double resultado;


    public Auto(String string, int i, Integer cantDias2){
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
        resultado = (2000 * cantDias) + (100 * cantDias * 5);
        return resultado;
    }
    



}
