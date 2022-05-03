
package ListaCircularSimple2;


public class ListaCircularSimple2 {
    
    private Nodo primero;
    private Nodo ultimo;
    private int cantNodos;  
   


    public ListaCircularSimple2() {
        this.primero = null;
        this.ultimo = null;
    } 
//------------------------------------------------------------------------
   public boolean esVacia(){
        return (this.primero ==null);    
    }     
//------------------------------------------------------------------------
public void insertarPrimero(Empleado p){
    Nodo nuevo = new Nodo(p); 
    
    if(esVacia()){
         this.primero = nuevo;
         this.ultimo = nuevo;
         nuevo.setSiguiente(primero);
     }else{
        nuevo.setSiguiente(primero);
        this.primero = nuevo;
        this.ultimo.setSiguiente(primero);
     }
    this.cantNodos++;
}
   
//------------------------------------------------------------------------
 public void insertarFinal(Empleado p){
    Nodo nuevo = new Nodo(p);
     if(esVacia()){
         this.primero = nuevo;
         this.ultimo = nuevo;
         nuevo.setSiguiente(primero);
     }else{
         this.ultimo.setSiguiente(nuevo);
         this.ultimo = nuevo;
         this.ultimo.setSiguiente(this.primero);         
     }
     
    this.cantNodos++; 
 }
//------------------------------------------------------------------------
     public void listar(){
        Nodo actual  = this.primero;
        
        if(esVacia()){
           System.out.println("Lista vacia");
        }else{
            do{
                System.out.println(actual.getEmpleado().getNombre());
                
                actual = actual.getSiguiente();
            }while(actual!=primero);
        }
    
    }
    
 
//------------------------------------------------------------------------
    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getCantNodos() {
        return cantNodos;
    }

    public void setCantNodos(int cantNodos) {
        this.cantNodos = cantNodos;
    }    
    
}
