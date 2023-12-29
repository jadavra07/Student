package com.Student.Config.Swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Jadav",
                        email = "jadav@gmail.com",
                        url = "https://jadav.com"
                ),
                description = "OpenApi documentation for spring Security",
                title = "Jadavra",
                version = "3.0",
                license = @License(
                        name = "licence name",
                        url = "https://licence.com"
                ),
                termsOfService = "term of service"
        )

)
public class OpenApiConfig {
}
