
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {
        Equipo equipo1 = new Equipo("SOLTEROS", 15);
        Equipo equipo2 = new Equipo("CASADOS", 15);
        Partido miPartido = new Partido(equipo1, equipo2);
        miPartido.mostrarAlineaciones();
    }    
}
