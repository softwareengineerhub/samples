package behavioral.visitor;

import java.util.*;

public class ShoppingCart {
    private List<ShoppingItem> items = new ArrayList<>();

    public void addItem(ShoppingItem item) {
        items.add(item);
    }

    public double acceptVisitor(ShoppingCartVisitor visitor) {
        double totalCost = 0;
        for (ShoppingItem item : items) {
            item.accept(visitor);
            totalCost += item.getCost();
        }
        return totalCost;
    }
}
