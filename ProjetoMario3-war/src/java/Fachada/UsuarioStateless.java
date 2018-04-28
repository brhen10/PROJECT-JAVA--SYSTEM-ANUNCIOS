/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Anuncio;
import modelo.Usuario;
import sessao.LoginLocal;
import sessao.UsuarioFacadeLocal;

/**
 *
 * @author Breno
 */
@Stateless
public class UsuarioStateless {
    
    @EJB
    private UsuarioFacadeLocal usuarioLocal;
    @EJB
    private LoginLocal loginLocal;
    
    public void create(Usuario usuario){
        usuarioLocal.create(usuario);
    }
    
    public void edit(Usuario usuario) {
        usuarioLocal.edit(usuario);
    }
    
    public void remove(Usuario usuario) {
        usuarioLocal.remove(usuario);
    }
    
    public Usuario find(int id) {
        return usuarioLocal.find(id);
    }
    
    public List<Usuario> findAll() {
        return usuarioLocal.findAll();
    }
    
}
