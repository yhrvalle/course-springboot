package com.yhr.course.repositories;

import com.yhr.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // essa interface do jpa já possui uma implementação padrão
}
