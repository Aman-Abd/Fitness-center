package com.example.fitness_center.service;

import com.example.fitness_center.entity.Role;
import com.example.fitness_center.entity.Trainer;
import com.example.fitness_center.entity.User;
import com.example.fitness_center.repository.RoleRepositor;
import com.example.fitness_center.repository.UserRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {


    @PersistenceContext
    private EntityManager em;

    private UserRepositor userRepositor;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepositor roleRepositor;

    public UserServiceImpl(UserRepositor userRepositor, BCryptPasswordEncoder passwordEncoder, RoleRepositor roleRepositor) {
        this.userRepositor = userRepositor;
        this.passwordEncoder = passwordEncoder;
        this.roleRepositor = roleRepositor;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositor.findAll();
    }

    @Override
    public User findByUsername(String username) {
        List<User> users = userRepositor.findAll();
        for(User user : users){
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepositor.findAll()));
        userRepositor.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User userDb = userRepositor.findById(id).orElse(null);
        if (userDb != null) {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(user.getPassword());

            userRepositor.save(userDb);
        }
    }

    public List<User> allUsers() {
        return userRepositor.findAll();
    }

    public List<User> userGetList(Long idMin) {
        List<User> users = userRepositor.findAll();
        List<User> result = new ArrayList<User>();

        for(User user : users){
            if(user.getUser_id() > idMin)
                result.add(user);
        }
        return result;
    }

    @Override
    public void deleteUser(Long id) {
        userRepositor.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = null;
        List<User> users = userRepositor.findAll();
        for(User u : users){
            if(u.getUsername().equals(username))
                user = u;
        }
        if (user == null) throw new UsernameNotFoundException("User: " + username + " not found!");
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
