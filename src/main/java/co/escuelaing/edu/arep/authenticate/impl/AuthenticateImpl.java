package co.escuelaing.edu.arep.authenticate.impl;

import co.escuelaing.edu.arep.authenticate.Authenticate;
import co.escuelaing.edu.arep.persistence.impl.PersistenceLocalImpl;
import co.escuelaing.edu.arep.security.Encryptor;
import co.escuelaing.edu.arep.security.impl.EncryptorImpl;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AuthenticateImpl implements Authenticate {
    private String user;
    private String pass;
    @Override
    public void convert(String json) {

        json = json.replace("}","");
        json = json.replace("{","");
        json = json.replace("\"","");
        String[] temp =json.split(",");
        user=temp[0].split(":")[1];
        pass=claveHash(temp[1].split(":")[1]);

    }

    public boolean comprobar(){
        PersistenceLocalImpl persistenceLocal= new PersistenceLocalImpl();
        if(persistenceLocal.contenuser(user)){
            List<String> list=persistenceLocal.getUserData(user);
            String passwd=claveHash(list.get(1));
            if(passwd.equals(pass)){
                return true;
            }
        }
        return false;
    }

    private String claveHash(String val) {
        EncryptorImpl encryptor = new EncryptorImpl();
        String temp=null;
        try {
             temp = encryptor.encriptar(val);
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
        } catch (NoSuchPaddingException noSuchPaddingException) {
            noSuchPaddingException.printStackTrace();
        } catch (InvalidKeyException invalidKeyException) {
            invalidKeyException.printStackTrace();
        } catch (BadPaddingException badPaddingException) {
            badPaddingException.printStackTrace();
        } catch (IllegalBlockSizeException illegalBlockSizeException) {
            illegalBlockSizeException.printStackTrace();
        }
        return temp;
    }
}
