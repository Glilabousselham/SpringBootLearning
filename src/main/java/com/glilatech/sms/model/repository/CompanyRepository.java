package com.glilatech.sms.model.repository;

import com.glilatech.sms.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Additional query methods can be defined here if needed
}
