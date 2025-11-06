package com.coupling.landingpage.repository;

import com.coupling.landingpage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // optional: eigene Query-Methoden, z. B. findByEmail(String email);
}
