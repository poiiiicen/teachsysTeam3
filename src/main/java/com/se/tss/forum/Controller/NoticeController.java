package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.NoticeEntity;
import com.se.tss.forum.Entity.UserEntity;
import com.se.tss.forum.Models.Notice;
import com.se.tss.forum.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.se.tss.forum.TimeManager.getBeijingTime;

//@CrossOrigin
@RestController
public class NoticeController {
    @Autowired
    ForumUserService userService;
    @Autowired
    NoticeService noticeService;
    //创建公告
    //传入值：topic content creator_uid
    //返回值：新建公告的序号
    @RequestMapping(value = "bbs/notice/create")
    public Notice createNotice(@RequestBody Notice n)
    {
        UserEntity creator = userService.findByUid(n.getCreator_uid());
        if(creator.getAuthority().equals("Teacher")) {
            NoticeEntity noticeEntity = new NoticeEntity();
            noticeEntity.setTopic(n.getTopic());
            noticeEntity.setContent(n.getContent());
            noticeEntity.setCreateTime(getBeijingTime());
            noticeEntity.setCreator(creator);
            noticeEntity.setModifiedTime(getBeijingTime());
            noticeService.save(noticeEntity);
            n.setNid(noticeEntity.getNid());
        }
        else
            n.setNid(0);
        return n;
    }

    //查询所有公告
    //返回：所有公告列表
    @RequestMapping(value = "/bbs/notice/all")
    public List<Notice> allNotice(){
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        List<NoticeEntity> noticeEntities = noticeService.findAll(sort);
        List<Notice> notices = new ArrayList<>();
        for(NoticeEntity ne: noticeEntities)
        {
            Notice n = ne.getNotice();
            notices.add(n);
        }
        return notices;
    }

    //查询特定公告详细信息
    @RequestMapping(value = "/bbs/notice/find/{nid}")
    public Notice specPost(@PathVariable Integer nid){
        NoticeEntity ne = noticeService.findByNid(nid);
        Notice n = ne.getNotice();
        return  n;
    }

    //删除公告
    //公告ID，删除者ID
    @RequestMapping(value = "/bbs/notice/delete/{nid}/{uid}")
    public Notice deletePost(@PathVariable Integer nid, @PathVariable Integer uid){
        UserEntity deleter = userService.findByUid(uid);
        NoticeEntity ne = noticeService.findByNid(nid);
        Notice n = ne.getNotice();
        //if(deleter.getAuthority().equals("Admin") || uid == ne.getCreator().getUid())
            noticeService.delete(ne);
        //else
          //  n.setNid(0);
        return n;
    }
}
