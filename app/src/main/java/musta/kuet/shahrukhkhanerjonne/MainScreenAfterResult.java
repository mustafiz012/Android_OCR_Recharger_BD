package musta.kuet.shahrukhkhanerjonne;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainScreenAfterResult extends Activity implements View.OnClickListener {

    Button banglalink, grameen, airtel, robi, teletalk, citycell, again;
    TextView show;
    String resultStr = null;
    String pre, post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_after_result);

        initialization();
    }

    void initialization() {
        banglalink = (Button) findViewById(R.id.banglalink);
        grameen = (Button) findViewById(R.id.grameen);
        airtel = (Button) findViewById(R.id.airtel);
        robi = (Button) findViewById(R.id.robi);
        teletalk = (Button) findViewById(R.id.teletalk);
        citycell = (Button) findViewById(R.id.citycell);
        show = (TextView) findViewById(R.id.codeShowing);
        again = (Button) findViewById(R.id.again);
        again.setOnClickListener(this);
        banglalink.setOnClickListener(this);
        grameen.setOnClickListener(this);
        airtel.setOnClickListener(this);
        robi.setOnClickListener(this);
        teletalk.setOnClickListener(this);
        citycell.setOnClickListener(this);
        resultStr = getIntent().getStringExtra("resu");
        show.setText(resultStr);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.banglalink:
                pre = "*123*";
                post = Uri.encode("#");
                resultStr = pre + resultStr + post;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + resultStr));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
                break;
            case R.id.grameen:
                pre = "*555*";
                post = Uri.encode("#");
                resultStr = pre+resultStr+post;
                Intent intentGra = new Intent(Intent.ACTION_CALL);
                intentGra.setData(Uri.parse("tel:"+resultStr));
                startActivity(intentGra);
                break;
            case R.id.airtel:
                pre = "*787*";
                post = Uri.encode("#");
                resultStr = pre+resultStr+post;
                Intent intentAir = new Intent(Intent.ACTION_CALL);
                intentAir.setData(Uri.parse("tel:"+resultStr));
                startActivity(intentAir);
                show.setText(resultStr);
                break;
            case R.id.robi:
                pre = "*111*";
                post = Uri.encode("#");
                resultStr = pre+resultStr+post;
                Intent intentRobi = new Intent(Intent.ACTION_CALL);
                intentRobi.setData(Uri.parse("tel:"+resultStr));
                startActivity(intentRobi);
                break;
            case R.id.teletalk:
                pre = "*151*";
                post = Uri.encode("#");
                resultStr = pre+resultStr+post;
                Intent intentTele = new Intent(Intent.ACTION_CALL);
                intentTele.setData(Uri.parse("tel:"+resultStr));
                startActivity(intentTele);
                break;
            case R.id.citycell:
                pre = "*888*";
                post = Uri.encode("#");
                resultStr = pre+resultStr+post;
                Intent intentCity = new Intent(Intent.ACTION_CALL);
                intentCity.setData(Uri.parse("tel:"+resultStr));
                startActivity(intentCity);
                break;
            case R.id.again:
                startActivity(new Intent(MainScreenAfterResult.this, CaptureActivity.class));
                break;
        }
    }
}
