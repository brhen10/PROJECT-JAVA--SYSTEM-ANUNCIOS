/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import modelo.Anuncio;
import modelo.Usuario;
import sessao.AnuncioFacadeLocal;

/**
 *
 * @author Breno
 */
@Stateless
public class AnuncioStateless {
    
    @EJB
    private AnuncioFacadeLocal anuncioLocal;
    
    public void create(Anuncio anuncio){
        anuncioLocal.create(anuncio);
    }
    
    public void edit(Anuncio anuncio) {
        anuncioLocal.edit(anuncio);
    }
    
    public void remove(Anuncio anuncio) {
        anuncioLocal.remove(anuncio);
    }
    
    public Anuncio find(int id) {
        return anuncioLocal.find(id);
    }
    
    public List<Anuncio> findAll() {
        return anuncioLocal.findAll();
    }
    
    public List<Anuncio> findUsuario(Usuario usuario) {
        return anuncioLocal.findAll(usuario);
    }
    
}
