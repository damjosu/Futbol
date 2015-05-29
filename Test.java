
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    private Equipo equipo1, equipo2;
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
}
