package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public abstract class Cazador {
    public List<Profugo> capturados = new ArrayList<>();
    public List<Profugo> intimidados = new ArrayList<>();
    private Integer experiencia;

    public Integer getExperiencia() {
        return experiencia;
    }

    public Cazador(Integer experiencia2) {
        this.experiencia = Math.max(0,Math.min(experiencia2,100));
    }

    protected Boolean puedeCapturar(Profugo profugo){
        return experiencia > profugo.getInocencia();
    }

    abstract Boolean doPuedeCapturar(Profugo profugo);  
    abstract void capturar(Profugo profugo);
    protected void intimidar(Profugo profugo){
        profugo.disminuirInocencia();
    }

    abstract void doIntimidar(Profugo profugo);
    
    protected void agregarIntimidado(Profugo profugo){
        intimidados.add(profugo);
    }

    protected void sumarExperiencia(){
         Integer minIntimidado = intimidados.stream().mapToInt(i -> i.getHabilidad()).min().orElse(0);
         Integer cantCapturados = capturados.size();
        experiencia += minIntimidado + (2 * cantCapturados);
    }

    protected void cazarEnZona(Zona zona){
        zona.profugos.stream().forEach(p -> capturar(p));
        this.sumarExperiencia();
        zona.profugos.removeAll(capturados);
    }
}
