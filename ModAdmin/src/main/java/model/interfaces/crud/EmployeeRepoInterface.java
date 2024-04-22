package model.interfaces.crud;

import model.domain.Employee;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface EmployeeRepoInterface extends Remote {
    /**
     * Insert a Employee in the repository
     * @param employee Employee to be inserted
     * @return true if the Employee was inserted, false if not
     */
    public Boolean insert(Employee employee) throws Exception;
    /**
     * Delete a Employee in the repository
     * @param employee Employee to be deleted
     * @return true if the Employee was deleted, false if not
     */
    public Boolean delete(Employee employee) throws Exception;
    /**
     * Update a Employee in the repository
     * @param employee Employee to be updated
     * @return true if the Employee was updated, false if not
     */
    public Boolean update(Employee employee) throws Exception;
    /**
     * Get a Employee from the repository
     * @param idEmployee Employee to be obtained
     * @return Employee if the Employee was found, null if not
     */
    public Employee getEmployee(String idEmployee) throws Exception;
    /**
     * Get all Employees from the repository
     * @return List of Employees
     */
    public List<Employee> getEmployees() throws Exception;
}
