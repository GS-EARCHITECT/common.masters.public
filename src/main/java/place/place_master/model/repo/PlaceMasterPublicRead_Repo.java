package place.place_master.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import place.place_master.model.master.PlaceMaster;

@Repository("placeMasterPublicReadRepo")
public interface PlaceMasterPublicRead_Repo extends JpaRepository<PlaceMaster, Long> 
{
	@Query(value = "SELECT * FROM Place_Master a order by a.place_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PlaceMaster> getAllPlaces();

	@Query(value = "SELECT * FROM Place_Master a where place_seq_no in :ids order by a.place_class_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<PlaceMaster> getSelectPlaces(@Param("ids") CopyOnWriteArrayList<Long> ids);;
	
}