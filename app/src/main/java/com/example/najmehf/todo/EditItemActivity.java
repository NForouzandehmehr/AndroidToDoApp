package com.example.najmehf.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        final int position = getIntent().getIntExtra("itemPosition", 0);
        String text= getIntent().getExtras().getString("itemText");
        TextView view = (TextView) findViewById(R.id.editText);
        view.setText(text);
        final EditText input = (EditText)findViewById(R.id.editText);
        input.setSelection(input.getText().length());
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("name", input.getText().toString());
                data.putExtra("position", position); // ints work too
                // Activity finished ok, return the data
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes the act
            }
        });

    }

}
