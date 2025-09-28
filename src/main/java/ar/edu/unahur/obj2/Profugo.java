package ar.edu.unahur.obj2;

public class Profugo implements Iprofugo {

    private Integer nivelInocencia;
    private Integer nivelHabilidad;
    private Boolean esNervioso;
    
    public Profugo(Integer nivelInocencia, Integer nivelHabilidad, Boolean esNervioso) {
        this.nivelInocencia = nivelInocencia;
        this.nivelHabilidad = Math.max(1,Math.min(nivelHabilidad, 100));
        this.esNervioso = esNervioso;
    }

    @Override
    public Integer getInocencia() {
        return nivelInocencia;
    }

    @Override
    public Integer getHabilidad() {
        return nivelHabilidad;
    }

    @Override
    public Boolean esNervioso() {
        return esNervioso;
    }

    @Override
    public void volverseNervioso() {
        esNervioso = true;
    }

    @Override
    public void dejarDeEstarNervioso() {
        esNervioso = false;
    }

    @Override
    public void reducirHabilidad() {
        nivelHabilidad = Math.max(0,nivelHabilidad - 5);
    }

    @Override
    public void disminuirInocencia() {
        nivelInocencia = Math.max(0,nivelInocencia - 2);
    }

    public void esIntimidado(Cazador cazador){
        cazador.intimidar(this);
    }

}
