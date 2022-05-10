package com.qdc.demoeurekaprovider1.Service;

import com.qdc.demoeurekaprovider1.pojo.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public User selectUserById(String id){
        return new User("aaa","123","lzh");
    }

    public List<User> selectAllUsers(){
        List<User> users=new ArrayList<>();
        User u1=new User("test001","111","aaa");
        User u2=new User("test002","111","bbb");
        users.add(u1);
        users.add(u2);
        return users;
    }
    public boolean addUser(User u){
        return true;
    }
    public boolean updateUser(User u){
        return true;
    }
    public boolean deleteUser(String name){
        return true;
    }

}
