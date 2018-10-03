/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponenteClase;

public class Atender {
    
    

    public Atender() {
    }
    private int nficha;
    private String fecha;
    private String nombre;
    private String apellido;
    private Double temperatura;
    private Double ta;
    private Double peso;
    private String sintomas;
    private String diagnosticos;
    
    public String getdiagnosticos(){
    return diagnosticos;
    }
    
    public void setdiagnosticos(String diagnosticos){
    this.diagnosticos=diagnosticos;
    }
    
    
    public String getsintomas(){
    return sintomas;
    }
    
    public void setsintomas(String sintomas){
    this.sintomas=sintomas;
    }

    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }
    private String usuario;
    
    public String getfecha() {
        return fecha;
    }
    public void setfecha(String fecha) {
        this.fecha = fecha;}
  
    public int getnficha() {
        return nficha;
    }

    public void setnficha(int nficha) {
        this.nficha = nficha;}

   
    
     public String getnombre() {
        return nombre;
     }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
     public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }
     public Double gettemperatura() {
        return temperatura;
    }

    public void settemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
    public Double getta() {
        return ta;
    }

    public void setta(Double ta) {
        this.ta = ta;
    }
    public Double getpeso() {
        return peso;
    }

    public void setpeso(Double peso) {
        this.peso = peso;
    }

    public void setcateg(String text) {
        
    }

    public void setid(int parseInt) {
        
    }

    public void setdescr(String text) {
        
    }

       
    

    
    
}
