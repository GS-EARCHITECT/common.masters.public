package enterprise.roles.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import enterprise.roles.model.dto.RoleMaster_DTO;
import enterprise.roles.services.I_RoleMasterPublicRead_Service;

@RestController
@RequestMapping("/roleMasterPublicReadManagement")
public class RoleMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Role_Role_Cuntroller.class);

	@Autowired
	private I_RoleMasterPublicRead_Service rolePublicReadServ;

	@GetMapping(value = "/getAllRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<RoleMaster_DTO>> getAllRoles() {
		CompletableFuture<CopyOnWriteArrayList<RoleMaster_DTO>> completableFuture = rolePublicReadServ
				.getAllRoles();
		CopyOnWriteArrayList<RoleMaster_DTO> roleDTOs = completableFuture.join();
		// logger.info("size :"+roleDTOs.size());
		return new ResponseEntity<>(roleDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectRoles", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<RoleMaster_DTO>> getSelectRoles(
			@RequestBody CopyOnWriteArrayList<Long> roleSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<RoleMaster_DTO>> completableFuture = rolePublicReadServ
				.getSelectRoles(roleSeqNos);
		CopyOnWriteArrayList<RoleMaster_DTO> roleDTOs = completableFuture.join();
		// logger.info("size :"+roleDTOs.size());
		return new ResponseEntity<>(roleDTOs, HttpStatus.OK);
	}

}