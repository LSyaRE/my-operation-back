package ec.com.saviasoft.operaciones.servicio;

import ec.com.saviasoft.operaciones.modelo.UsuarioPassword;
import ec.com.saviasoft.operaciones.repositorio.UsuarioPasswordRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UsuarioPasswordServicio {

    @Autowired
    private UsuarioPasswordRepositorio usuarioPasswordRepositorio;

    // Método para guardar la contraseña cifrada
    public UsuarioPassword guardarPassword(UsuarioPassword usuarioPassword) {
        usuarioPassword.setPassword(cifrarMD5(usuarioPassword.getPassword()));
        return usuarioPasswordRepositorio.save(usuarioPassword);
    }

    // Método para validar la contraseña
    public boolean validarUsuario(String username, String password) {
        UsuarioPassword usuarioPassword = usuarioPasswordRepositorio.findByUsuarioUsername(username);
        if (usuarioPassword == null) {
            return false;
        }
        return usuarioPassword.getPassword().equals(cifrarMD5(password));
    }

    // Método para cifrar la contraseña usando MD5
    private String cifrarMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al cifrar la contraseña", e);
        }
    }
}
