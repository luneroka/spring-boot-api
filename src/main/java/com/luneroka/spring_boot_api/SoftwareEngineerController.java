package com.luneroka.spring_boot_api;

import org.springframework.web.bind.annotation.*;

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

  @PostMapping
  public void createSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
    softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
  }

  @GetMapping("{id}")
  public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
    return softwareEngineerService.getSoftwareEngineerById(id);
  }
}


