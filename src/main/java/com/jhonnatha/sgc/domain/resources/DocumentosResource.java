package com.jhonnatha.sgc.domain.resources;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.services.drive.model.File;
import com.jhonnatha.sgc.services.DocumentosService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/documentos")
public class DocumentosResource {

	@Autowired
	private DocumentosService service;

	@GetMapping({ "/list", "/list/{parentId}" })
	public ResponseEntity<List<File>> list(@PathVariable(required = false) String parentId)
			throws IOException, GeneralSecurityException {
		List<File> folders = service.listFolderContent("root");
		String id = "";
		for (int i = 0; i < folders.size(); i++) {
			if (folders.get(i).getName().equalsIgnoreCase(parentId)) {
				id = folders.get(i).getId();
			}
		}

		List<File> files = service.listFolderContent(id);
		return ResponseEntity.ok(files);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping(value = "/upload", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> uploadSingleFile(@RequestBody MultipartFile file,
			@RequestParam(required = false) String path) throws IOException, GeneralSecurityException {
		
		List<File> folders = service.listFolderContent("root");
		String id = "";
		
		for (int i = 0; i < folders.size(); i++) {			;
			if (folders.get(i).getName().equalsIgnoreCase(path)) {
				id = folders.get(i).getId();
			}
		}
		
		String fileId = service.uploadFile(file, id);		
		if (fileId == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok("Success, FileId: " + fileId);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) throws Exception {
		service.deleteFile(id);
	}

	@GetMapping("/download/{id}")
	public void download(@PathVariable String id, HttpServletResponse response)
			throws IOException, GeneralSecurityException {
		service.downloadFile(id, response.getOutputStream());
	}

}
