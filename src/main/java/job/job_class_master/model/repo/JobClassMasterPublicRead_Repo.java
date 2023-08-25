package job.job_class_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import job.job_class_master.model.master.JobClassMaster;

@Repository("jobClassMasterPublicReadRepo")
public interface JobClassMasterPublicRead_Repo extends JpaRepository<JobClassMaster, Long> 
{

	@Query(value = "SELECT * from  JOB_CLASS_MASTER where JOB_CLASS_SEQ_NO in :ids ORDER BY JOB_CLASS_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<JobClassMaster> getSelectJobClasses(@Param("jobClassMasterSeqNos") CopyOnWriteArrayList<Long> ids);

	
}