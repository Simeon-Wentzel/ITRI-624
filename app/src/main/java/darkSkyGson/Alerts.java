package darkSkyGson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Alerts {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("expires")
    @Expose
    private Integer expires;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("uri")
    @Expose
    private String uri;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Alerts withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Alerts withTime(Integer time) {
        this.time = time;
        return this;
    }

    public Integer getExpires() {
        return expires;
    }

    public void setExpires(Integer expires) {
        this.expires = expires;
    }

    public Alerts withExpires(Integer expires) {
        this.expires = expires;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Alerts withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Alerts withUri(String uri) {
        this.uri = uri;
        return this;
    }

}
