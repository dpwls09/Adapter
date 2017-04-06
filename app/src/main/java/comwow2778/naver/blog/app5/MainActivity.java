package comwow2778.naver.blog.app5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t1;
    final int request_code_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onmyclick(View v){
        if(v.getId() == R.id.b1){
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);

            startActivityForResult(intent,request_code_1);
        }

    }
}
