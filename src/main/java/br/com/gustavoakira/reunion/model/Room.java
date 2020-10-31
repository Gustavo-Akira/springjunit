package br.com.gustavoakira.reunion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "date", nullable = false)
    private String date;

    @NotEmpty
    @Column(name = "startHour", nullable = false)
    private String startHour;

    @NotEmpty
    @Column(name = "endHour",nullable = false)
    private String endHour;


}
