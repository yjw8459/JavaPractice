package Generic;

import vo.ChildProduct;
import vo.Storage;
import vo.StorageImpl;
import vo.Tv;

public class GenericExtends {
    public static void main(String[] args) {
        ChildProduct<Tv, String, String> product = new ChildProduct<>();
        product.setKind(new Tv());
        product.setModel("Smart TV");
        product.setCompany("LG");

        Storage<Tv> storage = new StorageImpl<>(100);
        storage.add(new Tv(), 0);
        Tv tv = storage.get(0);
    }
}
