package test.scouting2018;

import com.example.X.scouting2018.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;

public class HomePage extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        final Button submitButton = (Button) (findViewById(R.id.submitButton));
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String TeamNumber = (((EditText)findViewById(R.id.teamNum)).getText()).toString();
                String MatchNumber = (((EditText)findViewById(R.id.matchNum)).getText()).toString();
                mainSubmit(TeamNumber, MatchNumber);
            }
        });
    }

    private void mainSubmit(String tnum, String mnum)
    {
        Intent i = new Intent(this, AutoScouting.class);
        i.putExtra("TeamNumber",tnum);
        i.putExtra("MatchNumber", mnum);

        startActivity(i);
    }
}