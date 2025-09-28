package ar.edu.unahur.obj2;

public class Rural extends Cazador{

   public Rural(Integer experiencia) {
        super(experiencia);
    }

   @Override
    protected Boolean puedeCapturar(Profugo profugo) {
        return super.puedeCapturar(profugo) && this.doPuedeCapturar(profugo);
    }

    @Override
    Boolean doPuedeCapturar(Profugo profugo) {
        return profugo.esNervioso();
    }

    @Override
    void capturar(Profugo profugo) {
        if (this.puedeCapturar(profugo)){
            capturados.add(profugo);
        }else{
            profugo.esIntimidado(this);
            this.agregarIntimidado(profugo);
        }
    }

    @Override
    protected void intimidar(Profugo profugo) {
        super.intimidar(profugo);
        this.doIntimidar(profugo);
    }

    @Override
    void doIntimidar(Profugo profugo) {
       profugo.volverseNervioso(); 
    }

    
}
