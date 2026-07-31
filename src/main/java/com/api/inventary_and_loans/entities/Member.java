package com.api.inventary_and_loans.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Firstname is obligatory and it must not be blank.")
    private String firstName;

    @NotBlank(message = "Lastname is obligatory and it must not be blank.")
    private String lastName;

    @NotBlank(message = "DNI is obligatory.")
    @Size(min = 9, max = 9, message = "DNI must have 9 characters.")
    private String nationalId; // For DNI

    @Column(unique = true)
    @NotNull(message = "Member number could not be null.")
    private Integer memberNumber;
}
