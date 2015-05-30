
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    private Equipo equipo1, equipo2;
    private Liga liguilla;
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        equipo1 = new Equipo("SOLTEROS", 15, true);
        equipo2 = new Equipo("CASADOS", 15, true);
    }
    
    public void entrenamiento(){
        equipo1.entrenar();
        equipo2.entrenar();
    }
    
    public void partido(){
        Partido miPartido = new Partido(equipo1, equipo2);
        miPartido.mostrarAlineaciones();
    }
    
    public void crearLiga(int numeroDeEquipos){
        liguilla = new Liga(numeroDeEquipos);
    }
    
    public void jugarUnaJornadaDeLiga(){
        if(liguilla != null){
            liguilla.jugarUnaJornada();
        }else{
            System.out.println("No hay liga creada, abortado");
        }
    }
}
