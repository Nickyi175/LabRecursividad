/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labrecursividad;

import javax.swing.JOptionPane;
public class PalindromoAir{
public static Ticket[] ticket;
    public int posicion;
    public double totalIngresos;
    public double totalPago;
    private Main main;
    
    public PalindromoAir(Main main){
        ticket=new Ticket[30];
        this.main=main;
    }
    
    //aFirst Available
    
    public int firstAvailable(){
        return firstAvailable(0);
    }
    
    private int firstAvailable(int posicion){
       
        if(posicion>=ticket.length){
            return -1;
        }
        if(ticket[posicion]==null){
            return posicion;
        }
       
        else{
            return firstAvailable(posicion+1);
        }
        
    }
    
    //b)Buscar Pasajero
    public int buscarPasajeros(String nombrePasajero){
       return buscarPasajero(nombrePasajero,0) ;
    }
    private int buscarPasajero(String nombrePasajero,int posicion){
        
       if(posicion>=ticket.length){
            return -1;
        }
       if (ticket[posicion] != null && ticket[posicion].getNombrePasajero().equals(nombrePasajero)) {
                return posicion; 
        }
        else{
           return buscarPasajero(nombrePasajero,posicion+1);
        }
    }
    
    //c)Es Palindroma
    public static boolean isPalindromo(String nombrePasajero){
       return isPalindromo(nombrePasajero,0,nombrePasajero.length()-1);
    }
    
    private static boolean isPalindromo(String nombrePasajero,int inicio,int fin){
        if(inicio<fin){
            if(nombrePasajero.charAt(inicio)==nombrePasajero.charAt(fin))
                return isPalindromo(nombrePasajero,inicio+1,fin-1);
                return false;
        }
        return true;
      }
    
   //d)Print Passengers

    public void printPassengers(){
       printPassengers(0);
    }
    private void printPassengers(int posicion){
        if(posicion>=ticket.length) {
            System.out.println("se sobrepasó");
            return;
        } 
        if(ticket[posicion]!=null){
           ticket[posicion].print();
        }
         printPassengers(posicion+1);
    }
    
    
    
    
    //e) Income
    public double income(){
        return income(totalIngresos,0);
    }
    private double income(double totalIngresos,int posicion){
       if(posicion>=ticket.length){
            return totalIngresos;
        } 
       if(ticket[posicion]!=null){
           totalIngresos+= ticket[posicion].getTotalPagado();
           return income(totalIngresos,posicion+1);
        }
        return income(totalIngresos,posicion+1);
    }
    
    //g)Sell Ticket
    
    public void sellTicket(String nombrePasajero){
        totalPago=0;
        posicion = firstAvailable(); 
        if(posicion!=-1){
            if(isPalindromo(nombrePasajero)==false){
                totalPago=800;
                JOptionPane.showMessageDialog(null, "¡Pasajero ingresado exitosamente!");
            }
            else{
                JOptionPane.showMessageDialog(null, "¡Pasajero ingresado exitosamente!\nYa que su nombre es palindromo \nha recibido un 20% de descuento");
                totalPago=800*0.8;
            }
            ticket[firstAvailable()] = new Ticket(nombrePasajero, totalPago,main);
            
            System.out.println("--------Monto a Pagar---------"+"\nNombre: "+ticket[posicion].getNombrePasajero()+
                    "\nMonto a pagar: Lps. "+ticket[posicion].getTotalPagado()+" \nPosicion: "+posicion);      
        }   
    }
    
    //f)Reset
    public void reset(){
        totalIngresos = 0;
        reset(0);
    }
    private void reset(int posicion){
         if(posicion>=ticket.length){  
             return;
        }
         ticket[posicion]=null;
          reset(posicion+1);      
    }
    
    //h)Cancel Ticket
     public boolean cancelTicket(String nombrePasajero){
         if (buscarPasajero(nombrePasajero,0)!=-1){
         ticket[posicion]=null;
         if(ticket[posicion]==null){
             System.out.println("si esta null");
         }
     }else{
             return false;
         }
         return true;
     }
    
    //i) dispatch
     public void dispatch(){
         JOptionPane.showMessageDialog(null, "Ingreso generado: $"+income());
         System.out.println("Ingreso generado: "+income());
         reset(0);
         totalIngresos=0;
         JOptionPane.showMessageDialog(null,"¡El avión fue despachado exitosamente!");
     }
}
