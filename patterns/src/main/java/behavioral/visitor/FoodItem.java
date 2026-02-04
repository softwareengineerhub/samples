package behavioral.visitor;

public class FoodItem extends ShoppingItem {
    public FoodItem(String name, double cost) {
        super(name, cost);
    }

    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}
