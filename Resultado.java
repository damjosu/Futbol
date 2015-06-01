public class Resultado
{
    // instance variables - replace the example below with your own
    private int golesLocal, golesVisitante;
    private Equipo local, visitante;

    /**
     * Constructor for objects of class Resultado
     */
    public Resultado(Equipo equiLocal, Equipo equiVisitante, int local, int visitante)
    {
        golesLocal = local;
        golesVisitante = visitante;
        this.local = equiLocal;
        this.visitante = equiVisitante;
    }

    public int getGolesLocal(){
        return golesLocal;
    }
    
    public int getGolesVisitante(){
        return golesVisitante;
    }
    
    public Equipo getEquipoLocal(){
        return local;
    }
    
    public Equipo getEquipoVisitante(){
        return visitante;
    }
    
    @Override
    public String toString(){
        return String.format("%s %d - %d %s", local.getNombre(), golesLocal, golesVisitante, visitante.getNombre());
    }
}
