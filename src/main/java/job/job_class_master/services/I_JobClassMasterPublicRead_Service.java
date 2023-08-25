package job.job_class_master.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import job.job_class_master.model.dto.JobClassMaster_DTO;

public interface I_JobClassMasterPublicRead_Service 
{
	public CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> getSelectJobClasses(CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<JobClassMaster_DTO>> getAllJobClasses();
}