package ru.test.postings.postdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends JpaRepository<PostRecord, Long> {

    @Query("select c from PostRecord c where c.pstngdate >= :dateFrom and c.pstngdate < :dateTo")
    List<PostRecord> findPostRecordByDates(LocalDate dateFrom, LocalDate dateTo);

    @Query("select c from PostRecord c where c.pstngdate >= :dateFrom and c.pstngdate < :dateTo and c.autorpstn is TRUE ")
    List<PostRecord> findPostRecordByDatesAuth(LocalDate dateFrom, LocalDate dateTo);

}
