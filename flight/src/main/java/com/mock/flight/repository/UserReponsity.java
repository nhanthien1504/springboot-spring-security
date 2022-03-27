package com.mock.flight.repository;

import com.mock.flight.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReponsity extends JpaRepository<User, Long> {
    /**
     * Find user by user name
     *
     * @param username
     * @return User
     */
    User findByUsername(String username);

    /**
     * Check exists an user by user name
     *
     * @param username
     * @return Boolean
     */
    Boolean existsByUsername(String username);

    /**
     * Check exists an user email
     *
     * @param email
     * @return Boolean
     */
    Boolean existsByEmail(String email);

}
