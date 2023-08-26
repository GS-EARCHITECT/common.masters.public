package service.service_class.controller;

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
import service.service_class.model.dto.ServiceClassMaster_DTO;
import service.service_class.service.I_ServiceClassMasterPublicRead_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/serviceClassPublicReadManagement")
public class ServiceClassMasterPublicRead_Controller 
{

	// private static final Logger logger =
	// LoggerFactory.getLogger(ServiceClassMaster_Controller.class);

	@Autowired
	private I_ServiceClassMasterPublicRead_Service serviceClassMasterPublicReadServ;

	@GetMapping(value = "/getAllserviceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ServiceClassMaster_DTO>> getAllServiceClasses() 
	{
		CompletableFuture<CopyOnWriteArrayList<ServiceClassMaster_DTO>> completableFuture = serviceClassMasterPublicReadServ.getAllServiceClasses();
		CopyOnWriteArrayList<ServiceClassMaster_DTO> serviceClassDTOs = completableFuture.join();
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectServiceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<ServiceClassMaster_DTO>> getSelectServiceClasses(
			@RequestBody CopyOnWriteArrayList<Long> serviceClassSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<ServiceClassMaster_DTO>> completableFuture = serviceClassMasterPublicReadServ.getSelectServiceClasses(serviceClassSeqNos);
		CopyOnWriteArrayList<ServiceClassMaster_DTO> serviceClassDTOs = completableFuture.join();
		return new ResponseEntity<>(serviceClassDTOs, HttpStatus.OK);
	}

	}