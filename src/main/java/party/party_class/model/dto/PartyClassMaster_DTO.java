package party.party_class.model.dto;

import java.io.Serializable;

public class PartyClassMaster_DTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7498107522392843367L;
	private Long partyClassSeqNo;
	private String partyClass;
	private String description;
	private Long specificationSeqNo;

	public Long getPartyClassSeqNo() {
		return partyClassSeqNo;
	}

	public void setPartyClassSeqNo(Long partyClassSeqNo) {
		this.partyClassSeqNo = partyClassSeqNo;
	}

	public String getPartyClass() {
		return partyClass;
	}

	public void setPartyClass(String partyClass) {
		this.partyClass = partyClass;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public PartyClassMaster_DTO(Long partyClassSeqNo, String partyClass, String description,
			Long specificationSeqNo) {
		super();
		this.partyClassSeqNo = partyClassSeqNo;
		this.partyClass = partyClass;
		this.description = description;
		this.specificationSeqNo = specificationSeqNo;
	}

	public PartyClassMaster_DTO() {
		super();
	}

}