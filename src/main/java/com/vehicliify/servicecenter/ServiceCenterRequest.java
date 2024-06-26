package com.vehicliify.servicecenter;

import lombok.Data;

@Data
public class ServiceCenterRequest {
    private String name;
    private String address;
    private String district;
    private String state;
    private String imageUrl;
    private Double latitude;
    private Double longitude;
}
