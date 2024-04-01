package cn.edu.bjut.manageridentified.service.implement;

import cn.edu.bjut.entity.enterprise.Enterprise;
import cn.edu.bjut.entity.manager.RegisterApproval;
import cn.edu.bjut.manageridentified.mapper.ManagerIdentifiedMapper;
import cn.edu.bjut.manageridentified.service.ManagerIdentifyService;
import cn.edu.bjut.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List<RegisterApproval> selectApprovalFirmOnStatus(RegisterApproval registerApproval) {
        return managerIdentifiedMapper.selectApprovalFirmOnStatus(registerApproval);
    }
}
