/**This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

package com.mobiletest.fileservice.controller;
import com.mobiletest.fileservice.FileService;
import java.lang.String;
import java.io.IOException;
import java.lang.Exception;
import com.wavemaker.runtime.file.model.DownloadResponse;
import javax.servlet.http.HttpServletRequest;
import com.mobiletest.fileservice.FileService.WMFile;
import org.springframework.web.multipart.MultipartFile;
import com.mobiletest.fileservice.FileService.FileUploadResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

@RestController	
@RequestMapping(value = "/file")
public class FileController{

	@Autowired	
	private FileService fileService;

	@RequestMapping(value = "/downloadFile", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET )
	public DownloadResponse getDownloadFile(@RequestParam(value="file", required=false)String file, @RequestParam(value="returnName", required=false)String returnName )  throws  Exception {
        
            return fileService.getDownloadFile(file, returnName);
	}

	@RequestMapping(value = "/downloadFileAsInline", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET )
	public DownloadResponse getDownloadFileAsInline(@RequestParam(value="file", required=false)String file, @RequestParam(value="returnName", required=false)String returnName )  throws  Exception {
        
            return fileService.getDownloadFileAsInline(file, returnName);
	}

	@RequestMapping(value = "/files", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
	public WMFile[] listFiles(HttpServletRequest httpServletRequest, @RequestParam(value="relativePath", required=false)String relativePath )  throws  IOException {
        
            return fileService.listFiles(httpServletRequest, relativePath);
	}

	@RequestMapping(value = "/file", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE )
	public boolean deleteFile(@RequestParam(value="file", required=false)String file )  throws  IOException {
        
            return fileService.deleteFile(file);
	}

	@RequestMapping(value = "/uploadFile", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST )
	public FileUploadResponse[] uploadFile(@RequestPart(value="files") MultipartFile[] files, @RequestParam(value="relativePath", required=false)String relativePath, HttpServletRequest httpServletRequest )   {
        
            return fileService.uploadFile(files, relativePath, httpServletRequest);
	}
} 