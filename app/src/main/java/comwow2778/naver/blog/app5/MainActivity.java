package comwow2778.naver.blog.app5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {

    ListView l1;
    final int request_code_1 = 1;
    final int request_code_2 = 2;
    ArrayList<list> information = new ArrayList<list>();
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l1 = (ListView)findViewById(R.id.listview);
        adapter = new BaseAdapters(information,this);
        l1.setAdapter(adapter);
        list_longorder();
        list_order();

    }
    void list_longorder(){
        l1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("삭제확인").setNegativeButton("취소",null).setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        information.remove(information.get(position));
                        adapter.notifyDataSetChanged();
                        Snackbar.make(getWindow().getDecorView().getRootView(),"삭제되었습니다.",Snackbar.LENGTH_SHORT).show();
                    }
                }).show();

                return true;
            }
        });
    }
    void list_order(){
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent3 = new Intent(MainActivity.this,Main3Activity.class);
                intent3.putExtra("act3",information.get(position));
                startActivityForResult(intent3,request_code_2);
            }
        });
    }

    public void onmyclick(View v){
        if(v.getId() == R.id.b1){
            Intent intent2 = new Intent(this, Main2Activity.class);
            startActivityForResult(intent2,request_code_1);
        }
        else if(v.getId() == R.id.bsort){
            sortname();
        }
        else if(v.getId() == R.id.bsort2){
            sortcategory();
        }
        else if(v.getId() == R.id.bchoice){
            choice();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == request_code_1 && resultCode == RESULT_OK) {
            list i1 = data.getParcelableExtra("name");
            information.add(i1);
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void sortname(){
        Comparator<list> sortname = new Comparator<list>() {
            @Override
            public int compare(list o1, list o2) {
                return o1.name.compareToIgnoreCase(o2.name);
            }
        };
        Collections.sort(information, sortname);
    }
    public void sortcategory(){
        Comparator<list> sortcategory = new Comparator<list>() {
            @Override
            public int compare(list o1, list o2) {
                return o1.category.compareToIgnoreCase(o2.category);
            }
        };

    }
    public void choice(){

    }
}
