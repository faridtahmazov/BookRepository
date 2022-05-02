import model.Brand;
import model.Category;
import model.Product;
import model.ProductDetails;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProductRepository repository = new ProductRepositoryImpl();

    public static void menu(){
        System.out.println(
                "\n-----JPA APP-----" +
                        "\n[1] Find Products" +
                        "\n[2] Find Product Entities" +
                        "\n[3] Find Product By Id" +
                        "\n[4] Find Product Details" +
                        "\n[5] Find Product Details By Id" +
                        "\n[6] Find Product Names" +
                        "\n[7] Find Product Names And Price" +
                        "\n[8] Find Great Price" +
                        "\n[9] Find Great And Less Price" +
                        "\n[10] Find Between Price" +
                        "\n[11] Find Like Product Name" +
                        "\n[12] Find In Category Name" +
                        "\n[13] Find All Product" +
                        "\n[14] Find Function Price" +
                        "\n[15] Find Group By Category" +
                        "\n[16] Find Group By Having Category" +
                        "\n[17] Find Order By Price" +
                        "\n[Any key] Exit"
        );
    }

    public static void main(String[] args) {
        Integer a = 1;

        while (a==1){
            menu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose: ");
            Integer action = scanner.nextInt();
            System.out.println();
            switch (action){
                case 1:
                    findProducts();
                    break;
                case 2:
                    findProductEntities();
                    break;
                case 3:
                    findProductById();
                    break;
                case 4:
                    findProductDetails();
                    break;
                case 5:
                    findProductDetailsById();
                    break;
                case 6:
                    findProductNames();
                    break;
                case 7:
                    findProductNameAndPrice();
                    break;
                case 8:
                    findGreatPrice();
                    break;
                case 9:
                    findGreatAndLessPrice();
                    break;
                case 10:
                    findBetweenPrice();
                    break;
                case 11:
                    findLikeProductName();
                    break;
                case 12:
                    findInCategoryName();
                    break;
                case 13:
                    findAllProduct();
                    break;
                case 14:
                    findFunctionsPrice();
                    break;
                case 15:
                    findGroupByCategory();
                    break;
                case 16:
                    findGroupByHavingCategory();
                    break;
                case 17:
                    findOrderByPrice();
                    break;
                default:
                    a=0;
                    break;
            }
        }


    }

    public static void findProducts(){
        List<Product> productList = repository.findProducts();
        productList.forEach(System.out::println);
    }

    public static void findProductEntities(){
        List<Product> productList = repository.findProductEntities(3, 6);
        productList.forEach(System.out::println);
    }

    public static void findProductById(){
        Product product = repository.findProductById(3);
        System.out.println(product);
    }

    public static void findProductDetails(){
        List<ProductDetails> productDetails = repository.findProductDetails();
        productDetails.forEach(System.out::println);
    }

    public static void findProductDetailsById(){
        ProductDetails productDetails = repository.findProductDetailsById(7);
        System.out.println(productDetails);
    }

    public static void findProductNames(){
        List<String> productNames = repository.findProductNames();
        productNames.forEach(System.out::println);
    }

    public static void findProductNameAndPrice(){
        List<Object[]> productNameAndPrice = repository.findProductNameAndPrice();
        for (Object[] objs: productNameAndPrice) {
            System.out.println(objs[0] + " - " + objs[1]);
        }
    }

    public static void findGreatAndLessPrice(){
        List<Product> productList = repository.findGreatAndLessPrice(1000, 2000);
        productList.forEach(System.out::println);
    }

    public static void findBetweenPrice(){
        List<Product> productList = repository.findBetweenPrice(3000, 4000);
        productList.forEach(System.out::println);
    }

    public static void findGreatPrice(){
        List<Product> productList = repository.findGreatPrice(2000);
        productList.forEach(System.out::println);
    }

    public static void findLikeProductName(){
        List<Product> productList = repository.findLikeProductName("ac");
        productList.forEach(System.out::println);
    }

    public static void findInCategoryName(){
        List<Product> productList = repository.findInCategoryName("COMPUTER", "PHONE");
        productList.forEach(System.out::println);
    }

    public static void findAllProduct(){
        List<Product> productList = repository.findAllProduct(1);
        productList.forEach(System.out::println);
    }

    public static void findOrderByPrice(){
        List<Product> productList = repository.findOrderByPrice();
        productList.forEach(System.out::println);
    }

    public static void findFunctionsPrice(){
        List<Object[]> prices = repository.findFunctionsPrice();
        Object[] objects = prices.get(0);
        System.out.println("AVG: " + objects[0]);
        System.out.println("SUM: " + objects[1]);
        System.out.println("MAX: " + objects[2]);
        System.out.println("MIN: " + objects[3]);
        System.out.println("COUNT: " + objects[4]);
    }

    public static void findGroupByCategory(){
        List<Object[]> productList = repository.findGroupByCategory();
        for (Object[] objs: productList) {
            System.out.println("Category Name: " + objs[0] + "- AVG: " + objs[1]);
        }
    }

    public static void findGroupByHavingCategory(){
        List<Object[]> productList = repository.findGroupByHavingCategory(2500);
        for (Object[] objs: productList) {
            System.out.println("Category Name: " + objs[0] + "- AVG: " + objs[1]);
        }
    }

    public static void insertData(){
        Brand brand1 = new Brand("APPLE");
        Brand brand2 = new Brand("SAMSUNG");
        Brand brand3 = new Brand("ASUS");
        Brand brand4 = new Brand("MICROSOFT");

        Category category1 = new Category("COMPUTER");
        Category category2 = new Category("PHONE");
        Category category3 = new Category("TABLET");

        Product product1 = new Product("Samsung Galaxy Note 9", 1250, 7, category3, brand2, new Date());
        Product product2 = new Product("Asus Tuf Gaming", 2870, 13, category1, brand3, new Date());
        Product product3 = new Product("Iphone 13 pro max", 2800, 3, category2, brand1, new Date());

        Product product4 = new Product("Samsung Z500", 130, 2, category3, brand2, new Date());
        Product product5 = new Product("Mac OS", 3420, 5, category1, brand1, new Date());
        Product product6 = new Product("Iphone 12 pro", 1950, 4, category2, brand1, new Date());

        Product product7 = new Product("Galaxy Tablet", 1100, 8, category3, brand2, new Date());
        Product product8 = new Product("Asus Tuf Gaming", 2870, 13, category1, brand3, new Date());
        Product product9 = new Product("Windows 10", 2250, 18, category1, brand4, new Date());

        repository.saveBrand(brand1);
        repository.saveBrand(brand2);
        repository.saveBrand(brand3);
        repository.saveBrand(brand4);

        repository.saveCategory(category1);
        repository.saveCategory(category2);
        repository.saveCategory(category3);

        repository.saveProduct(product1);
        repository.saveProduct(product2);
        repository.saveProduct(product3);
        repository.saveProduct(product4);
        repository.saveProduct(product5);
        repository.saveProduct(product6);
        repository.saveProduct(product7);
        repository.saveProduct(product8);
        repository.saveProduct(product9);
    }
}
