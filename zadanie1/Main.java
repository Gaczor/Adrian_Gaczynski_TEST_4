package zadanie1;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();
        wardrobe.addClothes(new Clothes("Shirt", 38, 99.99));
        wardrobe.addClothes(new Clothes("Trousers", 32, 199.99), new Clothes("Socks", 36, 29.99));
        wardrobe.addClothes(new Clothes("Jacket", 44, 499.99), new Clothes("T-Shirt", 28, 19.99), new Clothes("Skirt", 40, 899.99));

        for (Clothes c : wardrobe) {
            System.out.println(c.getName() + ", rozmiar " + c.getSize() + ", cena " + c.getPrice());
        }

        Clothes.setSortingCriterion(Criterion.PRICE);
        System.out.println("\nThe most expensive clothes is: " + (Collections.max(wardrobe.getClothes()).getName()));
        Clothes.setSortingCriterion(Criterion.SIZE);
        System.out.println("The biggest clothes is: " + (Collections.max(wardrobe.getClothes())).getName());


    }
}
