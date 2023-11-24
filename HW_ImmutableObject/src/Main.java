public class Main {
    public static void main(String[] args) {
        var immutableObject = new ImmutableObject.ImmutableObjectBuilder()
                .setValue(1)
                .setName("Immutable Object")
                .build();

        System.out.println(immutableObject.getValue());
        System.out.println(immutableObject.getName());
    }
}
