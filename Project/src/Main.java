import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> datos = new ArrayList<>();
        String cadenaDatos = "";

        boolean continuar = true;
        boolean calculadora = true;

        System.out.print("Ingresa los datos uno a uno (o escribe 'fin' para terminar): ");

        while (continuar) {
            String entrada = scanner.next();
            
            if (entrada.equalsIgnoreCase("fin")) {

                System.out.println("Has ingresado los siguientes números:");
                for (int i = 0; i < datos.size(); i++) {
                    cadenaDatos = cadenaDatos + datos.get(i);
                    if (i != (datos.size()-1)){
                        cadenaDatos =  cadenaDatos + ", ";
                    }
                }
        
                 System.out.println(cadenaDatos);

                //Operaciones 
                while (calculadora){
                    Double media;
                    Double varianza;
                    Double desviacion;

                    Scanner scanner2 = new Scanner(System.in);

                    String menu = "CALCULADORA ESTADISTICA"+"\n"+"1)Media"+"\n"+"2)Varianza"+"\n"+"3)Desviación Estandar"+"\n"+"4)Salir"
                    +"\n"+"Opcion:";
                    System.out.println(menu);
                    String opcion = scanner2.next();

                    

                    switch (opcion)
                    {
                        case "1": 
                        {
                            media = calcularMedia(datos); 
                            System.out.println("\n"+"MEDIA: " + media + "\n");
                            break;
                        }
                        case "2":
                        {
                         varianza = calcularVarianza(datos);
                         System.out.println("\n" + "VARIAZA: " + varianza + "\n");
                         break;
                        }
                        case "3": {
                            desviacion = calcularDesviacion(datos);
                            System.out.println("\n" + "DESVIACION: " + desviacion + "\n");
                            break;
                        }
                        case "4":  System.out.println("ADEU");calculadora = false;continuar = false;scanner2.close();break;
                        default: System.out.println("Opcion no valida!");break;
                    }
                    
                }
                
                continuar = false;
            } else {
                try {
                    Double numero = Double.parseDouble(entrada);
                    datos.add(numero);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Ingresa un número válido o 'fin' para terminar.");
                }
            }
        }
    
        // Cierra el scanner al finalizar
        scanner.close();
    }

    //Funcione para simplificar las operaciones
    public static Double calcularMedia( ArrayList<Double> datos){
        Double media = 0.0 ;
        for (Double num : datos){
            media = media + num ;
        }
        media = media / datos.size();
        return media;
    }
    public static Double calcularVarianza(ArrayList<Double> datos){
        Double media =  calcularMedia(datos);
        Double varianza = 0.0;

        for (Double num : datos){
            varianza =  varianza + Math.pow((num-media),2);
        }

        varianza = varianza/datos.size();
        return varianza;
    }     
     public static Double calcularDesviacion(ArrayList<Double> datos){
        Double varianza = calcularVarianza(datos);
        return Math.sqrt(varianza);
    }   
}
