/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp.recuperatorio.lab;

import java.util.ArrayList;

/**
 *
 * @author MICAELA
 */
 class Resultados {
    public static ArrayList<Resultados> resultados = new ArrayList<>();

    Equipo equipoLocal;
    Equipo visitante;
    int resultadoLocal;
    int resultadoVisitante;
    boolean impreso;

    public Resultados(Equipo equipoLocal, Equipo visitante, int resultadoLocal, int resultadoVisitante) {
        this.equipoLocal = equipoLocal;
        this.visitante = visitante;
        this.resultadoLocal = resultadoLocal;
        this.resultadoVisitante = resultadoVisitante;
        this.impreso = false;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public int getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(int resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public int getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(int resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }
    

    public void cargarResultado(Resultados resultado) {
        resultados.add(resultado);
    }

    public void imprimirResultados() {
        
        if (!impreso) {
            System.out.println(this.getEquipoLocal().getNombre().name() + " " + this.getResultadoLocal() + "- " + this.getResultadoVisitante() + " " + this.getVisitante().getNombre().name());
            impreso = true; // Marcar como impreso}
    }

}
 }
