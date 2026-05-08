package com.yhr.course.repositories;

import com.yhr.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository como esse repository esta herdando do jpaRepository então é opcional
public interface UserRepository extends JpaRepository<User, Long> {
    // essa interface do jpa já possui uma implementação padrão
}
