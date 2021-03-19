package co.escuelaing.edu.arep.persistence.impl;

import co.escuelaing.edu.arep.persistence.PersistenceLocal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersistenceLocalImpl implements PersistenceLocal {
    private Map<String,String> users;

    public PersistenceLocalImpl(){
        users= new HashMap<String,String>();
        users.put("prueba","123456");
        users.put("prueba2","123456");
        users.put("prueba3","123456");
    }

    @Override
    public void guardarRegistro(String Usuario, String pass) {
        users.put(Usuario,pass);
    }

    @Override
    public List<String> getUserData(String usuario) {
        List<String> list = new ArrayList<>();
        list.add(usuario);
        list.add(users.get(usuario));
        return list;
    }

    @Override
    public boolean contenuser(String user) {
        return users.containsKey(user);
    }


}
