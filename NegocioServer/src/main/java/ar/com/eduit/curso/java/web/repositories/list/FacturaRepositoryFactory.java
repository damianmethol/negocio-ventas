package ar.com.eduit.curso.java.web.repositories.list;

public class FacturaRepositoryFactory {
    private static FacturaRepository fr=new FacturaRepository();
    private FacturaRepositoryFactory(){}
    public static FacturaRepository getArticuloRepository(){
        return fr;
    }
}
