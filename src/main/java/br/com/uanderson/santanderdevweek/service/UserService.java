package br.com.uanderson.santanderdevweek.service;

import br.com.uanderson.santanderdevweek.domain.model.User;

public interface UserService {
 User findById(Long id);
 User create(User userCreate);

}
