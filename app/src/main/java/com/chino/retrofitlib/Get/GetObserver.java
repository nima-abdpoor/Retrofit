package com.chino.retrofitlib.Get;

import com.chino.retrofitlib.MainActivity;

public class GetObserver {
    GetPost getPost;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result;

    public GetObserver(GetPost getPost){
        this.getPost=getPost;
    }
    public void Update(){
        MainActivity.result.setText(getPost.getResult());
    }
}
