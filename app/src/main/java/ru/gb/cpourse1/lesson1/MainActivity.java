package ru.gb.cpourse1.lesson1;


import static ru.gb.cpourse1.lesson1.R.id.checkbox_CheckBox;
import static ru.gb.cpourse1.lesson1.R.id.dark_theme_ToggleButton;
import static ru.gb.cpourse1.lesson1.R.id.switch_Switch;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    //Объявляем переменные элеменов
    private TextView writeField;
    private EditText readField;
    private LinearLayout backgroundLinearLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Объявляем ресурсы цветов
        Resources resources = getResources();
        int readFieldTextColor = resources.getColor(R.color.green,  null);
        int writeFieldTextColor = resources.getColor(R.color.red,  null);

        //Изменяем цвет поля вывода TextView
        writeField = findViewById(R.id.write_field_TextView);
        writeField.setTextColor(readFieldTextColor);

        //Изменяем цвет поля ввода EditText
        readField = findViewById(R.id.read_field_EditText);
        readField.setTextColor(writeFieldTextColor);

        //Объявляем кнопку и описываем обработчик нажатия
        Button repeatButton = findViewById(R.id.repeat_Button);

        repeatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                writeField.setText(readField.getText());
            }
        });

        //Псевдо ночная тема - заменям цвет фона по нажатию ToggleButton
        backgroundLinearLayout = findViewById(R.id.background_LinearLayout);
        ToggleButton darkThemeButton = findViewById(dark_theme_ToggleButton);

        darkThemeButton.setOnCheckedChangeListener(this);

        //Объявляем Switch и CheckBox
        Switch switchBtn = findViewById(switch_Switch);
        CheckBox checkBoxBtn = findViewById(checkbox_CheckBox);


        if (switchBtn != null) {
            switchBtn.setOnCheckedChangeListener(this);
        }

        if (checkBoxBtn != null) {
            checkBoxBtn.setOnCheckedChangeListener(this);
        }


    }

    //Обработчик нажатия CheckBox, Switch, ToggleButton...
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        //Определяем источник события
        switch (buttonView.getId()) {

            case checkbox_CheckBox:
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "CheckBox on", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "CheckBox off", Toast.LENGTH_LONG).show();
                }
                break;

            case switch_Switch:

                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Switch on", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Switch off", Toast.LENGTH_LONG).show();
                }
                break;

            case dark_theme_ToggleButton:
                if (isChecked) {
                    // Меняем цвет фона на серый
                    backgroundLinearLayout.setBackgroundColor(getResources().getColor(R.color.gray, null));
                } else {
                    // Меняем цвет фона на белый
                    backgroundLinearLayout.setBackgroundColor(getResources().getColor(R.color.white, null));
                }
                break;


        }
    }
}