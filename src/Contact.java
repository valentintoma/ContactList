public class Contact  {
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
        return "Contact{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public int compareTo(Contact contact)  {
        int nameToCompare = this.name.compareTo(contact.name);
        if (nameToCompare==0){
            return nameToCompare;
        }
        int surnameToCompare = this.surname.compareTo(contact.surname);
        if (surnameToCompare == 0){
            return surnameToCompare;
        }
        return nameToCompare;
    }
}
