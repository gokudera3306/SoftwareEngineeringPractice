public class ImmutableObject {
    private final int value;
    private final String name;

    private ImmutableObject(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static class ImmutableObjectBuilder {
        private int value;
        private String name;

        public ImmutableObjectBuilder setValue(int value) {
            this.value = value;
            return this;
        }

        public ImmutableObjectBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ImmutableObject build() {
            return new ImmutableObject(value, name);
        }
    }
}
