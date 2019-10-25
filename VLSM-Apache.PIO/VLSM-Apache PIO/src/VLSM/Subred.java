/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VLSM;

/**
 *
 * @author UDC
 */
public class Subred {
    double n, siguiente; 
    int []Datos = new int[5];
    
    /*Datos[0] - Direccion de red
      Datos[1] - Mascara de red
      Datos[2] - Primera IP utilizable
      Datos[3] - Ultima IP utilizable
      Datos[4] - Broadcast*/
    
    public Subred(double n, double siguiente){
        this.n=n;
        this.siguiente=siguiente;
    }
    
    public void ObtenerDatos(){
        
        double N = 0, m = 0;
        
        Datos[0] = (int)siguiente;
        
        for(int x=8;x>0;x--){
            if(Math.pow(2, x)-2>=n){
                N =  x;
            }
        }
        
        siguiente = siguiente + Math.pow(2,N);
        
        Datos[2] = Datos[0]+1;
        Datos[3] = (int)siguiente - 2;
        Datos[4] = (int)siguiente - 1;
        
        double []Binario = {1,1,1,1,1,1,1,1};
       
        for(int x=7;N>0;x--){
            Binario[x]=0;
            N--;
        }
        
        double []Decimal = {128,64,32,16,8,4,2,1};
        
        for(int x=0;x<8;x++){
            if(Binario[x] == 1){
                m = m + Decimal[x];
            }
        } 
    
        Datos[1] = (int)m;
    }
    
}
