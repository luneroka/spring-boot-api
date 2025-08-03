package com.luneroka.spring_boot_api;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Service
public class SoftwareEngineerService {

  private final SoftwareEngineerRepository softwareEngineerRepository;

  public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
    this.softwareEngineerRepository = softwareEngineerRepository;
  }

  public List<SoftwareEngineer> getAllSoftwareEngineers() {
    return softwareEngineerRepository.findAll();
  }

  public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
    softwareEngineerRepository.save(softwareEngineer);
  }

  public SoftwareEngineer getSoftwareEngineerById(Integer id) {
    return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
  }

  public void deleteSoftwareEngineerById(Integer id) {
    var softwareEngineerToDelete = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    softwareEngineerRepository.deleteById(softwareEngineerToDelete.getId());
  }

  public void updateSoftwareEngineer(Integer id, SoftwareEngineer updatedSoftwareEngineer) {
    SoftwareEngineer softwareEngineerToUpdate = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    softwareEngineerToUpdate.setName(updatedSoftwareEngineer.getName());
    softwareEngineerToUpdate.setTechStack(updatedSoftwareEngineer.getTechStack());
    softwareEngineerRepository.save(softwareEngineerToUpdate);
  }
}
