package ar.com.eduit.curso.java.web.repositories.list;

public class ArticuloRepositoryFactory {
    private static ArticuloRepository ar=new ArticuloRepository();
    private ArticuloRepositoryFactory(){}
    public static ArticuloRepository getArticuloRepository(){
        return ar;
    }
}
