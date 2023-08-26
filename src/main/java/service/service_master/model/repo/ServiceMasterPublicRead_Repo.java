package service.service_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.service_master.model.master.ServiceMaster;

@Repository("serviceMasterPublicReadRepo")
public interface ServiceMasterPublicRead_Repo extends JpaRepository<ServiceMaster, Long> 
{
@Query(value = "SELECT * FROM service_master a order by a.service_SEQ_NO", nativeQuery = true)
CopyOnWriteArrayList<ServiceMaster> getAllServices();	
}
