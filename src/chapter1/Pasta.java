package chapter1;

/**
 * Created by marta on 15.04.17.
 * Pasta extends Dish class. It has an additional pastaType field. There are two types of Pasta: Spaghetti and Carbonara.
 */
public class Pasta extends Dish {
    private PastaType pastaType;

    @Override
    public float computePrice() {
        return pastaType.getCost() + getSauce().getCost() +
                computeToppingsCost();
    }

    public void setPastaType(PastaType pastaType) {
        this.pastaType = pastaType;
    }
}
enum PastaType{
    SPAGHETTI{
        public float getCost(){
            return 30;
        }
    },
    TAGIATELLE{
        public float getCost(){
            return 40;
        }
    };
    public abstract float getCost();
}

class Bolognese extends Pasta{
    public Bolognese() {
        this.setPastaType(PastaType.SPAGHETTI);
        this.addSouce(Sauce.TOMATO);
        this.addTopping(Topping.MINCED_MEAT);
        this.addTopping(Topping.TOMATO);
    }

    @Override
    public String toString() {
        return "BolognesePasta";
    }
}

class Carbonara extends Pasta{
    public Carbonara() {
        this.setPastaType(PastaType.TAGIATELLE);
        this.addSouce(Sauce.CHILLI);
        this.addTopping(Topping.HAM);
        this.addTopping(Topping.ONION);
        this.addTopping(Topping.CHEESE);
    }
    @Override
    public String toString() {
        return "CarbonaraPasta";
    }
}

