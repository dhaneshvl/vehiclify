package com.vehicliify.servicecenter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/v1/service-centers")
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class ServiceCenterController {

    private final ServiceCenterService service;

    @PostMapping
    public ResponseEntity<ServiceCenterDTO> createServiceCenter(@RequestBody ServiceCenterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createServiceCenter(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceCenterDTO> getServiceCenterById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getServiceCenterById(id));
    }

    @GetMapping
    public ResponseEntity<List<ServiceCenterDTO>> getAllServiceCenters() {
        return ResponseEntity.ok(service.getAllServiceCenters());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceCenterDTO> updateServiceCenter(@PathVariable Long id, @RequestBody ServiceCenterRequest request) {
        ServiceCenterDTO updatedServiceCenter = service.updateServiceCenter(id, request);
        return ResponseEntity.ok(updatedServiceCenter);
    }
}
