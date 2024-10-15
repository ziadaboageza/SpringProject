package com.fawry.springproject.repository;

import com.fawry.springproject.entity.Merchant;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    boolean existsByEmail(String email);
}
