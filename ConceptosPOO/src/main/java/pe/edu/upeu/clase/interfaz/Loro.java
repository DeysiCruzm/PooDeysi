package pe.edu.upeu.clase.interfaz;

public class Loro implements animal{
    @Override
    public void emitirSonido() {
        System.out.println("lorito");

    }

    @Override
    public void dormir() {
        System.out.println("Zzz Zzz..");

    }
}
