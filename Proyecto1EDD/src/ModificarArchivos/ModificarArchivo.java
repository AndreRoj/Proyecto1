/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModificarArchivos;

/**
 *
 * @author luciano
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author luciano
 */
public class ModificarArchivo
        {
    // Tanto añadir Elemento como Eliminar Elemento consiste en crear un nuevo archivo con el cambio a hacer, y eliminar el anterior que no contiene el cambio
    
       static void AñadirElemento(String file, String lineNeeded, String lineToAppend) //file es la dirección del archivo, lineNeeded es la linea a agregar.
      {

    try {
      int verificar = 0;
      File inFile = new File(file);

      if (!inFile.isFile()) {
        JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
        return;
      }

      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;

      //Esta parte lee todo el documento linea por linea
      while ((line = br.readLine()) != null) {

        

          pw.println(line);
          pw.flush();
          if (line.contains(lineNeeded)) {
              if(verificar == 0){
                  while(verificar == 0){
           BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
           
                   output.append(lineToAppend);
        output.newLine();
        output.close();
        verificar = 1;
        break;
              }
              }
          }
        
      }
      JOptionPane.showMessageDialog(null, "El Elemento fue eliminado existosamente", "Operación existosa", JOptionPane.INFORMATION_MESSAGE);

      pw.close();
      br.close();

      if (!inFile.delete()) {
        JOptionPane.showMessageDialog(null, "No se pudo borrar el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (!tempFile.renameTo(inFile))
        JOptionPane.showMessageDialog(null, "No se pudo renombrar el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);

    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }
    
        static void EliminarElemento(String file, String lineToRemove)
      {

    try {

      File inFile = new File(file);

      if (!inFile.isFile()) {
        JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe, o esta vacio", "Alerta", JOptionPane.ERROR_MESSAGE);
        return;
      }

      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

      BufferedReader br = new BufferedReader(new FileReader(file));
      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

      String line = null;

      
      while ((line = br.readLine()) != null) {

        if (!line.contains(lineToRemove)) {

          pw.println(line);
          pw.flush();
        }
      }
      JOptionPane.showMessageDialog(null, "El Elemento fue eliminado existosamente", "Operación existosa", JOptionPane.INFORMATION_MESSAGE);

      pw.close();
      br.close();

      if (!inFile.delete()) {
        JOptionPane.showMessageDialog(null, "No se pudo borrar el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);
        return;
      }

      if (!tempFile.renameTo(inFile))
        JOptionPane.showMessageDialog(null, "No se pudo renombrar el archivo", "Alerta", JOptionPane.ERROR_MESSAGE);

    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    // Acá se encuentran los archivos que utiliza el usuario para los inputs. Los de arriba son mayoritariamente para ejecutar el código
  }
        
        //Añadir lo que permita añadir users.
        
    public static boolean validador(String file, String nombre) throws FileNotFoundException, IOException{
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        while ((line = br.readLine()) != null) {
            if (line.contains(",")){
        if (line.split(",")[0].equals(nombre)) {
            br.close();
            return true;}
      if (line.split(",")[1].equals(nombre)) {
            br.close();
            return true;}
        }
             }
        br.close();
        return false;
    }
    
       public static void InputEliminacionUser(File Archivo, String user) throws IOException{
           BufferedReader br = new BufferedReader(new FileReader(Archivo));
    String aLineFromFile = null;
    String Mensaje = null;
    while ((aLineFromFile = br.readLine()) != null){
            Mensaje = Mensaje +"\n" + aLineFromFile; //Demostrar los elementos dentro del archivo
    }   
      br.close();
               //   JOptionPane.showMessageDialog(null, Mensaje);
                
                if(validador(Archivo.toString(),user)){
                    EliminarElemento(Archivo.toString(), user);
                }else{
                            JOptionPane.showMessageDialog(null, "ERROR:  No se encontro este elemento registrado", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
    }
            static void AñadirSimulacion(String nombre) throws IOException
      {
          File archivo = new File("/home/luciano/Desktop/Universidad/5to trimestre/Proyecto 1/java" + nombre);
            
                archivo.createNewFile();
        System.out.println("Prueba " + archivo.getAbsolutePath().toString());

        int position = 3/2;
        String ciudad = "ciudad";  
        String aristas = "aristas"; 
        //Añadir primer elemento
        BufferedWriter output = new BufferedWriter(new FileWriter(archivo.toString(), true));
        output.append(ciudad);
        output.append("\n");
        output.append(aristas);
        output.newLine();
        output.close();
        
    
}
}