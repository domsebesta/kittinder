package com.sema.kittinder.services;

import com.sema.kittinder.repositories.KittenRepository;
import org.springframework.stereotype.Service;

@Service
public class KittenServiceImpl  implements KittenService{

  private final KittenRepository kittenRepository;

  public KittenServiceImpl(KittenRepository kittenRepository){
    this.kittenRepository = kittenRepository;
  }

}
