package behavioral.visitor;

public interface ShoppingCartVisitor {

    void visit(ElectronicsItem item);
    void visit(ClothingItem item);
    void visit(FoodItem item);
}
