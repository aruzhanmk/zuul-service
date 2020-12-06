package kz.iitu.end.repository;

import kz.iitu.end.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String username);

    @Override
    Optional<Users> findById(Long id);
}
