import java.util.Random;
/**
 * Write a description of class JugadorDeCampo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorDeCampo extends Jugador
{
    private int pase;
    private int regate;
    private int remate;
    /**
     * Constructor for objects of class JugadorDeCampo
     */
    public JugadorDeCampo(String nombre, int edad)
    {
        super(nombre, edad);
        Random rnd = new Random();
        pase = rnd.nextInt((getMAX_ESTADISTICAS() + 1) - getMIN_ESTADISTICAS()) + getMIN_ESTADISTICAS();
        regate = rnd.nextInt((getMAX_ESTADISTICAS() + 1) - getMIN_ESTADISTICAS()) + getMIN_ESTADISTICAS();
        remate = rnd.nextInt((getMAX_ESTADISTICAS() + 1) - getMIN_ESTADISTICAS()) + getMIN_ESTADISTICAS();
    }

    public int getPase() {
        return pase;
    }

    public boolean setPase(int pase) {
        boolean set = false;
        if (pase >= getMIN_ESTADISTICAS() && pase <= getMAX_ESTADISTICAS()) {
            this.pase = pase;
            set = true;
        }
        return set;
    }

    public int getRegate() {
        return regate;
    }

    public boolean setRegate(int regate) {
        boolean set = false;
        if (regate >= getMIN_ESTADISTICAS() && regate <= getMAX_ESTADISTICAS()) {
            this.regate = regate;
            set = true;
        }
        return set;
    }

    public int getRemate() {
        return remate;
    }

    public boolean setRemate(int remate) {
        boolean set = false;
        if (remate >= getMIN_ESTADISTICAS() && remate <= getMAX_ESTADISTICAS()) {
            this.remate = remate;
            set = true;
        }
        return set;
    }

    public float valoracion() {
        return (getEstadoDeForma() + pase + regate + remate) / 4;
    }
    
    @Override
    public String toString() {
        return "";
    }
}
