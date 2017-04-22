package comwow2778.naver.blog.app5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by seon on 2017-04-13.
 */

public class BaseAdapters extends BaseAdapter implements Filterable{
    private boolean mCheckBoxState = false;
    private boolean checkboxstate = false;
    ArrayList<list> data = new ArrayList<>();
    ArrayList<list> filtered = new ArrayList<>();
    Context context;
    Filter listFilter;
    int parameter =0;

    public BaseAdapters(ArrayList<list> data, Context c){
        this.data = data;
        this.context = c;
        this.filtered = data;
    }

    public int getCount() {
        return filtered.size();
    }

    @Override
    public Object getItem(int position) {
        return filtered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.listlayout,null);
        }
        ImageView i1 = (ImageView)convertView.findViewById(R.id.listimage);
        TextView t1 = (TextView)convertView.findViewById(R.id.listt1);
        TextView t2 = (TextView)convertView.findViewById(R.id.listt2);
        CheckBox cbox = (CheckBox)convertView.findViewById(R.id.checkBox);
        final list data = filtered.get(position);
        if (parameter == 0) {
            data.selected = false;
            cbox.setChecked(false);
        }
        if (mCheckBoxState) {
            if (cbox.isChecked()) {

                data.selected = true;
            }
            else {
                data.selected = false;
            }
        }
        if (checkboxstate) {
            cbox.setVisibility(CheckBox.VISIBLE);
        }
        else {
            cbox.setVisibility(CheckBox.INVISIBLE);
        }


        t1.setText(filtered.get(position).getName());
        t2.setText(filtered.get(position).getCall());
        String a =filtered.get(position).getCategory();
        if (a.equals("1")) {
            i1.setImageResource(R.drawable.ch);
        } else if (a.equals("2")) {
            i1.setImageResource(R.drawable.pi);
        } else if (a.equals("3")) {
            i1.setImageResource(R.drawable.ha);
        }
        return convertView;
    }
        Comparator<list> sortname = new Comparator<list>() {
            @Override
            public int compare(list o1, list o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        Comparator<list> sortcategory = new Comparator<list>() {
            @Override
            public int compare(list o1, list o2) {
                return o1.getCategory().compareToIgnoreCase(o2.getCategory());
            }
        };

    public void setNameAsc() {
        Collections.sort(filtered, sortname);
        this.notifyDataSetChanged();
    }

    public void setCategoryAsc() {
        Collections.sort(filtered, sortcategory);
        this.notifyDataSetChanged();
    }
    public void setCheckBox(boolean pState) {
        mCheckBoxState = pState;
        notifyDataSetChanged();
    }

    public void isCheckBoxState(boolean state) {
        checkboxstate = state;
        notifyDataSetChanged();
    }


    @Override
    public Filter getFilter() {
        if (listFilter == null) listFilter = new ListFilter();
        return listFilter;
    }

    private class ListFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint == null || constraint.length() == 0) {
                results.values = data;
                results.count = data.size();
            } else {
                ArrayList<list> itemList = new ArrayList<list>();
                for (list item : data) {
                    if (item.getName().toUpperCase().contains(constraint.toString().toUpperCase()))
                        itemList.add(item);
                }
                results.values = itemList;
                results.count = itemList.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filtered = (ArrayList<list>) results.values;
            if (results.count >= 0) notifyDataSetChanged();
            else notifyDataSetInvalidated();
        }
    }
}
