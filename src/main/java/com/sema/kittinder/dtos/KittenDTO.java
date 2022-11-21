package com.sema.kittinder.dtos;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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


}
