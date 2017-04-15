package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by marta on 15.04.17.
 * Simple exercise to learn streams and lambda expressions in Java.
 */
public class Main {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();
        menu.add(new VegePizza());
        menu.add(new MeatPizza());
        menu.add(new Bolognese());
        menu.add(new Carbonara());

        System.out.println("Prizes:");
        for(Dish dish : menu) {
            System.out.println(dish.toString() + ": " + dish.computePrice());
        }

        System.out.println("____________________\nVege dishes: ");
        List<Dish> vegeDishes = filterItems(menu, Dish::isVege);

        for(Dish vege : vegeDishes)
           System.out.println(vege.toString());
        }


    public static <T> List<T> filterItems(List<T> list, Predicate<T> predicate){
        /**
         * Given a list of objects and a predicate, returns a filtered list.
         * Implemented to see the difference between a simple implementation like this and streams.
         */
        List<T> filteredRestultList = new ArrayList<>();
        for (T item: list){
            if(predicate.test(item))
                filteredRestultList.add(item);
        }
        return filteredRestultList;
    }

}
