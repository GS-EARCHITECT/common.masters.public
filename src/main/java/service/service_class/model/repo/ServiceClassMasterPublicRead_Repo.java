package service.service_class.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.service_class.model.master.ServiceClassMaster;

@Repository("serviceClassMasterPublicReadRepo")
public interface ServiceClassMasterPublicRead_Repo extends JpaRepository<ServiceClassMaster, Long> 
{}
