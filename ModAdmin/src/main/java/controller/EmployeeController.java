package controller;

import Model.EmployeeModel;
import View.EmployeeView;
import dataStructures.Array;
import dataStructures.Interfaces.Iterator;

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
                    return null;

                },
                event -> {
                    return null;
                },
                event -> {
                    return null;
                },
                event -> {
                    return null;
                }
        }), employeeModel.getEmployees());
    }


}
