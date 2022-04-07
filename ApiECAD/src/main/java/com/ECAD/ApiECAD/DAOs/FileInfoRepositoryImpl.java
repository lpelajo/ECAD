/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ECAD.ApiECAD.DAOs;

import com.ECAD.ApiECAD.Interface.IFileInfoRepository;
import com.ECAD.ApiECAD.Interface.IJpaRepository;
import com.ECAD.ApiECAD.Model.FileInfo;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lpela
 */
@Repository
public class FileInfoRepositoryImpl implements IFileInfoRepository {

    @Override
    public List<FileInfo> Select(FileInfo fileInfo, IJpaRepository repository) {
        List<FileInfo> retorno = repository.findAll();
        try {
            return selectFilter(retorno, fileInfo);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return retorno;
        }
    }

    private List<FileInfo> selectFilter(List<FileInfo> files, FileInfo fileInfo) throws Exception {
        String geradoPor = fileInfo.getGeradoPor();
        String tipo = fileInfo.getTipo();
        String dtEnvio = fileInfo.getDtEnvio();
        String dtGeracao = fileInfo.getDtGeracao();
        String banco = fileInfo.getBanco();
        String arquivo = fileInfo.getArquivo();
        
        System.out.println(geradoPor + "," + tipo + "," + dtEnvio + "," + dtGeracao + "," + banco + "," + arquivo);
        
        if ((geradoPor != null && !geradoPor.equals(""))
                || (tipo != null && !tipo.equals("") && !tipo.toUpperCase().equals("TODOS"))
                || (dtEnvio != null && !dtEnvio.equals(""))
                || (dtGeracao != null && !dtGeracao.equals(""))
                || (banco != null && !banco.equals("") && !banco.toUpperCase().equals("TODOS"))
                || (arquivo != null && !arquivo.equals("") && !arquivo.toUpperCase().equals("TODOS"))) {
            Boolean success = true;
            int i;
            if (geradoPor != null && !geradoPor.equals("")) {
                for (i = 0; i < files.size(); i++) {
                    if (!files.get(i).getGeradoPor().equals(geradoPor)) {
                        success = success && files.remove(files.get(i));
                        i--;
                    }
                }
            }
            if (tipo != null && !tipo.equals("") && !tipo.toUpperCase().equals("TODOS")) {
                if (tipo.toUpperCase().equals("REMESSA")) {
                    tipo = "REM";
                } else if (tipo.toUpperCase().equals("RETORNO")) {
                    tipo = "RET";
                }
                for (i = 0; i < files.size(); i++) {
                    if (!files.get(i).getTipo().equals(tipo)) {
                        success = success && files.remove(files.get(i));
                        i--;
                    }
                }
            }
            if (dtEnvio != null && !dtEnvio.equals("")) {
                for (i = 0; i < files.size(); i++) {
                    if (!files.get(i).getDtEnvio().equals(dtEnvio)) {
                        success = success && files.remove(files.get(i));
                        i--;
                    }
                }
            }
            if (dtGeracao != null && !dtGeracao.equals("")) {
                for (i = 0; i < files.size(); i++) {
                    if (!files.get(i).getDtGeracao().equals(dtGeracao)) {
                        success = success && files.remove(files.get(i));
                        i--;
                    }
                }
            }
            if (banco != null && !banco.equals("") && !banco.toUpperCase().equals("TODOS")) {
                for (i = 0; i < files.size(); i++) {
                    if (!files.get(i).getBanco().equals(banco)) {
                        success = success && files.remove(files.get(i));
                        i--;
                    }
                }
            }
            if (arquivo != null && !arquivo.equals("") && !arquivo.toUpperCase().equals("TODOS")) {
                for (i = 0; i < files.size(); i++) {
                    if (!files.get(i).getArquivo().equals(arquivo)) {
                        success = success && files.remove(files.get(i));
                        i--;
                    }
                }
            }
            if (success == false) {
                throw new Exception("Failed to filter");
            }
        }
        return files;
    }

    @Override
    public byte[] getData(String url) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
