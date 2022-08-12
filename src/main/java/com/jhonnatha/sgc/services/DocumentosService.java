package com.jhonnatha.sgc.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.jhonnatha.sgc.config.GoogleDriveManager;

@Service
public class DocumentosService {
	

	public List<File> findAll() throws IOException, GeneralSecurityException  {
	
		FileList result = GoogleDriveManager.getInstance().files().list()
		        .setPageSize(10)
		        .setFields("nextPageToken, files(id, name)")
		        .execute();
		  return result.getFiles();
	}
	
	public List<File> listFolderContent(String parentId) throws IOException, GeneralSecurityException {
		  if(parentId == null){
		     parentId = "root";
		  }
		  String query = "'" + parentId + "' in parents";
		  FileList result = GoogleDriveManager.getInstance().files().list()
		        .setQ(query)
		        .setPageSize(10)
		        .setFields("nextPageToken, files(id, name)")
		        .execute();
		  return result.getFiles();
		}
	
	
	public String uploadFile(MultipartFile file, String folderId ) throws IOException, GeneralSecurityException {
		
		  try {			
		     if (null != file) {
		        File fileMetadata = new File();
		        fileMetadata.setParents(Arrays.asList(folderId));
		        fileMetadata.setName(file.getOriginalFilename());	        
		        
		        File uploadFile = GoogleDriveManager.getInstance()
		              .files()
		              .create(fileMetadata, new InputStreamContent ( 
		                      file.getContentType() ,
		                      new ByteArrayInputStream ( file.getBytes()))
		              )
		              .setFields("id").execute();		       
		        return uploadFile.getId();
		     }
		  } catch (GoogleJsonResponseException e) {
			  System.err.println("Unable to upload file: " + e.getDetails());	           
	            System.out.printf("Error: ", e);
	            throw e;
		  }
		  return null;
	}

	public void deleteFile(String fileId) throws Exception {
		GoogleDriveManager.getInstance().files().delete(fileId).execute();
	}	
	
	
	public void downloadFile(String id, OutputStream outputStream) throws IOException, GeneralSecurityException {
		  if (id != null) {
			 outputStream.flush();
		     String fileId = id;
		     GoogleDriveManager.getInstance().files().get(fileId).executeMediaAndDownloadTo(outputStream);
		     outputStream.flush();
		     outputStream.close();
		  }
	}	

}