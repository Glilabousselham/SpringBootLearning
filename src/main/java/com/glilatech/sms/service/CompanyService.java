package com.glilatech.sms.service;

import com.glilatech.sms.model.dto.CompanyDto;
import com.glilatech.sms.model.entity.Company;
import com.glilatech.sms.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream().map(CompanyDto::toDto).collect(Collectors.toList());
    }

    public Company getCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }

    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company =  companyRepository.save(companyDto.toEntity());

        return CompanyDto.toDto(company);
    }

    public Company updateCompany(Long id, Company companyDetails) {
        Optional<Company> companyOpt = companyRepository.findById(id);
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            company.setName(companyDetails.getName());
            return companyRepository.save(company);
        }
        return null;
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
