package behavioral.visitor;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new ElectronicsItem("Laptop", 1200.00));
        cart.addItem(new ClothingItem("Shirt", 30.00));
        cart.addItem(new FoodItem("Apples", 2.50));

        ShoppingCartVisitor costCalculator = new CostCalculatorShoppingCartVisitor();
        double totalCost = cart.acceptVisitor(costCalculator);

        System.out.println("Total cost of shopping cart: " + totalCost);
    }
}
