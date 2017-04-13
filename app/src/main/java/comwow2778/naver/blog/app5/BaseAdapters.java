package comwow2778.naver.blog.app5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by seon on 2017-04-13.
 */

public class BaseAdapters extends BaseAdapter {
    ArrayList<list> data;
    Context c;

    public BaseAdapters(ArrayList<list> data, Context c){
        this.data = data;
        this.c = c;
    }

    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(c);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.listlayout,null);
        }
        ImageView i1 = (ImageView)convertView.findViewById(R.id.listimage);
        TextView t1 = (TextView)convertView.findViewById(R.id.listt1);
        TextView t2 = (TextView)convertView.findViewById(R.id.listt2);
        t1.setText(data.get(position).name);
        t2.setText(data.get(position).call);
        String a = data.get(position).category;
        if (a.equals("1")) {
            i1.setImageResource(R.drawable.ch);
        } else if (a.equals("2")) {
            i1.setImageResource(R.drawable.pi);
        } else if (a.equals("3")) {
            i1.setImageResource(R.drawable.ha);
        }
        return convertView;
    }
}
