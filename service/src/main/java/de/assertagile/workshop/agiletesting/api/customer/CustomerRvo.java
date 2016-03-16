package de.assertagile.workshop.agiletesting.api.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CustomerRvo {

    private final String firstName;
    private final String lastName;
    private final String emailAddress;

    public CustomerRvo(@JsonProperty("firstName") final String firstName,
            @JsonProperty("lastName") final String lastName, @JsonProperty("emailAddress") final String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
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

    @Override
    public String toString() {
        return "CustomerRvo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CustomerRvo that = (CustomerRvo) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, emailAddress);
    }
}
