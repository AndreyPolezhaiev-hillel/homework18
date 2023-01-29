package main.java.com.polezhaiev.homework18;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NotSuitableTypeException {
        Product product1 = new Product("Bok", 74);
        Product product2 = new Product("Book", 100);
        Product product3 = new Product("Book", 253);
        Product product4 = new Product("Book", 35);
        Product product5 = new Product("Book", 255);
        Product product6 = new Product("Bok", 46);
        Product product7 = new Product("Book", 40);
        Product product8 = new Product("Bok", 258);

        ProductService service = new ProductService();

        service.add(product1);
        service.add(product2);
        service.add(product3);
        service.add(product4);
        service.add(product5);
        service.add(product6);
        service.add(product7);
        service.add(product8);

        System.out.println(service.getProducts());
        System.out.println(service.getProductsByDiscount());
        System.out.println(service.getСheapestProductByDiscount());
        System.out.println(service.getСheapestProduct());
        System.out.println(service.getLastThreeProducts());
        System.out.println();
        System.out.println(service.getWholePrice());
        System.out.println();
        System.out.println(service.getGroupedProducts());


    }
}
