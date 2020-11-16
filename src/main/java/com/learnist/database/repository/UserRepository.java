package com.learnist.database.repository;

import com.learnist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(final String username);
    User findUserByEmail(final String email);
    User findUserById(final Long id);
}
