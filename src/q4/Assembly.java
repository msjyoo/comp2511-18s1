package q4;

import java.util.Collection;

class Assembly implements Component
{
    private Collection<Component> components;

    boolean addComponent(Component c) {
        return components.add(c);
    }

    boolean removeComponent(Component c) {
        return components.remove(c);
    }

    @Override
    public int getPrice() {
        return components.stream().mapToInt(Component::getPrice).sum();
    }
}
