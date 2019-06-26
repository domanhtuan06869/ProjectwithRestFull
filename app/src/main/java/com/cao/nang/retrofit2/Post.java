package com.cao.nang.retrofit2;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("short_desc")
    private String category;
    @SerializedName("cate_id")
    private String description;
    @SerializedName("image")
    private String url;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
