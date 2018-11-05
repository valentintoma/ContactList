import java.util.Objects;
import java.util.TreeSet;

public class ContactGroup {

    private TreeSet<Contact> contacts = new TreeSet<> ();

    public void removeContact(Contact contact) {

        for (Contact contactFromList : contacts) {
            if (contactFromList.equals ( contact )) {
                contacts.remove ( contactFromList );
            }
        }
    }

    public TreeSet<Contact> getContacts() {
        return contacts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactGroup)) return false;
        ContactGroup that = (ContactGroup) o;
        return Objects.equals ( contacts, that.contacts );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( contacts );

    }

    public void add(Contact contact) {
        contacts.add ( contact );
    }

    public   void remove(Contact contact) {
        contacts.remove ( contact );
    }

    @Override
    public String toString() {
        return "ContactGroup{" +
                "contacts=" + contacts +
                '}';
    }
}
