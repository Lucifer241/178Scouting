package test.scouting2018;

import com.example.X.scouting2018.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class TeleScouting extends Activity implements View.OnClickListener{

    TeleopFramework TF;
    TextView RSwitchTicker;
    Button rSwitchAdd;
    Button rSwitchSub;
    TextView BSwitchTicker;
    Button bSwitchAdd;
    Button bSwitchSub;
    TextView ScaleTicker;
    Button scaleAdd;
    Button scaleSub;
    TextView TeleExchangeTicker;
    Button exchangeAdd;
    Button exchangeSub;
    CheckBox doesPotato;
    CheckBox doesClimb;
    CheckBox doesClimbSupport;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele_scouting);

        Button rSwitchSub = (Button) findViewById(R.id.decreaseRSwitch);
        rSwitchSub.setOnClickListener(this);
        Button rSwitchAdd = (Button) findViewById(R.id.increaseRSwitch);
        rSwitchAdd.setOnClickListener(this);

        Button bSwitchSub = (Button) findViewById(R.id.decreaseBSwitch);
        bSwitchSub.setOnClickListener(this);
        Button bSwitchAdd = (Button) findViewById(R.id.increaseBSwitch);
        bSwitchAdd.setOnClickListener(this);

        Button scaleSub = (Button) findViewById(R.id.decreaseScale);
        scaleSub.setOnClickListener(this);
        Button scaleAdd = (Button) findViewById(R.id.increaseScale);
        scaleAdd.setOnClickListener(this);

        Button exchangeSub = (Button) findViewById(R.id.decreaseExchange);
        exchangeSub.setOnClickListener(this);
        Button exchangeAdd = (Button) findViewById(R.id.increaseExchange);
        exchangeAdd.setOnClickListener(this);

        Intent i = getIntent();
        String teamNum = i.getStringExtra("teamNum");
        String matchNum = i.getStringExtra("matchNum");

        TF = new TeleopFramework(matchNum, teamNum);

        submitButton = (Button) findViewById(R.id.submitTele);
        submitButton.setOnClickListener(this);

        RSwitchTicker = (TextView) findViewById(R.id.RSwitchTicker);
        BSwitchTicker = (TextView) findViewById(R.id.BSwitchTicker);
        ScaleTicker = (TextView) findViewById(R.id.ScaleTicker);
        TeleExchangeTicker = (TextView) findViewById(R.id.TeleExchangeTicker);
        doesPotato = (CheckBox) findViewById(R.id.potato);
        doesClimb = (CheckBox) findViewById(R.id.Climb);
        doesClimbSupport = (CheckBox) findViewById(R.id.climbSupport);

    }
    @Override
    public void onClick(View v)
    {

        switch(v.getId()){
            case R.id.decreaseRSwitch:
                TF.rSwitchScoresSub();
                RSwitchTicker.setText(String.valueOf(TF.getrSwitchScores()));
                break;
            case R.id.increaseRSwitch:
                TF.rSwitchScoresAdd();
                RSwitchTicker.setText(String.valueOf(TF.getrSwitchScores()));
                break;
            case R.id.decreaseBSwitch:
                TF.bSwitchScoresSub();
                BSwitchTicker.setText(String.valueOf(TF.getbSwitchScores()));
                break;
            case R.id.increaseBSwitch:
                TF.bSwitchScoresAdd();
                BSwitchTicker.setText(String.valueOf(TF.getbSwitchScores()));
                break;
            case R.id.increaseScale:
                TF.scaleScoresAdd();
                ScaleTicker.setText(String.valueOf(TF.getScaleScores()));
                break;
            case R.id.decreaseScale:
                TF.scaleScoresSub();
                ScaleTicker.setText(String.valueOf(TF.getScaleScores()));
                break;
            case R.id.increaseExchange:
                TF.exchangeScoresAdd();
                TeleExchangeTicker.setText(String.valueOf(TF.getExchangeScores()));
                break;
            case R.id.decreaseExchange:
                TF.exchangeScoresSub();
                TeleExchangeTicker.setText(String.valueOf(TF.getExchangeScores()));
                break;
            case R.id.submitTele:
                Toast.makeText(this, "kekerroni", Toast.LENGTH_LONG).show();
                if(doesClimb.isChecked()){
                    TF.changeClimb();
                }
                if(doesClimbSupport.isChecked()){
                    TF.changeSupport();
                }
                if(doesPotato.isChecked()){
                    TF.changePotato();
                }
                TF.printData();
                Intent intent = new Intent(getApplicationContext(), HomePage.class);
                ComponentName cn = intent.getComponent();
                Intent mainIntent = Intent.makeRestartActivityTask(cn);
                startActivity(mainIntent);
                break;
            default:
                break;

        }
    }
}