package resource.resource_class.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource.resource_class.model.dto.ResourceClassMaster_DTO;
import resource.resource_class.service.I_ResourceClassMasterPublicRead_Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceClassPublicReadManagement")
public class ResourceClassMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceClassMaster_Controller.class);

	@Autowired
	private I_ResourceClassMasterPublicRead_Service resourceClassMasterPublicReadServ;

	@GetMapping(value = "/getAllResourceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ResourceClassMaster_DTO>> getAllResourceClasses() {
		CompletableFuture<CopyOnWriteArrayList<ResourceClassMaster_DTO>> completableFuture = resourceClassMasterPublicReadServ
				.getAllResourceClasses();
		CopyOnWriteArrayList<ResourceClassMaster_DTO> resourceClassDTOs = completableFuture.join();
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ResourceClassMaster_DTO>> getSelectResourceClasses(
			@RequestBody CopyOnWriteArrayList<Long> resourceClassSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<ResourceClassMaster_DTO>> completableFuture = resourceClassMasterPublicReadServ
				.getSelectResourceClasses(resourceClassSeqNos);
		CopyOnWriteArrayList<ResourceClassMaster_DTO> resourceClassDTOs = completableFuture.join();
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}

}