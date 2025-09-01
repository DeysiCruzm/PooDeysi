package pe.edu.upeu.herencia.encapsulamiento;

public class persona {
    String nombre;
    int edad ;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void saludar(){
        System.out.println("hola soy "+ nombre + " mi edad es "+ edad);

    }
}
