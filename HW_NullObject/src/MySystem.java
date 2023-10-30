import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySystem {
    Map<String, Person> personMap = new HashMap<>();

    public void AddPerson(String name, String job, String weightString, String heightString) {
        Person newPerson;
        try {
            var weight = Integer.parseInt(weightString);
            var height = Integer.parseInt(heightString);

            if (weight < 0 || height < 0)
                throw new Exception("Invalid Value.");

            newPerson = new NormalPerson(name, job, weight, height);
        } catch (Exception e) {
            newPerson = new UnknownPerson(name);
        }

        personMap.put(name, newPerson);
    }

    public void DisplayJob(String name) {
        var targetPerson = personMap.get(name);

        System.out.println(targetPerson.getJob());
    }

    public void DisplayWeightAvg(List<String> names) {
        var weightSum = 0.0;

        for (var name : names) {
            var person = personMap.get(name);
            weightSum += person.getWeight();
        }

        var roundAvg = Math.round(weightSum / names.size());

        System.out.println(roundAvg);
    }

    public void DisplayWeightSum(List<String> names) {
        var weightSum = 0;

        for (var name : names) {
            var person = personMap.get(name);
            weightSum += person.getWeight();
        }

        System.out.println(weightSum);
    }

    public void DisplayHeightAvg(List<String> names) {
        var heightSum = 0.0;

        for (var name : names) {
            var person = personMap.get(name);
            heightSum += person.getHeight();
        }

        var roundAvg = Math.round(heightSum / names.size());

        System.out.println(roundAvg);
    }

    public void DisplayHeightSum(List<String> names) {
        var heightSum = 0;

        for (var name : names) {
            var person = personMap.get(name);
            heightSum += person.getHeight();
        }

        System.out.println(heightSum);
    }
}
