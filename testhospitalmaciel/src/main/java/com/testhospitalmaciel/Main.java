package com.testhospitalmaciel;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear instancia de HospitalMaciel con array vacío inicialmente
        HospitalMaciel hospital = new HospitalMaciel(new int[0]);

        // 1. Pedir cantidad de pacientes y crear array
        System.out.println("Entro en req 1");
        hospital.Cantidadpaciente();

        // 3. Registrar síntomas de los pacientes
        System.out.println("Entro en req 3");
        int[] nr = hospital.LlenarArray();

        // 4. Mostrar cantidad de casos críticos y guardar esa info
        System.out.println("Entro en req 4");
        int casos_criticos = hospital.CasosCriticos();
        System.out.println("Cantidad de casos críticos: " + casos_criticos);

        // 5. Pedir índice de paciente y mostrar gravedad, como el usuario va a ingresar un pte y puede poner 1, pero como inicia con i=0 hay que poner -1
        System.out.println("Entro en req 5");
        System.out.print("Ingrese el paciente: ");
        int indicePaciente = scanner.nextInt();
        int gravedad = hospital.GravedadDePaciente(indicePaciente-1);
        System.out.println("Su gravedad es " + gravedad);
        
        // 6 y 7. Pedir valor de gravedad y mostrar promedio y cantidad menor
        System.out.println("Entro en req 6 y 7");
        System.out.println("Gravedad 1: 1-3 sintomas\n" +
                            "Gravedad 2: 4-7 sintomas\n" +
                            "Gravedad 3: 7-10 sintomas\n" +
                            "Gravedad 4: + 10 sintomas\n");
        System.out.print("Ingrese un valor de gravedad (1-4): ");
        int valorGravedad = scanner.nextInt();
        int cantidadMenosGraves = hospital.CantidadpacienteMenosGraves(valorGravedad);
        double promedioSintomas = hospital.MostrarPromedioSintomas(valorGravedad);
        System.out.println("Cantidad de pacientes con gravedad menor a " + valorGravedad + ": " + cantidadMenosGraves);
        System.out.println("Promedio de síntomas para gravedad " + valorGravedad + ": " + promedioSintomas);


        // 8. Mostrar mayor cantidad de síntomas
        System.out.println("Entro en req 8");
        int mayorSintomas = hospital.MayorCantidadSintomas();
        System.out.println("Paciente con mayor cantidad de síntomas registrados: " + mayorSintomas);

        // 9. Mostrar porcentaje de pacientes con gravedad 1 y 2
        System.out.println("Entro en req 9");
        hospital.PorcentajeBajoYPocoGrave();
        double porcentaje = hospital.PorcentajeBajoYPocoGrave();
        System.out.println("Porcentaje de pacientes con gravedad 1 y 2: " + porcentaje + "%");
    
        scanner.close();
    }
}
