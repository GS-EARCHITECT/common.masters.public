package job.job_class_master.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import job.job_class_master.model.dto.JobClassMaster_DTO;
import job.job_class_master.services.I_JobClassMasterPublicRead_Service;

@RestController
@RequestMapping("/jobClassMasterPublicReadMgmt")
public class JobClassMasterPublicRead_Controller {
	@Autowired
	private I_JobClassMasterPublicRead_Service jobClassMasterPublicReadService;

	@GetMapping(value = "/getSelectJobClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassMaster_DTO>> getSelectJobClassMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobClassMasterSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> completableFuture = jobClassMasterPublicReadService.getSelectJobClasses(jobClassMasterSeqNos);
		CopyOnWriteArrayList<JobClassMaster_DTO> jobClassMaster_DTOs = completableFuture.join();   
		return new ResponseEntity<>(jobClassMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobClassMaster_DTO>> getAllJobClassMasters() 
	{
		CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> completableFuture = jobClassMasterPublicReadService.getAllJobClasses();
		CopyOnWriteArrayList<JobClassMaster_DTO> jobClassMaster_DTOs = completableFuture.join();   
		return new ResponseEntity<>(jobClassMaster_DTOs, HttpStatus.OK);
	}

}