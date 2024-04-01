package cn.edu.bjut.manageridentified.service.implement;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.manager.RegisterApproval;
import cn.edu.bjut.manageridentified.mapper.ManagerIdentifiedMapper;
import cn.edu.bjut.manageridentified.service.ManagerIdentifyService;
import cn.edu.bjut.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
public class ManagerIdentifyImpl implements ManagerIdentifyService {

    @Autowired
    private ManagerIdentifiedMapper managerIdentifiedMapper;

    @Override
    public List<Enterprise> selectPendingFirm() {
        return managerIdentifiedMapper.selectPendingFirm();
    }

    @Override
    public List<Map<Object, Object>> selectApprovalFirm() {
        return managerIdentifiedMapper.selectApprovalFirm();
    }

    @Override
    public Enterprise enterpriseDetail(Enterprise enterprise) {
        return managerIdentifiedMapper.selectEnterpriseDetail(enterprise);
    }

    @Override
    public List<Enterprise> selectPendingFirmOnNameAndCreditCode(Enterprise enterprise) {
        return managerIdentifiedMapper.selectPendingFirmOnNameAndCreditCode(enterprise);
    }

    @Override
    public List<Map<Object, Object>> selectApprovalFirmOnStatus(RegisterApproval registerApproval) {
        return managerIdentifiedMapper.selectApprovalFirmOnStatus(registerApproval);
    }

    @Override
    public Integer updateEnterpriseStatus(Enterprise enterprise) {
        return managerIdentifiedMapper.updateEnterpriseStatus(enterprise);
    }

    @Override
    @Transactional
    public Boolean approvalRegisterFirm(RegisterApproval registerApproval) {
        Integer firmStatusNum = managerIdentifiedMapper.updateEnterpriseStatus(registerApproval.getEnterprise());
        log.info("firmStatusNum:", firmStatusNum);
        LocalDateTime localDateTime = LocalDateTime.now();
        registerApproval.setApprovalTime(localDateTime);
        Integer approvalRecordStatusNum = managerIdentifiedMapper.insertApprovalRecord(registerApproval);
        log.info("approvalRecordStatusNum:", approvalRecordStatusNum);
        return firmStatusNum > 0 && approvalRecordStatusNum > 0;
    }
}
