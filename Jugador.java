import java.util.Comparator;
import java.util.Random;
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Jugador implements Comparable<Jugador>, Cloneable
{
    private final String  nombre;
    private int edad;
    private int dorsal;
    private int estadoDeForma;
    private boolean titular;
    private static final int MIN_EDAD = 18;
    private static final int MAX_EDAD = 40;
    private static final int MIN_ESTADISTICAS = 0;
    private static final int MAX_ESTADISTICAS = 10; 

    @Override
    public int compareTo(Jugador j1) {
        int compare = 0;
        if (j1 instanceof JugadorDeCampo || j1 instanceof Portero || j1 instanceof Capitan) {
            compare = new Float(valoracion()).compareTo(new Float(j1.valoracion()));
        } 
        return compare;
    }   
    
    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre, int edad)
    {
        Random rnd = new Random();
        this.nombre = nombre;
        this.edad = edad;
        dorsal = -1;   
        titular = false;
        estadoDeForma = rnd.nextInt((MAX_ESTADISTICAS + 1) - MIN_ESTADISTICAS) + MIN_ESTADISTICAS;
    } 

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getEstadoDeForma() {
        return estadoDeForma;
    }

    public boolean setEstadoDeForma(int nuevoValor) {
        boolean set = false;
        if (nuevoValor >= MIN_ESTADISTICAS && nuevoValor <= MAX_ESTADISTICAS) {
            this.estadoDeForma = nuevoValor;
            set = true;
        }
        return set;
    }

    public boolean titular() {
        return titular;
    }

    public void isTitular(boolean titular) {
        this.titular = titular;
    }

    public static int getMIN_EDAD() {
        return MIN_EDAD;
    }

    public static int getMAX_EDAD() {
        return MAX_EDAD;
    }

    public static int getMIN_ESTADISTICAS() {
        return MIN_ESTADISTICAS;
    }

    public static int getMAX_ESTADISTICAS() {
        return MAX_ESTADISTICAS;
    }

    public abstract float valoracion();
    
    @Override
    public String toString() {
        String cadena = String.format("%s %2d%s ", "Dorsal", dorsal, ".");
        cadena += String.format("%-29s", (nombre + " (Edad " + edad + ")"));
        cadena += String.format("%s: %-2d", "Forma", estadoDeForma);
        return cadena;
    }
    
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){}
        return obj;
    }
}
