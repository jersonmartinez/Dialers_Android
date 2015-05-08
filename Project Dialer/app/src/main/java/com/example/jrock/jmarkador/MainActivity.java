package com.example.jrock.jmarkador;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.content.Intent.ACTION_SENDTO;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn5;
    Button btn4;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnA;
    Button btnN;
    Button btnL;
    Button btnC;
    EditText caja;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button)this.findViewById(R.id.btn1);
        btn2=(Button)this.findViewById(R.id.btn2);
        btn3=(Button)this.findViewById(R.id.btn3);
        btn4=(Button)this.findViewById(R.id.btn4);
        btn5=(Button)this.findViewById(R.id.btn5);
        btn6=(Button)this.findViewById(R.id.btn6);
        btn7=(Button)this.findViewById(R.id.btn7);
        btn8=(Button)this.findViewById(R.id.btn8);
        btn9=(Button)this.findViewById(R.id.btn9);
        btn0=(Button)this.findViewById(R.id.btn0);
        btnA=(Button)this.findViewById(R.id.btnA);
        btnN=(Button)this.findViewById(R.id.btnN);
        btnL=(Button)this.findViewById(R.id.btnL);
        btnC=(Button)this.findViewById(R.id.btnC);
        caja= (EditText)this.findViewById(R.id.Caja);

        btn1.setOnClickListener((View.OnClickListener) this);
        btn2.setOnClickListener((View.OnClickListener) this);
        btn3.setOnClickListener((View.OnClickListener) this);
        btn4.setOnClickListener((View.OnClickListener) this);
        btn5.setOnClickListener((View.OnClickListener) this);
        btn6.setOnClickListener((View.OnClickListener) this);
        btn7.setOnClickListener((View.OnClickListener) this);
        btn8.setOnClickListener((View.OnClickListener) this);
        btn9.setOnClickListener((View.OnClickListener) this);
        btn0.setOnClickListener((View.OnClickListener) this);
        btnA.setOnClickListener((View.OnClickListener) this);
        btnN.setOnClickListener((View.OnClickListener) this);
        btnL.setOnClickListener((View.OnClickListener) this);
        btnC.setOnClickListener((View.OnClickListener) this);
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
        if (R.id.enviar_mensaje == id) {
            enviar_mesaje();
            return true;
        }
        if (id == R.id.contacto) {
            agregar_contacto();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View arg0) {
        switch(arg0.getId())
        {
            case R.id.btn0:
                caja.setText(caja.getText()+"0");
                break;
            case R.id.btn1:
                caja.setText(caja.getText()+"1");
                break;
            case R.id.btn2:
                caja.setText(caja.getText()+"2");
                break;
            case R.id.btn3:
                caja.setText(caja.getText()+"3");
                break;
            case R.id.btn4:
                caja.setText(caja.getText()+"4");
                break;
            case R.id.btn5:
                caja.setText(caja.getText()+"5");
                break;
            case R.id.btn6:
                caja.setText(caja.getText()+"6");
                break;
            case R.id.btn7:
                caja.setText(caja.getText()+"7");
                break;
            case R.id.btn8:
                caja.setText(caja.getText()+"8");
                break;
            case R.id.btn9:
                caja.setText(caja.getText()+"9");
                break;
            case R.id.btnA:
                caja.setText(caja.getText()+"*");
                break;
            case R.id.btnN:
                caja.setText(caja.getText()+"#");
                break;
            case R.id.btnL:
                //Codigo para llamar
                llamada();
                break;
            case R.id.btnC:
                caja.setText("");
                break;
        }
    }

    private void llamada() {
        Uri uri = Uri.parse("tel:" + caja.getText());
        Intent it;
        it = new Intent(Intent.ACTION_CALL, uri);
        startActivity(it);
    }

    private void enviar_mesaje(){
        Uri uri =  Uri.parse("smsto:"+caja.getText());
        Intent it;
        it = new Intent(ACTION_SENDTO, uri);
        it.putExtra("sms body", " ");
        startActivity(it);

    }

    private void agregar_contacto(){
        Intent contactIntent = new Intent(Intent.ACTION_INSERT);

        contactIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        contactIntent.putExtra(ContactsContract.Intents.Insert.NAME,"");
        contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,caja.getText());

        startActivity(contactIntent);
    }
}
