/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.astralexpress.shared;

/**
 *
 * @author PC 4060TI
 */
public interface FileJsonInterface<E> {

    E getObject(String pathFile, Class<E> classofT);

    E[] getObjects(String pathFile, Class<E[]> classOfT);

    Boolean writeObject(String pathFile, E object);

    Boolean writeObjects(String pathFile, E[] objects);
}
