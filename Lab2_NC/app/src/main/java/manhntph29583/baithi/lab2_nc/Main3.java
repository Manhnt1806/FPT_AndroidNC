package manhntph29583.baithi.lab2_nc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3 extends AppCompatActivity {
    Button btn1;
    EditText edt1;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn1 = findViewById(R.id.btn1L23);
        edt1 = findViewById(R.id.edtL23);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edt1.getText().toString();
                Intent intent = new Intent(context, myBR3.class);
                intent.putExtra("br", str);
                sendBroadcast(intent);
            }
        });
    }
}