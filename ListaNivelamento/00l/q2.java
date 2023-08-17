/*
 * Autor - Matheus Fagundes Araujo
 * Ultima Atualizcao - 11/08/2023
 * Objetivo - 
 */


class Aluno{
    private double x;
    private double y;
    private int id;
    private int nextID;

    Aluno(){
        inicializar(9999999, 999999999);
    }
    Aluno(int nId, int nNextID){
        inicializar(nId, nNextID);
    }
    public void inicializar(int nId, int nNextID){
        setId(nId);
        setnextID(nNextID);
    }

    public void setId(int nId){
        id = nId;
    }
    public void setnextID(int nNextID){
       boolean controlador = true;

       while(controlador){

           if(nNextID <= id){
               System.out.println("ID invalido porfavor digite outro ID");
           } else {
                nextID = nNextID;
                controlador = false;
           }
       } 
    }
    public int getId() {
        return id;
    }
    public int getNextID() {
        return nextID;
    }

}



public class q2 {
    
}
