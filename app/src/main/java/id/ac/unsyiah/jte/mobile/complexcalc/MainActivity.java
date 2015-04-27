package id.ac.unsyiah.jte.mobile.complexcalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClickBtnHitung(View view){
        float real1;
        float real2;
        float imag1;
        float imag2;

        int noinput= 0;

        EditText editTextreal1 = (EditText) findViewById(R.id.txt_real);
        if(editTextreal1.length()==noinput){
            real1=0;
            editTextreal1.setText("0");
        }else {
            real1 = Float.valueOf(String.valueOf(editTextreal1.getText()));
        }

        EditText editTextreal2 = (EditText) findViewById(R.id.txt_real2);
        if(editTextreal2.length()==noinput){
            real2=0;
            editTextreal2.setText("0");
        }else{
            real2 = Float.valueOf(String.valueOf(editTextreal2.getText()));
        }

        EditText editTextimag1 = (EditText) findViewById(R.id.txt_imag);
        if(editTextimag1.length()==noinput){
            imag1=0;
            editTextimag1.setText("0");
        }else{
            imag1 = Float.valueOf(String.valueOf(editTextimag1.getText()));
        }

        EditText editTextimag2 = (EditText) findViewById(R.id.txt_imag2);
        if(editTextimag2.length()==noinput){
            imag2= 0;
            editTextimag2.setText("0");
        }else{
            imag2 = Float.valueOf(String.valueOf(editTextimag2.getText()));
        }

        Spinner spinner_oper_arit = (Spinner) findViewById(R.id.sel_oper_arit);

        float hasil_real=0;
        float hasil_imag=0;

        String salahOper = "";
        if (spinner_oper_arit.getSelectedItem().equals("+")){
            hasil_real = real1 + real2;
            hasil_imag = imag1 + imag2;
        }else if (spinner_oper_arit.getSelectedItem().equals("-")){
            hasil_real = real1 - real2;
            hasil_imag = imag1 - imag2;
        }else if (spinner_oper_arit.getSelectedItem().equals("*")){
            hasil_real = real1 * real2;
            hasil_imag = imag1 * imag2;
        }else if (spinner_oper_arit.getSelectedItem().equals("/")){
            hasil_real = real1 / real2;
            hasil_imag = imag1 / imag2;
        }else{
            salahOper = "Kesalahan Operasi!";
        }

        String hasil_realStr = String.valueOf(hasil_real);
        String hasil_imagStr = String.valueOf(hasil_imag);

        //check apakah bil. memiliki desimal
        if(hasil_realStr.endsWith(".0") && hasil_imagStr.endsWith(".0")){
            //hapus desimal
            int hasil_realInt = Math.round(Float.valueOf(hasil_realStr));
            int hasil_imagInt = Math.round(Float.valueOf(hasil_imagStr));

            hasil_realStr = String.valueOf(hasil_realInt);
            hasil_imagStr = String.valueOf(hasil_imagInt);
        }else if(hasil_realStr.endsWith(".0")){
            //hapus desimal
            int hasil_realInt = Math.round(Float.valueOf(hasil_realStr));

            hasil_realStr = String.valueOf(hasil_realInt);
        }else if(hasil_imagStr.endsWith(".0")){
            //hapus desimal
            int hasil_imagInt = Math.round(Float.valueOf(hasil_imagStr));

            hasil_imagStr = String.valueOf(hasil_imagInt);
        }
        TextView textView = (TextView) findViewById(R.id.txt_hasil);

        if(salahOper.length()>0){
            textView.setText(salahOper);
        }else if(hasil_imagStr.contains("-")){
            //check apakah bil. imajiner negatif
            hasil_imag = Math.abs(Float.valueOf(hasil_imagStr));
            hasil_imagStr = String.valueOf(hasil_imag);

            //check apakah output adalah bil. desimal
            if (hasil_imagStr.endsWith(".0")){
                int hasil_imagInt = Math.round(Float.valueOf(hasil_imagStr));
                hasil_imagStr = String.valueOf(hasil_imagInt);
            }

            textView.setText("Hasil = "+hasil_realStr+"- j"+hasil_imagStr);

        }else{
            textView.setText("Hasil = "+hasil_realStr+"+ j"+hasil_imagStr);
        }
    }

}