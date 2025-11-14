
package com.testhospitalmaciel;

import java.util.Scanner;

  /* Requerimientos:
* 1. Pida la cantidad de pacientes que desea registrar en el hospital.
* 2. Cree un array hospital. Los arrays son creados con una capacidad máxima de N
* pacientes entrados por el usuario.  Inicialmente no se ha registrado ningún paciente.
* 3. Registre los pacientes en el hospital, dada su cantidad de síntomas.
* 4. Retorna la cantidad de casos críticos del hospital, se entiende como 
* crítico a todo paciente que tenga más de 10 síntomas.
* 5. Retorne el valor de la gravedad de un paciente dado. La gravedad se basa 
* en los siguientes criterios médicos:
* Número de Síntomas	Gravedad	Valor de gravedad
*    1-3	    Bajo observación (No grave)	1
*    4-7	    Poco Grave	                2
*    7-10	    Grave	                    3
*    Más de 10	Crítico	                    4
* 6. Dado un valor de gravedad, retorna el promedio de síntomas y la cantidad de pacientes 
* de gravedad menor que dicho valor que hay ingresados en el Hospital.
* 7. Mostrar promedio de síntomas de los pacientes que tengan un valor de gravedad entrada 
* por el usuario.
* 8. Mostrar la mayor cantidad de síntomas registrada por un paciente.
* 9. Mostrar el porcentaje de pacientes con las categorías de: Bajo Vigilancia y 
* Poco Grave, en el Hospital.
*/


public class HospitalMaciel {

    private int[] hospital; // Array estatico para almacenar la cantidad de síntomas de cada paciente
   

    public HospitalMaciel(int[]hospital){
        this.hospital = hospital;
    }

    //Metodo
    public void Cantidadpaciente() {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de pacientes: ");
        int Cantidadpaciente = scanner.nextInt();    
        hospital = new int[Cantidadpaciente];
    
    }    

    // 3. Método para registrar un paciente con su cantidad de síntomas
    public int[] LlenarArray() {
        Scanner scanner = new Scanner(System.in);
            
        //con el for llenamos el array hospital con la cantidad de sintomas de c/pte
        for (int i = 0; i < hospital.length; i++) {
                
         System.out.println("Ingrese la cantidad de síntomas: ");
            int cantidadsintomas = scanner.nextInt();  //almaceno la cantidad de sintmas del pte
            hospital[i] = cantidadsintomas;  //registro en el array en la posicion i la cantidad de sintomas

        }
            
        return hospital;
    }
    
       
    // 5. Método para obtener el valor de gravedad de un paciente dado

    public int CasosCriticos() {
        int casos_criticos = 0;  //contador de cantidad de ptes criticos
        int cantidadsintomas = 0; //almacena cantidad de sintomas

        //recorre arreglo de hospital para saber por c/pte su cantidad de sintomas
        //y saber si es critico.
        for (int numeropaciente = 0; numeropaciente < hospital.length; numeropaciente++) {
            cantidadsintomas = hospital[numeropaciente]; //almacena los sintomas del pte [numeropaciente]

            if (hospital[numeropaciente] > 10){  //evalua si el pte [numeropaciente] tiene mas de 10 sintomas
                casos_criticos += 1;  //cuento el pte con mas de 10 sintomas
            }
        }

        return casos_criticos;
    }
        
    public int GravedadDePaciente(int paciente){
        int gravedad = 0;

        if (hospital[paciente] < 4 ) {
            gravedad = 1;
        }
        else if (hospital[paciente] < 8) {
        gravedad = 2;
        }
        else if (hospital[paciente] < 11) {
        gravedad = 3;
        }
        else {
        gravedad = 4;
        }
             
        return gravedad; 
    

    }
        
    public int CantidadpacienteMenosGraves(int valorgravedad){
        int contadorpaciente = 0;
        for(int i = 0; i < hospital.length; i++){
            if(GravedadDePaciente(i) < valorgravedad){
                contadorpaciente++;
            }
        }

        return contadorpaciente;
    }

    //mostrar promedio de sintomas
    public double MostrarPromedioSintomas(int gravedad){
        int contadorpaciente = 0;
        int suma = 0;
        double promedio = 0;

        for(int i = 0; i < hospital.length; i++){
            if(GravedadDePaciente(i) == gravedad){
                contadorpaciente++;
                suma = suma + hospital[i];

            }
        }
        //pacientes [10,1,25,4,5,12,9] dividido el total de ptes [7]
        if(contadorpaciente > 0){
            promedio = (double) suma / contadorpaciente;
        }
        return promedio;
    }

    //Mostrar la mayor cantidad de sintomas registrados por un pte
    public int MayorCantidadSintomas(){
        int mayor = 0;
        int indicepaciente = 0;
        for(int i = 0; i < hospital.length; i++){   //[15,8,5] - 3 ptes
            if(hospital[i] > mayor){
                mayor = hospital[i];
                indicepaciente = i;
            }
        }
        return mayor;
    }

    // Getter para el array hospital
    public int[] getHospital() {
        return hospital;
    }

    // 9. Mostrar el porcentaje de pacientes con las categorías de: Bajo Vigilancia y Poco Grave
    public double PorcentajeBajoYPocoGrave() {
        int contador = 0;
        for (int i = 0; i < hospital.length; i++) {
            int gravedad = GravedadDePaciente(i);
            if (gravedad == 1 || gravedad == 2) {
                contador++;
            }
        }
        return (double) contador / hospital.length * 100;
    }


}




