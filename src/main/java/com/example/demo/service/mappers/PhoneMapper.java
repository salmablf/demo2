package com.example.demo.service.mappers;

import com.example.demo.Dao.Entities.Phone;
import com.example.demo.service.dto.PhoneDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public PhoneDto toDTO(Phone phone) {
        return modelMapper.map(phone, PhoneDto.class);
    }

    public Phone toEntity(PhoneDto phoneDTO) {
        return modelMapper.map(phoneDTO, Phone.class);
    }}
