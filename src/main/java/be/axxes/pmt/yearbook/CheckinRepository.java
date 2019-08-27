package be.axxes.pmt.yearbook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CheckinRepository extends PagingAndSortingRepository<Checkin, Long> {

    List<Checkin> findByUser(String user);
    List<Checkin> findByUserAndYear(String user, Integer year);
}
