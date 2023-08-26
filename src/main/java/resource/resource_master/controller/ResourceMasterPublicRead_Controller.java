package resource.resource_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource.resource_master.model.dto.ResourceMaster_DTO;
import resource.resource_master.service.I_ResourceMasterPublicRead_Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceMasterPublicReadManagement")
public class ResourceMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceMaster_Controller.class);

	@Autowired
	private I_ResourceMasterPublicRead_Service resourceMasterPublicReadServ;

	@GetMapping(value = "/getAlMasterResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ResourceMaster_DTO>> getAllMasterResources() {
		CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> completableFuture = resourceMasterPublicReadServ
				.getAllMasterResources();
		CopyOnWriteArrayList<ResourceMaster_DTO> resourceDTOs = completableFuture.join();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectMasterResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ResourceMaster_DTO>> getSelectMasterResources(
			@RequestBody CopyOnWriteArrayList<Long> resourceSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<ResourceMaster_DTO>> completableFuture = resourceMasterPublicReadServ
				.getSelectMasterResources(resourceSeqNos);
		CopyOnWriteArrayList<ResourceMaster_DTO> resourceDTOs = completableFuture.join();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

}