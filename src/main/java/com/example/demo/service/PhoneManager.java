package com.example.demo.service;

import com.example.demo.service.dto.PhoneDto;

import java.util.List;

public interface PhoneManager  {
    List<PhoneDto> findPhonesByModel(String model);
    List<PhoneDto> findPhonesByModelAndPrice(String model, Float price);
    PhoneDto savePhone(PhoneDto phoneDTO);
    PhoneDto deletePhoneById(Long id);


    void deletePhone(Long id);

    List<PhoneDto> getPhonesByModel(String model);

    List<PhoneDto> getPhoneByModelAndPrice(String model, float price);
}
