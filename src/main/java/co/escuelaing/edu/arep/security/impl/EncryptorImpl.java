package co.escuelaing.edu.arep.security.impl;

import co.escuelaing.edu.arep.security.Encryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class EncryptorImpl implements Encryptor {
    private final String  key="arep2021";

    private SecretKeySpec crearClave() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveEncriptacion = key.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        claveEncriptacion = sha.digest(claveEncriptacion);
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");
        return secretKey;
    }

    @Override
    public String encriptar(String valor) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKey =crearClave();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] datosEncriptar = valor.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);

        return encriptado;

    }

    @Override
    public String desencriptar(String valor) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKey = crearClave();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] bytesEncriptados = Base64.getDecoder().decode(valor);
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        String datos = new String(datosDesencriptados);

        return datos;
    }
}
