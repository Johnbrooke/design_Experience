package com.example.administrator.mydemo_kaiyuanceshi;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/14 0014.
 */
public class TextInput_Acty extends Activity {

    @InjectView(R.id.input_name)
    EditText inputName;
    @InjectView(R.id.layout_name)
    TextInputLayout layoutName;
    @InjectView(R.id.input_password)
    EditText inputPassword;
    @InjectView(R.id.layout_password)
    TextInputLayout layoutPassword;
    @InjectView(R.id.input_email)
    EditText inputEmail;
    @InjectView(R.id.layout_email)
    TextInputLayout layoutEmail;
    @InjectView(R.id.bt_item)
    Button btItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testintput_item);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.bt_item)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_item:
                canLogin();
                break;

        }

    }

    private void canLogin() {
        if (!isNameValid()) {
            Toast.makeText(this, "请仔细检查未完成的选项", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isPasswordValid()) {
            Toast.makeText(this, "请仔细检查未完成的选项", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isEmailValid()){
            Toast.makeText(this,"请仔细检查未完成的选项",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();

    }

    public boolean isNameValid() {
        if (inputName.getText().toString().trim().equals("") || inputName.getText().toString().trim().isEmpty()){
            layoutName.setError("请检查姓名是否有误");
            layoutName.setErrorEnabled(true);
            inputName.requestFocus();
            return true;
        }
        layoutName.setErrorEnabled(false);
        return true;
    }

    public boolean isPasswordValid() {
        if (inputPassword.getText().toString().trim().equals("")||inputPassword.getText().toString().isEmpty()){
            layoutPassword.setError("请检查密码是否有误");
            layoutPassword.setErrorEnabled(true);
            inputPassword.requestFocus();
            return false;
        }
        layoutPassword.setErrorEnabled(false);
        return true;
    }

    public boolean isEmailValid() {
        String email = inputEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            layoutEmail.setError("请检查邮箱是否有误");
            layoutEmail.setErrorEnabled(true);
            layoutEmail.requestFocus();
            return false;
        }
        layoutEmail.setErrorEnabled(false);
        return true;
    }
    private class MyTextWatcher implements TextWatcher{
        private View view;

        private MyTextWatcher(View view){
            this.view = view;
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()){
                case R.id.input_name:
                    isNameValid();
                    break;
                case R.id.input_password:
                    isPasswordValid();
                    break;
                case R.id.input_email:
                    isEmailValid();
                    break;
            }

        }
    }
}
