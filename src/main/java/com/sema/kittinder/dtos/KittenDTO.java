package com.sema.kittinder.dtos;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KittenDTO {
  @NotNull
  @NotEmpty
  @Size(min=4)
  private String name;

  @NotNull
  @NotEmpty
  @Size(min=20)
  private String description;

  @NotNull
  private LocalDate dateOfBirth;

  public KittenDTO(String name, String description, LocalDate dateOfBirth){
    this.name = name;
    this.description = description;
    this.dateOfBirth = dateOfBirth;
  }
}
