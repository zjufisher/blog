package zjufisher.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CustomerType {
    @JsonProperty("vip")
    VIP,
    @JsonProperty("non_vip")
    NON_VIP;
}
