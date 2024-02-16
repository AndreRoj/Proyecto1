/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author pjroj
 */
public class Ciudad {

    private int name;   
    private int unidos;
    //cantidad total de ciudades que hay//
    private int ciudadmax;

    public Ciudad() {
        this.unidos = 0;
        this.ciudadmax = 0;
        this.name = 1;
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
}
