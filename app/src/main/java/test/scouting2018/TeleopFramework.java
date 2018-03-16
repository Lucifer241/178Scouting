package test.scouting2018;

import android.os.Environment;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class TeleopFramework {
    String matchNum;
    String teamNum;
    int rSwitchScores;
    int bSwitchScores;
    int scaleScores;
    int exchangeScores;
    boolean doesPotato;
    boolean doesClimb;
    boolean doesClimbSupport;


    public TeleopFramework(String match, String team)
    {
        matchNum = match;
        teamNum = team;
        rSwitchScores = 0;
        bSwitchScores = 0;
        scaleScores = 0;
        exchangeScores = 0;
        doesClimb = false;
        doesPotato = false;
        doesClimbSupport = false;
    }


    public void rSwitchScoresAdd(){ rSwitchScores+=1;}
    public void rSwitchScoresSub(){
        rSwitchScores-=1;
    }
    public int getrSwitchScores(){
        return rSwitchScores;
    }
    public void bSwitchScoresAdd(){
        bSwitchScores+=1;
    }
    public void bSwitchScoresSub(){
        bSwitchScores-=1;
    }
    public int getbSwitchScores(){
        return bSwitchScores;
    }
    public void scaleScoresAdd(){
        scaleScores+=1;
    }
    public void scaleScoresSub(){
        scaleScores-=1;
    }
    public int getScaleScores(){
        return scaleScores;
    }
    public void exchangeScoresAdd(){ exchangeScores +=1; }
    public void exchangeScoresSub(){
        exchangeScores-=1;
    }
    public int getExchangeScores(){
        return exchangeScores;
    }
    public void changePotato(){
        doesPotato = true;
    }
    public void changeClimb(){
        doesClimb = true;
    }
    public void changeSupport(){
        doesClimbSupport = true;
    }
    public boolean isDoesPotato(){
        return doesPotato;
    }
    public boolean isDoesClimb() {
        return doesClimb;
    }
    public boolean doesHaveClimb() { return doesClimbSupport; }
    public void printData(){
        JSONObject TeleJSON= new JSONObject();
        try{
            TeleJSON.put("MatchNum", matchNum);
            TeleJSON.put("TeamNum", teamNum);
            TeleJSON.put("RedSwitchScores", rSwitchScores);
            TeleJSON.put("BlueSwitchScores", bSwitchScores);
            TeleJSON.put("ScaleScores", scaleScores);
            TeleJSON.put("ExchangeScores", exchangeScores);
            TeleJSON.put("Climb", doesClimb);
            TeleJSON.put("Potato", doesPotato);
            TeleJSON.put("Support", doesClimbSupport);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Tele.json");

            if (!file.exists()) {
                file = new File(Environment.getExternalStorageDirectory(), "Tele.json");
            }

            PrintWriter outputStream = new PrintWriter(new FileWriter(file, true));

            String s = TeleJSON.toString();
            outputStream.println(s);
            outputStream.flush();
            outputStream.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
