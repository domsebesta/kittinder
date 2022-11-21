package com.sema.kittinder.controllers;

import com.sema.kittinder.services.KittenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KittenController {

  private final KittenService kittenService;

  @Autowired
  public KittenController(KittenService kittenService){
    this.kittenService = kittenService;
  }

}
