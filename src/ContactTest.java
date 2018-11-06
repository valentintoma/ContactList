public class ContactTest {

    public static void main(String[] args) {

        inputContact ();

    }


    public static void inputContact() {
        Agenda contact = new Agenda ();

        try {
            contact.addContacts ();
        } catch (NameNotValidException exceptions) {
            System.out.println ( exceptions.getMessage () );
        }


    }

    // pt afisare Agend - > merg  prin entry map, apoi din Contact group -> treeSet  cu entry
    // pt editare cu (Contact  original , Contact editing )


}




