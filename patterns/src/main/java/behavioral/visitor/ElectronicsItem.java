package behavioral.visitor;

public class ElectronicsItem extends ShoppingItem {
    public ElectronicsItem(String name, double cost) {
        super(name, cost);
    }

    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}
