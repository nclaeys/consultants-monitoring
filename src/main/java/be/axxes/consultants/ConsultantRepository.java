package be.axxes.consultants;

import be.axxes.consultants.model.Consultant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "consultants", path = "consultants")
public interface ConsultantRepository extends PagingAndSortingRepository<Consultant, Long> {
    List<Consultant> findByFirstName(@Param("firstName") String firstName);
}
