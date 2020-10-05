package zjufisher.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paranamer.ParanamerModule;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SerializationTest {

    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void deserializationCustomerTest() throws Exception {
        Customer customer = Customer.builder().customerType(CustomerType.NON_VIP).age(18).name("zjufisher").build();
        String serializedCustomerString = objectMapper.writeValueAsString(customer);
        System.out.println(serializedCustomerString);
        Customer deserializedCustomer = objectMapper.readValue(serializedCustomerString, Customer.class);
        assertEquals(customer.getAge(), deserializedCustomer.getAge());
        assertEquals(customer.getCustomerType(), deserializedCustomer.getCustomerType());
        assertEquals(customer.getName(), deserializedCustomer.getName());
        System.out.println("deserialized name: " + deserializedCustomer.getName());
        /**
         * {"customerType":"non_vip","name":"zjufisher","age":18}
         * name is:
         * null
         * deserialized name: zjufisher
         */
    }

    @Test
    public void deserializationCustomersTest() throws Exception {
        Customer customer1 = Customer.builder().customerType(CustomerType.NON_VIP).age(18).name("zjufisher1").build();
        Customer customer2 = Customer.builder().customerType(CustomerType.VIP).age(28).name("zjufisher2").build();
        List<Customer> customerList = Arrays.asList(customer1, customer2);
        Customers customers = Customers.builder().customers(customerList).version(1).build();
        String serializedString = objectMapper.writeValueAsString(customers);
        System.out.println(serializedString);
        Customers deserializedCustomers = objectMapper.readValue(serializedString, Customers.class);

    }

    @Test
    public void deserializeCustomerWithParaNamerModuleTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new ParanamerModule());
        Customer customer = Customer.builder().customerType(CustomerType.NON_VIP).age(18).name("zjufisher").build();
        String serializedCustomerString = mapper.writeValueAsString(customer);
        System.out.println(serializedCustomerString);
//        System.out.println(customer.getCustomerType().toString());
        Customer deserializedCustomer = mapper.readValue(serializedCustomerString, Customer.class);
        assertEquals(customer.getAge(), deserializedCustomer.getAge());
        assertEquals(customer.getCustomerType(), deserializedCustomer.getCustomerType());
        assertEquals(customer.getName(), deserializedCustomer.getName());
    }
}
