package com.smart.service;

import com.smart.dao.CommentLogDao;
import com.smart.dao.ViewPointDao;
import com.smart.dao.ViewSpaceDao;
import com.smart.domain.CommentLog;
import com.smart.domain.ViewPoint;
import com.smart.domain.ViewSpace;
import com.smart.service.exception.IpCommentedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wuchao
 * @date： 2017/2/20
 */
@Service
public class ViewSpaceService {

    @Autowired
    private ViewSpaceDao viewSpaceDao;

    @Autowired
    private ViewPointDao viewPointDao;

    @Autowired
    private CommentLogDao commentLogDao;

    public void addViewSpace(ViewSpace viewSpace) {
        viewSpaceDao.save(viewSpace);
    }

    public void deleteViewSpace(int spaceId) {
        commentLogDao.removeBySpaceId(spaceId);
        ViewSpace viewSpace = viewSpaceDao.load(spaceId);
        viewSpaceDao.remove(viewSpace);

    }

    public void updateViewSpace(ViewSpace viewSpace) {
        viewSpaceDao.update(viewSpace);
    }

    public List<ViewSpace> queryViewSpaceByName(String name) {
        return viewSpaceDao.queryByName(name);
    }

    public List<ViewSpace> queryViewSpaceById(int user_id) {
        return viewSpaceDao.queryByUserId(user_id);
    }

    public List<ViewSpace> getAllViewSpaces() {
        return viewSpaceDao.loadAll();
    }

    public ViewSpace getFullViewSpace(int spaceId) {
        ViewSpace viewSpace = viewSpaceDao.get(spaceId);
        if (viewSpace != null) {
            viewSpaceDao.initialize(viewSpace.getViewPoints());
            viewSpaceDao.initialize(viewSpace.getUser());
            return viewSpace;
        }
        return null;
    }

    public ViewSpace getViewSpace(int spaceId) {
        return viewSpaceDao.get(spaceId);
    }


   public void addCommentLog(CommentLog commentLog) throws IpCommentedException {
       ViewSpace viewSpace = commentLog.getViewSpace();
       viewSpace = viewSpaceDao.load(viewSpace.getSpaceId());
       boolean commented = commentLogDao.isIpCommented(viewSpace.getSpaceId(), commentLog.getIp());
       if (commented) {
           throw new IpCommentedException("这个IP已经对景区进行了评论");
       }
       commentLog.setViewSpace(viewSpace);
       switch (commentLog.getCommentType()) {
           case CommentLog.WANT_TO_GO:
               viewSpace.setWantNum(viewSpace.getWantNum() + 1);
               break;
           case CommentLog.HAVE_BEAN_GO:
               viewSpace.setBeenNum(viewSpace.getBeenNum() + 1);
               break;
           case CommentLog.DONT_WANT_TO_GO:
               viewSpace.setNotwantNum(viewSpace.getNotwantNum() + 1);
               break;
           default:
                throw new RuntimeException("评论类型不正确");
       }
       commentLogDao.save(commentLog);
   }

    public List<CommentLog> getCommentLogBySpaceId(int spaceId) {
        return commentLogDao.getCommentLogBySpaceId(spaceId);
    }


    /**
     * 景点维护
     */


    public void addViewPoint(ViewPoint viewPoint) {
        viewPointDao.save(viewPoint);
    }


    public ViewPoint getFullViewPoint(int pointId) {
        ViewPoint vp = viewPointDao.get(pointId);
        return vp;
    }


    public void deleteViewPoint(int pointId) {
        ViewPoint vp = viewPointDao.get(pointId);

        viewPointDao.remove(vp);
    }

    public void updateViewPoint(ViewPoint viewPoint) {
        viewPointDao.update(viewPoint);
    }


    public void setCommentLogDao(CommentLogDao commentLogDao) {
        this.commentLogDao = commentLogDao;
    }

    public void setViewPointDao(ViewPointDao viewPointDao) {
        this.viewPointDao = viewPointDao;
    }

    public void setViewSpaceDao(ViewSpaceDao viewSpaceDao) {
        this.viewSpaceDao = viewSpaceDao;
    }
}
