package connectly.assignment.fixture;

import connectly.assignment.product.domain.Product;
import connectly.assignment.product.dto.ProductRequest;
import connectly.assignment.product.dto.ProductUpdateRequest;

public class ProductFactory {
    private ProductFactory() {}

    public static Product create(String name) {
        return new Product.Builder()
                .name(name)
                .brand("루이비통")
                .originPrice(10_000)
                .discountRate(0)
                .serial("serial")
                .productStatus("NEW")
                .madeIn("CHINA")
                .shippingBy("CHINA")
                .display(true)
                .detail("detail")
                .build();
    }

    public static ProductRequest createRequest(String name) {
        return new ProductRequest.Builder()
                .name(name)
                .brand("루이비통")
                .originPrice(10_000)
                .discountRate(0)
                .serial("serial")
                .productStatus("NEW")
                .madeIn("CHINA")
                .shippingBy("CHINA")
                .display(true)
                .detail("detail")
                .build();
    }

    public static ProductUpdateRequest createUpdateRequest(String name) {
        return new ProductUpdateRequest.Builder()
                .name(name)
                .brand("루이비통")
                .originPrice(10_000)
                .discountRate(0)
                .productStatus("NEW")
                .madeIn("CHINA")
                .shippingBy("CHINA")
                .display(true)
                .build();
    }
}