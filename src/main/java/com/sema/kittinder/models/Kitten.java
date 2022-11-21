package com.sema.kittinder.models;

import com.sema.kittinder.dtos.KittenDTO;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Kitten {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private LocalDate dateOfBirth;
  private LocalDate addedAt;
  private String description;


  public Kitten(KittenDTO kittenDTO){
    this.name = kittenDTO.getName();
    this.description =kittenDTO.getDescription();
    this.addedAt = LocalDate.now();
    this.dateOfBirth = kittenDTO.getDateOfBirth();
  }
}
