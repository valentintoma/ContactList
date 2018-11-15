import java.util.Comparator;

public class PhoneNumber implements Comparable<PhoneNumber> {

    public static final String DEFAULT_PREFIX = "+40";

    private String prefix;
    private String number;

    public PhoneNumber(String number) {
        this.prefix = DEFAULT_PREFIX;
        this.number = number;
    }

    public PhoneNumber(String prefix, String number) {
        if (prefix.isEmpty ()) {
            prefix = DEFAULT_PREFIX;
        }
        this.prefix = prefix;
        this.number = number;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompletePhoneNumber() {
        return prefix + number;
    }

    @Override
    public String toString() {
        return
                ",  Phone number is : " + prefix  + number ;
    }

    @Override
    public int compareTo(PhoneNumber contact) {
        return Comparator.comparing ( PhoneNumber::getPrefix )
                .thenComparing ( PhoneNumber::getNumber )
                .compare ( this, contact );
    }
}
