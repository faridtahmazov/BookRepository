package repository;

import jpaFactory.JpaFactory;
import jpaFactoryImpl.JpaFactoryImpl;
import model.Brand;
import model.Category;
import model.Product;
import model.ProductDetails;
import queries.ProductQueries;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{
    private JpaFactory jpaFactory = new JpaFactoryImpl();

    private EntityManager entityManager = jpaFactory.getEntityManager();
    private EntityTransaction transaction = entityManager.getTransaction();


    @Override
    public Product saveProduct(Product product) {
        transaction.begin();
        entityManager.persist(product);
        transaction.commit();

        return product;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        transaction.begin();
        entityManager.persist(brand);
        transaction.commit();

        return brand;
    }

    @Override
    public Category saveCategory(Category category) {
        transaction.begin();
        entityManager.persist(category);
        transaction.commit();

        return category;
    }

    @Override
    public List<Product> findProducts() {
        TypedQuery<Product> query = this.entityManager.createQuery(ProductQueries.findProducts, Product.class);
        List<Product> products = query.getResultList();

        return products;
    }

    @Override
    public List<Product> findProductEntities(Integer firstResult, Integer maxResult) {
        TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findProducts, Product.class);
        typedQuery.setFirstResult(firstResult);
        typedQuery.setMaxResults(maxResult);

        List<Product> products = typedQuery.getResultList();
        return products;
    }

    @Override
    public Product findProductById(Integer productId) {
        TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findProductById, Product.class);
        typedQuery.setParameter("productId", productId);

        Product product = typedQuery.getSingleResult();

        return product;
    }

    @Override
    public List<ProductDetails> findProductDetails() {
        TypedQuery<ProductDetails> typedQuery = this.entityManager.createQuery(ProductQueries.findProductDetails, ProductDetails.class);
        List<ProductDetails> productDetails = typedQuery.getResultList();

        return productDetails;
    }

    @Override
    public ProductDetails findProductDetailsById(Integer productId) {
        TypedQuery<ProductDetails> typedQuery = this.entityManager.createQuery(ProductQueries.findProductDetailsById, ProductDetails.class);
        typedQuery.setParameter("productId", productId);
        ProductDetails productDetails = typedQuery.getSingleResult();

        return productDetails;
    }

    @Override
    public List<String> findProductNames() {
        TypedQuery<String> typedQuery = this.entityManager.createQuery(ProductQueries.findProductNames, String.class);
        List<String> productNames = typedQuery.getResultList();

        return productNames;
    }

    @Override
    public List<Object[]> findProductNameAndPrice() {
        Query query = this.entityManager.createQuery(ProductQueries.findProductNamePrice);
        List<Object[]> productNameAndPrice = query.getResultList();

        return productNameAndPrice;
    }

    @Override
    public List<Product> findGreatPrice(Integer unitPrice) {
        TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findGreatPrice, Product.class);
        typedQuery.setParameter("unitPrice", unitPrice);
        List<Product> productGreatPrice = typedQuery.getResultList();

        return productGreatPrice;
    }

    @Override
    public List<Product> findGreatAndLessPrice(Integer minUnitPrice, Integer maxUnitPrice) {
        TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findGreatLessPrice, Product.class);
        typedQuery.setParameter("minUnitPrice", minUnitPrice);
        typedQuery.setParameter("maxUnitPrice", maxUnitPrice);

        List<Product> productGreatAndLessPrice = typedQuery.getResultList();

        return productGreatAndLessPrice;
    }

    @Override
    public List<Product> findBetweenPrice(Integer minUnitPrice, Integer maxUnitPrice) {
        TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findBetweenPrice, Product.class);
        typedQuery.setParameter("minUnitPrice", minUnitPrice);
        typedQuery.setParameter("maxUnitPrice", maxUnitPrice);

        List<Product> productGreatAndLessPrice = typedQuery.getResultList();

        return productGreatAndLessPrice;
    }

    @Override
    public List<Product> findLikeProductName(String productName) {
        TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findLikeProductName, Product.class);
        typedQuery.setParameter("productName", "%" + productName + "%");

        List<Product> productGreatAndLessPrice = typedQuery.getResultList();

        return productGreatAndLessPrice;
    }

    @Override
    public List<Product> findInCategoryName(String categoryName1, String categoryName2) {
        TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findInCategoryName, Product.class);
        typedQuery.setParameter("categoryName1", categoryName1);
        typedQuery.setParameter("categoryName2", categoryName2);

        List<Product> productGreatAndLessPrice = typedQuery.getResultList();

        return productGreatAndLessPrice;
    }

    @Override
    public List<Product> findAllProduct(Integer categoryId) {
        TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findAllProduct, Product.class);
        typedQuery.setParameter("categoryId", categoryId);

        List<Product> productGreatAndLessPrice = typedQuery.getResultList();

        return productGreatAndLessPrice;
    }

    @Override
    public List<Object[]> findFunctionsPrice() {
       Query query = this.entityManager.createQuery(ProductQueries.findFunctionsPrice);
       List<Object[]> functionPrices = query.getResultList();

       return functionPrices;
    }

    @Override
    public List<Object[]> findGroupByCategory() {
        Query query = this.entityManager.createQuery(ProductQueries.findGroupByCategory);
        List<Object[]> groupByCategory = query.getResultList();

        return groupByCategory;
    }

    @Override
    public List<Object[]> findGroupByHavingCategory(Integer unitPrice) {
        Query query = this.entityManager.createQuery(ProductQueries.findGroupByHavingCategory);
        query.setParameter("unitPrice", unitPrice.doubleValue());
        List<Object[]> groupByHavingCategory = query.getResultList();

        return groupByHavingCategory;
    }

    @Override
    public List<Product> findOrderByPrice() {
        TypedQuery typedQuery = this.entityManager.createQuery(ProductQueries.findOrderByPrice, Product.class);
        List<Product> productList = typedQuery.getResultList();

        return productList;
    }
}
