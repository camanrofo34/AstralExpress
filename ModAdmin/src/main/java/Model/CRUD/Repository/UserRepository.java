package Model.CRUD.Repository;

import DataStructures.ArrayList;
import DataStructures.Interfaces.List;
import Model.CRUD.Repository.Entities.UserEntity;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.CRUD.Shared.FileJsonInterface;
import Model.Domain.Employee;
import Model.Domain.Passenger;
import Model.Domain.PassengerContact;
import Model.Domain.User;
import Model.Interfaces.CRUD.UserRepoInterface;

public class UserRepository implements UserRepoInterface {
    private final FileJsonInterface<UserEntity> fileJson;
    private final String pathFile;

    public UserRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    @Override
    public Boolean insert(User user) {
        List<UserEntity> users = getUserEntityList();
        String idPerson = user.getPerson().getIdPerson();
        UserEntity userEntity = new UserEntity(user.getUsername(), user.getPassword(), idPerson);
        users.add(userEntity);
        if (idPerson.startsWith("E")) {
            EmployeeRepository employeeRepository = new EmployeeRepository("employees.json");
            employeeRepository.insert((Employee) user.getPerson());
        } else if (idPerson.startsWith("PC")) {
            PassengerContactRepository passengerContactRepository = new PassengerContactRepository("passengerContacts.json");
            passengerContactRepository.insert((PassengerContact) user.getPerson());

        } else if (idPerson.startsWith("P")) {
            PassengerRepository passengerRepository = new PassengerRepository("passengers.json");
            passengerRepository.insert((Passenger) user.getPerson());
        }
        return fileJson.writeObjects(pathFile, users);
    }

    @Override
    public Boolean delete(User user) {
        List<UserEntity> users = getUserEntityList();
        String idPerson = user.getPerson().getIdPerson();
        UserEntity userEntity = new UserEntity(user.getUsername(), user.getPassword(), idPerson);
        users.remove(userEntity);
        if (idPerson.startsWith("E")) {
            EmployeeRepository employeeRepository = new EmployeeRepository("employees.json");
            employeeRepository.delete((Employee) user.getPerson());
        } else if (idPerson.startsWith("PC")) {
            PassengerContactRepository passengerContactRepository = new PassengerContactRepository("passengerContacts.json");
            passengerContactRepository.delete((PassengerContact) user.getPerson());
        } else if (idPerson.startsWith("P")) {
            PassengerRepository passengerRepository = new PassengerRepository("passengers.json");
            passengerRepository.delete((Passenger) user.getPerson());
        }
        return fileJson.writeObjects(pathFile, users);
    }

    @Override
    public Boolean update(User user) {
        ArrayList<UserEntity> users = (ArrayList<UserEntity>) fileJson.getObjects(pathFile, UserEntity[].class);
        String idPerson = user.getPerson().getIdPerson();
        UserEntity userEntity = new UserEntity(user.getUsername(), user.getPassword(), idPerson);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getIdPerson().equals(idPerson)) {
                users.set(i, userEntity);
                break;
            }
        }
        if (idPerson.startsWith("E")) {
            EmployeeRepository employeeRepository = new EmployeeRepository("employees.json");
            employeeRepository.update((Employee) user.getPerson());
        } else if (idPerson.startsWith("PC")) {
            PassengerContactRepository passengerContactRepository = new PassengerContactRepository("passengerContacts.json");
            passengerContactRepository.update((PassengerContact) user.getPerson());
        } else if (idPerson.startsWith("P")) {
            PassengerRepository passengerRepository = new PassengerRepository("passengers.json");
            passengerRepository.update((Passenger) user.getPerson());
        }
        return fileJson.writeObjects(pathFile, users);
    }

    @Override
    public User getUser(String username) {
        ArrayList<UserEntity> users = (ArrayList<UserEntity>) getUserEntityList();
        for (int i = 0; i < users.size(); i++) {
            UserEntity userEntity = users.get(i);
            if (userEntity.getUsername().equals(username)) {
                String idPerson = users.get(i).getIdPerson();
                if (idPerson.startsWith("E")) {
                    EmployeeRepository employeeRepository = new EmployeeRepository("employees.json");
                    Employee employee = employeeRepository.getEmployee(idPerson);
                    return new User(userEntity.getUsername(), userEntity.getPassword(), employee);
                } else if (idPerson.startsWith("PC")) {
                    PassengerContactRepository passengerContactRepository = new PassengerContactRepository("passengerContacts.json");
                    PassengerContact passengerContact = passengerContactRepository.getPassengerContact(idPerson);
                    return new User(userEntity.getUsername(), userEntity.getPassword(), passengerContact);
                } else if (idPerson.startsWith("P")) {
                    PassengerRepository passengerRepository = new PassengerRepository("passengers.json");
                    Passenger passenger = passengerRepository.getPassenger(idPerson);
                    return new User(userEntity.getUsername(), userEntity.getPassword(), passenger);
                }
            }
        }
        return User.getNullUser();
    }

    @Override
    public List<User> getUsers(){
        ArrayList<UserEntity> users = (ArrayList<UserEntity>) getUserEntityList();
        List<User> usersList = new ArrayList<>(users.size());
        for (int i = 0; i < users.size(); i++) {
            UserEntity userEntity = users.get(i);
            String idPerson = userEntity.getIdPerson();
            if (idPerson.startsWith("E")) {
                EmployeeRepository employeeRepository = new EmployeeRepository("employees.json");
                Employee employee = employeeRepository.getEmployee(idPerson);
                usersList.add(new User(userEntity.getUsername(), userEntity.getPassword(), employee));
            } else if (idPerson.startsWith("PC")) {
                PassengerContactRepository passengerContactRepository = new PassengerContactRepository("passengerContacts.json");
                PassengerContact passengerContact = passengerContactRepository.getPassengerContact(idPerson);
                usersList.add(new User(userEntity.getUsername(), userEntity.getPassword(), passengerContact));
            } else if (idPerson.startsWith("P")) {
                PassengerRepository passengerRepository = new PassengerRepository("passengers.json");
                Passenger passenger = passengerRepository.getPassenger(idPerson);
                usersList.add(new User(userEntity.getUsername(), userEntity.getPassword(), passenger));
            }
        }
        return usersList;
    }

    private List<UserEntity> getUserEntityList() {
        return fileJson.getObjects(pathFile, UserEntity[].class);
    }

}
