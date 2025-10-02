package Clases;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    List<Pregunta> preguntasJava = new ArrayList<>();
    List<Pregunta> preguntasSql = new ArrayList<>();
    int respuestasCorrectas = 0 ;

    public void agregarPreguntaJava (Pregunta p){
         preguntasJava.add(p);
    }

    public void agregarPreguntaSql (Pregunta p){
        preguntasSql.add(p);
    }


}
