package service.service_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import service.service_master.model.master.ServiceMaster;

@Repository("serviceMasterPublicReadRepo")
public interface ServiceMasterPublicRead_Repo extends JpaRepository<ServiceMaster, Long> 
{
@Query(value = "SELECT * FROM service_master a order by a.service_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<ServiceMaster> getAllServices();	

@Query(value = "SELECT * FROM service_master a where service_seq_no in :ids order by a.service_seq_no", nativeQuery = true)
CopyOnWriteArrayList<ServiceMaster> getSelectServiceClasses(@Param("ids") CopyOnWriteArrayList<Long> ids);
}
