package resource.resource_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resource.resource_master.model.master.ResourceMaster;

@Repository("resourceMasterPublicReadRepo")
public interface ResourceMasterPublicRead_Repo extends JpaRepository<ResourceMaster, Long> 
{
	@Query(value = "SELECT * FROM resource_master a order by a.resource_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ResourceMaster> getAllResources();	

	@Query(value = "SELECT * FROM resource_master a where resource_seq_no in :ids order by a.resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<ResourceMaster> getSelectResources(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * FROM resource_master a where oem_seq_no in :ids order by a.resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<ResourceMaster> getSelectResourcesByOEMs(@Param("ids") CopyOnWriteArrayList<Long> ids);

}
