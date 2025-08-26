package pe.edu.upeu.herencia.claseInterna;

public class ClaseExterna {
    int a,b;
    int operacion(){ return a+b;}

    class ClaseInterna1{
        int r;
        void mensaje(){
            r=a+b;
            System.out.println(" la suma es :"+r);
        }

    }
    class ClaseInterna2{
        void otraOperacion(){
            System.out.println("la operacion de la resta es :"+(a-b));

        }
    }
    public static void main(String[] args) {
        ClaseExterna ce =new ClaseExterna();
        ce.a=8;
        ce.b=2;
        System.out.println("la operacion es: "+ce.operacion());
        ClaseInterna1 ci1=ce.new ClaseInterna1();
        ci1.mensaje();
        ClaseInterna2 ci2=ce.new ClaseInterna2();
        ci2.otraOperacion();
    }
}
class ClaseExternaX{

}
class ClaseExternaY{
}
