package cc.lz.elasticsearchdata.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@Document(indexName = "hotel")
public class HotelDoc {
    @Field(type = FieldType.Keyword)
    private Long id;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", copyTo = "all")
    private String name;

    @Field(type = FieldType.Keyword)
    private String address;

    @Field(type = FieldType.Float)
    private Integer price;

    @Field(type = FieldType.Float)
    private Integer score;

    @Field(type = FieldType.Keyword, copyTo = "all")
    private String brand;

    @Field(type = FieldType.Keyword, copyTo = "all")
    private String city;

    @Field(type = FieldType.Keyword)
    private String starName;

    @Field(type = FieldType.Text)
    private String business;

    @Field(type = FieldType.Keyword, index = false)
    private String location;

    @Field(type = FieldType.Keyword, index = false)
    private String pic;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String all;  // Ensure that this field exists for 'copy_to' to work

    public HotelDoc(Hotel hotel) {
        this.id = hotel.getId();
        this.name = hotel.getName();
        this.address = hotel.getAddress();
        this.price = hotel.getPrice();
        this.score = hotel.getScore();
        this.brand = hotel.getBrand();
        this.city = hotel.getCity();
        this.starName = hotel.getStarName();
        this.business = hotel.getBusiness();
        this.location = hotel.getLatitude() + ", " + hotel.getLongitude();
        this.pic = hotel.getPic();
    }
}
