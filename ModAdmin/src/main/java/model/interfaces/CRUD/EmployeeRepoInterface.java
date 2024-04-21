package model.interfaces.CRUD;

import model.domain.Employee;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface EmployeeRepoInterface extends Remote {
    public Boolean insert(Employee employee) throws Exception;

    public Boolean delete(Employee employee) throws Exception;

    public Boolean update(Employee employee) throws Exception;

    public Employee getEmployee(String idEmployee) throws Exception;

    public List<Employee> getEmployees() throws Exception;
}
