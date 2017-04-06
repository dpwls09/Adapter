package comwow2778.naver.blog.app5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6;
    RadioButton r1,r2,r3;
    ArrayList<list> information = new ArrayList<list>();
    int category_number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
        e3 = (EditText)findViewById(R.id.e3);
        e4 = (EditText)findViewById(R.id.e4);
        e5 = (EditText)findViewById(R.id.e5);
        e6 = (EditText)findViewById(R.id.e6);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);
    }

    public void onmyclick(View v){
        if(v.getId() == R.id.b2){
            Toast.makeText(this,"취소 되었습니다.",Toast.LENGTH_SHORT);
        }
        else if(v.getId() ==R.id.b3){
            String menu[] = new String[3];
            String name = e1.getText().toString();
            String call = e2.getText().toString();
            menu[0] = e3.getText().toString();
            menu[1] = e4.getText().toString();
            menu[2] = e5.getText().toString();
            String adress = e6.getText().toString();
            String when = DateFormat.getDateInstance().format(new Date());
            category_number++;
            String category = String.valueOf(category_number);
            list i= new list(name,call,menu,adress,when,category);
            information.add(i);

            Intent intent = new Intent(this, Main3Activity.class);
            Intent intent2 = new Intent(this, MainActivity.class);
            //2->3
            // ->1

        }
    }
}
