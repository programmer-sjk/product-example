package connectly.assignment.product;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
public class ProductImage {
    @Id @GeneratedValue
    private Long id;

    @Comment("상품 이미지 경로")
    private String path;

    @Comment("Main 화면에서 보여줄지, 상품정보 더보기 클릭시 보여주는 타입")
    @Enumerated(EnumType.STRING)
    private ProductImageType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
