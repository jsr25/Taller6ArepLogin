package co.escuelaing.edu.arep.authenticate;

public interface Authenticate {

    /**
     * metodo que recibe un json y obtiene las credeciales ingresadas
     * @param json valor json que viene con las credenciales del usuario
     */
    public void convert(String json);

    /**
     * Metodo que permite comprobar si los datos son correctos
     * @return valor booleano que indica si el usuario puede ingresar correctamente
     */
    public boolean comprobar();
}
