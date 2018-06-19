package com.se.tss.CourseArrangeMgr.logic;

import com.se.tss.CourseArrangeMgr.Dao.ClassInfo;
import com.se.tss.CourseArrangeMgr.Dao.ClassRoomInfo;
import com.se.tss.CourseArrangeMgr.Dao.TeacherInfo;
import com.se.tss.CourseArrangeMgr.Service.ClassInfoService;
import com.se.tss.CourseArrangeMgr.Service.ClassRoomInfoService;
import com.se.tss.CourseArrangeMgr.Service.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Configuration
public class ArrangeClassLogic {
    //自动排课的主逻辑

    @Autowired
    ClassInfoService classInfoService;
    @Autowired
    TeacherInfoService teacherInfoService;
    @Autowired
    ClassRoomInfoService classRoomInfoService;
    @Autowired
    AddLogic addLogic;

    public void Arrange(){
        //获取所有需要投影仪的课程
        List<ClassInfo> classNeedPro = classInfoService.findAllByEquipment("processor");
        //获取所有不需要投影仪的课程
        List<ClassInfo> classNoNeedPro = classInfoService.findAllByEquipment(null);
        //合并
        classNeedPro.addAll(classNoNeedPro);
        List<ClassInfo> allClass = new ArrayList<>(classNeedPro);
        //遍历所有课程
        for(ClassInfo classInfo: allClass){
            //拿到上课老师ID
            String teacherId = classInfo.getTeacherid();
            //拿到上课老师DAO
            TeacherInfo teacherInfo=teacherInfoService.findTeacherInfoById(teacherId);
            //拿到老师所在校区所有教室
            List<ClassRoomInfo> classRoomInfoInPlace=classRoomInfoService.findByPlace(teacherInfo.getPlace());
            //拿到不在老师所在校区所有教室
            List<ClassRoomInfo> classRoomInfoNotInPlace=classRoomInfoService.findByPlaceNot(teacherInfo.getPlace());
            //合并
            classRoomInfoInPlace.addAll(classRoomInfoNotInPlace);
            List<ClassRoomInfo> classRoomInfos =new ArrayList<>(classRoomInfoInPlace);
            //排课成功标记
            boolean flag=false;
            //遍历
            for(ClassRoomInfo classRoomInfo: classRoomInfos){
                //从周一到周五 每天六个时间段遍历
                for(int i=0;i<4;i++){
                    for(int j=0;j<4;j++){
                        //试图插入课程
                        String result=addLogic.Add(teacherId,classInfo.getId(),classRoomInfo.getId(),i,j);
                        if(result==""){  //插入成功退出循环
                            flag=true;
                            break;
                        }
                        else{
                            continue;
                        }
                    }
                    if(flag){  //插入成功退出循环
                        i--;
                        break;
                    }
                }
                if(flag){  //插入成功退出循环
                    break;
                }
            }
        }
    }


}
