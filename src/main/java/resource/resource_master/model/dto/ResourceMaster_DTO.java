package resource.resource_master.model.dto;

import java.io.Serializable;

public class ResourceMaster_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6597045184762199325L;
	private Long masterResourceSeqNo;
	private String description;
	private String resourceName;
	private Long specificationSeqNo;
	private Long oemSeqNo;

	public Long getMasterResourceSeqNo() {
		return masterResourceSeqNo;
	}

	public void setMasterResourceSeqNo(Long masterResourceSeqNo) {
		this.masterResourceSeqNo = masterResourceSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public Long getOemSeqNo() {
		return oemSeqNo;
	}

	public void setOemSeqNo(Long oemSeqNo) {
		this.oemSeqNo = oemSeqNo;
	}

	public ResourceMaster_DTO(Long masterResourceSeqNo, String description, String resourceName,
			Long specificationSeqNo, Long oemSeqNo) {
		super();
		this.masterResourceSeqNo = masterResourceSeqNo;
		this.description = description;
		this.resourceName = resourceName;
		this.specificationSeqNo = specificationSeqNo;
		this.oemSeqNo = oemSeqNo;
	}

	public ResourceMaster_DTO() {
		super();
	}

}