package com.example.testapi.controller;

import com.example.testapi.models.entity.Phones;
import com.example.testapi.models.pojo.PhonesDto;
import com.example.testapi.service.PhonesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/phones")
public class PhonesController {

    private final PhonesService phonesService;

    @GetMapping
    public List<PhonesDto> getAllPhones(){
        return phonesService.getAllPhones();
    }

    @GetMapping("/{id}")
    public PhonesDto getPhoneById(@PathVariable Long id){
        return phonesService.getPhoneById(id);
    }

    @PostMapping
    public void createPhone(@Valid @RequestBody PhonesDto phonesDto){
        phonesService.createPhone(phonesDto);
    }

    @DeleteMapping("/{id}")
    public void deletePhone(@PathVariable Long id){
        phonesService.deletePhone(id);
    }

    @PutMapping("/{id}")
    public void updatePhone(@PathVariable Long id, @Valid @RequestBody PhonesDto updatedDto){
        phonesService.updatePhone(id, updatedDto);
    }

    @PatchMapping("/{id}")
    public void patchPhone(@PathVariable Long id, @Valid @RequestBody PhonesDto updatedDto){
        phonesService.patchPhone(id, updatedDto);
    }
}
