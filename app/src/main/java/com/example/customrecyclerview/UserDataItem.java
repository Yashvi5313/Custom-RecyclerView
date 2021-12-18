package com.example.customrecyclerview;

public class UserDataItem {
    String UserName;
    String Gender;
    String MobileNo;
    int Image;
    boolean isSelected;

    public UserDataItem(String UserName, String Gender, String MobileNo, int Image){
        this.UserName = UserName;
        this.Gender = Gender;
        this.MobileNo = MobileNo;
        this.Image = Image;
    }

    public String getUserName() { return UserName; }

    public String getGender() { return Gender; }

    public String getMobileNo() { return MobileNo; }

    public int getImage() { return Image; }

    public boolean isSelected() { return isSelected; }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
