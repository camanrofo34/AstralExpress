/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.Employee;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.LinkedList.LinkedList;
import org.model.io.array.Array;
import org.model.util.iterator.Iterator;
import org.model.util.list.List;

import java.io.Serializable;

/**
 * @author admin
 */
public class EmployeeRepository implements Serializable {
    private FileJsonInterface<EmployeeEntity> fileJson;
    private String pathFile;

    public EmployeeRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Employee getEmployee(String idEmployee) {
        EmployeeEntity[] userEntity = fileJson.getObjects(pathFile, EmployeeEntity[].class);
        Array<EmployeeEntity> employeesEntity = new Array<>(userEntity);
        Iterator<EmployeeEntity> iterator = employeesEntity.iterator();
        while (iterator.hasNext()) {
            EmployeeEntity employee = iterator.next();
            if (employee.id.equals(idEmployee)) {
                return new Employee(employee.id, employee.names, employee.lastNames, new Array<>(employee.phoneNumbers.split(",")));
            }
        }
        return new Employee();
    }

    public List<Employee> getEmployees() {
        EmployeeEntity[] userEntity = fileJson.getObjects(pathFile, EmployeeEntity[].class);
        Array<EmployeeEntity> employeesEntity = new Array<>(userEntity);
        List<Employee> employees = new LinkedList<>();
        Iterator<EmployeeEntity> iterator = employeesEntity.iterator();
        while (iterator.hasNext()) {
            EmployeeEntity employee = iterator.next();
            employees.add(new Employee(employee.id, employee.names, employee.lastNames, new Array<>(employee.phoneNumbers.split(","))));
        }
        return employees;
    }
}
