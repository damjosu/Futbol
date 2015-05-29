import java.util.ArrayList;
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
    private ArrayList<Jugador> localTitular, localReserva;
    private ArrayList<Jugador> visitanteTitular, visitanteReserva;
    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipo1, Equipo equipo2)
    {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        localTitular = new ArrayList<Jugador>();
        localReserva = new ArrayList<Jugador>();
        visitanteTitular = new ArrayList<Jugador>();
        visitanteReserva = new ArrayList<Jugador>();
    }

    public void mostrarAlineaciones() {
        int numeroEquipo1 = equipo1.getNumJugadores();
        for (int i = 0; i < numeroEquipo1; i++) {
            Jugador temporal = equipo1.getJugador(i);
            if (temporal.titular()) {
                localTitular.add(temporal);
            } else {
                localReserva.add(temporal);
            }
        }

        int numeroEquipo2 = equipo2.getNumJugadores();
        for (int i = 0; i < numeroEquipo2; i++) {
            Jugador temporal = equipo2.getJugador(i);
            if (temporal.titular()) {
                visitanteTitular.add(temporal);
            } else {
                visitanteReserva.add(temporal);
            }
        }
        System.out.println(equipo1.getNombre() + "\nTitulares:");
        for(Jugador deAqui:localTitular){
            System.out.println(deAqui);
        }
        System.out.println("******************* Media de valoracion del equipo titular: " + String.format("%.2f", valoracionMedia(localTitular)) + " *******************\nReservas:");
        for(Jugador deAquiReserva:localReserva){
            System.out.println(deAquiReserva);
        }
        System.out.println("\n" + equipo2.getNombre() + "\nTitulares:");
        for(Jugador deAlli:visitanteTitular){
            System.out.println(deAlli);
        }
        System.out.println("******************* Media de valoracion del equipo titular: " + String.format("%.2f", valoracionMedia(visitanteTitular)) + " *******************\nReservas:");
        for(Jugador deAlliReserva:localReserva){
            System.out.println(deAlliReserva);
        }
    }

    private float valoracionMedia(ArrayList<Jugador> equipo) {
        float media = 0;
        for(Jugador evaluar:equipo){
            media += evaluar.valoracion();
        }
        return (media / equipo.size());
    }
}
