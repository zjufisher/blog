package zjufisher.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Customers {
    List<Customer> customers;
    int version;

//    public Customers(
//            @JsonProperty("customers") final List<Customer> customers,
//            @JsonProperty("version") final int version) {
//        this.customers = customers;
//        this.version = version;
//    }
}
