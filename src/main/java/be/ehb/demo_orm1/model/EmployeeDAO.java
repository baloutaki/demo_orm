package be.ehb.demo_orm1.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

    Iterable<Employee> findByIdOrderByNaam(String naam);

    @Query(value = "select b from Employee b where b.naam = :naam")
    Iterable<Employee> zoekBijNaam(String naam);


    Optional<Employee> findByNaam(String naam);
}