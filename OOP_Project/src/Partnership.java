import java.util.Date;
public class Partnership {

    private String providerName;
    private String partnerShipId;
    private Date startDate;
    private Date endDate;
    private double commissionRate;
    private Administrator administrator;

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // Method to set the commission rate of the partnership
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    // Method to get the ID of the partnership
    public String getPartnershipId() {
        return partnerShipId;
    }

    public void updateContract(Partnership partnership, Date newEndDate, double newCommissionRate) {
        partnership.setEndDate(newEndDate);
        partnership.setCommissionRate(newCommissionRate);
        System.out.println("Contract updated for partnership with ID: " + partnership.getPartnershipId());
    }
    public boolean isActive() {
        Date currentDate = new Date(); // Current date
        return endDate.after(currentDate); // Partnership end date is after current date
    }


}
