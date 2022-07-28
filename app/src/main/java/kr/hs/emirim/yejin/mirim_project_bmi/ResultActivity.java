package kr.hs.emirim.yejin.mirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView textComment = findViewById(R.id.text_result_comment);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        ImageView imgv=findViewById(R.id.imgv);
        double weight = Double.parseDouble(intent.getStringExtra("weight"));
        double height = Double.parseDouble(intent.getStringExtra("height"));
        double bmi = weight / Math.pow(height/100, 2);
        String bmiResult = "";
        if(bmi < 18.5){
            bmiResult = "저체충";
            imgv.setImageResource(R.drawable.bmi1);
        }else if (bmi < 24.9){
            bmiResult = "정상";
            imgv.setImageResource(R.drawable.bmi2);
        }else if (bmi < 29.9){
            bmiResult = "과체중";
            imgv.setImageResource(R.drawable.bmi3);
        }else if (bmi < 34.9){
            bmiResult = "비만";
            imgv.setImageResource(R.drawable.bmi4);
        }else {
            bmiResult = "고도비만";
            imgv.setImageResource(R.drawable.bmi5);
        }
        textComment.setText(name + "님의 BMI지수는 " + String.format("%.2f", bmi) + "입니다. 따라서" + bmiResult + "체중입니다.");
    }
}