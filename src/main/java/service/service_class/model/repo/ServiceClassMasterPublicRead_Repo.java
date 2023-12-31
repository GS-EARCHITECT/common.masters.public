package service.service_class.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import service.service_class.model.master.ServiceClassMaster;

@Repository("serviceClassMasterPublicReadRepo")
public interface ServiceClassMasterPublicRead_Repo extends JpaRepository<ServiceClassMaster, Long> 
{
	@Query(value = "SELECT * FROM service_class_master a order by a.service_class_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ServiceClassMaster> getAllServiceClasses();
	
	@Query(value = "SELECT * FROM service_class_master a where service_class_seq_no in :ids order by a.service_class_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<ServiceClassMaster> getSelectResourceClasses(@Param("ids") CopyOnWriteArrayList<Long> ids);

}
