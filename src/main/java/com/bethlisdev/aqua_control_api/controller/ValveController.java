package com.bethlisdev.aqua_control_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bethlisdev.aqua_control_api.dto.ValveDto;
import com.bethlisdev.aqua_control_api.service.ValveService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aquacontrol/api/v1/valve")
public class ValveController {

    private final ValveService valveService;

    @PostMapping(path = "/createValve")
    public String setValve(@Valid @RequestBody ValveDto valveDto) {
        return valveService.setValve(valveDto);
    }
}
