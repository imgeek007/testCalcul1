package com.example.testcalcul;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    final int MENU_RESET_ID=1;
    final int MENU_QUIT_ID=2;


    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnOk;

    TextView tvResult;
    String oper=" ";
    float num2=0;
    float num1=0;
    float result=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=findViewById(R.id.tvResult);
        etNum1=findViewById(R.id.etNum1);
        etNum2=findViewById(R.id.etNum2);
        btnAdd=findViewById(R.id.btnAdd);
        btnSub=findViewById(R.id.btnSub);
        btnMult=findViewById(R.id.btnMult);
        btnDiv= findViewById(R.id.btnDiv);

        btnOk=findViewById(R.id.btnOk);


       btnAdd.setOnClickListener(this);
       btnSub.setOnClickListener(this);
       btnMult.setOnClickListener(this);
       btnDiv.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
//         num1=0;
//         num2=0;
//         result = 0;
        if (TextUtils.isEmpty(etNum1.getText().toString())
            ||TextUtils.isEmpty(etNum2.getText().toString())){return;
    }

        num1=Float.parseFloat(etNum1.getText().toString());
        num2=Float.parseFloat(etNum2.getText().toString());

      switch (view.getId()){
          case R.id.btnAdd:
              oper="+";
              result=num1+num2;
              break;
          case R.id.btnSub:
              oper="-";
              result=num1-num2;
              break;
          case R.id.btnMult:
              oper="*";
              result=num1*num2;
              break;
          case R.id.btnDiv:
              oper="/";
              result=num1/num2;
              break;
              default:
                  break;

      }
      tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case MENU_RESET_ID:
                etNum1.setText("");
                etNum2.setText("");
                tvResult.setText("");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }return super.onOptionsItemSelected(item);
    }


    public void onClickReturnFirstPage(View view) {
        String resultText = tvResult.getText().toString();
        Intent intent = new Intent(MainActivity.this, FirstActivity.class);
        intent.putExtra("key", resultText);
        startActivity(intent);
    }
}
