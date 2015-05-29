import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;
/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo 
{   
    private final String nombre;  
    private ArrayList<Jugador> jugadores;
    private int numJugadores;
    private int dorsalUltimoJugador = 2;
    private static final int MIN_JUGADORES = 11;   

    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nombre, int numJugadores, boolean hayCrack)
    {
        this.nombre = nombre;
        this.numJugadores = numJugadores;
        jugadores = new ArrayList<>();
        Random rnd = new Random();
        String nombres[] = {"Ramon", "Pedro", "Juan", "Mario", "Marcos", "Miguel", "Luis", "Carlos", 
                "Jose Ramon", "Federico", "Alberto", "Roberto", "Ruben", "Guillermo", "Hector", 
                "Mario", "Felipe", "Manuel", "Tomas", "Agustin", "Jose Manuel", "Juan Jesus", 
                "Pepe", "Ricardo", "Fernando", "Antonio", "Jose Alberto", "Jose Luis", "David", 
                "Emilio", "Cesar", "German", "Raul", "Pablo"};             

        if (numJugadores <= MIN_JUGADORES) { //  Hay el mínimo de jugadores y por lo tanto todos son titulares.
            for (int i = 0; i < MIN_JUGADORES - 2; i++) {
                jugadores.add(new JugadorDeCampo(nombres[rnd.nextInt(nombres.length - 1)], rnd.nextInt((Jugador.getMAX_EDAD() + 1) - Jugador.getMIN_EDAD()) + Jugador.getMIN_EDAD()));
                jugadores.get(i).isTitular(true);
            }    
        } else {    //  Hay más del minimo de jugadores.
            for (int i = 0; i < numJugadores - 2; i++) {    //  Se añaden los jugadores.
                jugadores.add(new JugadorDeCampo(nombres[rnd.nextInt(nombres.length - 1)], rnd.nextInt((Jugador.getMAX_EDAD() + 1) - Jugador.getMIN_EDAD()) + Jugador.getMIN_EDAD()));
            }
            Collections.sort(jugadores, new Comparator<Jugador>() { //  Ordena el ArrayList de mayor a menor valoracion.
                    @Override
                    public int compare(Jugador j1, Jugador j2) {
                        return new Float(j2.valoracion()).compareTo(new Float(j1.valoracion()));
                    }
                });
            for (int i = 0; i < MIN_JUGADORES - 2; i++) {   //  Hace titulares a los MIN_JUGADORES - 2  primeros jugadores.
                jugadores.get(i).isTitular(true);
            }
        }
        jugadores.add(new Capitan(nombres[rnd.nextInt(nombres.length - 1)], rnd.nextInt((Jugador.getMAX_EDAD() + 1) - Jugador.getMIN_EDAD()) + Jugador.getMIN_EDAD())); //  Añade al capitan.
        Collections.shuffle(jugadores); //  Desordena el ArrayList.
        for (int i = 0; i < numJugadores - 1; i++) {   //  Asigna los dorsales (el primero reservado para el portero).
            jugadores.get(i).setDorsal(dorsalUltimoJugador);
            dorsalUltimoJugador++;
        }
        if(hayCrack){
            int id = rnd.nextInt(jugadores.size());
            Jugador crack = jugadores.get(id);
            if(crack instanceof JugadorDeCampo){
                JugadorDeCampo superPlayer = (JugadorDeCampo) crack;
                superPlayer.setPase(10);
                superPlayer.setRegate(10);
                superPlayer.setRemate(10);
                superPlayer.setEstadoDeForma(10);
            }else{
                Capitan superCapi = (Capitan) crack;
                superCapi.setPase(10);
                superCapi.setRegate(10);
                superCapi.setRemate(10);
                superCapi.setEstadoDeForma(10);
                superCapi.setLiderazgo(5);
            }
        }
        jugadores.add(0, new Portero(nombres[rnd.nextInt(nombres.length - 1)], rnd.nextInt((Jugador.getMAX_EDAD() + 1) - Jugador.getMIN_EDAD()) + Jugador.getMIN_EDAD())); //  Añade al portero.
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public int getDorsalUltimoPlayer() {
        return dorsalUltimoJugador;
    }

    public void setDorsalUltimoPlayer() {
        dorsalUltimoJugador++;
    }

    public int getMIN_JUGADORES() {
        return MIN_JUGADORES;
    }
    
    public Jugador getJugador(int jugador) {
        return jugadores.get(jugador);
    }
    
    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
    
}
