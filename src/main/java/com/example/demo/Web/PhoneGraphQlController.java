package com.example.demo.Web;

import com.example.demo.service.PhoneManager;
import com.example.demo.service.dto.PhoneDto;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PhoneGraphQlController {
    private final PhoneManager phoneManager;

    @QueryMapping
    public List<PhoneDto> getPhoneByModel(String model) {
        return phoneManager.findPhonesByModel(model);
    }

    @QueryMapping
    public List<PhoneDto> getPhoneByModelAndPrice(String model, Float price) {
        return phoneManager.findPhonesByModelAndPrice(model, price);
    }

    @MutationMapping
    public PhoneDto savePhone(PhoneDto phoneDTO) {
        return phoneManager.savePhone(phoneDTO);
    }

    @MutationMapping
    public PhoneDto deletePhone(Long id) {
        return phoneManager.deletePhoneById(id);
    }
}
