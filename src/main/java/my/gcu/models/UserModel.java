package my.gcu.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserModel
{
    @NotNull(message="First Name is a required field")
    @Size(min=1, max=32, message="First Name must be between 1-32 characters long")
    private String firstName;

    @NotNull(message="Last Name is a required field")
    @Size(min=1, max=32, message="Last Name must be between 1-32 characters long")
    private String lastName;

   @NotNull(message="Username is a required field")
    @Size(min=3, max=32, message="Username must be between 3-32 characters long")
    private String username;

    @NotNull(message="Password is a required field")
    @Size(min=5, max=32, message="Password must be between 5-32 characters long")
    private String password;

    @NotNull(message="E-Mail is a required field")
    @Size(min=1, max=32, message="E-Mail must be between 1-32 characters long")
    private String emailAddress;

    @NotNull(message="Phone Number is a required field")
    @Size(min=1, max=32, message="Phone Number must be between 1-32 characters long")
    private String phoneNumber;

    public UserModel(String firstName, String lastName, String userName, String password, String emailAddress, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = userName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public UserModel()
    {
        this.firstName = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.emailAddress = "";
        this.phoneNumber = "";
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param userName the userName to set
     */
    public void setUsername(String userName) {
        this.username = userName;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return String return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
