package com.example.demo.service;

import com.example.demo.Dao.Entities.Phone;
import com.example.demo.Dao.repositories.PhoneRepository;
import com.example.demo.service.dto.PhoneDto;
import com.example.demo.service.mappers.PhoneMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public  class PhoneManagerAction implements PhoneManager {
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Override
    public List<PhoneDto> findPhonesByModel(String model) {
        return phoneRepository.findByModel(model)
                .stream().map(phoneMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<PhoneDto> findPhonesByModelAndPrice(String model, Float price) {
        return phoneRepository.findByModelAndPrice(model, price)
                .stream().map(phoneMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public PhoneDto savePhone(PhoneDto phoneDTO) {
        if (phoneRepository.existsByIMEI(phoneDTO.getIMEI())) {
            throw new IllegalArgumentException("Phone with this IMEI already exists!");
        }
        Phone phone = phoneMapper.toEntity(phoneDTO);
        return phoneMapper.toDTO(phoneRepository.save(phone));
    }

    @Override
    public PhoneDto deletePhoneById(Long id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Phone not found!"));
        phoneRepository.delete(phone);
        return phoneMapper.toDTO(phone);
    }

    @Override
    public void deletePhone(Long id) {

    }

    @Override
    public List<PhoneDto> getPhonesByModel(String model) {
        return null;
    }

    @Override
    public List<PhoneDto> getPhoneByModelAndPrice(String model, float price) {
        return null;
    }
}