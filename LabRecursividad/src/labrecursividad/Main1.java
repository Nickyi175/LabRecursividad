/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labrecursividad;
import java.util.Scanner;

public class Main1 {
    
    public static void main(String[] args) {
        // Crear objeto de la clase PalindromoAir
        PalindromoAir palindromoAir = new PalindromoAir();
        String opciones;
        String nombrePasajero;
        Scanner lea = new Scanner(System.in);
        
                   
         do{   
                System.out.println("Menu Principal");
                System.out.println("\nEliga una opcion (1-5)" + "\n1. Vender boletos" + "\n2. Cancelar un boleto" + "\n3. Despachar el avion" + 
                        "\n4. Imprimir el detalle de todos los pasajeros" + "\n 5. Salir");
               
            //Ingresar Seccion
       System.out.print("\nIngrese la opciones a la que desea ingresar: ");
       opciones=lea.useDelimiter("\n").next();
       //Restriccion Seccion
       if(opciones.equals("1")||opciones.equals("2")||opciones.equals("3")||opciones.equals("4")||opciones.equals("5")){
           opciones=opciones;
       }
       else 
            do{
            System.out.print("Ingrese la opciones a la que desea ingresar: "); 
            opciones=lea.useDelimiter("\n").next();
           } while (!opciones.equals("1")&&!opciones.equals("2")&&!opciones.equals("3")&&!opciones.equals("4")&&!opciones.equals("5"));
       

            if (opciones.equals("1")){
                //Vender un boleto
                System.out.println("Escribir el nombre del pasajero: ");
                nombrePasajero = lea.useDelimiter("\n").next();
                palindromoAir.sellTicket(nombrePasajero);
            }

            if (opciones.equals("2")){
                //Cancelar un boleto
                System.out.println("Escribir el nombre del pasajero: ");
                nombrePasajero = lea.useDelimiter("\n").next();

                boolean cancelResult = palindromoAir.cancelTicket(nombrePasajero);
                if (cancelResult) {
                    System.out.println("Ticket Cancelado");
                } else {
                    System.out.println("Ticket No encontrado ");
                }
            }

            if (opciones.equals("3")){
                //Despachar el avión
                palindromoAir.dispatch(); // Imprimir ingreso generado y resetear los asientos
            }

            if (opciones.equals("4")) {
                //Imprimir detalle de los pasajeros
                System.out.println("Detalle de los pasajeros:" + "\n");
                palindromoAir.printPassengers();
            }    
    }while(!opciones.equals("5"));
      
    }
  
}
