/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModuloArchivos;

import Clases.Camino;
import Clases.Ciudad;
import Clases.ListaCaminos;
import Clases.ListaCiudad;
import static ModuloArchivos.ModificarArchivo.AñadirElemento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author luciano
 */
public class ConversionLista {
    
    
       static void DocumentoALista(ListaCiudad listaciudad, ListaCaminos listacaminos, File inFile) throws IOException{
           //Hacer que se abra el archivo aquí con el String de archivo
           int valor = 0;
         
      if (!inFile.isFile()) {
        JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
        return;
      }   
      BufferedReader br = new BufferedReader(new FileReader(inFile));

      String line = null;

        while ((line = br.readLine()) != null ) {

            if (!line.contains("aristas")&& !line.contains("ciudad") && valor == 0) {
 
                Ciudad num = new Ciudad(Integer.valueOf(line));
                listaciudad.insertFinal(num);      
            }
            if(line.contains("aristas") || valor ==1 && line != null){
                valor = 1;


               if (!line.contains("aristas")&& !line.contains("ciudad") && line.contains(",")) {
                    String[] camino = line.split(",");
                    System.out.println(camino[0] + " " + camino[1] + " " + camino[2]);
                    Ciudad num1 = new Ciudad(Integer.valueOf(camino[0]));
                    Ciudad num2 = new Ciudad(Integer.valueOf(camino[1]));
                    float num3 = (Float.parseFloat(camino[2]));

                        Camino cam = new Camino(num1,num2,num3);
                        listacaminos.insertFinal(cam);  
                }

        }
        }


    }
    static void ListaAdocumento(ListaCiudad lista, String archivo, String lineNeeded){

        for (int i = 0; i < lista.getSize(); i++ ) {
            AñadirElemento(archivo, lineNeeded, lista.GetElementIndex(i).toString());
            System.out.println(i);
          }
          
    }
   public static JFileChooser obtenerArchivo(){
        JFileChooser chooser = new JFileChooser();
chooser.setCurrentDirectory(new java.io.File("."));
chooser.setDialogTitle("Seleccione un archivo txt");
chooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
chooser.setAcceptAllFileFilterUsed(false);

if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
  
  
} else {
   JOptionPane.showMessageDialog(null, "No hay selección", "Alerta", JOptionPane.ERROR_MESSAGE);
   System.exit(0);
  
  
}
        return chooser;
        
    }
}   

