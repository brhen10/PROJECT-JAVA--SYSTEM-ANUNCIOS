/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Fachada.UsuarioStateless;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import modelo.Usuario;
import sessao.LoginLocal;
import sessao.UsuarioFacadeLocal;

/**
 *
 * @author Breno
 */
@Named(value = "usuarioControle")
@SessionScoped
public class UsuarioControle implements Serializable {

    private Usuario usuario;
    @EJB
    private UsuarioStateless usuarioLocal;
    @EJB
    private LoginLocal loginLocal;
    /**
     * Creates a new instance of UsuarioControle
     */
    public UsuarioControle() {
    }
    
    //NAVEGAÇÃO
    public String urlCreate() {
        usuario = new Usuario();
        return "create";
    }
    
    public String urlLogin() {
        usuario = new Usuario();
        return "login";
    }
    
    public String urlLogout() {
        loginLocal.deslogar();
        return "/anuncios";
    }
    //FIM DA NAVEGAÇÃO
    
    //OPERAÇÕES DE LOGIN
    public Usuario usuarioLogado() {
        return loginLocal.logado();
    }
    
    public String login() {
        for (Usuario u : usuarioLocal.findAll()) {
            if (usuario.getLogin().equals(u.getLogin())) {
                loginLocal.logar(u);
                return "/privado/list";
            }
        }
        return "";
    }
    //FIM DAS OPERAÇÕES DE LOGIN
    
    //BANCO DE DADOS
    public void create() {
        usuarioLocal.create(usuario);
    }
    
    public List<Usuario> findAll() {
        return usuarioLocal.findAll();
    }
    //FIM DAS OPERAÇÕES DE BANCO DE DADOS
    
    //GET E SET
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //FIM DOS GET E SET
    
}
