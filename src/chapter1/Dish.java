package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 * Created by marta on 15.04.17.
 */
public abstract class Dish {
    private Sauce sauce;

    private List<Topping> toppingList;

    Dish() {
        this.toppingList = new ArrayList<>();
    }

    public float computeToppingsCost(){
        /*
         * Computes the final cost of the whole dish.
         * First, we map the stream of toppings to get a stream of Float costs only. Then we use reduce function to get the sum.
         */
        Stream<Topping> myStream = getToppingList().stream();
        Stream<Float> costStream = myStream.map(Topping::getCost);
        return costStream.reduce((float)0, (a,b)-> a + b);
    }

    public boolean isVege(){
        /*
         * Filtering the toppings stream and checking if none were filtered out - this means there are no meat topping items.
         */
        Stream<Topping> toppingStream = getToppingList().stream();
        return toppingStream.filter(Topping::isVege).count() == getToppingList().size();
    }


    public void addTopping(Topping topping){
        getToppingList().add(topping);
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void addSouce(Sauce sauce){
        this.sauce = sauce;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public abstract float computePrice();
}

// ENUMS for Sauce, Topping

enum Sauce {
    CHILLI {
        public float getCost() {
            return 10;
        }
    },
    BBQ {
        public float getCost() {
            return 15;
        }
    },
    TOMATO {
        public float getCost() {
            return 15;
        }
    };
    public abstract float getCost();
}

enum Topping{
    HAM{
        public float getCost(){
            return 40;
        }
        public boolean isVege(){
            return false;
        }
    },
    CHEESE{
        public float getCost(){
            return 30;
        }
        public boolean isVege(){
            return true;
        }
    },
    ONION{
        public float getCost(){
            return 20;
        }
        public boolean isVege(){
            return true;
        }
    },
    MINCED_MEAT{
        public float getCost(){
            return 20;
        }
        public boolean isVege(){
            return false;
        }
    },
    TOMATO{
        public float getCost(){
            return 20;
        }
        public boolean isVege(){
            return true;
        }
    };
    public abstract float getCost();
    public abstract boolean isVege();
}



