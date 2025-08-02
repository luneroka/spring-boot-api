package com.luneroka.spring_boot_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

  private final SoftwareEngineerService softwareEngineerService;

  public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
    this.softwareEngineerService = softwareEngineerService;
  }

  @GetMapping
  public List<SoftwareEngineer> getSoftwareEngineers() {
    return softwareEngineerService.getAllSoftwareEngineers();
  }
}

