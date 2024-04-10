package Model.CRUD;

import DataStructures.ArrayList;
import DataStructures.Interfaces.Iterator;
import DataStructures.Interfaces.List;
import Model.CRUD.Entities.UserEntity;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.CRUD.Visitor.PersonVisitor;
import Model.Domain.AbstractClasses.AbstractPerson;
import Model.Domain.User;

public class JSONUser {


    private String USERENTITY_FILE_PATH;
    private String PERSON_FILE_PATH;

    public JSONUser(String pathFileUser, String pathFilePerson){
        USERENTITY_FILE_PATH = pathFileUser;
        PERSON_FILE_PATH = pathFilePerson;
        fileJsonAPAdapter = FileJsonAdapter.getInstance();
        fileJsonUEAdapter = FileJsonAdapter.getInstance();
    }

    private final FileJsonAdapter<UserEntity> fileJsonUEAdapter;
    private final FileJsonAdapter<AbstractPerson> fileJsonAPAdapter;

    public <E extends AbstractPerson> User getUser(String userName, PersonVisitor<E> visitor) {
        List<UserEntity> users = fileJsonUEAdapter.getObjects(USERENTITY_FILE_PATH, UserEntity[].class);
        Iterator<UserEntity> iterator = users.iterator();
        while (iterator.hasNext()) {
            UserEntity userEntity = iterator.next();
            if (userEntity.getUserName().equals(userName)) {
                return new User(userEntity.getUserName(), userEntity.getPassword(), visitor.visit((E) userEntity.getPerson()));
            }
        }
        return User.getNullUser();
    }

    public <E extends AbstractPerson> List<User> getUsers (PersonVisitor<E> visitor) {
        List<UserEntity> users = fileJsonUEAdapter.getObjects(USERENTITY_FILE_PATH, UserEntity[].class);
        List<User> userList = new ArrayList<>();
        Iterator<UserEntity> iterator = users.iterator();
        while (iterator.hasNext()) {
            UserEntity userEntity = iterator.next();
            userList.add(new User(userEntity.getUserName(), userEntity.getPassword(), visitor.visit((E) userEntity.getPerson())));
        }
        return userList;
    }

    public Boolean writeUsers(List<User> users) {
        List<UserEntity> userEntities = new ArrayList<>();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            userEntities.add(new UserEntity(user.getUsername(), user.getPassword(), user.getPerson()));
        }
        return fileJsonUEAdapter.writeObjects(USERENTITY_FILE_PATH, userEntities);
    }



}
