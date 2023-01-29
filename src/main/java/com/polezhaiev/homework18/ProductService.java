package main.java.com.polezhaiev.homework18;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products = new ArrayList<>();
    private List <Product> productsByDiscount = new ArrayList<>();


    public void add(Product product){
        products.add(product);
        product.setDate(new Date());
        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        product.setCalendar(calendar);
    }

    public List<Product> getProducts(){
        if(products == null || products.size() == 0){
            System.out.println("No products");
            return null;
        }

        return products.stream()
                .filter(product -> product.getType().equalsIgnoreCase("Book") && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public List<Product> getProductsByDiscount() throws NotSuitableTypeException {
        if(products == null || products.size() == 0){
            System.out.println("No products");
            return null;
        }
        products.stream()
                .filter(product -> product.getType().equalsIgnoreCase("Book") && product.getPrice() > 250)
                .peek(product -> productsByDiscount.add(new Product(product.getType(), (int)(product.getPrice() - (product.getDiscount() * product.getPrice())))))
                .collect(Collectors.toList());

        if(productsByDiscount == null || productsByDiscount.size() == 0){
            throw new NotSuitableTypeException("Book");

        } else {
            return productsByDiscount;

        }
    }

    public Product getСheapestProduct() throws NotSuitableTypeException {
        if(products == null || products.size() == 0){
            System.out.println("No products");
            return null;
        }

        try {
            Optional<Product> optMin = products.stream()
                    .filter(product -> product.getType().equalsIgnoreCase("Book"))
                    .min((o1, o2) -> o1.compareTo(o2));

            return optMin.get();

        } catch (NoSuchElementException e){
            throw new NotSuitableTypeException("Book");

        }
    }

    public Product getСheapestProductByDiscount() throws NotSuitableTypeException {
        if(products == null || products.size() == 0){
            System.out.println("No products");
            return null;
        }

        try {
            Optional<Product> optMin = productsByDiscount.stream()
                    .filter(product -> product.getType().equalsIgnoreCase("Book"))
                    .min((o1, o2) -> o1.compareTo(o2));

            return optMin.get();

        } catch (NoSuchElementException e){
            throw new NotSuitableTypeException("Book");

        }
    }

    public List<Product> getLastThreeProducts(){
        if(products == null || products.size() == 0){
            System.out.println("No products");
            return null;
        }

        if(products.size() <= 3){
            return products;
        }

        return products.stream()
                .skip(products.size() - 3)
                .collect(Collectors.toList());
    }

    public long getWholePrice(){
        if(products == null || products.size() == 0){
            System.out.println("No products");
            return 0;
        }

        java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
        calendar.setTime(new java.util.Date());
        int currentYear = calendar.get(java.util.Calendar.YEAR);

        return products.stream()
                .filter(product -> product.getCalendar().get(java.util.Calendar.YEAR) == currentYear)
                .filter(product -> product.getType().equalsIgnoreCase("Book"))
                .filter(product -> product.getPrice() < 75)
                .reduce(0L, (acc, prod) -> acc + prod.getPrice(), (c1, c2) -> c1 + c2);
    }

    public Map<String, List<Product>> getGroupedProducts(){
        if(products == null || products.size() == 0){
            System.out.println("No products");
            return null;
        }

        return products.stream()
                .collect(Collectors.groupingBy(Product::getType, Collectors.toList()));

    }

}
