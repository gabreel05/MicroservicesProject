package br.com.vehicles.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String board;

    @NonNull
    private Long userId;
}
