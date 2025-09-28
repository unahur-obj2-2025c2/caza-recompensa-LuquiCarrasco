package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

public class Zona {
    private String nombre;
    public List<Profugo> profugos = new ArrayList<>();
    public Zona(String nombre, List<Profugo> profugos) {
        this.nombre = nombre;
        this.profugos = profugos;
    }
    public Zona(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProfugo(Profugo profugo){
        profugos.add(profugo);
    }

    public String getNombre() {
        return nombre;
    }

    public void eliminarCapturado(Profugo profugo){
        profugos.remove(profugo);
    }
    
}
