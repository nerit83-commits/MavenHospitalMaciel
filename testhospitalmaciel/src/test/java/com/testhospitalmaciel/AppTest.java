package com.testhospitalmaciel;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void CasosCriticos() {

        int[] h1 = new int[] {4,5}; //creo array de 5 pacientes, h1 es el array
        HospitalMaciel hospitaltest = new HospitalMaciel(h1); //creo objeto hospitaltest

        assertTrue(hospitaltest.CasosCriticos() == 0);

    }

    @Test
    void MayorCantidadSintomasTest() {

        int[] h1 = new int[] {4,11};  //creo array con 2 sintomas
        HospitalMaciel hospitaltest1 = new HospitalMaciel(h1); //creo objeto hospitaltest para usar los metodos

        assertTrue(hospitaltest1.MayorCantidadSintomas() == 11); //verifico que el metodo mayor cantidad de sintomas me devuelva 11
      
    }


}
