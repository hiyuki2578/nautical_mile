package net.hiyuki2578.nautical_mile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText input = (EditText)findViewById(R.id.editText);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView)findViewById(R.id.textView);
                String num = input.getText().toString();
                textView.setText(calc(Double.parseDouble(num)));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent1 = new Intent(this, Setting.class);
                startActivity(intent1);
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);
    }
    private String calc(Double num) {
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(this);
        String default_str = "0.539956803,kilo_to_mile";
        String pref = spf.getString("unit", default_str);
        String[] prefs = pref.split(",", 0);
        double unit = Double.parseDouble(prefs[0]);
        double cal = num * unit;
        return String.valueOf(cal);
    }
}
