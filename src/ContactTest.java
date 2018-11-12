import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ContactTest {
    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    public static final String PHONE_NUMBER = "PHONE_NUMBER";
    public static final String PREFIX = "PREFIX";

    Scanner sc = new Scanner ( System.in );


    public static void main(String[] args) {


        inputContact ();

    }

    //map de string si integer  ( unde integeer a pozitia pe care se afla stringul )

    public static List<Contact> readContactsFromFile() {
        String firstName = "";
        String lastName = "";
        String phoneNumber = "";
        String prefix = "";

        HashMap<String, Integer> header = new HashMap<> ();
        List<Contact> contactList = new ArrayList<> ();

        try (BufferedReader reader = new BufferedReader ( new FileReader ( "agenda.csv" ) )) {
            boolean firstLine = true;
            String line = null;
            while ((line = reader.readLine ()) != null) {
                String[] csvLine = line.split ( "," );

                if (firstLine) {
                    for (int i = 0; i < csvLine.length; i++) {
                        switch (csvLine[i]) {
                            case FIRST_NAME:
                                header.put ( FIRST_NAME, i );
                                break;
                            case LAST_NAME:
                                header.put ( LAST_NAME, i );
                                break;
                            case PHONE_NUMBER:
                                header.put ( PHONE_NUMBER, i );
                                break;
                            case PREFIX:
                                header.put ( PREFIX, i );
                                break;
                        }
                    }

                    firstLine = false;
                    continue;
                }

                firstName = csvLine[header.get ( FIRST_NAME )];
                lastName = csvLine[header.get ( LAST_NAME )];
                phoneNumber = csvLine[header.get ( PHONE_NUMBER )];

                // the prefix is optional, we add it only if it is in the file
                if (header.get ( PREFIX ) != null) {
                    prefix = csvLine[header.get ( PREFIX )];
                }
                contactList.add ( new Contact ( firstName, lastName, new PhoneNumber ( phoneNumber, prefix ) ) );

            }
            reader.close ();
        } catch (IOException e) {
            System.out.println ( "File not found" + e );

        }
        return contactList;
    }

    public static void inputContact() {
        Agenda agenda = new Agenda ();
        List<Contact> contacts = readContactsFromFile ();
        try {

            for (Contact c : contacts) {
                agenda.addContact ( c );
            }

        } catch (NameNotValidException exceptions) {
            System.out.println ( exceptions.getMessage () );
        }

        agenda.showAgenda ();

    }





    public void showMenu() {
        System.out.println ( "Agenda functions :" );
        System.out.println ( "1.Show Contacts" );
        System.out.println ( "2.Add Contact" );
        System.out.println ( "3.Remove Contact" );
        System.out.println ( "4.Search Contact " );
        System.out.println ( "5.Edit Contact" );

    }



    public void menuChoice(Agenda agenda) {

        System.out.println("Select an action from below:");
        int number = sc.nextInt();

        switch (number) {

            case 1:
                agenda.showAgenda ();
                showPrevoiusMenu ();
                break;

            case 2:
                agenda.addContact ( agenda.createContact () );
                showPrevoiusMenu ();
                break;

            case 3:
                agenda.removeContact ();
                showPrevoiusMenu ();
                break;

            case 4:
                System.out.println ( "Type your first name : " );
                String firstName = sc.nextLine ();
                System.out.println ( "Type your last name : " );
                String lastName = sc.nextLine ();
                agenda.searchContact ( agenda.createContact ());
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
}


// pt afisare Agend - > merg  prin entry map, apoi din Contact group -> treeSet  cu entry
// pt editare cu (Contact  original , Contact editing )


//  editPhoneNumber(Contact original, PhoneNUmber new);

//    editLastName()
//
//





