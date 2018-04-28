/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import javax.ejb.Local;
import modelo.Usuario;

/**
 *
 * @author Breno
 */
@Local
public interface LoginLocal {
    
    public void logar(Usuario u);
    
    public Usuario logado();
    
    public void deslogar();
    
}
