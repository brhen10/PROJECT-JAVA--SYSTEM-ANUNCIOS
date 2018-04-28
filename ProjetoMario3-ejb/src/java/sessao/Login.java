/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import javax.ejb.Stateful;
import modelo.Usuario;

/**
 *
 * @author Breno
 */
@Stateful
public class Login implements LoginLocal {

    private Usuario usuarioLogado;
    
    @Override
    public void logar(Usuario u) {
        usuarioLogado = u;
    }

    @Override
    public Usuario logado() {
        return usuarioLogado;
    }

    @Override
    public void deslogar() {
        usuarioLogado = null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
