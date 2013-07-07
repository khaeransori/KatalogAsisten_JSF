/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.TblAslab;

/**
 *
 * @author Khaer Ansori
 */
@Stateless
public class ItemFacade implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "aslab_profilePU")
    private EntityManager em;
    
    public List<TblAslab> findAll() {
        return em.createQuery("select object(o) from TblAslab as o").getResultList();
    }
    
    public List<TblAslab> findRange(int maxResults, int firstResult) {
        Query q = em.createQuery("select object(o) from TblAslab as o");
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }
    
    public int getItemCount() {
        return ((Long) em.createQuery("select count(o) from TblAslab as o").getSingleResult()).intValue();
    }
    
    public void create(TblAslab pet){
        em.persist(pet);
    }
    
    public void edit(TblAslab pet){
        em.merge(pet);
    }
    
    public void remove(TblAslab pet) {
        em.remove(em.merge(pet));
    }
    
    public TblAslab find(Object id) {
        return em.find (TblAslab.class, id);
    }
}
