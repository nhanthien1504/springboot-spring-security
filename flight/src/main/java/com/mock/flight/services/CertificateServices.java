package com.mock.flight.services;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.Certificate;
import com.mock.flight.model.MockProjectResponse;
import com.mock.flight.repository.CertificateRepository;
import com.mock.flight.services.Imp.CertificateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateServices implements CertificateServiceImp {

    @Autowired
    private CertificateRepository certificateRepository;


    @Override
    public MockProjectResponse getAllCertificate() {
        MockProjectResponse response = new MockProjectResponse();
        response.setData(certificateRepository.findAll());
        return response;
    }

    @Override
    public void createCertificate(Certificate certificate) throws MockProjectException {
        validateCertificate(certificate);
        Certificate fromDB = new Certificate();
        fromDB.setId(certificate.getId());
        fromDB.setAirplaneCode(certificate.getAirplaneCode());
        fromDB.setStaffCode(certificate.getStaffCode());
        certificateRepository.save(certificate);
    }

    @Override
    public void updateCertificate(Certificate certificate, Long id) throws MockProjectException {
        validateCertificate(certificate);
        Optional<Certificate> certificateId = certificateRepository.findById(id);
        if (certificateId.isPresent()) {
            validateCertificate(certificate);
            Certificate fromDB = new Certificate();
            fromDB.setId(certificate.getId());
            fromDB.setAirplaneCode(certificate.getAirplaneCode());
            fromDB.setStaffCode(certificate.getStaffCode());
            certificateRepository.saveAndFlush(certificate);
        } else {
            throw new MockProjectException("Id of Certificate was present");
        }
    }

    @Override
    public void deleteCertificate(Long id) throws MockProjectException {
        Optional<Certificate> certificateId = certificateRepository.findById(id);
        if (certificateId.isPresent()) {
            certificateRepository.deleteById(id);
        } else {
            throw new MockProjectException("You can not delete with this id");
        }
    }

    private void validateCertificate(Certificate certificate) throws MockProjectException {
        if (certificate.getAirplaneCode() == null) {
            throw new MockProjectException("You can not get air plane code equal null");
        }
        if (certificate.getStaffCode() == null) {
            throw new MockProjectException("You can not get Staff code equal null");
        }
    }
}
