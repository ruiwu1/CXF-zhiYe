package com.CXF.mapper;

import com.CXF.model.ApplyStatusForMore;
import com.CXF.model.ExamData;
import com.CXF.model.ImageForMore;
import com.commen.pojo.zhiye.Image;
import com.commen.pojo.zhiye.PacsReport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:
 */
@Repository
public interface MutualCheckRuleMapper {

    ApplyStatusForMore getExamApplyStatus(ExamData examData);

    PacsReport selectPacsReportByExamUID(@Param("examUID") String examUID);

    List<ImageForMore> selectPacsImageByExamUID(@Param("examUID") String examUID);

    List<String> getApplyNo(@Param("examUID") String examUID);
}
