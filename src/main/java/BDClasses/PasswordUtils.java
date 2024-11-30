/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDClasses;

/**
 *
 * @author alexo
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class PasswordUtils {

    // Método para encriptar la contraseña con PBKDF2
    public static String hashPassword(String password) throws Exception {
        // Parámetros para el hashing
        int iterations = 10000;  // Número de iteraciones
        int keyLength = 256;     // Longitud de la clave en bits
        String salt = "randomSalt"; // Esto debería ser generado aleatoriamente y almacenado de forma segura.

        // Generamos el hash con PBKDF2
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, keyLength);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = factory.generateSecret(spec).getEncoded();

        // Convertimos el hash en Base64 para almacenarlo de manera segura
        return Base64.getEncoder().encodeToString(hash);
    }

    // Método para verificar si la contraseña coincide con el hash almacenado
    public static boolean verifyPassword(String password, String storedHash) throws Exception {
        String hashedPassword = hashPassword(password); // Vuelve a generar el hash para la comparación
        return storedHash.equals(hashedPassword);
    }
}