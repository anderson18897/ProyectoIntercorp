package com.reto.intercop.repository;

import com.reto.intercop.model.Customer;
import com.reto.intercop.model.Indicator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.dni LIKE %:text% OR c.email LIKE %:text%")
    Customer findBy(String text);

    @Query(value = "SELECT date_format(date_birth, \"%m-%Y\") as fecha_nacimiento, COUNT(date_format(date_birth, \"%m-%Y\")) cantidad from customer group by \n" +
            "date_format(date_birth, \"%m-%Y\") having cantidad >= 1", nativeQuery=true)
    List<Indicator> findByIndicator();

    @Query(value = "SELECT date_format(date_birth, \"%m-%Y\") as fecha_nacimiento, COUNT(date_format(date_birth, \"%m-%Y\")) as cantidad\n" +
            "FROM customer c  GROUP BY date_format(date_birth, \"%m-%Y\") \n" +
            "HAVING COUNT(c.date_birth)=( \n" +
            "SELECT MAX(mycount) \n" +
            "FROM ( \n" +
            "SELECT c.date_birth, COUNT(date_format(date_birth, \"%m-%Y\")) mycount \n" +
            "FROM customer c\n" +
            "GROUP BY date_format(date_birth, \"%m-%Y\")) AS sub)", nativeQuery=true)
    List<Indicator> findByIndicatorMax();

    @Query(value = "SELECT date_format(date_birth, \"%m-%Y\") as fecha_nacimiento, COUNT(date_format(date_birth, \"%m-%Y\")) as cantidad\n" +
            "FROM customer c  GROUP BY date_format(date_birth, \"%m-%Y\") \n" +
            "HAVING COUNT(c.date_birth)=( \n" +
            "SELECT MIN(mycount) \n" +
            "FROM ( \n" +
            "SELECT c.date_birth, COUNT(date_format(date_birth, \"%m-%Y\")) mycount \n" +
            "FROM customer c\n" +
            "GROUP BY date_format(date_birth, \"%m-%Y\")) AS sub)", nativeQuery=true)
    List<Indicator> findByIndicatorMin();

}
