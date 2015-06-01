import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
/**
 * Write a description of class Liga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liga
{
    // instance variables - replace the example below with your own
    private ArrayList<Equipo> participantes;
    private ArrayList<Partido> jornadas;
    private int[] puntuaciones;
    private int jornadaActual;
    private Iterator<Partido> iterador;

    /**
     * Constructor for objects of class Liga
     */
    public Liga(int numero)
    {
        if(numero < 2){
            numero = 2;
        }
        participantes = new ArrayList<Equipo>();
        inscripciones(numero);
        puntuaciones = new int[numero];
        jornadaActual = 0;
        jornadas = new ArrayList<Partido>();
        generarLiga();
        iterador = jornadas.iterator();
    }

    private void inscripciones(int numero){
        Random aleatorio = new Random();
        boolean crack;
        for (int i=0; i < numero; i++){
            if((aleatorio.nextInt(2) + 2) % 2 == 0){
                crack = true;
            }else{
                crack = false;
            }
            participantes.add(new Equipo(("Equipo " + (i+1)), (14 + aleatorio.nextInt(5)), crack));
        }
    }

    private void generarLiga(){
        for(int i=0; i<participantes.size() - 1; i++){
            Equipo local = participantes.get(i);
            for(int j=i+1; j<participantes.size(); j++){
                Equipo visitante = participantes.get(j);
                if(!(local.equals(visitante))){
                    jornadas.add(new Partido(local, visitante));
                }
            }
        }
        Collections.shuffle(jornadas);
    }

    public void verClasificacion(){
        System.out.println("Clasificacion del Torneillo del Bar Budo, jornada " + jornadaActual + " de " + (participantes.size() - 1));
        System.out.println("----------------------------------------------------------");
        for (int i=0; i < puntuaciones.length; i++){
            System.out.println(String.format("%-30s%d", participantes.get(i).getNombre(), puntuaciones[i]));
        }
        System.out.println("----------------------------------------------------------\n");
    }

    public void jugarUnaJornada(){
        int contador = 0;
        while (iterador.hasNext() && contador < 3){
            Partido aJugar = iterador.next();
            if(jornadaActual != 0){
                aJugar.getEquipoLocal().entrenar();
                aJugar.getEquipoVisitante().entrenar();
            }
            Resultado finalPartido = aJugar.jugarPartido();
            int golesLocal = finalPartido.getGolesLocal();
            int golesVisitante = finalPartido.getGolesVisitante();
            if(golesLocal != golesVisitante){
                if(golesLocal > golesVisitante){
                    puntuaciones[participantes.indexOf(finalPartido.getEquipoLocal())] += 3;
                }else{
                    puntuaciones[participantes.indexOf(finalPartido.getEquipoVisitante())] += 3;
                }
            }else{
                puntuaciones[participantes.indexOf(finalPartido.getEquipoLocal())]++;
                puntuaciones[participantes.indexOf(finalPartido.getEquipoVisitante())]++;
            }
            contador++;
        }
        jornadaActual++;
    }
    
    public void jugarJornadas(int numero){
        if(numero > 0){
            for(int i=0; i < numero; i++){
                jugarUnaJornada();
            }
        }
        verClasificacion();
    }
    
    public void jugarLigaEntera(){
        while(jornadaActual < (participantes.size() - 1)){
            jugarUnaJornada();
        }
        verClasificacion();
    }
}
