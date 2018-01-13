package com.example.android.edinburghquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    CheckBox busCheckBox;
    CheckBox tramCheckBox;
    CheckBox blackCabCheckBox;
    RadioButton buttonThree;
    RadioButton buttonYes;
    RadioButton buttonDelicacy;
    RadioButton buttonSaltSauce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name_field);
        busCheckBox = findViewById(R.id.bus_checkbox);
        tramCheckBox = findViewById(R.id.tram_checkbox);
        blackCabCheckBox = findViewById(R.id.black_cab_checkbox);
        buttonThree = findViewById(R.id.third_button);
        buttonYes = findViewById(R.id.yes_button);
        buttonDelicacy = findViewById(R.id.delicacy_button);
        buttonSaltSauce = findViewById(R.id.salt_sauce_button);

    }

    /**
     * adds all points from the different input types and displays a toast with reached point
     */

    public void addScores(View view) {
        int score = 0;

        /**
         * handles the Text Edits, adding the name to the result
         */

        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        /**
         * handles the checkboxes and adds points when answer is correct
         */

        CheckBox busCheckBox = (CheckBox) findViewById(R.id.bus_checkbox);
        boolean bus = busCheckBox.isChecked();
        if (bus) score++;

        CheckBox tramCheckBox = (CheckBox) findViewById(R.id.tram_checkbox);
        boolean tram = tramCheckBox.isChecked();
        if (tram) score++;

        CheckBox blackCabCheckBox = (CheckBox) findViewById(R.id.black_cab_checkbox);
        boolean blackCab = blackCabCheckBox.isChecked();
        if (blackCab) score++;

        /**
         * handles the radio buttons and adds points when answer is correct
         */

        boolean three = buttonThree.isChecked();
        if (three) score++;

        boolean yes = buttonYes.isChecked();
        if (yes) score++;

        boolean delicacy = buttonDelicacy.isChecked();
        if (delicacy) score++;

        boolean saltSauce = buttonSaltSauce.isChecked();
        if (saltSauce) score++;

        /**
         * different toasts for different reached points get toasted
         */


        if (score == 8) {
            Context context = getApplicationContext();
            CharSequence text = nameEditable + getResources().getString(R.string.true_edinburgher) + score + getResources().getString(R.string.out_of_points);
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else if (score > 3) {
            Context context = getApplicationContext();
            CharSequence text = nameEditable + getResources().getString(R.string.not_bad) + score + getResources().getString(R.string.out_of_points);
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {
            Context context = getApplicationContext();
            CharSequence text = nameEditable + getResources().getString(R.string.not_trying) + score + getResources().getString(R.string.out_of_points);
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }

        return;

    }

}
