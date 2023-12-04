package com.backend.microservices.blogservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Setter @Getter @ToString
@Document
public class Blog {
    @Id
    private String blogId;
    @NotEmpty
    private String title;
    @NotEmpty
    private String body;
    @NotEmpty
    private Date dateOfCreation;
    @NotEmpty(message = "date Should not be null")
    private Date dateOfPublish;
    @NotEmpty
    private Date lastUpdateDate;
}
