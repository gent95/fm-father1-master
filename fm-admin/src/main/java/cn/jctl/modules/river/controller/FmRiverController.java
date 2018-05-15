package cn.jctl.modules.river.controller;

import cn.jctl.common.utils.R;
import cn.jctl.modules.node.entity.FmNodeEntity;
import cn.jctl.modules.river.entity.FmRiverEntity;
import cn.jctl.modules.river.service.FmRiverService;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author ${user}
 * @ClassName ${type_name}
 * @date ${date}
 */
@RestController
@RequestMapping("modules/river")
public class FmRiverController {
    @Autowired
    private FmRiverService fmRiverService;

    @RequestMapping("/list")
    public List<FmRiverEntity> getRiverList(){
        return fmRiverService.getRiverList();
    }

    @RequestMapping("/node/{riverId}")
    public List<FmNodeEntity> getNodeListById(@PathVariable("riverId") Integer riverId){
        return fmRiverService.getNodeListById(riverId);
    }

    @RequestMapping("/add")
    public R addRiver(FmRiverEntity fmRiverEntity){
        System.out.println(fmRiverEntity);
        fmRiverService.addRiver(fmRiverEntity);
        return R.ok();
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("files") MultipartFile files) throws Exception {
        FTPClient ftp = new FTPClient();
        InputStream local=null;
        ftp.connect("47.92.129.52", 21);
        ftp.login("ftpuser", "ftpuser");
        String path="/upload/images/img";
        boolean flag = ftp.changeWorkingDirectory(path);
        if(!flag){
            ftp.makeDirectory(path);
        }
        ftp.changeWorkingDirectory(path);
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        String filename = files.getOriginalFilename();
        System.out.println(filename);
        String p="F:/"+filename;
        File file = new File(p);

        local = new FileInputStream(file);
        boolean result = ftp.storeFile(file.getName(), local);
        System.out.println(result);
        String url="ftp://ftpuser:ftpuser@47.92.129.52/upload/images/img/"+filename;
        return url;
    }

    @RequestMapping("/delete")
    public R deleteRiver(Integer riverId){
        /*for(Integer riverId:riverIds){
            fmRiverService.deleteRiver(riverId);
        }*/
        fmRiverService.deleteRiver(riverId);
        return R.ok();
    }
}
