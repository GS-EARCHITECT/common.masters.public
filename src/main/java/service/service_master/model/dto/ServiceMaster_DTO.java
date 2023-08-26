package service.service_master.model.dto;

import java.io.Serializable;

public class ServiceMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2215312470770647938L;
	private Long masterServiceSeqNo;
	private String description;
	private String service;
	private Long specificationSeqNo;

	public Long getMasterServiceSeqNo() {
		return masterServiceSeqNo;
	}

	public void setMasterServiceSeqNo(Long masterServiceSeqNo) {
		this.masterServiceSeqNo = masterServiceSeqNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public ServiceMaster_DTO(Long masterServiceSeqNo, String description, String service, Long specificationSeqNo) {
		super();
		this.masterServiceSeqNo = masterServiceSeqNo;
		this.description = description;
		this.service = service;
		this.specificationSeqNo = specificationSeqNo;
	}

	public ServiceMaster_DTO() {
		super();
	}

}