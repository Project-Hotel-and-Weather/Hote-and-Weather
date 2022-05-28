package pl.sda.impala.response;

import java.util.ArrayList;

public class Rate {
    public String rateId;
    public String start;
    public String end;
    public int maxOccupancy;
    public Object hotelAgreement;
    public RetailRate retailRate;
    public int sellerCommissionPercentage;
    public ArrayList<Object> components;
    public ArrayList<CancellationPolicy> cancellationPolicies;
}
