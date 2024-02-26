
package Clases;


public class Ciudad {

    private int name;   
    private int unidos;
    private int ciudadlimite;

    public Ciudad(int name) {
        this.unidos = 0;
        this.name = name;
        this.ciudadlimite = 20;
    }

    public int getUnidos() {
        return unidos;
    }

    public void setUnidos(int unidos) {
        this.unidos = unidos;
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

}
