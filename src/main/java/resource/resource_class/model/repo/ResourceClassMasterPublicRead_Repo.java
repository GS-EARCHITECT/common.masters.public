package resource.resource_class.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resource.resource_class.model.master.ResourceClassMaster;

@Repository("resourceClassMasterPublicReadRepo")
public interface ResourceClassMasterPublicRead_Repo extends JpaRepository<ResourceClassMaster, Long> 
{
	@Query(value = "SELECT * FROM resource_class_master a order by a.resource_class_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<ResourceClassMaster> getAllResourceClasses();

	@Query(value = "SELECT * FROM resource_class_master a where resource_class_seq_no in :ids order by a.resource_class_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<ResourceClassMaster> getSelectResourceClasses(@Param("ids") CopyOnWriteArrayList<Long> ids);
}
