/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sessions;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

/**
 *
 * @author jaker
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

   private String usuario;
   private String contrasenia;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
   
   
    public Login() {
    }
    
    public void validar() throws IOException{
    
        if("mon".equals(usuario) && contrasenia.equals("123")){
           FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
     }
        else{
          FacesContext.getCurrentInstance().getExternalContext().redirect("Login.xhtml");
        }
    }
    
}
