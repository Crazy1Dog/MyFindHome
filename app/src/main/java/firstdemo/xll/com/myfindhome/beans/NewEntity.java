package firstdemo.xll.com.myfindhome.beans;

/**
 * Created by steven on 2015/11/18.
 * {
 "id": "HOS2015111801224408",
 "type": "0",
 "title": "去库存已定 后续政策如何？",
 "summary": "下一步应重点关注高库存的三四线城市，多管齐下稳定市场。",
 "thumbnail": "http://inews.gtimg.com/newsapp_ls/0/96953519_640330/0",
 "groupthumbnail": "http://inews.gtimg.com/newsapp_ls/0/96953519_150120/0",
 "commentcount": 162,
 "imagecount": 2,
 "commentid": "1249476869"
 },
 */
public class NewEntity {
    private String id;
    private int type;
    private String title;
    private String summary;
    private String thumbnail;
    private String groupthumbnail;
    private int commentcount;
    private int imagecount;
    private String commentid;

    public NewEntity(String id, int type, String title, String summary, String thumbnail, String groupthumbnail, int commentcount, int imagecount, String commentid) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.summary = summary;
        this.thumbnail = thumbnail;
        this.groupthumbnail = groupthumbnail;
        this.commentcount = commentcount;
        this.imagecount = imagecount;
        this.commentid = commentid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getGroupthumbnail() {
        return groupthumbnail;
    }

    public void setGroupthumbnail(String groupthumbnail) {
        this.groupthumbnail = groupthumbnail;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public int getImagecount() {
        return imagecount;
    }

    public void setImagecount(int imagecount) {
        this.imagecount = imagecount;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    @Override
    public String toString() {
        return "NewEntity{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", groupthumbnail='" + groupthumbnail + '\'' +
                ", commentcount=" + commentcount +
                ", imagecount=" + imagecount +
                ", commentid='" + commentid + '\'' +
                '}';
    }
}
