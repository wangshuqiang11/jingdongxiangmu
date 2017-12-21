package com.bawei.jingdongxiangmu.faxian;

public class My_ListBean {

    /**
     * airTime : 2017
     * angleIcon :
     * dataId : CMCC_00000000000000001_626996536
     * description : 《变形金刚5》新片段“热破”现身
     * duration : 00:01:19
     * loadURL : http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=CMCC_00000000000000001_626996536
     * loadtype : video
     * pic : http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/05/09/1494321106287069775.jpg
     * roomId :
     * score : 0
     * shareURL : http://m.svipmovie.com/#/moviedetails/CMCC_00000000000000001_626996536
     * title : 《变形金刚5》新片段“热破”现身
     */

    private int airTime;
    private String angleIcon;
    private String dataId;
    private String description;
    private String duration;
    private String loadURL;
    private String loadtype;
    private String pic;
    private String roomId;
    private int score;
    private String shareURL;
    private String title;

    public int getAirTime() {
        return airTime;
    }

    public void setAirTime(int airTime) {
        this.airTime = airTime;
    }

    public String getAngleIcon() {
        return angleIcon;
    }

    public void setAngleIcon(String angleIcon) {
        this.angleIcon = angleIcon;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLoadURL() {
        return loadURL;
    }

    public void setLoadURL(String loadURL) {
        this.loadURL = loadURL;
    }

    public String getLoadtype() {
        return loadtype;
    }

    public void setLoadtype(String loadtype) {
        this.loadtype = loadtype;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getShareURL() {
        return shareURL;
    }

    public void setShareURL(String shareURL) {
        this.shareURL = shareURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "My_ListBean{" +
                "airTime=" + airTime +
                ", angleIcon='" + angleIcon + '\'' +
                ", dataId='" + dataId + '\'' +
                ", description='" + description + '\'' +
                ", duration='" + duration + '\'' +
                ", loadURL='" + loadURL + '\'' +
                ", loadtype='" + loadtype + '\'' +
                ", pic='" + pic + '\'' +
                ", roomId='" + roomId + '\'' +
                ", score=" + score +
                ", shareURL='" + shareURL + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
