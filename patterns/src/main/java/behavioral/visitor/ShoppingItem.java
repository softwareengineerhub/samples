package behavioral.visitor;

public abstract class ShoppingItem {
    private String name;
    private double cost;

    public ShoppingItem(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public abstract void accept(ShoppingCartVisitor visitor);
}
