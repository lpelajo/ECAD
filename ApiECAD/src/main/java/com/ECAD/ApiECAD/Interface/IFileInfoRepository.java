/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ECAD.ApiECAD.Interface;

import com.ECAD.ApiECAD.Model.FileInfo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author lpela
 */
public interface IFileInfoRepository {

    /**
     *
     * @param geradoPor
     * @param tipo
     * @param dtIni
     * @param dtFim
     * @param banco
     * @param arquivo
     * @param repository
     * @return
     */
    public List<FileInfo> Select(FileInfo fileinfo,IJpaRepository repository);
    
    public byte[] getData(String path);
}
