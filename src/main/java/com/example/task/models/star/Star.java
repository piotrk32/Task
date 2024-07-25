package com.example.task.models.star;


import com.example.task.models.basic.BasicEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;



@Entity
@Table(name = "stars")
@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Star extends BasicEntity {

    @Column(name = "star_name")
    @Schema(description = "Name of the star", example = "Proxima Centauri")
    String starName;

    @Column(name = "distance")
    @Schema(description = "Distance of the star from the sun in light-years", example = "4.24")
    Long distance;

    public Star(String starName, Long distance) {
        this.starName = starName;
        this.distance = distance;
    }
}
