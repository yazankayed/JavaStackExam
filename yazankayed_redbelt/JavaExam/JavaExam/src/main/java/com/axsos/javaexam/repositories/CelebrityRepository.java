package com.axsos.javaexam.repositories;

import com.axsos.javaexam.models.Celebrity;
import com.axsos.javaexam.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CelebrityRepository extends CrudRepository<Celebrity, Long> {
    List<Celebrity> findAll();
    Optional<Celebrity> findById(Long id);
//    List<Celebrity> findAllByUsers(User user);
//    List<Celebrity> findByUsersNotContains(User user);
//    List<Celebrity> findAllByTeamLead(User user);
}
