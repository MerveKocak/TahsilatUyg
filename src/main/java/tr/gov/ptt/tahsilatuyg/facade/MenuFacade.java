/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.tahsilatuyg.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tr.gov.ptt.tahsilatuyg.entity.Menu;

/**
 *
 * @author Administrator
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu> {
    @PersistenceContext(unitName = "tr.gov.ptt_TahsilatUyg_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }
    
}
