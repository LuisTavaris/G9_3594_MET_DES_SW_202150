/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorSystem.controller;

import javax.swing.JOptionPane;

/**
 *
 * @author luist
 */
public class ValidacionController {
    
      public boolean Cedula(String validacion)
{
        boolean ValidacionCorrecta = false;

        try
        {

            if (validacion.length() == 10) // ConstantesApp.LongitudCedula
            {
            int tercerDigito = Integer.parseInt(validacion.substring(2, 3));
            if (tercerDigito < 6) {
            // Coeficientes de validación cédula
            // El decimo digito se lo considera dígito verificador
             int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
             int verificador = Integer.parseInt(validacion.substring(9,10));
             int suma = 0;
             int digito = 0;
            for (int i = 0; i < (validacion.length() - 1); i++)
            {
             digito = Integer.parseInt(validacion.substring(i, i + 1))* coefValCedula[i];
             suma += ((digito % 10) + (digito / 10));
            }

            if ((suma % 10 == 0) && (suma % 10 == verificador))
            {
             ValidacionCorrecta = true;
            }
            else if ((10 - (suma % 10)) == verificador) {
             ValidacionCorrecta = true;
            } else {
             ValidacionCorrecta = false;
            }
            } else {
            ValidacionCorrecta = false;
            }
            } else {
            ValidacionCorrecta = false;
            }
            } catch (NumberFormatException nfe) {
            ValidacionCorrecta = false;
        }
        catch (Exception err)
        {
            System.out.println("Una excepcion ocurrio en el proceso de validacion");
            ValidacionCorrecta = false;
        }
       
        return ValidacionCorrecta;
   }
      
      public boolean Celular(String validacion){
          boolean ValidacionCorrecta = false;
      
      try{
          if(validacion.length()==10){
              ValidacionCorrecta = true;
          
          }else{
           ValidacionCorrecta = false;
          }
 
            } catch (NumberFormatException nfe) {
            ValidacionCorrecta = false;
        }
        catch (Exception err)
        {
            System.out.println("Una excepcion ocurrio en el proceso de validacion");
            ValidacionCorrecta = false;
        }           
      
      return ValidacionCorrecta;
      }
    
}
