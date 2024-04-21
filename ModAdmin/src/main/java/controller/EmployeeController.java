package controller;

import model.domain.Employee;
import model.domain.User;
import model.EmployeeModel;
import view.EmployeeView;
import dataStructures.Array;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

import java.util.function.UnaryOperator;

public class EmployeeController {
    EmployeeModel employeeModel;
    EmployeeView employeeView;

    public EmployeeController(EmployeeModel employeeModel, EmployeeView employeeView) {
        this.employeeModel = employeeModel;
        this.employeeView = employeeView;
    }

    public void init() throws Exception {
        employeeView.initComponents(new Array<>(new UnaryOperator[]{
                event -> {
                    String names = employeeView.getNames();
                    String lastNames = employeeView.getLastNames();
                    String contactNumber = employeeView.getContactNumber();
                    Array<String> contactNumbers = new Array<>(contactNumber.split(","));
                    String user = employeeView.getUser();
                    String password = employeeView.getPassword();

                    if (names.isEmpty() || lastNames.isEmpty() || contactNumber.isEmpty() || user.isEmpty() || password.isEmpty()) {
                        employeeModel.getMessenger().setMessage("All fields are required");
                        return null;
                    }
                    if (password.length() < 8) {
                        employeeModel.getMessenger().setMessage("Password must be at least 8 characters long");
                        return null;
                    }
                    Iterator<String> iterator = contactNumbers.iterator();
                    while (iterator.hasNext()) {
                        String contact = iterator.next();
                        if (!contact.matches("^[0-9()+-]+$")) {
                            employeeModel.getMessenger().setMessage("Contact numbers must be numeric");
                            return null;
                        }
                    }
                    try {
                        if (employeeModel.addEmployee(user, password, names, lastNames, contactNumbers)) {
                            employeeModel.getMessenger().setMessage("Employee added successfully");
                        } else {
                            employeeModel.getMessenger().setMessage("Username already exists");
                        }
                        employeeView.chargeTable(employeeModel.getEmployees());
                    } catch (Exception e) {
                        employeeModel.getMessenger().setMessage("An error occurred while adding the employee");
                        throw new RuntimeException(e);
                    }
                    return null;
                },
                event -> {
                    Array<String> data = employeeView.getSelectedRow();
                    if (!data.isEmpty()) {
                        String id = data.get(0);
                        String username = data.get(1);
                        String password = data.get(2);
                        String names = data.get(3);
                        String lastNames = data.get(4);
                        Array<String> contactNumbers = new Array<>(data.get(5).split(","));
                        User user = new User(username, password, false, new Employee(id, names, lastNames, contactNumbers));
                        try {
                            if (employeeModel.deleteEmployee(user)) {
                                employeeModel.getMessenger().setMessage("Employee deleted successfully");
                                employeeView.chargeTable(employeeModel.getEmployees());
                            } else {
                                employeeModel.getMessenger().setMessage("An error occurred while deleting the employee");
                            }
                        } catch (Exception e) {
                            employeeModel.getMessenger().setMessage("An error occurred while deleting the employee");
                            throw new RuntimeException(e);
                        }
                    }
                    return null;
                },
                event -> {
                    Array<String> data = employeeView.getSelectedRow();
                    String id = data.get(0);
                    String username = data.get(1);
                    String password = data.get(2);
                    String names = data.get(3);
                    String lastNames = data.get(4);
                    Array<String> contactNumbers = new Array<>(data.get(5).split(","));
                    User user = new User(username, password, false, new Employee(id, names, lastNames, contactNumbers));
                    try {
                        if (employeeModel.editEmployee(user)) {
                            employeeModel.getMessenger().setMessage("Employee edited successfully");
                            employeeView.chargeTable(employeeModel.getEmployees());
                        } else {
                            employeeModel.getMessenger().setMessage("An error occurred while editing the employee");
                        }
                    } catch (Exception e) {
                        employeeModel.getMessenger().setMessage("An error occurred while editing the employee");
                        throw new RuntimeException(e);
                    }
                    return null;
                },
                event -> {
                    String search = employeeView.getSearched();
                    try {
                        List<User> employees = employeeModel.getEmployees();
                        employees.remove(e -> !e.getPerson().getNames().contains(search) && !e.getPerson().getIdPerson().contains(search));
                        employeeView.chargeTable(employees);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return null;
                }
        }), employeeModel.getEmployees());
    }


}
