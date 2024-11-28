package cc.lz.elasticsearchdata.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_hotel")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Integer price;
    private Integer score;
    private String brand;
    private String city;
    private String starName;
    private String business;
    private String longitude;
    private String latitude;
    private String pic;
}
