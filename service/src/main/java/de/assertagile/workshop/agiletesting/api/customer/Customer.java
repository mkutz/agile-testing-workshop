package de.assertagile.workshop.agiletesting.api.customer;

public class Customer {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;

    public Customer(final String id, final String firstName, final String lastName, final String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public static Customer fromRvo(final CustomerRvo rvo) {
        if (rvo == null) return null;
        return new Customer(null, rvo.getFirstName(), rvo.getLastName(), rvo.getEmailAddress());
    }

    public static Customer fromEntity(final CustomerEntity entity) {
        if (entity == null) return null;
        return new Customer(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getEmailAddress());
    }

    public CustomerRvo toRvo() {
        return new CustomerRvo(this.firstName, this.lastName, this.emailAddress);
    }

    public CustomerEntity toEntity() {
        return new CustomerEntity(this.id, this.firstName, this.lastName, this.emailAddress);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
