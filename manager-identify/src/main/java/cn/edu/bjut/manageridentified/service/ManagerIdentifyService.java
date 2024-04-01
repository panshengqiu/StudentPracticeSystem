package cn.edu.bjut.manageridentified.service;

import cn.edu.bjut.entity.enterprise.Enterprise;

import java.util.List;
import java.util.Map;

public interface ManagerIdentifyService {
    public List<Enterprise> selectPendingFirm();
    public List<Map<Object, Object>> selectApprovalFirm();
    public Enterprise enterpriseDetail(Enterprise enterprise);
}
