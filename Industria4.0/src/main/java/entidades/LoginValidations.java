
package entidades;

public class LoginValidations {
   public boolean validate (String nombreUsuario, String contraseña){
       return nombreUsuario.equals("mon") && contraseña.equals("1234");
   } 
}
