/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package session;

import entity.Location;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 *
 * @author nishansubba
 */
@Stateless
public class LocationFacade extends AbstractFacade<Location> implements LocationFacadeLocal {

    @PersistenceContext(unitName = "HomeBasePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<String> getAllLocationNames() {
        return em.createQuery("SELECT location.name FROM Location location", String.class).getResultList();
    }

    public LocationFacade() {
        super(Location.class);
    }
    
}
