import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MySystem {
    private final List<Component> components = new LinkedList<>();
    private final Stack<LargerComponent> groupStack = new Stack<>();

    public void addLine() {
        if (groupStack.isEmpty()) {
            components.add(new Line());
        } else {
            groupStack.peek().addComponent(new Line());
        }
    }

    public void addText() {
        if (groupStack.isEmpty()) {
            components.add(new Text());
        } else {
            groupStack.peek().addComponent(new Text());
        }
    }

    public void addRectangle() {
        if (groupStack.isEmpty()) {
            components.add(new Rectangle());
        } else {
            groupStack.peek().addComponent(new Rectangle());
        }
    }

    public void addEmptyGroup() {
        if (groupStack.isEmpty()) {
            components.add(new LargerComponent());
        } else {
            groupStack.peek().addComponent(new LargerComponent());
        }
    }

    public void startAddGroup() {
        groupStack.push(new LargerComponent());
    }

    public void endAddGroup() {
        var group = groupStack.pop();
        if (groupStack.isEmpty()) {
            components.add(group);
        } else {
            groupStack.peek().addComponent(group);
        }
    }

    public void draw() {
        for (var component : components) {
            component.draw();
            System.out.println();
        }
    }
}
