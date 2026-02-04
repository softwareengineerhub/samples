package behavioral.visitor;

public class ClothingItem extends ShoppingItem {
    public ClothingItem(String name, double cost) {
        super(name, cost);
    }

    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}
