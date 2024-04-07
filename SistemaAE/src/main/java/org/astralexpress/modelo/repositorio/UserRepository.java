/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;
import org.astralexpress.modelo.domain.Employee;
import org.astralexpress.modelo.domain.User;
import org.astralexpress.shared.FileJsonAdapter;
import org.model.io.LinkedList.LinkedList;
import org.model.util.iterator.Iterator;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.array.Array;
import org.model.util.list.List;

/**
 *
 * @author admin
 */
public class UserRepository implements Serializable{
    private FileJsonInterface<UserEntity> fileJson;
    private String pathFile;

    public UserRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }
    
    public User getUser(String username){
        UserEntity[] userEntity = fileJson.getObjects(pathFile, UserEntity[].class);
        Array<UserEntity> usersEntity = new Array<>(userEntity);
        Iterator<UserEntity> iterator = usersEntity.iterator();
        while (iterator.hasNext()){
            UserEntity user = iterator.next();
            if (user.username.equals(username)){
                EmployeeRepository employeeRepository = new EmployeeRepository("src\\main\\java\\org\\astralexpress\\database\\employee.json");
                Employee employee = employeeRepository.getEmployee(user.person);
                return new User(user.username, user.password, employee);
            }
        }
        return User.getNullUser();
    }  
    
    public List<User> getUsers(){
        UserEntity[] userEntity = fileJson.getObjects(pathFile, UserEntity[].class);
        Array<UserEntity> usersEntity = new Array<>(userEntity);
        List<User> users = new LinkedList<>();
        Iterator<UserEntity> iterator = usersEntity.iterator();
        EmployeeRepository employeeRepository = new EmployeeRepository("src\\main\\java\\org\\astralexpress\\database\\employee.json");
        while (iterator.hasNext()){
            UserEntity user = iterator.next();
            Employee employee = employeeRepository.getEmployee(user.person);
            users.add(new User(user.username, user.password, employee));
            }
        return users;
    }  
}
