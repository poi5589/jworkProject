package com.mj.jwork.project.model.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Project {
	
	 private int projectNo;
	 private int projectWriter;
	 private String projectName;
	 private String projectContent;
	 private String status;
	 private String fileUrl;
	 private String originName;
	 private String startDate;
	 private String endDate;
}
