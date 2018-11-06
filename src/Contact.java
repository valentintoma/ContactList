import java.util.Objects;

public class Contact implements Comparable<Contact> {
    public String name;
    public String surname;
    public PhoneNumber phoneNumber;

    public Contact(String name, String surname, PhoneNumber phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact name is  : " + name + '\'' +
                " surname is " + surname + '\'' +
                ", phoneNumber is : " + phoneNumber ;
    }

    @Override
    public int compareTo(Contact contact) {
        int nameToCompare = this.name.compareTo ( contact.name );
        if (nameToCompare != 0) {
            return nameToCompare;
        }
        int surnameToCompare = this.surname.compareTo ( contact.surname );
        if (surnameToCompare != 0) {
            return surnameToCompare;
        }
        return this.phoneNumber.compareTo ( contact.phoneNumber );

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals ( name, contact.name ) &&
                Objects.equals ( surname, contact.surname ) &&
                Objects.equals ( phoneNumber, contact.phoneNumber );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( name, surname, phoneNumber );
    }

    public String getFirstLetter() {
        String firstLetter = String.valueOf ( name.charAt ( 0 ) );

        return firstLetter ;
    }
}
