package com.glilatech.sms.model.dto;


import com.glilatech.sms.model.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static CompanyDto toDto(Company company){
        return new CompanyDto(
            company.getId(),
            company.getName(),
            company.getCreatedAt(),
            company.getUpdatedAt()
        );
    }


    public Company toEntity(){
        Company company = new Company();
        company.setId(this.getId());
        company.setName(this.getName());
        company.setCreatedAt(this.getCreatedAt());
        company.setUpdatedAt(this.getUpdatedAt());
        return company;
    }
}
