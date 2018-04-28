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
import modelo.Usuario;

/**
 *
 * @author Breno
 */
@Singleton
public class UsuarioFacade implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ProjetoMario3-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
    }

    @Override
    public void create(Usuario usuario) {
        getEntityManager().persist(usuario);
    }

    @Override
    public void edit(Usuario usuario) {
        getEntityManager().merge(usuario);
    }

    @Override
    public void remove(Usuario usuario) {
        getEntityManager().remove(usuario);
    }

    @Override
    public Usuario find(Object id) {
        return getEntityManager().find(Usuario.class, id);
    }

    @Override
    public List<Usuario> findAll() {
        String sql = "SELECT u FROM Usuario u";
        Query q = getEntityManager().createQuery(sql);
        return q.getResultList();
    }

    @Override
    public List<Usuario> findRange(int[] range) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int count() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
