package br.com.uanderson.santanderdevweek.service.impl;

import br.com.uanderson.santanderdevweek.domain.model.User;
import br.com.uanderson.santanderdevweek.domain.repository.UserRepository;
import br.com.uanderson.santanderdevweek.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id " + id));
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exists.");
        }
        return userRepository.save(userToCreate);
        /*
            if (userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
                throw new IllegalArgumentException("This user ID already exists.");
            }
        */
    }
}
