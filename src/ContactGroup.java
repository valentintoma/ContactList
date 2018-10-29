import java.util.Objects;
import java.util.TreeSet;

public   class ContactGroup   {

    private  TreeSet<Contact> contacts = new TreeSet<> (  );


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


}
