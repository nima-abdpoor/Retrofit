package com.chino.retrofitlib;

import com.google.gson.annotations.SerializedName;

public class Comments {
    private String postId;
    private String id;
    private String name;
    private String email;
    @SerializedName("body")
    private String body;

    public String getPostId() {
        return postId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
