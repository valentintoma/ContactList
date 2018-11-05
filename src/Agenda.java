import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Agenda {

    Scanner sc = new Scanner ( System.in );

    Map<String, ContactGroup> agenda = new TreeMap<> ();

    //add contact to the contact group
    //add methods
    //edit methods
    //deletion methods


    public Contact createContacts() {
        System.out.println ( "Type the phone nr" );
        String number = sc.nextLine ();
        System.out.println ( "Type your first name : " );
        String firstName = sc.nextLine ();
        System.out.println ( "Type your last name : " );
        String lastName = sc.nextLine ();


        Contact contact = new Contact ( firstName, lastName, new PhoneNumber ( "+040", number ) );

        return contact;
    }


    public void addContacts() {
        Contact contact = createContacts ();
        String firstLetter = String.valueOf ( contact.name.charAt ( 0 ) );
        ContactGroup contactGroup = agenda.get ( firstLetter );
        if (contactGroup == null) {
            contactGroup = new ContactGroup ();
            agenda.put ( firstLetter, contactGroup );
        }
        contactGroup.add ( contact );

    }


    public   void showAgenda() {

        System.out.println ( agenda.entrySet ()
                .stream ()
                .map ( entry -> "Key is :" + entry.getKey () + " Value" + entry.getValue () )
                .collect ( Collectors.joining () ) );

    }



    public void removeContact() {

        Contact contact = createContacts ();
        String firstLetter = String.valueOf ( contact.name.charAt ( 0 ) );
        ContactGroup contactGroup = agenda.get ( firstLetter );
        contactGroup.remove ( contact );

    }


    public void searchContact() {
        Contact contact = createContacts ();
        String firstLetter = String.valueOf ( contact.name.charAt ( 0 ) );
        ContactGroup contactGroup = agenda.get ( firstLetter );

        if ( contactGroup != null){
            contactGroup.getContacts ().stream ().filter ( contact1 ->  contact.getName ().equalsIgnoreCase ( C ) )
        }


    }


}




