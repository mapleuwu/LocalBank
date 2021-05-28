package sg.edu.rp.c346.id20023766.mylocalbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dbsbank;
    TextView ocbcbank;
    TextView uobbank;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbsbank = findViewById(R.id.dbs);
        ocbcbank = findViewById(R.id.ocbc);
        uobbank = findViewById(R.id.uob);

        registerForContextMenu(dbsbank);
        registerForContextMenu(ocbcbank);
        registerForContextMenu(uobbank);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        if (v == dbsbank) {
            wordClicked = "dbsbank";
        } else if(v == ocbcbank) {
            wordClicked = "ocbcbank";
        } else if(v == uobbank) {
            wordClicked = "uobbank";
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbsbank")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: + 1800-111-1111"));
                startActivity(intent);
            }
        } else if (wordClicked.equalsIgnoreCase("ocbcbank")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://internet.ocbc.com/internet-banking/login/login"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: + 1800-363-3333"));
                startActivity(intent);
            }
        } else if (wordClicked.equalsIgnoreCase("uobbank")){
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/index.page?origref=https%3A%2F%2Fwww.uob.com.sg%2Fpersonal%2Febanking%2Foverview.html"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: + 1800-222-2121"));
                startActivity(intent);
            }
        }
        return super.onContextItemSelected(item);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbsbank.setText("DBS");
            ocbcbank.setText("OCBC");
            uobbank.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbsbank.setText("星展银行");
            ocbcbank.setText("华侨银行");
            uobbank.setText("大华银行");
            return true;
        } else if (id == R.id.ThaiSelection) {
            dbsbank.setText("ธนาคารดีบีเอส");
            ocbcbank.setText("ธนาคาร OCBC");
            uobbank.setText("ธนาคารยูโอบี");
        } else if (id == R.id.TamilSelection){
            dbsbank.setText("டி.பி.எஸ் வங்கி");
            ocbcbank.setText("OCBC வங்கி");
            uobbank.setText("யுனைடெட் ஓவர்சீஸ் வங்கி");
        } else {
            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

}