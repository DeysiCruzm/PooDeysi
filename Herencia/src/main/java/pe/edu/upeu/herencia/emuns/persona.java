package pe.edu.upeu.herencia.emuns;

enum GENERO{Masculino , Femenino}
enum NACIONALIDAD{Peruana,Venezolano,Colombiano, }

public class persona {
    static String nombre;
    static GENERO genero=GENERO.Femenino;
   static NACIONALIDAD nacionalidad=NACIONALIDAD.Peruana;

    public static void main(String[] args) {
        nombre="dey";
        System.out.println(nombre + " es " +nacionalidad+ " y es de genero " +genero);



    }
}
