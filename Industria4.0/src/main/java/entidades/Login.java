
package entidades;

import javax.inject.Named;

@Named("appLogin")
public class Login {
    private String nombreUsuario ="ingresa nombre de usuario";
    private String Contraseña ="ingresa contraseña";

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
}
