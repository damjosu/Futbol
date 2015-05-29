import java.util.Random;
/**
 * Write a description of class Capitan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capitan extends JugadorDeCampo
{
    private int liderazgo;
    private static final int MIN_LIDERAZGO = 0;
    private static final int MAX_LIDERAZGO = 5;

    /**
     * Constructor for objects of class Capitan
     */
    public Capitan(String nombre, int edad)
    {
        super(nombre, edad);
        isTitular(true);
        Random rnd = new Random();
        liderazgo = rnd.nextInt((MAX_LIDERAZGO + 1) - MIN_LIDERAZGO) + MIN_LIDERAZGO;
    }

    public int getLiderazgo() {
        return liderazgo;
    }
    
    public boolean setLiderazgo(int liderazgo) {
         boolean set = false;
        if (liderazgo >= MIN_LIDERAZGO && liderazgo <= MAX_LIDERAZGO) {
            this.liderazgo = liderazgo;
            set = true;
        }
        return set;
    }
    
    public static int getMIN_LIDERAZGO() {
        return MIN_LIDERAZGO;
    }
    
    public static int getMAX_LIDERAZGO() {
        return MAX_LIDERAZGO;
    }
    
    @Override
    public float valoracion() {
        float valoracion = 0;
        if (super.valoracion() + liderazgo > 10) {
            valoracion = 10;
        } else {
            valoracion = (super.valoracion() + liderazgo);
        }
        return valoracion;
    }
    
    @Override
    public String toString() {
        return super.toString() + String.format("  %s: %-2d", "Liderazgo", liderazgo);
    }
}
