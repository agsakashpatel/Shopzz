package com.app.shopzz.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.app.shopzz.R;
import com.app.shopzz.customView.GenericView;
import com.app.shopzz.helper.ToastHelper;
import com.app.shopzz.listener.OnValidationClick;
import com.app.shopzz.utility.Utils;
import com.app.shopzz.utility.ValidationClass;

public class EditProfileActivity extends AppCompatActivity implements OnValidationClick {

    private LinearLayout llParent;
    private ImageView ivClose;
    private TextView tvTitle;
    private TextView tvEdit;

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etMobileNumber;
    private EditText etEmailAddress;
    private RadioGroup rgGender;
    private RadioButton rbMale;
    private RadioButton rbFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_edit_profile);

        llParent = GenericView.findViewById(this, R.id.llParent);
        Utils.getInstance().setupOutSideTouchHideKeyboard(llParent);

        ivClose = GenericView.findViewById(this, R.id.ivClose);
        tvTitle = GenericView.findViewById(this, R.id.tvTitle);
        tvEdit = GenericView.findViewById(this, R.id.tvEdit);
        tvTitle.setText(getResources().getString(R.string.str_edit_profile));
        tvEdit.setText(getResources().getString(R.string.str_save));

        etFirstName = GenericView.findViewById(this, R.id.etFirstName);
        etLastName = GenericView.findViewById(this, R.id.etLastName);
        etMobileNumber = GenericView.findViewById(this, R.id.etMobileNumber);
        etEmailAddress = GenericView.findViewById(this, R.id.etEmailAddress);
        rgGender = GenericView.findViewById(this, R.id.rgGender);
        rbMale = GenericView.findViewById(this, R.id.rbMale);
        rbFemale = GenericView.findViewById(this, R.id.rbFemale);

    }

    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.ivClose:
                onBackPressed();
                break;
            case R.id.tvEdit:
                break;
        }
    }

    private boolean isValidate() {
        if (ValidationClass.isEmpty(etFirstName.getText().toString())) {
            ToastHelper.displayCustomToast(this, getResources().getString(R.string.str_first_name_validation), etFirstName, this);
            return false;
        } else {
            if (ValidationClass.isEmpty(etLastName.getText().toString())) {
                ToastHelper.displayCustomToast(this, getResources().getString(R.string.str_last_name_validation), etLastName, this);
                return false;
            } else {
                if (ValidationClass.isEmpty(etMobileNumber.getText().toString())) {
                    ToastHelper.displayCustomToast(this, getResources().getString(R.string.str_mobile_validation), etMobileNumber, this);
                    return false;
                } else {
                    if (etMobileNumber.getText().toString().length() != 10) {
                        ToastHelper.displayCustomToast(this, getResources().getString(R.string.str_mobile_length_validation), etMobileNumber, this);
                        return false;
                    } else {
                        if (ValidationClass.isEmpty(etEmailAddress.getText().toString())) {
                            ToastHelper.displayCustomToast(this, getResources().getString(R.string.str_email_validation), etEmailAddress, this);
                            return false;
                        } else {
                            if (!ValidationClass.matchPattern(etEmailAddress.getText().toString().trim(), Patterns.EMAIL_ADDRESS.pattern())) {
                                ToastHelper.displayCustomToast(this, getResources().getString(R.string.str_valid_email_validation), etEmailAddress, this);
                                return false;
                            } else {
                                return true;
                            }
                        }
                    }
                }
            }
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override
    public void OnValidationClick(View mView) {
        mView.requestFocus();
        Utils.getInstance().launchKeyboard(this, (EditText) mView);
    }
}
