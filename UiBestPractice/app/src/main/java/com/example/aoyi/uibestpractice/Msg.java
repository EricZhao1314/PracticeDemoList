package com.example.aoyi.uibestpractice;

/**
 * Created by aoyi on 2016/12/12.
 */

public class Msg {
    public static int TYPE_RECEIVED=0;
    public static int TYPE_SENT=1;
    private String content;
    private int type;

    public Msg(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
