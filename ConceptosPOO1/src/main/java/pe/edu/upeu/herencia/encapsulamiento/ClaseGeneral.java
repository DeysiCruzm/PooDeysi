package pe.edu.upeu.herencia.encapsulamiento;

public class ClaseGeneral {
    public static void main(String[] args) {
        persona persona = new persona();//es un objeto
       // persona.nombre = "Deysi";
       // persona.edad = 17;
        persona.setNombre("Deysi");
        persona.setEdad(17);

        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());

        persona.saludar();
    }
}
