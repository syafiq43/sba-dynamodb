package in.brainupgrade.dynamodb;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingUserRepository extends PagingAndSortingRepository<User, String> {
	Page<User> findByLastName(String lastName, Pageable pageable);

	@EnableScan
	@EnableScanCount
	Page<User> findAll(Pageable pageable);
}