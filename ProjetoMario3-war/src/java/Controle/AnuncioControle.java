/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Fachada.AnuncioStateless;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import modelo.Anuncio;
import modelo.Usuario;
import sessao.AnuncioFacadeLocal;

/**
 *
 * @author Breno
 */
@Named(value = "anuncioControle")
@SessionScoped
public class AnuncioControle implements Serializable {

    private Anuncio anuncio;
    @EJB
    private AnuncioStateless anuncioLocal;
    @Inject
    private UsuarioControle usuarioControle;
    /**
     * Creates a new instance of Anuncio
     */
    public AnuncioControle() {
    }
    
    //NAVEGAÇÃO
    public String urlTodosAnuncios() {
        return "anuncios";
    }
    
    public String urlAnuncios() {
        return "list";
    }
    
    public String urlCreate() {
        anuncio = new Anuncio();
        anuncio.setUsuario(usuarioControle.usuarioLogado());
        return "create";
    }
    
    public String urlEdit(int id) {
        anuncio = new Anuncio();
        anuncio = anuncioLocal.find(id);
        return "edit";
    }
    //FIM DA NAVEGAÇÃO
    
    //BANCO DE DADOS
    public List<modelo.Anuncio> findAll() {
        return  anuncioLocal.findAll();
    }
    
    public List<modelo.Anuncio> findUsuario() {
        Usuario usuario = usuarioControle.usuarioLogado();
        return  anuncioLocal.findUsuario(usuario);
    }
    
    public void create() {
        anuncioLocal.create(anuncio);
    }
    
    public void edit() {
        anuncioLocal.edit(anuncio);
    }
    
    public void remove(Anuncio u) {
        anuncio = u;
        anuncioLocal.remove(anuncio);
    }
    //FIM DAS OPERAÇÕES COM BANCO DE DADOS
    

    //GET E SET
    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
    //FIM DO GET E SET
    
}
