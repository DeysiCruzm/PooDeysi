package pe.edu.upeu.clase.interfaz;

public class ClasePrincipal {
    public static void main(String[] args) {
        animal animal=new Loro();
        animal.emitirSonido();
        animal.dormir();

        animal=new Gato();
        animal.emitirSonido();
        animal.dormir();


    }
}
