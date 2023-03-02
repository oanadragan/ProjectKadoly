package ObjectModels;

public class RegistrationModel {

    private RegistrationAccountModel registrationAccountModel;
    private String firstName1Error;
    private String lastName1Error;
    private String email1Error;
    private String password1Error;
    private String lastName2Error;
    private String firstName2Error;
    private String city1Error;
    private String address1Error;
    private String postalCodeError;
    private String phoneNoError;
    private String aliasError;

    public RegistrationModel(String firstName1, String lastName1, String email1, String password1,
                             String lastName2, String firstName2, String city1,
                             String address1, String postalCode, String mobilePhoneNo, String aliasAddress,
                             String firstName1Error, String lastName1Error, String email1Error, String password1Error,
                             String lastName2Error, String firstName2Error, String city1Error, String address1Error,
                             String postalCodeError, String phoneNoError, String aliasError) {

        RegistrationAccountModel registrationAc = new RegistrationAccountModel();
        registrationAc.setFirstName1(firstName1);
        registrationAc.setLastName1(lastName1);
        registrationAc.setEmail1(email1);
        registrationAc.setPassword1(password1);
        registrationAc.setFirstName2(firstName2);
        registrationAc.setLastName2(lastName2);
        registrationAc.setCity1(city1);
        registrationAc.setAddress1(address1);
        registrationAc.setPostalCode(postalCode);
        registrationAc.setMobilePhoneNo(mobilePhoneNo);
        registrationAc.setAliasAddress(aliasAddress);

        this.registrationAccountModel = registrationAc;
        this.firstName1Error = firstName1Error;
        this.lastName1Error = lastName1Error;
        this.email1Error = email1Error;
        this.password1Error = password1Error;
        this.lastName2Error = lastName2Error;
        this.firstName2Error = firstName2Error;
        this.city1Error = city1Error;
        this.address1Error = address1Error;
        this.postalCodeError = postalCodeError;
        this.phoneNoError = phoneNoError;
        this.aliasError = aliasError;
    }

    public RegistrationAccountModel getRegistrationAccountModel() {
        return registrationAccountModel;
    }
    public String getFirstName1Error() {
        return firstName1Error;
    }
    public String getLastName1Error() {
        return lastName1Error;
    }
    public String getEmail1Error() {
        return email1Error;
    }
    public String getPassword1Error() {
        return password1Error;
    }

    public String getLastName2Error() {
        return lastName2Error;
    }

    public String getFirstName2Error() {
        return firstName2Error;
    }

    public String getCity1Error() {
        return city1Error;
    }

    public String getAddress1Error() {
        return address1Error;
    }

    public String getPostalCodeError() {
        return postalCodeError;
    }

    public String getPhoneNoError() {
        return phoneNoError;
    }

    public String getAliasError() {
        return aliasError;
    }



}
