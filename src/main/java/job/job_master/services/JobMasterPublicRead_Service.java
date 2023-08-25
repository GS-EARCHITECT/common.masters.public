package job.job_master.services;

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
import job.job_master.model.dto.JobMaster_DTO;
import job.job_master.model.master.JobMaster;
import job.job_master.model.repo.JobMasterPublicRead_Repo;

@Service("jobMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobMasterPublicRead_Service implements I_JobMasterPublicRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobMasterService.class);

	@Autowired
	private JobMasterPublicRead_Repo jobMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getAllJobMasters() 
	{
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{		
		CopyOnWriteArrayList<JobMaster> jobList = (CopyOnWriteArrayList<JobMaster>) jobMasterPublicReadRepo.findAll();
		CopyOnWriteArrayList<JobMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jobDTOs;
   		},asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMasters(CopyOnWriteArrayList<Long> jcmSeqNos) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{		
		CopyOnWriteArrayList<JobMaster> jobList = (CopyOnWriteArrayList<JobMaster>) jobMasterPublicReadRepo.getSelectJobMasters(jcmSeqNos);
		CopyOnWriteArrayList<JobMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jobDTOs;
   		},asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMastersByParties(CopyOnWriteArrayList<Long> pids) 
{
		CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{		
		CopyOnWriteArrayList<JobMaster> jobList = (CopyOnWriteArrayList<JobMaster>) jobMasterPublicReadRepo.getSelectJobMastersByParties(pids);
		CopyOnWriteArrayList<JobMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobMaster_DTO>();
		jobDTOs = jobList != null ? this.getJobMaster_DTOs(jobList) : null;
		return jobDTOs;
   		},asyncExecutor);
		return future;
	}
	
	private synchronized CopyOnWriteArrayList<JobMaster_DTO> getJobMaster_DTOs(CopyOnWriteArrayList<JobMaster> jobMasters) {
		JobMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<JobMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized JobMaster_DTO getJobMaster_DTO(JobMaster jobMaster2) 
	{
		JobMaster_DTO jobMasterDTO = new JobMaster_DTO();
		jobMasterDTO = new JobMaster_DTO();		
		jobMasterDTO.setJobSeqNo(jobMaster2.getJobSeqNo());
		jobMasterDTO.setDescription(jobMaster2.getDescription());
		jobMasterDTO.setDiscPer(jobMaster2.getDiscPer());
		jobMasterDTO.setDiscSeqNo(jobMaster2.getDiscSeqNo());
		jobMasterDTO.setDiscVal(jobMaster2.getDiscVal());
		jobMasterDTO.setDuration(jobMaster2.getDuration());
		jobMasterDTO.setDurationCodeSeqNo(jobMaster2.getDurationCodeSeqNo());
		jobMasterDTO.setJob(jobMaster2.getJob());
		jobMasterDTO.setJobId(jobMaster2.getJobId());
		jobMasterDTO.setPartySeqNo(jobMaster2.getPartySeqNo());
		jobMasterDTO.setSpecificationSeqNo(jobMaster2.getSpecificationSeqNo());
		jobMasterDTO.setTaxPer(jobMaster2.getTaxPer());
		jobMasterDTO.setTaxSeqNo(jobMaster2.getTaxSeqNo());
		jobMasterDTO.setTaxVal(jobMaster2.getTaxVal());
		jobMasterDTO.setUnitRate(jobMaster2.getUnitRate());
		jobMasterDTO.setUnitRateSeqNo(jobMaster2.getUnitRateSeqNo());
		jobMasterDTO.setRemark(jobMaster2.getRemark());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		return jobMasterDTO;
	}
	
}