package co.escuelaing.edu.arep.persistence;

import java.util.List;

public interface PersistenceLocal {
    void guardarRegistro(String Usuario, String pass);
    List<String> getUserData(String usuario);
    boolean contenuser(String user);

}
