package com.vehicliify.servicecenter;

public record ServiceCenterDTO(
        Long id,
        String name,
        String address,
        String district,
        String state,
        String imageUrl,
        Double latitude,
        Double longitude
) {
}
