/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo;

import org.astralexpress.modelo.domain.Employee;
import org.astralexpress.modelo.domain.User;
import org.model.array.Array;
import org.model.util.iterator.Iterator;

/**
 *
 * @author admin
 */
public class UsersModule {
    Array<User> users;

    public UsersModule() {
        this.users = new Array<>(new User[]{
            new User("Username1", "Password1", new Employee("ID1","Name1", "LastName1", new Array<String>(new String[]{"Phone1-1", "Phone1-2"}))),
            new User("Username2", "Password2", new Employee("ID2","Name2", "LastName2", new Array<String>(new String[]{"Phone1-1", "Phone1-2"}))),
            new User("Username3", "Password3", new Employee("ID3","Name3", "LastName3", new Array<String>(new String[]{"Phone1-1", "Phone1-2"}))),
            new User("Username4", "Password4", new Employee("ID4","Name4", "LastName4", new Array<String>(new String[]{"Phone1-1", "Phone1-2"}))),
            new User("Username5", "Password5", new Employee("ID5","Name5", "LastName5", new Array<String>(new String[]{"Phone1-1", "Phone1-2"})))
        });
    }
    
    public boolean buscarEmpleado(String name, String password){
        Iterator<User> iterator =users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if (user.getUsername().equals(name) && user.getPassword().equals(password)) return true;
        }
        return false;
    }
    
    
    
    
    
}
