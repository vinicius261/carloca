package br.com.carloca.models;

import br.com.carloca.enums.CarColors;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private CarVersion carVersion;
    @Column(name = "car_color")
    private CarColors carColor;
    @Column(name = "in_use")
    private boolean inUSe;
    private Integer odometer;

    public Car(String name, CarVersion carVersion, CarColors carColor, boolean inUSe, Integer odometer) {
        this.name = name;
        this.carVersion = carVersion;
        this.carColor = carColor;
        this.inUSe = inUSe;
        this.odometer = odometer;
    }

}
