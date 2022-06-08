package ru.test.postings.loginsdata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginsRepository extends JpaRepository<LoginRecord, Long> {

}
