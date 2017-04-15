package chapter1;

/**
 * Created by marta on 15.04.17.
 * Pizza extends Dish class. It has an additional Dough field. There are two types of Pizza: VegePizza and MeatPizza.
 */
class PizzaDecorator extends Dish{
    private Dough dough;

    public PizzaDecorator() {
        this.addTopping(Topping.CHEESE);
    }

    @Override
    public float computePrice() {
        return dough.getCost() + getSauce().getCost()
                + computeToppingsCost();
    }
    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }
}

enum Dough{
    WHITE{
        public float getCost(){
            return 20;
        }
    },
    BROWN{
        public float getCost(){
            return 25;
        }
    };
    public abstract float getCost();
}

class MeatPizza extends PizzaDecorator{
    public MeatPizza() {
        super();
        this.setDough(Dough.WHITE);
        this.addSouce(Sauce.BBQ);
        this.addTopping(Topping.HAM);
    }

    @Override
    public String toString() {
        return "MeatPizza";
    }
}

class VegePizza extends PizzaDecorator{
    public VegePizza(){
        super();
        this.setDough(Dough.BROWN);
        this.addSouce(Sauce.CHILLI);
        this.addTopping(Topping.ONION);
    }

    @Override
    public String toString() {
        return "VegePizza";
    }
}
