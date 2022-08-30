package group.ace.test.demo.repository;

import group.ace.test.demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //pameten e spring i pretpostavuva sto sakas da baras po imeto na metodot
    Optional<Customer> findByName(String name);

    @Query(value = "SELECT CUSTOMER.NAME FROM CUSTOMER", nativeQuery = true)
    public List<String> findAllByName();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CUSTOMER c WHERE c.name = :name", nativeQuery = true)
    void deleteByName(@Param("name") String name);

}
