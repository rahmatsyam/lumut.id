package io.github.rahmatsyam.lumutid.data.model;

public class ItemData {

    private String mtitle;
    private int mUserId;
    private int mId;

    public ItemData() {

    }

    public ItemData(String title, int userId, int id) {
        this.mtitle = title;
        this.mUserId = userId;
        this.mId = id;

    }

    public String getTitle() {
        return mtitle;
    }

    public void setTitle(String title) {
        this.mtitle = title;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        this.mUserId = userId;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

}
