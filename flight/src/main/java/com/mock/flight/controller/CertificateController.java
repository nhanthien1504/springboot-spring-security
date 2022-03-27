package com.mock.flight.controller;

import com.mock.flight.exception.MockProjectException;
import com.mock.flight.model.Certificate;
import com.mock.flight.model.MockProjectResponse;
import com.mock.flight.services.CertificateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateServices certificateServices;

    @GetMapping("/find")
    public MockProjectResponse getCertificateAll() {
        return certificateServices.getAllCertificate();
    }


    @PutMapping("/update")
    public void updateCertificate(@RequestBody Certificate certificate, @RequestParam("id") Long idCertificate) throws MockProjectException {
        certificateServices.updateCertificate(certificate, idCertificate);
    }

    @PostMapping("/create")
    public void createCertificate(@RequestBody Certificate certificate) throws MockProjectException {
        certificateServices.createCertificate(certificate);
    }

    @DeleteMapping("/delete")
    public void deleteCertificate(@RequestParam("id") Long idCertificate) throws MockProjectException {
        certificateServices.deleteCertificate(idCertificate);
    }

}
