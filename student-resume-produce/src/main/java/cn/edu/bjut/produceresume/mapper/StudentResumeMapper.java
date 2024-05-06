package cn.edu.bjut.produceresume.mapper;

import cn.edu.bjut.entity.student.exprience.EducationInfo;
import cn.edu.bjut.entity.student.exprience.OrganizationExperience;
import cn.edu.bjut.entity.student.exprience.PracticeExperience;
import cn.edu.bjut.entity.student.exprience.ProjectExperience;
import cn.edu.bjut.entity.student.other.Resume;
import cn.edu.bjut.entity.student.performance.Certification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentResumeMapper {
    public Integer insertCertification(Certification certification);
    public Integer countCertificateByIndex(Certification certification);
    public List<Certification> getAllCertificates(Integer studentId);
    public Integer updateCertification(Certification certification);

    Integer deleteCertifications(Certification certification);

    Integer updateCertificateAfterDelete(Certification certification);

    Integer countProjectByIndex(ProjectExperience projectExperience);

    Integer insertProject(ProjectExperience projectExperience);

    Integer updateProject(ProjectExperience projectExperience);

    List<ProjectExperience> getAllProject(Integer studentId);

    Integer deleteProject(ProjectExperience projectExperience);

    Integer updateProjectAfterDelete(ProjectExperience projectExperience);

    Integer countOrganizationByIndex(OrganizationExperience organizationExperience);

    Integer insertOrganization(OrganizationExperience organizationExperience);

    Integer updateOrganization(OrganizationExperience organizationExperience);

    Integer deleteOrganization(OrganizationExperience organizationExperience);

    Integer updateOrganizationAfterDelete(OrganizationExperience organizationExperience);

    List<OrganizationExperience> getAllOrganization(Integer studentId);

    Integer countPracticeByIndex(PracticeExperience practiceExperience);

    Integer insertPractice(PracticeExperience practiceExperience);

    Integer updatePractice(PracticeExperience practiceExperience);

    Integer deletePractice(PracticeExperience practiceExperience);

    Integer updatePracticeAfterDelete(PracticeExperience practiceExperience);

    List<PracticeExperience> getAllPractice(Integer studentId);

    Integer countEducationByIndex(EducationInfo educationInfo);

    Integer insertEducation(EducationInfo educationInfo);

    Integer updateEducation(EducationInfo educationInfo);

    Integer deleteEducation(EducationInfo educationInfo);

    Integer updateEducationAfterDelete(EducationInfo educationInfo);

    List<EducationInfo> getAllEducation(Integer studentId);

    Integer insertLocalResume(Resume resume);

    Integer deleteLocalResume(Resume resume);

    List<Resume> getAllResume(Integer studentId);
}
