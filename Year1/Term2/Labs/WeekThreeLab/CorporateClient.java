public class CorporateClient extends Client {

    private int companyRegistrationNumber;

    public CorporateClient(String name, int companyRegistrationNumber) {
        super(name);
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public int getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }
    
}
