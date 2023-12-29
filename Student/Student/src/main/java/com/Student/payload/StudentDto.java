package com.Student.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private long Id = 0;

    @NotEmpty
    @Size(min = 3, max = 8, message = "Add tha more then 3 charter")
    private String name;

    @NotEmpty
    @Size(min = 3, max = 5, message = "Add tha more then 3 charter")
    private String surname;

    @NotEmpty
    @Size(min = 3, max = 5, message = "Add tha more then 3 charter")
    private String city;



}
