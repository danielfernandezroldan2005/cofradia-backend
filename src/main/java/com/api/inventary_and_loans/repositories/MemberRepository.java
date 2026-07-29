package com.api.inventary_and_loans.repositories;

import com.api.inventary_and_loans.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Usage: "SELECT * WHERE national_id = ?"
    Optional<Member> findByNationalId(String nationalId);
}
