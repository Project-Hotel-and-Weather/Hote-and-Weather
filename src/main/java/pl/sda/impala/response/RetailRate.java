
package pl.sda.impala.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class RetailRate {

    @SerializedName("total")
    @Expose
    private Total total;
    @SerializedName("taxesAndFees")
    @Expose
    private TaxesAndFees taxesAndFees;
    @SerializedName("deal")
    @Expose
    private Deal deal;

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public TaxesAndFees getTaxesAndFees() {
        return taxesAndFees;
    }

    public void setTaxesAndFees(TaxesAndFees taxesAndFees) {
        this.taxesAndFees = taxesAndFees;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

}
