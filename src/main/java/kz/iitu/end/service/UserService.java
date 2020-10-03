package kz.iitu.end.service;

import kz.iitu.end.entity.Users;
import kz.iitu.end.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserByID(Long id)
    {
        return userRepository.findById(id).get();
    }

    public Users createUser(Users user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
        return user;
    }

    public void updateUser(Long id, Users user)
    {
        Users userDb = userRepository.findById(id).orElse(null);

        if (userDb != null)
        {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(user.getPassword());

            userRepository.saveAndFlush(userDb);
        }
    }

    public void deleteUser(Long id)
    {
        Users user = new Users();
        user.setId(id);
        userRepository.delete(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Users user = userRepository.findByUsername(username);

        if (user == null)
        {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }

        return user;
    }


}
