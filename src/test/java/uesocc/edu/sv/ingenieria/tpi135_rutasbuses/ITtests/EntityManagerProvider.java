/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.ITtests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.mockito.internal.util.reflection.Whitebox;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;

/**
 *
 * @author pedrojv
 */
public class EntityManagerProvider implements TestRule {
    
    public static EntityManagerProvider emp;
    private final EntityTransaction transaction;
    private final EntityManager em;
    private final AbstractFacade facade;

    
    private EntityManagerProvider(String unitName, AbstractFacade facade) {
        this.facade = facade;
        this.em = Persistence.createEntityManagerFactory(unitName).createEntityManager();
        Whitebox.setInternalState(facade, "em", this.em);
        this.transaction = this.em.getTransaction();
    }
    
    public static EntityManagerProvider getInstance(String unitName, AbstractFacade facade) {
        return new EntityManagerProvider(unitName, facade);
    }
    
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                getEm().clear();
                getEm().close();        
            }
        };
    }
    
   public static EntityManagerProvider getEmp() {
        return emp;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public EntityManager getEm() {
        return em;
    }

    public AbstractFacade getFacade() {
        return facade;
    }
    
}
