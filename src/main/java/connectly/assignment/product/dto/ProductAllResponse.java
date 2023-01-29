package connectly.assignment.product.dto;

import connectly.assignment.product.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductAllResponse {
    private Long id;
    private String name;
    private String brand;
    private int originPrice;
    private int discountRate;
    private List<ProductImageResponse> productImages;

    public ProductAllResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.brand = product.getBrand();
        this.originPrice = product.getOriginPrice();
        this.discountRate = product.getDiscountRate();
        this.productImages = product.getProductImages()
                .stream()
                .map(ProductImageResponse::new)
                .collect(Collectors.toList());
    }

    protected ProductAllResponse() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public List<ProductImageResponse> getProductImages() {
        return productImages;
    }
}