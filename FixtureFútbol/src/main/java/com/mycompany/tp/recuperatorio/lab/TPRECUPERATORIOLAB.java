/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tp.recuperatorio.lab;

import java.util.ArrayList;
import java.util.Iterator;

public class TPRECUPERATORIOLAB {

    public static void main(String[] args) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        Equipo Argentina = new Equipo("ARGENTINA");
        equipos.add(Argentina);

        Equipo Arabia = new Equipo("ARABIA");
        equipos.add(Arabia);

        Equipo Mexico = new Equipo("MEXICO");
        equipos.add(Mexico);

        Equipo Polonia = new Equipo("POLONIA");
        equipos.add(Polonia);

        Resultados resultado = new Resultados(Argentina, Polonia, 2, 0);
        resultado.cargarResultado(resultado);
        partidoGanadoPerdido(resultado);
        resultado.imprimirResultados();

        Resultados resultado1 = new Resultados(Argentina, Arabia, 1, 2);
        resultado1.cargarResultado(resultado1);
        partidoGanadoPerdido(resultado1);
        resultado1.imprimirResultados();

        Resultados resultado2 = new Resultados(Argentina, Mexico, 2, 0);
        resultado2.cargarResultado(resultado2);
        partidoGanadoPerdido(resultado2);
        resultado2.imprimirResultados();

        Resultados resultado3 = new Resultados(Polonia, Arabia, 2, 0);
        resultado3.cargarResultado(resultado3);
        partidoGanadoPerdido(resultado3);
        resultado3.imprimirResultados();

        Resultados resultado4 = new Resultados(Polonia, Mexico, 0, 0);
        resultado4.cargarResultado(resultado4);
        partidoGanadoPerdido(resultado4);
        resultado4.imprimirResultados();

        Resultados resultado5 = new Resultados(Mexico, Arabia, 2, 1);
        resultado5.cargarResultado(resultado5);
        partidoGanadoPerdido(resultado5);
        resultado5.imprimirResultados();

        //String resultadoPartido1 = resultadoPartido(Argentina, Arabia);
        //System.out.println("Resultado del partido: " + resultadoPartido1);

        //String resultadoPartido2 = resultadoPartido(Mexico, Polonia);
        //System.out.println("Resultado del partido: " + resultadoPartido2);

        recorrerTabla(equipos);
        equiposClasificados(equipos);
        
        for (Resultados res : Resultados.resultados) {
        res.imprimirResultados();
        }
    }

    public static void partidoGanadoPerdido(Resultados resultado) {
        //chequeo de partidos ganados perdidos o empatados
        int puntosLocal = 0, puntosVisitante = 0;
        //suma de puntos

        //local mas goles
        if (resultado.resultadoLocal > resultado.resultadoVisitante) {
            resultado.equipoLocal.setGanados(resultado.equipoLocal.getGanados() + 1);
            puntosLocal = puntosLocal + 3;
            resultado.visitante.setPerdidos(resultado.visitante.getPerdidos() + 1);

        }
        //visitante mas goles
        if (resultado.resultadoLocal < resultado.resultadoVisitante) {
            resultado.equipoLocal.setPerdidos(resultado.equipoLocal.getPerdidos() + 1);
            resultado.visitante.setGanados(resultado.visitante.getGanados() + 1);
            puntosVisitante = puntosVisitante + 3;
        }
        //empate
        if (resultado.resultadoLocal == resultado.resultadoVisitante) {
            resultado.equipoLocal.setEmpatados(resultado.equipoLocal.getEmpatados() + 1);
            resultado.visitante.setEmpatados(resultado.visitante.getEmpatados() + 1);
            puntosLocal = puntosLocal + 1;
            puntosVisitante = puntosVisitante + 1;
        }

        //cuenteo de goles.
        resultado.equipoLocal.setGolesFavor(resultado.resultadoLocal);
        resultado.equipoLocal.setGolesContra(resultado.resultadoVisitante);
        resultado.visitante.setGolesFavor(resultado.resultadoVisitante);
        resultado.visitante.setGolesContra(resultado.resultadoLocal);

        //puntos
        resultado.equipoLocal.setPuntos(puntosLocal);
        resultado.visitante.setPuntos(puntosVisitante);

    }

    public static void recorrerTabla(ArrayList<Equipo> equipos) {
        System.out.println("TABLA POSICIONES:\n");
        System.out.println("PAIS         |    G    |    E    |    P    |    Gf    |    Ge    |    Pts");

        for (Equipo team : equipos) {
            System.out.printf("%-13s | %3d | %3d | %3d | %3d | %3d | %3d%n",
                    team.getNombre(), team.getGanados(), team.getEmpatados(),
                    team.getPerdidos(), team.getGolesFavor(), team.getGolesContra(),
                    team.getPuntos());
        }
    }

    public static String resultadoPartido(Equipo equipo1, Equipo equipo2) {

         for (Resultados resultado : Resultados.resultados) {
            
            if ((resultado.getEquipoLocal() == equipo1 && resultado.getVisitante() == equipo2)
                    || (resultado.getEquipoLocal() == equipo2 && resultado.getVisitante() == equipo1)) {
                return resultado.getEquipoLocal().getNombre().name() + " "
                        + resultado.getResultadoLocal() + " - " + resultado.getResultadoVisitante() + " "
                        + resultado.getVisitante().getNombre().name();
            }
        }
        return "Resultado no encontrado";

    }

    public static void equiposClasificados(Iterable<Equipo> equipos) {
        // Calcula los puntos de cada equipo
        for (Equipo equipo : equipos) {
            int puntos = equipo.getGanados() * 3 + equipo.getEmpatados();
            equipo.setPuntos(puntos);
        }

        System.out.println("Equipos Clasificados:");
        int posicion = 1;
        for (Equipo equipo : equipos) {
            System.out.println(posicion + ". " + equipo.getNombre() + " - Puntos: " + equipo.getPuntos());
            posicion++;
        }
    }
    
    
}
