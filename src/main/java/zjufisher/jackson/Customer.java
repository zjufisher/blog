package zjufisher.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Customer {
    /**
     * jackson by default uses getters method via reflection to serialize Object.
     */
    private CustomerType customerType;
    private String name;
    private int age;

    /**
     * Deserialization:
     *      - either through setters method & empty constructor.
     *      - or by annotated constructor.
     */

    public Customer(
            // jackson will auto-detect fields via setters after this constructor.
            @JsonProperty(value = "cc") final CustomerType customerType,
            @JsonProperty(value = "bb") final String name) {
//            @JsonProperty(value = "aa") final int age) {
        System.out.println("name is:");
        System.out.println(name);
        this.customerType = customerType;
        this.name = name;
//        this.age = age;
    }
}
