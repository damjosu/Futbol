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
    public Equipo(String nombre, int numJugadores)
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
                jugadores.get(i).setTitular(true);
            }    
        } else {    //  Hay más del minimo de jugadores, se seleccionará s los que tengan mejor valoración.
            for (int i = 0; i < numJugadores - 2; i++) {
                jugadores.add(new JugadorDeCampo(nombres[rnd.nextInt(nombres.length - 1)], rnd.nextInt((Jugador.getMAX_EDAD() + 1) - Jugador.getMIN_EDAD()) + Jugador.getMIN_EDAD()));
            }
            Collections.sort(jugadores, new Comparator<Jugador>() {
                    @Override
                    public int compare(Jugador j1) {
                        return new Float(j2.valoracion()).compareTo(new Float(j1.valoracion()));
                    }
                });
            for (int i = 0; i < MIN_JUGADORES - 2; i++) {
                jugadores.get(i).setTitular(true);
            }
        }
        jugadores.add(new Capitan(nombres[rnd.nextInt(nombres.length - 1)], rnd.nextInt((Jugador.getMAX_EDAD() + 1) - Jugador.getMIN_EDAD()) + Jugador.getMIN_EDAD()));
        Collections.shuffle(jugadores);
        for (int i = 0; i < MIN_JUGADORES - 1; i++) {
            jugadores.get(i).setDorsal(dorsalUltimoJugador);
            dorsalUltimoJugador++;
        }
        jugadores.add(new Portero(nombres[rnd.nextInt(nombres.length - 1)], rnd.nextInt((Jugador.getMAX_EDAD() + 1) - Jugador.getMIN_EDAD()) + Jugador.getMIN_EDAD()));
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

    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

}
