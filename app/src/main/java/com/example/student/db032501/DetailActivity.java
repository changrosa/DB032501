package com.example.student.db032501;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tv1, tv2, tv3, tv4;

        int ID = getIntent().getIntExtra("ID", 0);
        studentDAOMemoryImpl impl = new studentDAOMemoryImpl();
        student student = impl.getStudent(ID);

        System.out.println("===== student");

        tv1 = (TextView) findViewById(R.id.txDetailID);
        tv2 = (TextView) findViewById(R.id.txDetailName);
        tv3 = (TextView) findViewById(R.id.txDetailTel);
        tv4 = (TextView) findViewById(R.id.txDetailAddr);

        tv1.setText(String.valueOf(student.ID));
        tv2.setText(student.Name);
        tv3.setText(student.Tel);
        tv4.setText(student.Addr);
    }
}
