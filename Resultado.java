public class Resultado
{
    // instance variables - replace the example below with your own
    private int golesLocal, golesVisitante;
    private String nombreLocal, nombreVisitante;

    /**
     * Constructor for objects of class Resultado
     */
    public Resultado(String nomLocal, String nomVisitante, int local, int visitante)
    {
        golesLocal = local;
        golesVisitante = visitante;
        nombreLocal = nomLocal;
        nombreVisitante = nomVisitante;
    }

    public int getGolesLocal(){
        return golesLocal;
    }
    
    public int getGolesVisitante(){
        return golesVisitante;
    }
    
    @Override
    public String toString(){
        return String.format("%s %d - %d %s", nombreLocal, golesLocal, golesVisitante, nombreVisitante);
    }
}
