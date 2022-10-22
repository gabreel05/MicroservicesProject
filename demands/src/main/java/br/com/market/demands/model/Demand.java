package br.com.market.demands.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Demand {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private Double price;

    @NonNull
    private Long userId;

    @NonNull
    private Long addressId;

    @NonNull
    private Long productId;
}
