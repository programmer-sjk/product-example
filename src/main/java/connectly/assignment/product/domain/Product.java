package connectly.assignment.product.domain;

import connectly.assignment.common.BaseEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product extends BaseEntity {
    @Id @GeneratedValue
    private Long id;

    @Comment("상품명")
    @Column(nullable = false)
    private String name;

    @Comment("브랜드명")
    @Column(nullable = false)
    private String brand;

    @Comment("원가")
    @Column(nullable = false)
    private int originPrice;

    @Comment("할인률")
    @ColumnDefault("0")
    private int discountRate;

    @Comment("상품 시리얼 번호")
    @Column(nullable = false)
    private String serial;

    @Comment("상품 상태(신상품, 기존)")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus productStatus;

    @Comment("평점")
    @Column(precision = 2, scale = 1)
    private BigDecimal star = BigDecimal.valueOf(0.0);

    @Comment("원산지")
    @Column(nullable = false)
    private String madeIn;

    @Comment("출고지")
    @Column(nullable = false)
    private String shippingBy;

    @Comment("검색 시 노출 flag")
    @ColumnDefault("true")
    private boolean display;

    @Comment("상품 상세 설명")
    @Lob
    private String detail;

    @Comment("Main, Detail에 나오는 사진")
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImages = new ArrayList<>();

    public Product() {
        this.name = "name";
        this.brand = "name";
        this.originPrice = 10_000;
        this.serial = "aaa";
        this.productStatus = ProductStatus.NORMAL;
        this.madeIn = "CN";
        this.shippingBy = "CN";
    }

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

    public String getSerial() {
        return serial;
    }

    public ProductStatus getProductStatus() {
        return productStatus;
    }

    public BigDecimal getStar() {
        return star;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public String getShippingBy() {
        return shippingBy;
    }

    public boolean isDisplay() {
        return display;
    }

    public String getDetail() {
        return detail;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }
}