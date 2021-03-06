package edu.eci.cvds.servlet.model;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.Random;

@ManagedBean(name = "guessBean")
@ApplicationScoped
public class BackingBean {

    private ArrayList<Integer> intentos;
    private int premioAcumulado;
    private int numeroAleatorio;
    private String estado;

    public BackingBean(){
        restart();
    }

    public void restart(){
        Random r = new Random();
        numeroAleatorio = r.nextInt(11);
        intentos = new ArrayList<>();
        premioAcumulado = 100000;
        estado = "No gana";
    }

    public void guess(int intento){
        if(premioAcumulado > 0){
            intentos.add(intento);
            if(intento != numeroAleatorio){
                premioAcumulado -= 10000;
            }
            else{
                estado = "Gana!";
            }
        }
    }


    public ArrayList<Integer> getIntentos() {
        return intentos;
    }

    public void setIntentos(ArrayList<Integer> intentos) {
        this.intentos = intentos;
    }

    public int getPremioAcumulado() {
        return premioAcumulado;
    }

    public void setPremioAcumulado(int premioAcumulado) {
        this.premioAcumulado = premioAcumulado;
    }

    public int getNumeroAleatorio() {
        return numeroAleatorio;
    }

    public void setNumeroAleatorio(int numeroAleatorio) {
        this.numeroAleatorio = numeroAleatorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
