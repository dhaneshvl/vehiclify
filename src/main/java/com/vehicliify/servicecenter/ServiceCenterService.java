package com.vehicliify.servicecenter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceCenterService {

    private final ServiceCenterRepository repository;

    public ServiceCenterDTO createServiceCenter(ServiceCenterRequest request) {
        ServiceCenter serviceCenter = new ServiceCenter();
        serviceCenter.setName(request.getName());
        serviceCenter.setAddress(request.getAddress());
        serviceCenter.setDistrict(request.getDistrict());
        serviceCenter.setState(request.getState());
        serviceCenter.setImageUrl(request.getImageUrl());
        serviceCenter.setLatitude(request.getLatitude());
        serviceCenter.setLongitude(request.getLongitude());
        ServiceCenter savedServiceCenter = repository.save(serviceCenter);
        return mapToDTO(savedServiceCenter);
    }

    public ServiceCenterDTO getServiceCenterById(Long id) {
        ServiceCenter serviceCenter = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service center not found with id: " + id));
        return mapToDTO(serviceCenter);
    }

    public List<ServiceCenterDTO> getAllServiceCenters() {
        List<ServiceCenter> serviceCenters = repository.findAll();
        return serviceCenters.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ServiceCenterDTO updateServiceCenter(Long id, ServiceCenterRequest request) {
        ServiceCenter existingServiceCenter = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service center not found with id: " + id));

        existingServiceCenter.setName(request.getName());
        existingServiceCenter.setAddress(request.getAddress());
        existingServiceCenter.setDistrict(request.getDistrict());
        existingServiceCenter.setState(request.getState());
        existingServiceCenter.setImageUrl(request.getImageUrl());
        existingServiceCenter.setLatitude(request.getLatitude());
        existingServiceCenter.setLongitude(request.getLongitude());

        ServiceCenter updatedServiceCenter = repository.save(existingServiceCenter);
        return mapToDTO(updatedServiceCenter);
    }

    private ServiceCenterDTO mapToDTO(ServiceCenter serviceCenter) {
        return new ServiceCenterDTO(
                serviceCenter.getId(),
                serviceCenter.getName(),
                serviceCenter.getAddress(),
                serviceCenter.getDistrict(),
                serviceCenter.getState(),
                serviceCenter.getImageUrl(),
                serviceCenter.getLatitude(),
                serviceCenter.getLongitude()
        );
    }

}
