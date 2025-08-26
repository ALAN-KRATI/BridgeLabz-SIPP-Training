class Prototype implements Cloneable {
    String field;
    Prototype(String field) { this.field = field; }
    protected Object clone() throws CloneNotSupportedException { return super.clone(); }
}

public class CloneDemo {
    public static void main(String[] args) throws Exception {
        Prototype p1 = new Prototype("Data");
        Prototype p2 = (Prototype) p1.clone();
        System.out.println("Cloned: " + p2.field);
    }
}
