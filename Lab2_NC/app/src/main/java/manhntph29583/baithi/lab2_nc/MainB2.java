package manhntph29583.baithi.lab2_nc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainB2 extends AppCompatActivity {
    Button btn1;
    EditText edt1;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b2);
        btn1 = findViewById(R.id.btn1L22);
        edt1 = findViewById(R.id.edtL22);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= edt1.getText().toString();
                Intent intent = new Intent(context, myBR2.class);
                intent.putExtra("br", data);
                sendBroadcast(intent);
            }
        });
    }
}