package repository;

import model.Brand;
import model.Category;
import model.Product;
import model.ProductDetails;

import java.util.List;

public interface ProductRepository {
    //Save Entities
    Product saveProduct(Product product);

    Brand saveBrand(Brand brand);

    Category saveCategory(Category category);

    //Find entities
    List<Product> findProducts();

    List<Product> findProductEntities(Integer firstResult, Integer maxResult); //Part action

    Product findProductById(Integer productId);

    List<ProductDetails> findProductDetails();

    ProductDetails findProductDetailsById(Integer productId);

    List<String> findProductNames(); //Product Names

    List<Object[]> findProductNameAndPrice(); //Product name and prices

    List<Product> findGreatPrice(Integer unitPrice); // > unitPrice

    List<Product> findGreatAndLessPrice(Integer minUnitPrice, Integer maxUnitPrice); //Min Max price

    List<Product> findBetweenPrice(Integer minUnitPrice, Integer maxUnitPrice); //

    List<Product> findLikeProductName(String productName);

    List<Product> findInCategoryName(String categoryName1, String categoryName2);

    List<Product> findAllProduct(Integer categoryId);

    List<Object[]> findFunctionsPrice();

    List<Object[]> findGroupByCategory();

    List<Object[]> findGroupByHavingCategory(Integer unitPrice);

    List<Product> findOrderByPrice();












}




























