package enterprise.roles.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import enterprise.roles.model.master.RoleMaster;

@Repository("roleMasterPublicReadRepo")
public interface RoleMasterPublicRead_Repo extends JpaRepository<RoleMaster, Long> 
{
	@Query(value = "select * from ROLE_MASTER ORDER BY MASTER_ROLE_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<RoleMaster> getAllMasters();

	@Query(value = "select * from ROLE_MASTER where MASTER_ROLE_SEQ_NO in :ids ORDER BY MASTER_ROLE_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<RoleMaster> getSelectRoleMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);

}
