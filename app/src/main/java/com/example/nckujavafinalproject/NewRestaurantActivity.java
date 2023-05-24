package com.example.nckujavafinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class NewRestaurantActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.restaurantlistsql.REPLY";
    private LinearLayout checkboxList;

    private EditText mEditRestaurantView;
    private LabelViewModel mLabelViewModel;
    private ArrayList<String> checkedLabels=new ArrayList<>();;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_restaurant);
        mEditRestaurantView = findViewById(R.id.edit_restaurant);

        checkboxList=findViewById(R.id.checkbox_list);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditRestaurantView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String restaurant = mEditRestaurantView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, restaurant);
                setResult(RESULT_OK, replyIntent);
                // TODO: send checked label to activity
            }
            finish();
        });

        // dynamically generate label list

        mLabelViewModel = new ViewModelProvider(this).get(LabelViewModel.class);
        mLabelViewModel.getAllLabels().observe(this, labels -> {
            for (int i = 0; i < labels.size(); i++) {
                String text=labels.get(i).getName();
                CheckBox checkBox = new CheckBox(getApplicationContext());
                checkBox.setText(text);

                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            checkedLabels.add((String) checkBox.getText());
                        } else {
                            checkedLabels.remove((String) checkBox.getText());
                        }
                    }
                });

                checkboxList.addView(checkBox);
            }
        });
    }

}
