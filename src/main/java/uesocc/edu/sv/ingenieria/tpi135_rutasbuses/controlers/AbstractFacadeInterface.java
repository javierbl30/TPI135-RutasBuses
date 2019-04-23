/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import java.util.List;

/**
 *
 * @author pedrojv
 * @param <T>
 */
public interface AbstractFacadeInterface<T>{
    
    public void create(T entity);

    public void edit(T entity);

    public void remove(T entity);

    public T find(Object id);

    public List<T> findAll();

    public List<T> findRange(int inicio, int tamanio);

    public int count();
    
}
