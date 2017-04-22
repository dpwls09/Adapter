package comwow2778.naver.blog.app5;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView l1;
    Button b1;
    EditText et1;
    final int request_code_1 = 1;
    final int request_code_2 = 2;
    ArrayList<list> information = new ArrayList<list>();
    BaseAdapters adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1 = (ListView) findViewById(R.id.listview);
        b1 = (Button) findViewById(R.id.bchoice);
        et1 = (EditText) findViewById(R.id.et1);

        adapter = new BaseAdapters(information, this);
        l1 = (ListView) findViewById(R.id.listview);
        l1.setAdapter(adapter);
        list_order();
        textfilter();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1.getText().equals("선택")) {
                    b1.setText("삭제");
                    adapter.isCheckBoxState(true);
                    adapter.parameter = 1;
                } else {
                    b1.setText("선택");
                    adapter.setCheckBox(true);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("삭제하시겠습니까?")
                            .setPositiveButton("닫기", null)
                            .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    for (int i = information.size()-1; i >= 0; i--) {
                                        list data = information.get(i);
                                        if (data.IsSelected()) {
                                            information.remove(data);
                                            adapter.notifyDataSetChanged();
                                        }
                                    }
                                    adapter.parameter = 0;
                                }
                            })
                            .show();
                    adapter.isCheckBoxState(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    void textfilter(){
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String search = s.toString();
                adapter.getFilter().filter(search);
            }
        });

    }

    void list_order() {
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent3 = new Intent(MainActivity.this, Main3Activity.class);
                intent3.putExtra("act3", information.get(position));
                startActivityForResult(intent3, request_code_2);
            }
        });
    }

    public void onmyclick(View v) {
        if (v.getId() == R.id.b1) {
            Intent intent2 = new Intent(this, Main2Activity.class);
            startActivityForResult(intent2, request_code_1);
        } else if (v.getId() == R.id.bsort) {
            adapter.setNameAsc();
        } else if (v.getId() == R.id.bsort2) {
            adapter.setCategoryAsc();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == request_code_1 && resultCode == RESULT_OK) {
            list i1 = data.getParcelableExtra("name");
            information.add(i1);
            adapter.notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
