import java.util.Random;
/**
 * Write a description of class Portero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portero extends Jugador
{
    private int agilidad;
    private int fortalezaMental;
    /**
     * Constructor for objects of class Portero
     */
    public Portero(String nombre, int edad)
    {
        super(nombre, edad);
        isTitular(true);
        setDorsal(1);
        Random rnd = new Random();
        agilidad = rnd.nextInt((getMAX_ESTADISTICAS() + 1) - getMIN_ESTADISTICAS()) + getMIN_ESTADISTICAS();
        fortalezaMental = rnd.nextInt((getMAX_ESTADISTICAS() + 1) - getMIN_ESTADISTICAS()) + getMIN_ESTADISTICAS();
    }

    public int getAgilidad() {
        return agilidad;
    }

    public boolean setAgilidad(int agilidad) {
        boolean set = false;
        if (agilidad >= getMIN_ESTADISTICAS() && agilidad <= getMAX_ESTADISTICAS()) {
            this.agilidad = agilidad;
            set = true;
        }
        return set;
    }

    public int getFortalezaMental() {
        return fortalezaMental;
    }

    public boolean setFortalezaMental(int fortalezaMental) {
        boolean set = false;
        if (fortalezaMental >= getMIN_ESTADISTICAS() && fortalezaMental <= getMAX_ESTADISTICAS()) {
            this.fortalezaMental = fortalezaMental;
            set = true;
        }
        return set;
    }

    public float valoracion() {
        return (getEstadoDeForma() + agilidad + fortalezaMental) / 3;
    }
    
    @Override
    public String toString() {
        return "Dorsal " + getDorsal() + " " + getNombre() + " Forma: " + getEstadoDeForma() + " Agil.: " + agilidad + " FortM.: " + fortalezaMental +" Valoración: " + valoracion();
    }
}
