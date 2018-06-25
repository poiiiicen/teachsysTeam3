package com.se.tss.forum.Controller;

import com.se.tss.forum.Entity.PostEntity;
import com.se.tss.forum.Entity.ReplyEntity;
import com.se.tss.forum.Models.Reply;
import com.se.tss.forum.Service.ForumUserService;
import com.se.tss.forum.Service.PostService;
import com.se.tss.forum.Service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.se.tss.forum.TimeManager.getBeijingTime;

//@CrossOrigin
@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;
    @Autowired
    PostService postService;
    @Autowired
    ForumUserService userService;

    //创建回帖
    //传入值：pid, uid, reply_content
    //返回值：回帖的信息+序号
    @RequestMapping(value = "bbs/reply/create")
    public Reply createNotice(@RequestBody Reply r) {
        ReplyEntity replyEntity = new ReplyEntity();
        PostEntity postEntity = postService.findByPid(r.getPid());
        Timestamp replyTime = getBeijingTime();
        replyEntity.setCreator(userService.findByUid(r.getUid()));//userService.findByUid(r.getCreator_uid()));
        replyEntity.setContent(r.getReply_content());
        replyEntity.setReplyTime(replyTime);
        replyEntity.setPost(postEntity);
        postEntity.setLastReplyTime(replyTime);
        postService.save(postEntity);
        replyService.save(replyEntity);
        r.setRid(replyEntity.getRid());
        return r;
    }
    //得到某用户的回帖
    @RequestMapping(value = "/bbs/reply/user/{uid}")
    public List<Reply> searchPost(@PathVariable Integer uid){
        List<ReplyEntity> replyEntities = replyService.findByCreatorOrderByReplyTimeDesc(userService.findByUid(uid));
        List<Reply> replies = new ArrayList<>();
        for(ReplyEntity re: replyEntities)
        {
            Reply r = re.getReply();
            replies.add(r);
        }
        return replies;
    }
}