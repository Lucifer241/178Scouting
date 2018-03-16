package test.scouting2018;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.xmlpull.v1.XmlSerializer;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class AutonomousFramework {
    String matchNum;
    String teamNum;
    int rSwitchScores;
    int bSwitchScores;
    int scaleScores;
    int exchangeScores;
    boolean doesPotato;
    boolean doesCross;
    boolean autoFail;

    public AutonomousFramework(String match, String team)
    {
        matchNum = match;
        teamNum = team;
        rSwitchScores = 0;
        bSwitchScores = 0;
        scaleScores = 0;
        exchangeScores = 0;
        doesCross = false;
        doesPotato = false;
        autoFail = false;
    }

    //methods for red switch
    public void rSwitchScoresAdd(){ rSwitchScores += 1; }
    public void rSwitchScoresSub(){ rSwitchScores -= 1; }
    public int getrSwitchScores(){
        return rSwitchScores;
    }
    //methods for blue switch
    public void bSwitchScoresAdd(){ bSwitchScores += 1; }
    public void bSwitchScoresSub(){ bSwitchScores -= 1; }
    public int getbSwitchScores(){
        return bSwitchScores;
    }
    //methods for scale
    public void scaleScoresAdd(){
        scaleScores += 1;
    }
    public void scaleScoresSub(){ scaleScores -= 1; }
    public int getScaleScores(){
        return scaleScores;
    }
    //methods for exchange
    public void exchangeScoresAdd(){ exchangeScores += 1; }
    public void exchangeScoresSub(){ exchangeScores -= 1; }
    public int getExchangeScores(){
        return exchangeScores;
    }
    //methods for potato, doesCross
    public void changePotato() {
        if (doesPotato == true){
            doesPotato = false;    }else{   doesPotato = true;    }}
    public void changeCross(){
        if (doesCross == true){
            doesCross = false;    }else{   doesCross = true;    }}
    public void changeAutoFail(){
        if (autoFail == true){
            autoFail = false;    }else{   autoFail = true;    }}
    public boolean isDoesPotato(){
        return doesPotato;
    }
    public boolean isDoesCross() {
        return doesCross;
    }
    public boolean isAutoFail() { return autoFail; }

    public void printData(){
        JSONObject AutoJSON= new JSONObject();
        try{
            AutoJSON.put("MatchNum", matchNum);
            AutoJSON.put("TeamNum", teamNum);
            AutoJSON.put("RedSwitchScores", rSwitchScores);
            AutoJSON.put("BlueSwitchScores", bSwitchScores);
            AutoJSON.put("ScaleScores", scaleScores);
            AutoJSON.put("ExchangeScores", exchangeScores);
            AutoJSON.put("Cross", doesCross);
            AutoJSON.put("Potato", doesPotato);
            AutoJSON.put("Code", autoFail);
        } catch (JSONException e) {
            e.printStackTrace();

        }
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "Auto.json");

            if (!file.exists()) {
                file = new File(Environment.getExternalStorageDirectory(), "Auto.json");

            }
            PrintWriter outputStream = new PrintWriter(new FileWriter(file, true));

            outputStream.print(AutoJSON.toString());

            outputStream.append("\n");

            outputStream.flush();

            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
