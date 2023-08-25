package job.job_master.controller;

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
import job.job_master.model.dto.JobMaster_DTO;
import job.job_master.services.I_JobMasterPublicRead_Service;

@RestController
@RequestMapping("/jobMasterPublicReadMgmt")
public class JobMasterPublicRead_Controller {
	@Autowired
	private I_JobMasterPublicRead_Service jobMasterPublicReadService;

	@GetMapping(value = "/getSelectJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMasters(
			@RequestBody CopyOnWriteArrayList<Long> jobMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> completableFuture = jobMasterPublicReadService
				.getSelectJobMasters(jobMasterSeqNos);
		CopyOnWriteArrayList<JobMaster_DTO> jobMaster_DTOs = completableFuture.join();
		return new ResponseEntity<>(jobMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectJobMastersByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMastersByParties(
			@RequestBody CopyOnWriteArrayList<Long> jobMasterSeqNos) {
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> completableFuture = jobMasterPublicReadService
				.getSelectJobMastersByParties(jobMasterSeqNos);
		CopyOnWriteArrayList<JobMaster_DTO> jobMaster_DTOs = completableFuture.join();
		return new ResponseEntity<>(jobMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllJobMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<JobMaster_DTO>> getAllJobMasters() {
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> completableFuture = jobMasterPublicReadService
				.getAllJobMasters();
		CopyOnWriteArrayList<JobMaster_DTO> jobMaster_DTOs = completableFuture.join();
		return new ResponseEntity<>(jobMaster_DTOs, HttpStatus.OK);
	}

}