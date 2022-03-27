package com.mock.flight.services.Imp;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.Certificate;
import com.mock.flight.model.MockProjectResponse;

public interface CertificateServiceImp {
    MockProjectResponse getAllCertificate();

    void createCertificate(Certificate certificate) throws MockProjectException;

    void updateCertificate(Certificate certificate, Long id) throws MockProjectException;

    void deleteCertificate(Long id) throws MockProjectException;
}
