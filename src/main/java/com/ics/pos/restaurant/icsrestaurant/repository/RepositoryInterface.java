/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ics.pos.restaurant.icsrestaurant.repository;

import java.util.List;

/**
 *
 * @author nateelive
 * @param <Class>
 */
public interface RepositoryInterface<Class> {
    
    Class create(Class clazz);
    boolean createList(List<Class> listClass);
    boolean update(String key, Class clazz);
    boolean delete(String key);
    List<Class> findAll();
    Class findById(Class clazz);
}
