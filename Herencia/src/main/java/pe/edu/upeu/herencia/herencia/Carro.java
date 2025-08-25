package pe.edu.upeu.herencia.herencia;

public class Carro extends Vehiculo {
    String color = "Blanco";
    String modelo= "fortuner";
    void caracteristicas(){
        marca ="toyota ";
        System.out.println(" el vehiculo tiene las siguientes caracteristicas");
        System.out.println("la marca de este vehiculo "+ marca);
        System.out.println("la color de este vehiculo "+ color);
        System.out.println("la Modelo de este vehiculo "+ modelo);
        System.out.println("y emite el siguiente sonido"+ sonido());
    }

    public static void main(String[] args) {
        Carro carro=new Carro();
        carro .caracteristicas();


    }

}
