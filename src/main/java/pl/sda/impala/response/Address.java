package pl.sda.impala.response;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Address {
    public String line1;
    public Object line2;
    public String city;
    public String postalCode;
    public String region;
    public String country;
    public String countryName;
}
