package cn.jctl.river.controller;

import cn.jctl.common.utils.R;
import cn.jctl.river.entity.FmNodeEntity;
import cn.jctl.river.entity.FmRiverEntity;
import cn.jctl.river.entity.FmRiverNodeEntity;
import cn.jctl.river.entity.FmWaterareaEntity;
import cn.jctl.river.service.FmRiverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/river")
@Api(tags="河流接口")
public class FmRiverController {
    @Autowired
    private FmRiverService fmRiverService;

    /*@RequestMapping("/list")*/
    @GetMapping("list")
    @ApiOperation("河流列表")
    public List<FmRiverEntity> getRiverList(){
        return fmRiverService.getRiverList();
    }

    /*@RequestMapping("/node/{riverId}")*/
    @GetMapping("node/{riverId}")
    @ApiOperation("节点展示")
    public List<FmNodeEntity> getNodeListById(@PathVariable("riverId") Integer riverId){
        return fmRiverService.getNodeListById(riverId);
    }

    /*@RequestMapping("/add")*/
    @PostMapping("add")
    @ApiOperation("添加河流")
    public R addRiver(FmRiverNodeEntity fmRiverNodeEntity){
        fmRiverService.addRiver(fmRiverNodeEntity);
        Long riverId = fmRiverService.getRiverId();
        FmNodeEntity fmNodeEntity = new FmNodeEntity();
        fmNodeEntity.setNodeNumber(fmRiverNodeEntity.getNodeNumber());
        fmNodeEntity.setNodeLat(fmRiverNodeEntity.getNodeLat());
        fmNodeEntity.setNodeLon(fmRiverNodeEntity.getNodeLon());
        fmNodeEntity.setRiverId(riverId);
        fmRiverService.addNode(fmNodeEntity);
        return R.ok();
    }

    @PostMapping("update")
    @ApiOperation("更新河流")
    public R updateRiver(FmRiverNodeEntity fmRiverNodeEntity){
        fmRiverService.updateRiver(fmRiverNodeEntity);
        FmNodeEntity fmNodeEntity = new FmNodeEntity();
        fmNodeEntity.setNodeNumber(fmRiverNodeEntity.getNodeNumber());
        fmNodeEntity.setNodeLon(fmRiverNodeEntity.getNodeLon());
        fmNodeEntity.setNodeLat(fmRiverNodeEntity.getNodeLat());
        fmNodeEntity.setRiverId(fmRiverNodeEntity.getRiverId());
        fmNodeEntity.setId(fmRiverNodeEntity.getNodeId());
        fmRiverService.updateNode(fmNodeEntity);
        return R.ok();
    }

    /*@RequestMapping("/upload")*/
    @PostMapping("upload")
    @ApiOperation("上传图片")
    public String upload(@RequestParam("files") MultipartFile files,String picUrl) throws Exception {
        System.out.println(picUrl);
        FTPClient ftp = new FTPClient();
        InputStream local=null;
        String username="ftpuser";
        String password="ftpuser";
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
        String p=picUrl+filename;
        File file = new File(p);

        local = new FileInputStream(file);
        boolean result = ftp.storeFile(file.getName(), local);
        System.out.println(result);
//        String url="ftp://+username:password@+"47.92.129.52/upload/images/img/"+filename;
        String url="ftp://"+username+":"+password+"@"+"47.92.129.52/upload/images/img/"+filename;
        return url;
    }

    /*@RequestMapping("/delete")*/
    @PostMapping("delete")
    @ApiOperation("删除河流")
    public R deleteRiver(Long riverId,Long nodeId){
        /*for(Integer riverId:riverIds){
            fmRiverService.deleteRiver(riverId);
        }*/
        fmRiverService.deleteRiver(riverId);
        fmRiverService.deleteNode(nodeId);
        return R.ok();
    }

    /**
     * 查询水域信息
     * @return List<FmWaterareaEntity>
     */
    /*@RequestMapping("/info")*/
    @GetMapping("info")
    @ApiOperation("水域信息")
    public List<FmWaterareaEntity> getWaterareaInfo(){
        return fmRiverService.getWaterareaInfo();
    }

    @GetMapping("getinfo")
    @ApiOperation("单个河流信息")
    public FmWaterareaEntity getRiverOne(Long riverId){
        return fmRiverService.getRiverOne(riverId);
    }
}
