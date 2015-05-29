
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    private Equipo equipo1;
    private Equipo equipo2;
    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipo1, Equipo equipo2)
    {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public void mostrarAlineaciones() {
        String titulares1 = "";
        String reservas1 = "";
        String titulares2 = "";
        String reservas2 = "";        
        for (int i = 0; i < equipo1.getNumJugadores(); i++) {
            if (equipo1.getJugador(i).titular()) {
                titulares1 += equipo1.getJugador(i).toString() + "\n";
            } else {
                reservas1 += equipo1.getJugador(i).toString() + "\n";
            }
        }

        for (int i = 0; i < equipo2.getNumJugadores(); i++) {
            if (equipo2.getJugador(i).titular()) {
                titulares2 += equipo2.getJugador(i).toString() + "\n";
            } else {
                reservas2 += equipo2.getJugador(i).toString() + "\n";
            }
        }
        System.out.println(equipo1.getNombre());
        System.out.println("Titulares:\n" + titulares1 + "\n \t \t**************** Media de valoración del equipo titular: " + valoracionMedia(equipo1) + " ****************\nReservas:\n" + reservas1);
        System.out.println(equipo2.getNombre());
        System.out.println("Titulares:\n" + titulares2 + "\n \t \t**************** Media de valoración del equipo reserva: " + valoracionMedia(equipo2) + " ****************\nReservas:\n" + reservas2);
    }

    private float valoracionMedia(Equipo equipo) {
        float media = 0;
        int numTitulares = 0;
        for (int i = 0; i < equipo.getNumJugadores(); i++) {
            if (equipo1.getJugador(i).titular()) {
                media += equipo.getJugador(i).valoracion();
                numTitulares++;
            }
        }        
        media = media / numTitulares;
        return media;
    }
}
