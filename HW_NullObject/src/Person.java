public abstract class Person {
    private final String name;
    private final String job;
    private final int weight;
    private final int height;

    public Person(String name, String job, int weight, int height) {
        this.name = name;
        this.job = job;
        this.weight = weight;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getJob() {
        return job;
    }

    public String getName() {
        return name;
    }
}
