package debashis.newfeatures;

public class RecordRunner {

    record Person(String name, String email, String phoneNumber){}

    public static void main(String[] args) {
        Person p1 = new Person("John","jon@test123.com","967876643");
        Person p2 = new Person("John","jon@test123.com","967876643");
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));
    }
}
