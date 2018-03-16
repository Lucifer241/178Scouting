package test.scouting2018;

import com.example.X.scouting2018.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class AutoScouting extends Activity implements View.OnClickListener{

    String teamNum;
    String matchNum;
    TextView RSwitchTicker;
    Button rSwitchAdd;
    Button rSwitchSub;
    TextView BSwitchTicker;
    Button bSwitchAdd;
    Button bSwitchSub;
    TextView ScaleTicker;
    Button scaleAdd;
    Button scaleSub;
    TextView AutoExchangeTicker;
    Button exchangeAdd;
    Button exchangeSub;
    CheckBox doesPotato;
    CheckBox doesCross;
    CheckBox autoFail;
    AutonomousFramework AF;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_scouting);

        Intent i = getIntent();
        teamNum = i.getStringExtra("TeamNumber");
        matchNum = i.getStringExtra("MatchNumber");

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

        RSwitchTicker = (TextView) findViewById(R.id.RSwitchTicker);
        BSwitchTicker = (TextView) findViewById(R.id.BSwitchTicker);
        ScaleTicker = (TextView) findViewById(R.id.ScaleTicker);
        AutoExchangeTicker = (TextView) findViewById(R.id.AutoExchangeTicker);
        doesPotato = (CheckBox) findViewById(R.id.potato);
        doesCross = (CheckBox) findViewById(R.id.lineCross);
        autoFail = (CheckBox) findViewById(R.id.autoCodeFail);

        AF = new AutonomousFramework(matchNum, teamNum);

        submitButton = (Button) findViewById(R.id.submitAuto);
        submitButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId()){
            case R.id.decreaseRSwitch:
                AF.rSwitchScoresSub();
                RSwitchTicker.setText(String.valueOf(AF.getrSwitchScores()));
                break;
            case R.id.increaseRSwitch:
                AF.rSwitchScoresAdd();
                RSwitchTicker.setText(String.valueOf(AF.getrSwitchScores()));
                break;
            case R.id.decreaseBSwitch:
                AF.bSwitchScoresSub();
                BSwitchTicker.setText(String.valueOf(AF.getbSwitchScores()));
                break;
            case R.id.increaseBSwitch:
                AF.bSwitchScoresAdd();
                BSwitchTicker.setText(String.valueOf(AF.getbSwitchScores()));
                break;
            case R.id.increaseScale:
                AF.scaleScoresAdd();
                ScaleTicker.setText(String.valueOf(AF.getScaleScores()));
                break;
            case R.id.decreaseScale:
                AF.scaleScoresSub();
                ScaleTicker.setText(String.valueOf(AF.getScaleScores()));
                break;
            case R.id.increaseExchange:
                AF.exchangeScoresAdd();
                AutoExchangeTicker.setText(String.valueOf(AF.getExchangeScores()));
                break;
            case R.id.decreaseExchange:
                AF.exchangeScoresSub();
                AutoExchangeTicker.setText(String.valueOf(AF.getExchangeScores()));
                break;
            case R.id.submitAuto:
                Toast.makeText(this, "It Worked a Lil Bit", Toast.LENGTH_LONG).show();
                if(doesCross.isChecked()){
                    AF.changeCross();
                }
                if(doesPotato.isChecked()){
                    AF.changePotato();
                }
                if(autoFail.isChecked()){
                    AF.changeAutoFail();
                }
                AF.printData();
                Intent intent = new Intent(this, TeleScouting.class);
                intent.putExtra("teamNum", teamNum);
                intent.putExtra("matchNum", matchNum);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

