
package pl.sda.hotelweatherproject.response.hotelimpalaresponse;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Address {

  @SerializedName("line1")
  @Expose
  private String line1;
  @SerializedName("line2")
  @Expose
  private Object line2;
  @SerializedName("city")
  @Expose
  private String city;
  @SerializedName("postalCode")
  @Expose
  private String postalCode;
  @SerializedName("region")
  @Expose
  private String region;
  @SerializedName("country")
  @Expose
  private String country;
  @SerializedName("countryName")
  @Expose
  private String countryName;

  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public Object getLine2() {
    return line2;
  }

  public void setLine2(Object line2) {
    this.line2 = line2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

}
