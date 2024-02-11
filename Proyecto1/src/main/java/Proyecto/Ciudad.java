
package Proyecto;

public class Ciudad {

private int visibilidad;
// cantidad de caminos unidos entre si por cada ciudad//
private int unidos;
//cantidad total de ciudades que hay//
private int ciudadmax;    

    public Ciudad() {
        this.visibilidad = 2;
        this.unidos = 0;
        this.ciudadmax = 0;
    }

    public int getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(int visibilidad) {
        this.visibilidad = visibilidad;
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

}
