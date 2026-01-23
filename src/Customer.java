/*
 * This class stores customer information
 * (Model class)
 */
public class Customer {

    private String name;
    private String phone;
    private String email;
    private int pin;

    public Customer(String name, String phone, String email, int pin) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.pin = pin;
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public int getPin() { return pin; }
}
