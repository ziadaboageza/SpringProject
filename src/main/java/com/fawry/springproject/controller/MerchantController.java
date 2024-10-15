package com.fawry.springproject.controller;

import com.fawry.springproject.dto.MerchantDto;
import com.fawry.springproject.entity.Merchant;
import com.fawry.springproject.service.mechant.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping("/{id}")
    public Merchant getMerchantById(@PathVariable Long id) {
        return merchantService.getMerchantById(id);
    }

    @PostMapping
    public Merchant createMerchant(@Valid @RequestBody MerchantDto merchant) {
        return merchantService.createMerchant(merchant);
    }

    @PutMapping("/{id}")
    public Merchant updateMerchant(@PathVariable Long id, @Valid @RequestBody MerchantDto merchant) {
        return merchantService.updateMerchant(id, merchant);
    }

    @DeleteMapping("/{id}")
    public void deleteMerchant(@PathVariable Long id) {
        merchantService.deleteMerchant(id);
    }

}
