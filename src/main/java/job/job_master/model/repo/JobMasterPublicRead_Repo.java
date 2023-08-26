package job.job_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job.job_master.model.master.JobMaster;

@Repository("jobMasterPublicReadRepo")
public interface JobMasterPublicRead_Repo extends JpaRepository<JobMaster, Long> 
{
	
	@Query(value = "select * from JOB_MASTER ORDER BY MASTER_JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobMaster> getAllJobMasters();

	@Query(value = "select * from JOB_MASTER where MASTER_JOB_SEQ_NO in :ids ORDER BY MASTER_JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobMaster> getSelectJobMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * from  JOB_MASTER where party_SEQ_NO in :pids ORDER BY MASTER_JOB_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobMaster> getSelectJobMastersByParties(@Param("pids") CopyOnWriteArrayList<Long> pids);
}