
package pl.sda.impala.response;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Deal {

    @SerializedName("dealId")
    @Expose
    private String dealId;
    @SerializedName("conditions")
    @Expose
    private List<Object> conditions = null;
    @SerializedName("discount")
    @Expose
    private Discount discount;

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public List<Object> getConditions() {
        return conditions;
    }

    public void setConditions(List<Object> conditions) {
        this.conditions = conditions;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

}
