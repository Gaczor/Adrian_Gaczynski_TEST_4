package ZADANIE1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Wardrobe implements Iterable<Clothes> {
    private List<Clothes> clothes;

    public Wardrobe() {
            clothes = new ArrayList<>();
    }

    public List<Clothes> getClothes() {
        return clothes;
    }

    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }

    public void addClothes(Clothes... newClothes) {
        Collections.addAll(clothes, newClothes);
    }

    @Override
    public Iterator<Clothes> iterator() {
        return clothes.iterator();
    }
}
