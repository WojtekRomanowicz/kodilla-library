package com.example.kodillalibrary.repository;

import com.example.kodillalibrary.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Integer id);
}