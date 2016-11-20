package bean;

/**
 * Created by tianyunchen on 11/20/16.
 */

public class Announcement {
    private int anid;
    private String content;
    private String title;
    private String date;

    public void setAnid(int anid) {
        this.anid = anid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAnid() {
        return anid;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }
}
