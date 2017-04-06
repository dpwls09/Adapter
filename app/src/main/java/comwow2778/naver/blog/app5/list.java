package comwow2778.naver.blog.app5;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by seon on 2017-04-06.
 */

public class list implements Parcelable{
    String name = "";
    String call = "";
    String menu[] = new String[3];
    String adress = "";
    String when = "";
    String category = "";
    public list(String name, String call, String menu[], String adress, String when, String category){
        this.name = name;
        this.call = call;
        this.menu = menu;
        this.adress = adress;
        this.when = when;
        this.category = category;
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
