
package entidades;

import javax.inject.Named;

@Named("appLogin")
public class Login {
    private String nombreUsuario ="ingresa nombre de usuario";
    private String contraseña ="ingresa contraseña";

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.contraseña = Contraseña;
    }
    public String process(){
        if (new LoginValidations().validate(nombreUsuario, contraseña)) {
        return "/jsf/output.xhtml";    
        }else{
             return "/jsf/input.xhtml"; 
        }
    }
}
