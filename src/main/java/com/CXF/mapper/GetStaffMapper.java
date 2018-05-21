package com.CXF.mapper;

import com.commen.pojo.Dept;
import com.commen.pojo.StaffDept;
import com.commen.pojo.StaffSystem;
import com.commen.pojo.User;
import com.commen.pojo.zhiye.ApplyInfo;
import com.commen.pojo.zhiye.ApplyStatus;
import com.commen.pojo.zhiye.ExamItem;
import com.commen.pojo.zhiye.PacsReport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetStaffMapper {

    List<User> getUserByStaff(User user);

    List<Dept> getStaffDept(StaffDept staffDept);

    ApplyStatus getExamApplyStatus(String ExamUID);

    ApplyInfo getApplyStatus(ExamItem examItem);

    PacsReport getPacsReport(PacsReport report);

    List<String> getApplyNos(PacsReport report);
}
