package nl.jworks.hartjes.repository;

import nl.jworks.hartjes.domain.User;
import org.joda.time.LocalDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Spring Data MongoDB repository for the User entity.
 */
public interface UserRepository extends MongoRepository<User, String> {

    
    @Query("{activationKey: ?0}")
    User getUserByActivationKey(String activationKey);

    
    @Query("{activation_key: 'false', createdDate: {$gt: ?0}")
    List<User> findNotActivatedUsersByCreationDateBefore(LocalDate localDate);

}
