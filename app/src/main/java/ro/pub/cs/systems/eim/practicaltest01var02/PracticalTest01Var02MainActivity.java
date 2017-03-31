package ro.pub.cs.systems.eim.practicaltest01var02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    private Button adunare = null;
    private Button scadere = null;
    private EditText upper = null;
    private EditText bottom = null;
    private EditText eticheta = null;


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("upper_edit_text", upper.getText().toString());
        savedInstanceState.putString("bottom_edit_text", bottom.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("upper_edit_text")) {
            upper.setText(savedInstanceState.getString("upper_edit_text"));
        } else {
            upper.setText(String.valueOf(new StringBuilder()));
        }
        if (savedInstanceState.containsKey("bottom_edit_text")) {
            bottom.setText(savedInstanceState.getString("bottom_edit_text"));
        } else {
            bottom.setText(String.valueOf(new StringBuilder()));
        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

//            if (upperButton.getText() == null || bottomButton.getText() == null){
//                Toast.makeText(this, "Introdu ambele valori", Toast.LENGTH_LONG).show();
//            }

            int upper_nr = Integer.parseInt(upper.getText().toString());
            int bottom_nr = Integer.parseInt(bottom.getText().toString());

            switch (view.getId()) {
                case R.id.adunare:
                    String output = new StringBuilder()
                            .append(upper_nr)
                            .append('+')
                            .append(bottom_nr)
                            .toString();
                    eticheta.setText(String.valueOf(output));
                    break;
                case R.id.scadere:
                    String output2 = new StringBuilder()
                            .append(upper_nr)
                            .append('-')
                            .append(bottom_nr)
                            .toString();
                    eticheta.setText(String.valueOf(output2));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        adunare = (Button)findViewById(R.id.adunare);
        scadere = (Button)findViewById(R.id.scadere);
        upper = (EditText)findViewById(R.id.upper_edit_text);
        bottom = (EditText)findViewById(R.id.bottom_edit_text);
        eticheta = (EditText)findViewById(R.id.needitabil);

        adunare.setOnClickListener(buttonClickListener);
        scadere.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("upper_edit_text")) {
                upper.setText(savedInstanceState.getString("upper_edit_text"));
            } else {
                upper.setText(String.valueOf(new StringBuilder()));
            }
            if (savedInstanceState.containsKey("bottom_edit_text")) {
                bottom.setText(savedInstanceState.getString("bottom_edit_text"));
            } else {
                bottom.setText(String.valueOf(new StringBuilder()));
            }
        } else {
            upper.setText(String.valueOf(new StringBuilder()));
            bottom.setText(String.valueOf(new StringBuilder()));
        }
    }


}
