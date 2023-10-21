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
    
//    public String printPassengers(){
//        return printPassengers(0,"");
//    }
//    private String printPassengers(int posicion,String DatosGeneral){
//        if(posicion>=ticket.length){
//           if(ticket[posicion]!=null){
//               String info="\nNombre: "+ticket[posicion].getNombrePasajero()+" - Total: $"+ticket[posicion].getTotalPagado();
//           //ticket[posicion].print();
//           return printPassengers(posicion+1,DatosGeneral+info);
//
//        }
//        }
//        return DatosGeneral;
//    }
    public void printPassengers(){
       printPassengers(0);
    }
    private void printPassengers(int posicion){
        if(firstAvailable()==-1){
            System.out.println("se sobrepasó");
        } else
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
            }
            else{
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
         ticket [posicion]=null;
     }else{
             return false;
         }
         return true;
     }
    
    //i) dispatch
     public void dispatch(){
         
         System.out.println("Ingreso generado: "+income());
         reset(0);
         totalIngresos=0;
     }
}
//public class PalindromoAir {
//    
//    Ticket[] ticket;
//    public int posicion;
//    public double totalIngresos;
//    public double totalPago;
//    
//    
//    public PalindromoAir(){
//        ticket=new Ticket[30];
//    }
//    
//    //aFirst Available
//    
//    public int firstAvailable(){
//        return firstAvailable(0);
//    }
//    
//    private int firstAvailable(int posicion){
//       
//        if(posicion>=ticket.length){
//            System.out.println("-1");
//            return -1;
//        }
//        if(ticket[posicion]==null){
//            System.out.println("FA"+posicion);
//            return posicion;
//        }
//       
//        else{
//            System.out.println("FA"+posicion+1);
//            return firstAvailable(posicion+1);
//        }
//        
//    }
//    
//    //b)Buscar Pasajero
//    public int buscarPasajeros(String nombrePasajero){
//       return buscarPasajero(nombrePasajero,0) ;
//    }
//    private int buscarPasajero(String nombrePasajero,int posicion){
//        
//       if(posicion>=ticket.length){
//            return -1;
//        }
//       if (ticket[posicion] != null && ticket[posicion].getNombrePasajero().equals(nombrePasajero)) {
//                return posicion; 
//        }
//        else{
//           return buscarPasajero(nombrePasajero,posicion+1);
//        }
//    }
//    
//    //c)Es Palindroma
//    public static boolean isPalindromo(String nombrePasajero){
//       return isPalindromo(nombrePasajero,0,nombrePasajero.length()-1);
//    }
//    
//    private static boolean isPalindromo(String nombrePasajero,int inicio,int fin){
//        if(inicio<fin){
//            if(nombrePasajero.charAt(inicio)==nombrePasajero.charAt(fin))
//                return isPalindromo(nombrePasajero,inicio+1,fin-1);
//                return false;
//        }
//        return true;
//      }
//    
//   //d)Print Passengers
//    public void printPassengers(){
//       printPassengers(0);
//    }
//    private void printPassengers(int posicion){
//        if(posicion>=ticket.length){
//            
//        } 
//        if(ticket[posicion]!=null){
//           ticket[posicion].print();
//        }
//         printPassengers(posicion+1);
//    }
//    
//    //e) Income
//    public double income(){
//        return income(totalIngresos,0);
//    }
//    private double income(double totalIngresos,int posicion){
//       if(posicion>=ticket.length){
//            return totalIngresos;
//        } 
//       if(ticket[posicion]!=null){
//           totalIngresos+= ticket[posicion].getTotalPagado();
//           return income(totalIngresos,posicion+1);
//        }
//        return income(totalIngresos,posicion+1);
//    }
//    
//    //g)Sell Ticket
//    
//    public void sellTicket(String nombrePasajero){
//       
//        totalPago=0;
//        posicion = firstAvailable(); 
//        System.out.println(posicion +" posicion de sell");
//        if(posicion!=-1){
//            if(isPalindromo(nombrePasajero)==false){
//                totalPago=800;
//                System.out.println("se vendio");
//                JOptionPane.showMessageDialog(null, "Se vendió");
////                for(int i=0;i<ticket.length;i++){
//                    
//                
////                }
//            }
//            else{
//                totalPago=800*0.8;
//                JOptionPane.showMessageDialog(null, "Se vendio y es palindromo");
//                System.out.println("se vendio y es palindromo");
//            }
//            ticket[posicion] = new Ticket(nombrePasajero, totalPago);
//            System.out.println(ticket[posicion].nombrePasajero+" "+posicion); 
//            System.out.println("--------Monto a Pagar---------"+"\nNombre: "+ticket[posicion].getNombrePasajero()+
//                    "\nMonto a pagar: Lps. "+ticket[posicion].getTotalPagado());      
//        }   
//    }
//    
//    //f)Reset
//    public void reset(){
//        totalIngresos = 0;
//        reset(0);
//    }
//    private void reset(int posicion){
//         if(posicion>=ticket.length){  
//             return;
//        }
//         ticket[posicion]=null;
//          reset(posicion+1);      
//    }
//    
//    
//    
//    //h)Cancel Ticket
//     public boolean cancelTicket(String nombrePasajero){
//        
//         if (buscarPasajero(nombrePasajero,0)!=-1){ 
//             System.out.println("entro if de cancel que es -1");
//             System.out.println(ticket[posicion].nombrePasajero+" "+posicion);
//         ticket[posicion]=null;
//             System.out.println("se canceló");
//             //System.out.println(ticket[posicion].nombrePasajero+" "+posicion);
//         return true;
//     }else{
//             System.out.println("no se canceló");
//             return false;
//         }
//         
//     }
//    
//    //i) dispatch
//     public void dispatch(){
//         JOptionPane.showMessageDialog(null, "Ingreso generado: $"+income());
//         System.out.println("Ingreso generado: "+income());
//         reset(0);
//         totalIngresos=0;
//     }
//    }

    

