package com.reto.intercop;

import com.reto.intercop.model.Customer;
import com.reto.intercop.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IntercopApplicationTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindBy() {
        Customer customer = customerRepository.findBy("mikel@gmail.com");
        assertThat(customer.getEmail()).isEqualTo("mikel@gmail.com");
    }

}
