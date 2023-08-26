package job.job_class_master.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job.job_class_master.model.dto.JobClassMaster_DTO;
import job.job_class_master.model.master.JobClassMaster;
import job.job_class_master.model.repo.JobClassMasterPublicRead_Repo;

@Service("jobClassMasterPublicReadServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobClassMasterPublicRead_Service implements I_JobClassMasterPublicRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobClassMasterService.class);

	@Autowired
	private JobClassMasterPublicRead_Repo jobClassMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> getAllJobClasses() 
	{
    	CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{		
		CopyOnWriteArrayList<JobClassMaster> jobList = (CopyOnWriteArrayList<JobClassMaster>) jobClassMasterPublicReadRepo.getAllJobClasses();
		CopyOnWriteArrayList<JobClassMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobClassMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobClassMaster_DTOs(jobList) : null;
		return jobDTOs;
   		},asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> getSelectJobClasses(CopyOnWriteArrayList<Long> ids) 
	{
    	CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{		
		CopyOnWriteArrayList<JobClassMaster> jobList = (CopyOnWriteArrayList<JobClassMaster>) jobClassMasterPublicReadRepo.findAllById(ids);
		CopyOnWriteArrayList<JobClassMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobClassMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobClassMaster_DTOs(jobList) : null;
		return jobDTOs;
   		},asyncExecutor);
		return future;
	}
	
	private CopyOnWriteArrayList<JobClassMaster_DTO> getJobClassMaster_DTOs(CopyOnWriteArrayList<JobClassMaster> jobMasters) 
	{
		JobClassMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<JobClassMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobClassMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobClassMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private JobClassMaster_DTO getJobClassMaster_DTO(JobClassMaster jobClassMaster2) 
	{
		JobClassMaster_DTO jobClassMasterDTO = new JobClassMaster_DTO();
		jobClassMasterDTO = new JobClassMaster_DTO();
		jobClassMasterDTO.setJobClassSeqNo(jobClassMaster2.getJobClassSeqNo());
		jobClassMasterDTO.setJobClass(jobClassMaster2.getJobClass());
		jobClassMasterDTO.setRemark(jobClassMaster2.getRemark());
		jobClassMasterDTO.setStatus(jobClassMaster2.getStatus());
		return jobClassMasterDTO;
	}

}