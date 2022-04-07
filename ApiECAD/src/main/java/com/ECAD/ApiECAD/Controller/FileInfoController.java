/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ECAD.ApiECAD.Controller;

import com.ECAD.ApiECAD.DAOs.FileInfoRepositoryImpl;
import java.util.List;
import com.ECAD.ApiECAD.Model.FileInfo;
import java.util.ArrayList;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ECAD.ApiECAD.Interface.IJpaRepository;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lpela
 */
@RestController
public class FileInfoController {

    private final IJpaRepository repository;

    FileInfoController(IJpaRepository repository) {
        this.repository = repository;
    }

    @Inject
    private FileInfoRepositoryImpl fileDAO;

    @CrossOrigin(origins = "*/*")
    @GetMapping("/filesInfo")
    List<FileInfo> all(
            @RequestBody FileInfo allParams) {
        System.out.println(allParams);
        this.fileDAO = new FileInfoRepositoryImpl();

        List<FileInfo> infos = fileDAO.Select(allParams, repository);
        return infos;
    }

    @GetMapping("/filesInfo/nomes")
    List<String> allNames() {
        List<FileInfo> filesInfo = repository.findAll();
        List<String> names = new ArrayList<>();
        for (FileInfo info : filesInfo) {
            names.add(info.getArquivo());
        }
        return names;
    }

    @GetMapping("filesInfo/bancos")
    List<String> allBancos() {
        List<FileInfo> filesInfo = repository.findAll();
        List<String> bancos = new ArrayList<>();
        for (FileInfo info : filesInfo) {
            if (!bancos.contains(info.getBanco())) {
                bancos.add(info.getBanco());
            }
        }
        return bancos;
    }

    @GetMapping("/download/${id}")
    public byte[] downloadFile(
            @RequestParam Long id) {
        FileInfo file = repository.findById(id).orElse(new FileInfo());
        this.fileDAO = new FileInfoRepositoryImpl();
        return fileDAO.getData(file.getUrl());
    }

}
