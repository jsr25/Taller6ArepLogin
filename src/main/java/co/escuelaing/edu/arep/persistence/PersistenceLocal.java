package co.escuelaing.edu.arep.persistence;

import java.util.List;

public interface PersistenceLocal {
    /**
     * Metodo que permite agregar mas usuarios al servidor
     * @param Usuario nombre de usuario
     * @param pass contraseña del usuario
     */
    void guardarRegistro(String Usuario, String pass);

    /**
     * metodos que permite obtener las credenciales del usuario
     * @param usuario nombre de usuario
     * @return credenciales del usuario
     */
    List<String> getUserData(String usuario);

    /**
     * Metodo que permite comprobar si el usario esta registrado
     * @param user nombre de usuario
     * @return valor indicando si el usuario esta registrado
     */
    boolean contenuser(String user);

}
