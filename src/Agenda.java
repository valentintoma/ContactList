import java.util.*;
import java.util.stream.Collectors;

public class Agenda {

    Scanner sc = new Scanner ( System.in );

    Map<String, ContactGroup> agenda = new TreeMap<> ();

    //add contact to the contact group
    //add methods
    //edit methods
    //deletion methods

    public void showMenu() {
        System.out.println ( "Agenda functions :" );
        System.out.println ( "1.Show Contacts" );
        System.out.println ( "2.Add Contact" );
        System.out.println ( "3.Remove Contact" );
        System.out.println ( "4.Search Contact " );
        System.out.println ( "5.Edit Contact" );

        readMenuAnswer ();
    }

    public void readMenuAnswer() {
        System.out.println ( "Please input your answer" );
        int answer = sc.nextInt ();

        menuChoice ( answer );
    }

    public void menuChoice(int i) {

        switch (i) {

            case 1:
                showAgenda ();
                showPrevoiusMenu ();
                break;

            case 2:
                //  addContacts ();
                showPrevoiusMenu ();
                break;

            case 3:
                removeContact ();
                showPrevoiusMenu ();
                break;

            case 4:
                System.out.println ( "Type your first name : " );
                String firstName = sc.nextLine ();
                System.out.println ( "Type your last name : " );
                String lastName = sc.nextLine ();
                searchContact ( firstName, lastName );
                showPrevoiusMenu ();

                break;

            case 5:


                break;

        }

    }

    public void showPrevoiusMenu() {
        System.out.println ( " " );
        System.out.println ( "2. Back to menu ? Press 2." );
        int ans = sc.nextInt ();
        if (ans == 2) {
            showMenu ();
        }
    }


    public Contact createContact() {
        System.out.println ( "Type the phone nr" );
        String number = sc.nextLine ();
        System.out.println ( "Type your first name : " );
        String firstName = sc.nextLine ();
        System.out.println ( "Type your last name : " );
        String lastName = sc.nextLine ();

        return new Contact ( firstName, lastName, new PhoneNumber ( "+040", number ) );

    }


    public void addContacts() throws NameNotValidException {
        Contact contact = createContact ();
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
                .map ( entry -> "Key is :" + entry.getKey () + " Value" + entry.getValue () )
                .collect ( Collectors.joining () ) );

    }


    public void removeContact() {

        Contact contact = createContact ();
        String firstLetter = String.valueOf ( contact.name.charAt ( 0 ) );
        ContactGroup contactGroup = agenda.get ( firstLetter );
        contactGroup.remove ( contact );

    }


    public List<Contact> searchContact(String name, String lastName) {
        ContactGroup contactGroup = agenda.get ( String.valueOf ( name.charAt ( 0 ) ) );

        List<Contact> foundContacts = new ArrayList<> ();

        if (contactGroup != null) {
            foundContacts.addAll ( contactGroup.getContacts ()
                    .stream ()
                    .filter ( contact -> contact.getName ().equalsIgnoreCase ( name )
                            && contact.getSurname ().equalsIgnoreCase ( lastName ) )
                    .collect ( Collectors.toList () ) );

        }


        return foundContacts;
    }
//    }
//
//    public void editContact(String firstName, String lastName) {
//        String firstLetter = String.valueOf (firstName.charAt ( 0 ) );
//        ContactGroup contactGroup = agenda.get ( firstLetter );
//
//        //trebuie sa modific contactul din contact grup dupa care sa ii dau replace pe agenda
//
//        contactGroup.getContacts ().stream ().forEach ( contact -> contact.getName ().replaceAll ( contact.getName () , firstName ) );
//
//        if (contactGroup != null) {
//
//
//
//          agenda.replace ( firstLetter , contactGroup )
//
//        }


}







