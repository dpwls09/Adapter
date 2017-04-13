package comwow2778.naver.blog.app5;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    TextView t2, t3, t4, t5, t6, t7, t8;
    ImageView i1;
    ImageView ib1, ib2;
    list list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t4 = (TextView) findViewById(R.id.t4);
        t5 = (TextView) findViewById(R.id.t5);
        t6 = (TextView) findViewById(R.id.t6);
        t7 = (TextView) findViewById(R.id.t7);
        t8 = (TextView) findViewById(R.id.t8);
        i1 = (ImageView) findViewById(R.id.i1);
        ib1 = (ImageView) findViewById(R.id.ib1);
        ib2 = (ImageView) findViewById(R.id.ib2);

        Intent intent = getIntent();
        list = intent.getParcelableExtra("act3");
        t2.setText(list.name);
        t3.setText(list.menu[0]);
        t4.setText(list.menu[1]);
        t5.setText(list.menu[2]);
        t6.setText(list.call);
        t7.setText(list.adress);
        t8.setText(list.when);
        image(list.category);
    }

    public void onmyclick(View v) {
        if (v.getId() == R.id.b4) {
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        } else {
            if (v.getId() == R.id.ib1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + list.call));
                startActivity(intent);
            } else if (v.getId() == R.id.ib2) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + list.adress));
                startActivity(intent);
            }
        }

    }
    public void image(String a) {
        if (a == "1") {
            i1.setImageResource(R.drawable.ch);
        } else if (a == "2") {
            i1.setImageResource(R.drawable.pi);
        } else if (a == "3") {
            i1.setImageResource(R.drawable.ha);
        }
    }

}
