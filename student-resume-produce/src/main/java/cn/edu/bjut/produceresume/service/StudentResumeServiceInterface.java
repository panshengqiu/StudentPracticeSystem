package cn.edu.bjut.produceresume.service;

import cn.edu.bjut.entity.student.exprience.EducationInfo;
import cn.edu.bjut.entity.student.exprience.OrganizationExperience;
import cn.edu.bjut.entity.student.exprience.PracticeExperience;
import cn.edu.bjut.entity.student.exprience.ProjectExperience;
import cn.edu.bjut.entity.student.performance.Certification;

import java.util.List;

public interface StudentResumeServiceInterface {
    Integer insertProject(ProjectExperience projectExperience);
     Integer insertCertification(Certification certification);
    List<Certification> getAllCertificates(Integer studentId);

    Integer deleteCertification(Certification certification);

    List<ProjectExperience> getAllProject(Integer studentId);

    Integer deleteProject(ProjectExperience projectExperience);

    Integer insertOrganization(OrganizationExperience organizationExperience);

    Integer deleteOrganization(OrganizationExperience organizationExperience);

    List<OrganizationExperience> getAllOrganization(Integer studentId);

    Integer insertPractice(PracticeExperience practiceExperience);

    Integer deletePractice(PracticeExperience practiceExperience);

    List<PracticeExperience> getAllPractice(Integer studentId);

    Integer insertEducation(EducationInfo educationInfo);

    Integer deleteEducation(EducationInfo educationInfo);


    List<EducationInfo> getAllEducation(Integer studentId);
}
