package enterprise.designations.controller;

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
import enterprise.designations.model.dto.DesignationMaster_DTO;
import enterprise.designations.services.I_DesignationMasterPublicRead_Service;

@RestController
@RequestMapping("/designationMasterPublicReadManagement")
public class DesignationMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(Designation_Designation_Cuntroller.class);

	@Autowired
	private I_DesignationMasterPublicRead_Service designationPublicReadServ;

	@GetMapping(value = "/getAllDesignations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<DesignationMaster_DTO>> getAllDesignations() {
		CompletableFuture<CopyOnWriteArrayList<DesignationMaster_DTO>> completableFuture = designationPublicReadServ
				.getAllDesignations();
		CopyOnWriteArrayList<DesignationMaster_DTO> designationDTOs = completableFuture.join();
		// logger.info("size :"+designationDTOs.size());
		return new ResponseEntity<>(designationDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDesignations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<DesignationMaster_DTO>> getSelectDesignations(
			@RequestBody CopyOnWriteArrayList<Long> designationSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<DesignationMaster_DTO>> completableFuture = designationPublicReadServ
				.getSelectDesignations(designationSeqNos);
		CopyOnWriteArrayList<DesignationMaster_DTO> designationDTOs = completableFuture.join();
		// logger.info("size :"+designationDTOs.size());
		return new ResponseEntity<>(designationDTOs, HttpStatus.OK);
	}

}