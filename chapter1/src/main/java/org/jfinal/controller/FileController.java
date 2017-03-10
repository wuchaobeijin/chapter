package org.jfinal.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import org.jfinal.model.Files;

/**
 * @author: wuchao
 * @date： 2017/3/8
 */
public class FileController extends Controller {

    public void index() {
        setAttr("files", Files.dao.paginate(getParaToInt(0,1),10));
        render("getFile.jsp");
    }

    public void upload() {
        UploadFile file = getFile("file");
        String fileName = file.getFileName();
        Long length = file.getFile().length();
        String saveDirectory = file.getSaveDirectory();
        saveDirectory = saveDirectory.substring(54);
        saveDirectory = saveDirectory + fileName;
        String filePath = file.getFile().getPath();
        Record upload = new Record().set("filename", fileName).set("length", length).set("filePath", filePath).set("directory", saveDirectory);
        Db.save("file", upload);
        redirect("/file");
    }

}
