package pe.edu.upeu.clase.interfaz;

public class Gato implements animal {
    @Override
    public void emitirSonido() {
        System.out.println("MIAU..miau");
    }

    @Override
    public void dormir() {
        System.out.println("Zzz Zzz..");

    }
}
