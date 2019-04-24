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

/**
 *
 * @author pedrojv
 */
public class EntityManagerProvider implements TestRule {
   
    private EntityManager em;
    private EntityTransaction tx;
    
    private EntityManagerProvider(String unitName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitName);
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }
    public static EntityManagerProvider withUnit(String unitName) {
        return new EntityManagerProvider(unitName);
    }
    public void begin() {
        this.tx.begin();
    }
    public void commit() {
        this.tx.commit();
    }
    public EntityTransaction tx() {
        return this.tx;
    }
    public EntityManager em() {
        return this.em;
    }
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                base.evaluate();
                em.clear();
            }
        };
    }
}
