package com.example.recyclercard;

public class Instagram {

    private int MyImageSource;
    private String Text;

    public Instagram(int myImageSource,String Text){
        MyImageSource = myImageSource;
        Text = Text;
    }

    public int getMyImageSource() {
        return MyImageSource;
    }

    public void setMyImageSource(int myImageSource) {
        MyImageSource = myImageSource;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
