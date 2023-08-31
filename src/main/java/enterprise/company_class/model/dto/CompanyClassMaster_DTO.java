package enterprise.company_class.model.dto;

import java.io.Serializable;

public class CompanyClassMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2745611839562338827L;
	private Long companyClassSeqNo;
	private String companyClass;
	private String description;
	private Long specificationSeqNo;

	public Long getCompanyClassSeqNo() {
		return companyClassSeqNo;
	}

	public void setCompanyClassSeqNo(Long companyClassSeqNo) {
		this.companyClassSeqNo = companyClassSeqNo;
	}

	public String getCompanyClass() {
		return companyClass;
	}

	public void setCompanyClass(String companyClass) {
		this.companyClass = companyClass;
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

	public CompanyClassMaster_DTO(Long companyClassSeqNo, String companyClass, String description,
			Long specificationSeqNo) {
		super();
		this.companyClassSeqNo = companyClassSeqNo;
		this.companyClass = companyClass;
		this.description = description;
		this.specificationSeqNo = specificationSeqNo;
	}

	public CompanyClassMaster_DTO() {
		super();
	}

}