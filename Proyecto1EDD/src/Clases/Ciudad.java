
package Clases;

public class Ciudad {

 private int name;   
private int unidos;
//cantidad total de ciudades que hay//
private int ciudadmax;
private int ciudadlimite;
private Global global;


    public Ciudad(int name) {
        this.unidos = 0;
        this.ciudadmax = 0;
        this.name = name;
        this.ciudadlimite = 20;
    }

    public int getUnidos() {
        return unidos;
    }

    public void setUnidos(int unidos) {
        this.unidos = unidos;
    }

    public int getCiudadmax() {
        return ciudadmax;
    }

    public void setCiudadmax(int ciudadmax) {
        this.ciudadmax = ciudadmax;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getCiudadlimite() {
        return ciudadlimite;
    }

    public void setCiudadlimite(int ciudadlimite) {
        this.ciudadlimite = ciudadlimite;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

}
