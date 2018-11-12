import java.util.*;
import java.util.stream.Collectors;

public class Agenda {

    Scanner sc = new Scanner ( System.in );

    Map<String, ContactGroup> agenda = new TreeMap<> ();

    //add contact to the contact group
    //add methods
    //edit methods
    //deletion methods


    public Contact createContact() {
        System.out.println ( "Type the phone nr" );
        String number = sc.nextLine ();
        System.out.println ( "Type your first name : " );
        String firstName = sc.nextLine ();
        System.out.println ( "Type your last name : " );
        String lastName = sc.nextLine ();

        return new Contact ( firstName, lastName, new PhoneNumber ( "+040", number ) );

    }

    public void addContact() throws NameNotValidException {

        Contact contact = createContact ();

        addContact ( contact );
    }


    public void addContact(Contact contact) throws NameNotValidException {
        if (contact.getName () == null || contact.getName ().isEmpty ()) {
            throw new NameNotValidException ( "Name can not be null or empty " );
        }

        String firstLetter = String.valueOf ( contact.name.charAt ( 0 ) );
        ContactGroup contactGroup = agenda.get ( firstLetter );

        if (contactGroup == null) {
            contactGroup = new ContactGroup ();
            agenda.put ( firstLetter, contactGroup );
        }

        contactGroup.add ( contact );
    }


    public void showAgenda() {

        System.out.println ( agenda.entrySet ()
                .stream ()
                .map ( entry -> "Key is : " + entry.getKey () + " Value " + entry.getValue () )
                .collect ( Collectors.joining () ) );

    }


    public void removeContact() {

        Contact contact = createContact ();
        String firstLetter = String.valueOf ( contact.name.charAt ( 0 ) );
        ContactGroup contactGroup = agenda.get ( firstLetter );
        contactGroup.remove ( contact );

    }


    public List<Contact> searchContact(Contact contactToSearch) {
        ContactGroup contactGroup = agenda.get ( String.valueOf ( contactToSearch.name.charAt ( 0 ) ) );

        List<Contact> foundContacts = new ArrayList<> ();

        if (contactGroup != null) {
            foundContacts.addAll ( contactGroup.getContacts ()
                    .stream ()
                    .filter ( contact -> contact.getName ().equalsIgnoreCase ( contact.getName () )
                            && contact.getSurname ().equalsIgnoreCase ( contact.getSurname () ) )
                    .collect ( Collectors.toList () ) );

        }


        return foundContacts;
    }

    public Contact editContact(Contact original, Contact newContact) {
        ContactGroup contactGroup = agenda.get ( String.valueOf ( original.name.charAt ( 0 ) ) );

        if (contactGroup != null) {
            searchContact ( original )
                    .stream ()
                    .forEach ( contact -> original.setName ( newContact.getName () ) );

        }

    }
}
//    public void editContact(String firstName, String lastName) {
//        ContactGroup contactGroup = agenda.get ( String.valueOf ( firstName.charAt ( 0 ) ) );
//        //trebuie sa modific contactul din contact grup dupa care sa ii dau replace pe agenda
//
//        if (contactGroup != null) {
//            searchContact ( firstName, lastName )
//                    .stream ()
//                    .forEach ( contact -> contact.setName ( sc.next () ) && contact.setSurname ( sc.next ()) );
//
//
//        }


}










