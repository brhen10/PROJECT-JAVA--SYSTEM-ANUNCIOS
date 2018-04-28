/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Anuncio;
import modelo.Usuario;

/**
 *
 * @author Breno
 */
@Singleton
public class AnuncioFacade implements AnuncioFacadeLocal {

    @PersistenceContext(unitName = "ProjetoMario3-ejbPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public AnuncioFacade() {
    }

    @Override
    public void create(Anuncio anuncio) {
        getEntityManager().persist(anuncio);
    }

    @Override
    public void edit(Anuncio anuncio) {
        getEntityManager().merge(anuncio);
    }

    @Override
    public void remove(Anuncio anuncio) {
        getEntityManager().remove(getEntityManager().find(Anuncio.class, anuncio.getIdanuncio()));
    }

    @Override
    public Anuncio find(Object id) {
        return getEntityManager().find(Anuncio.class, id);
    }

    @Override
    public List<Anuncio> findAll() {
        String sql = "SELECT a FROM Anuncio a";
        Query q = getEntityManager().createQuery(sql);
        return q.getResultList();
    }
    
    @Override
    public List<Anuncio> findAll(Usuario usuario) {
        String sql = "SELECT a FROM Anuncio a WHERE a.usuario = :usuario";
        Query q = getEntityManager().createQuery(sql);
        q.setParameter("usuario", usuario);
        return q.getResultList();
    }

    @Override
    public List<Anuncio> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
