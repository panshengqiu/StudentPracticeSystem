package cn.edu.bjut.produceresume.service;

import cn.edu.bjut.entity.student.exprience.EducationInfo;
import cn.edu.bjut.entity.student.exprience.OrganizationExperience;
import cn.edu.bjut.entity.student.exprience.PracticeExperience;
import cn.edu.bjut.entity.student.exprience.ProjectExperience;
import cn.edu.bjut.entity.student.other.Resume;
import cn.edu.bjut.entity.student.performance.Certification;
import cn.edu.bjut.produceresume.mapper.StudentResumeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentResumeService implements StudentResumeServiceInterface {

    @Autowired
    private StudentResumeMapper studentResumeMapper;

    @Override
    public Integer insertProject(ProjectExperience projectExperience) {
        Integer existingRecords = studentResumeMapper.countProjectByIndex(projectExperience);
        System.out.println(existingRecords);
        Integer CertificationChange;
        if (existingRecords == null) {
            // 不存在记录，执行插入操作
            CertificationChange = studentResumeMapper.insertProject(projectExperience);
        } else {
            // 存在记录，执行更新操作
            CertificationChange = studentResumeMapper.updateProject(projectExperience);
        }
        log.info("Certificationinsert:", CertificationChange);
        return CertificationChange;
    }

    public Integer insertCertification(Certification certification) {
//        Integer Certificationinsert = studentResumeMapper.insertCertification(certification);
        Integer existingRecords = studentResumeMapper.countCertificateByIndex(certification);
        System.out.println(existingRecords);
        Integer CertificationChange;
        if (existingRecords == null) {
            // 不存在记录，执行插入操作
            CertificationChange = studentResumeMapper.insertCertification(certification);
        } else {
            // 存在记录，执行更新操作
            CertificationChange = studentResumeMapper.updateCertification(certification);
        }
        log.info("Certificationinsert:", CertificationChange);
        return CertificationChange;
    }

    @Override
    public List<Certification> getAllCertificates(Integer studentId) {
        return studentResumeMapper.getAllCertificates(studentId);
    }

    @Override
    public Integer deleteCertification(Certification certification) {
        Integer deleteNum = studentResumeMapper.deleteCertifications(certification);
        Integer updateCertificateAfterDelete = studentResumeMapper.updateCertificateAfterDelete(certification);
        return deleteNum;
    }

    @Override
    public List<ProjectExperience> getAllProject(Integer studentId) {
        return studentResumeMapper.getAllProject(studentId);
    }

    @Override
    public Integer deleteProject(ProjectExperience projectExperience) {
        Integer deleteNum = studentResumeMapper.deleteProject(projectExperience);
        Integer updateCertificateAfterDelete = studentResumeMapper.updateProjectAfterDelete(projectExperience);
        return deleteNum;
    }

    @Override
    public Integer insertOrganization(OrganizationExperience organizationExperience) {
        Integer existingRecords = studentResumeMapper.countOrganizationByIndex(organizationExperience);
        System.out.println(existingRecords);
        Integer organizationChagen;
        if (existingRecords == null) {
            // 不存在记录，执行插入操作
            organizationChagen = studentResumeMapper.insertOrganization(organizationExperience);
        } else {
            // 存在记录，执行更新操作
            organizationChagen = studentResumeMapper.updateOrganization(organizationExperience);
        }
        log.info("Certificationinsert:", organizationChagen);
        return organizationChagen;
    }

    @Override
    public Integer deleteOrganization(OrganizationExperience organizationExperience) {
        Integer deleteNum = studentResumeMapper.deleteOrganization(organizationExperience);
        Integer updateOrganizationAfterDelete = studentResumeMapper.updateOrganizationAfterDelete(organizationExperience);
        return deleteNum;
    }

    @Override
    public List<OrganizationExperience> getAllOrganization(Integer studentId) {
        return studentResumeMapper.getAllOrganization(studentId);
    }

    @Override
    public Integer insertPractice(PracticeExperience practiceExperience) {
        Integer existingRecords = studentResumeMapper.countPracticeByIndex(practiceExperience);
        System.out.println(existingRecords);
        Integer practiceChange;
        if (existingRecords == null) {
            // 不存在记录，执行插入操作
            practiceChange = studentResumeMapper.insertPractice(practiceExperience);
        } else {
            // 存在记录，执行更新操作
            practiceChange = studentResumeMapper.updatePractice(practiceExperience);
        }
        log.info("Certificationinsert:", practiceChange);
        return practiceChange;
    }

    @Override
    public Integer deletePractice(PracticeExperience practiceExperience) {
        Integer deleteNum = studentResumeMapper.deletePractice(practiceExperience);
        Integer updateOrganizationAfterDelete = studentResumeMapper.updatePracticeAfterDelete(practiceExperience);
        return deleteNum;
    }

    @Override
    public List<PracticeExperience> getAllPractice(Integer studentId) {
        return studentResumeMapper.getAllPractice(studentId);
    }

    @Override
    public Integer insertEducation(EducationInfo educationInfo) {
        Integer existingRecords = studentResumeMapper.countEducationByIndex(educationInfo);
        System.out.println(existingRecords);
        Integer practiceChange;
        if (existingRecords == null) {
            // 不存在记录，执行插入操作
            practiceChange = studentResumeMapper.insertEducation(educationInfo);
        } else {
            // 存在记录，执行更新操作
            practiceChange = studentResumeMapper.updateEducation(educationInfo);
        }
        log.info("Certificationinsert:", practiceChange);
        return practiceChange;
    }

    @Override
    public Integer deleteEducation(EducationInfo educationInfo) {
        Integer deleteNum = studentResumeMapper.deleteEducation(educationInfo);
        Integer updateOrganizationAfterDelete = studentResumeMapper.updateEducationAfterDelete(educationInfo);
        return deleteNum;
    }

    @Override
    public List<EducationInfo> getAllEducation(Integer studentId) {
        return studentResumeMapper.getAllEducation(studentId);
    }

    @Override
    public Integer insertLocalResume(Resume resume) {
        return studentResumeMapper.insertLocalResume(resume);
    }

    @Override
    public Integer deleteLocalResume(Resume resume) {
        return studentResumeMapper.deleteLocalResume(resume);
    }

    @Override
    public List<Resume> getAllResume(Integer studentId) {
        return studentResumeMapper.getAllResume(studentId);
    }
}