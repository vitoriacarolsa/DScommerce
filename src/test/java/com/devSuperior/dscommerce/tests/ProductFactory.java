package com.devSuperior.dscommerce.tests;

import com.devSuperior.dscommerce.entities.Category;
import com.devSuperior.dscommerce.entities.Product;

public class ProductFactory {

    public static Product createProduct() {
        Category category = CategoryFactory.createCategory();
        Product product = new Product(1L, "Console", "Descrição do Produto", 399.0, "https://urlProducts" );
        product.getCategories() .add(category);
        return product;
    }

    public static Product createProduct(String name){
        Product product = createProduct();
        product.setName(name);
        return product;
    }

}
