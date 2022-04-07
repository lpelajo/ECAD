/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ECAD.ApiECAD.Config;

import com.ECAD.ApiECAD.Model.FileInfo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ECAD.ApiECAD.Interface.IJpaRepository;

/**
 *
 * @author lpela
 */
@Configuration
public class PreLoadData {
    @Bean
  CommandLineRunner initDatabase(IJpaRepository repository) {

    return args -> {
      repository.save(new FileInfo("Bradesco","RET","CB120800.RET","12/08/2020","RRCUNHA","12/08/2020",508,19,110266.19,"url"));
      repository.save(new FileInfo("Bradesco","RET","CB120801.RET","12/08/2020","RRCUNHA","12/08/2020",320,9,100598.46,"url"));
      repository.save(new FileInfo("Bradesco","RET","CB120802.RET","12/08/2020","RRCUNHA","12/08/2020",8,6,34975.77,"url"));
      repository.save(new FileInfo("Bradesco","RET","CB120803.RET","12/08/2020","RRCUNHA","12/08/2020",603,26,139881.24,"url"));
      repository.save(new FileInfo("Bradesco","REM","CB120801.REM","12/08/2020","MMORAIS","12/08/2020",286,9,208924.55,"url"));
      repository.save(new FileInfo("Bradesco","REM","CB120802.REM","12/08/2020","MMORAIS","12/08/2020",15,19,6260.43,"url"));
    };
  }
}