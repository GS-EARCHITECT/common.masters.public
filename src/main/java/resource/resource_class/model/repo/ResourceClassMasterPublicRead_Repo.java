package resource.resource_class.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import resource.resource_class.model.master.ResourceClassMaster;

@Repository("resourceClassMasterPublicReadRepo")
public interface ResourceClassMasterPublicRead_Repo extends JpaRepository<ResourceClassMaster, Long> 
{}
