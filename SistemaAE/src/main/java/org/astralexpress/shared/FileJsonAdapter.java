/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.shared;

/**
 * @author PC 4060TI
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileJsonAdapter<E> implements FileJsonInterface<E> {
    private static FileJsonAdapter<?> instance;
    private Object fileWriterLock;

    private FileJsonAdapter() {
        this.fileWriterLock = new Object();
    }

    @SuppressWarnings("unchecked")
    public static synchronized <E> FileJsonAdapter<E> getInstance() {
        if (instance == null) {
            instance = new FileJsonAdapter<>();
        }
        return (FileJsonAdapter<E>) instance;
    }

    public E getObject(String pathFile, Class<E> classOfT) {
        E object = null;
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            object = gson.fromJson(bufferedReader, classOfT);
        } catch (FileNotFoundException | RuntimeException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return object;
    }

    public E[] getObjects(String pathFile, Class<E[]> classOfT) {
        E[] objArray = null;
        try {
            Gson gson = new GsonBuilder().create();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            objArray = gson.fromJson(bufferedReader, classOfT);
        } catch (RuntimeException | IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return objArray;
    }

    public Boolean writeObject(String pathFile, E object) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                gson.toJson(object, writer);
            }
            successful = true;
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }

    public Boolean writeObjects(String pathFile, E[] objects) {
        boolean successful = false;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(pathFile)) {
            synchronized (fileWriterLock) {
                gson.toJson(objects, writer);
            }
            successful = true;
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return successful;
    }

}
