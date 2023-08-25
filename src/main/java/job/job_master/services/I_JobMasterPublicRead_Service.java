package job.job_master.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import job.job_master.model.dto.JobMaster_DTO;

public interface I_JobMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMasters(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getSelectJobMastersByParties(CopyOnWriteArrayList<Long> pids);
	public CompletableFuture<CopyOnWriteArrayList<JobMaster_DTO>> getAllJobMasters();
}