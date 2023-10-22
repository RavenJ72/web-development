package web.development.models.entities;

import jakarta.persistence.*;
import web.development.models.baseEntities.TimeBaseEntity;
import web.development.models.converters.EngineTypeConverter;
import web.development.models.converters.TransmissionTypeConverter;
import web.development.models.enums.EngineType;
import web.development.models.enums.TransmissionType;


import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends TimeBaseEntity {

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Convert(converter = EngineTypeConverter.class)
    @Column(name = "engine", length = 11, nullable = false)
    private EngineType engine;

    @Column(name = "imageUrl", length = 512, nullable = false)
    private String imageUrl;

    @Column(name = "mileage", length = 11, nullable = false)
    private Integer mileage;

    @Column(name = "price", columnDefinition = "numeric(19,2)", nullable = false)
    private BigDecimal price;

    @Convert(converter = TransmissionTypeConverter.class)
    @Column(name = "transmission", length = 11, nullable = false)
    private TransmissionType transmission;

    @Column(name = "year", length = 11, nullable = false)
    private Integer year;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private User seller;

    public Offer() {
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
