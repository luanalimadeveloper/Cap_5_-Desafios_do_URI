package com.devsuperior.uri2603.repositories;

import com.devsuperior.uri2603.dto.CustomerDTO;
import com.devsuperior.uri2603.entities.Customer;
import com.devsuperior.uri2603.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true, value =
        "SELECT name, street " +
        "FROM customers " +
        "WHERE UPPER (city) = UPPER (:city) "
    )
    List<CustomerMinProjection> search1(String city);


    @Query(
        "SELECT new com.devsuperior.uri2603.dto.CustomerDTO(obj.name, obj.street) " +
        "FROM Customer obj " +
        "WHERE  UPPER (obj.city) = UPPER (:city) "
    )
    List<CustomerDTO> search2(String city);

}
