package comwow2778.naver.blog.app5;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by seon on 2017-04-06.
 */

public class list implements Parcelable{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String[] getMenu(int i) {
        return menu;
    }

    public void setMenu(String[] menu) {
        this.menu = menu;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public boolean IsSelected(){return this.selected;}


    private String name = "";
    private String call = "";
    String menu[] = new String[3];
    private String adress = "";
    private String when = "";
    private String category = "";
    private CheckBox checkBox;
    public boolean selected;
    public list(String name, String call, String menu[], String adress, String when, String category){
        this.name = name;
        this.call = call;
        this.menu = menu;
        this.adress = adress;
        this.when = when;
        this.category = category;
        this.selected = false;
    }

    protected list(Parcel in) {
        name = in.readString();
        call = in.readString();
        menu = in.createStringArray();
        adress = in.readString();
        when = in.readString();
        category = in.readString();
    }

    public static final Creator<list> CREATOR = new Creator<list>() {
        @Override
        public list createFromParcel(Parcel in) {
            return new list(in);
        }

        @Override
        public list[] newArray(int size) {
            return new list[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(call);
        dest.writeStringArray(menu);
        dest.writeString(adress);
        dest.writeString(when);
        dest.writeString(category);
    }
}
