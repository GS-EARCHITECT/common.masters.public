package service.service_master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.service_master.model.dto.ServiceMaster_DTO;
import service.service_master.service.I_ServiceMasterPublicRead_Service;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/servicePublicReadManagement")
public class ServiceMasterPublicRead_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ServiceMaster_Controller.class);

	@Autowired
	private I_ServiceMasterPublicRead_Service serviceMasterPublicReadServ;

	@GetMapping(value = "/getAllserviceies", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ServiceMaster_DTO>> getAllServiceMasters() {
		CompletableFuture<CopyOnWriteArrayList<ServiceMaster_DTO>> completableFuture = serviceMasterPublicReadServ
				.getAllServiceMasters();
		CopyOnWriteArrayList<ServiceMaster_DTO> serviceDTOs = completableFuture.join();
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ServiceMaster_DTO>> getSelectServiceMasters(
			@RequestBody CopyOnWriteArrayList<Long> serviceSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<ServiceMaster_DTO>> completableFuture = serviceMasterPublicReadServ
				.getSelectServices(serviceSeqNos);
		CopyOnWriteArrayList<ServiceMaster_DTO> serviceDTOs = completableFuture.join();
		return new ResponseEntity<>(serviceDTOs, HttpStatus.OK);
	}

}