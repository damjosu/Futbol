import java.util.Random;
import java.util.ArrayList;
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
    private int[] puntuaciones;
    private int jornadaActual;

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
    
    public void verClasificacion(){
        System.out.println("Clasificacion del Torneillo del Bar Budo, jornada " + jornadaActual + " de " + (participantes.size() - 1));
        System.out.println("----------------------------------------------------------");
        for (int i=0; i < puntuaciones.length; i++){
            System.out.println(String.format("%-30s%d", participantes.get(i).getNombre(), puntuaciones[i]));
        }
        System.out.println("----------------------------------------------------------\n");
    }
    
    public void jugarUnaJornada(){
        if(jornadaActual < participantes.size() - 1){
            if(jornadaActual != 0){
                for(Equipo participante:participantes){
                    participante.entrenar();
                }
            }
            for(int i=0; i<participantes.size() - 1; i++){
                Equipo local = participantes.get(i);
                for(int j=i+1; j<participantes.size(); j++){
                    Equipo visitante = participantes.get(j);
                    if(!(local.equals(visitante))){
                        Partido encuentro = new Partido(local, visitante);
                        Resultado finalPartido = encuentro.jugarPartido();
                        int golesLocal = finalPartido.getGolesLocal();
                        int golesVisitante = finalPartido.getGolesVisitante();
                        if(golesLocal != golesVisitante){
                            if(golesLocal > golesVisitante){
                                puntuaciones[participantes.indexOf(local)] += 3;
                            }else{
                                puntuaciones[participantes.indexOf(visitante)] += 3;
                            }
                        }else{
                            puntuaciones[participantes.indexOf(local)]++;
                            puntuaciones[participantes.indexOf(visitante)]++;
                        }
                    }
                }
            }
            jornadaActual++;
        }
    }
}
