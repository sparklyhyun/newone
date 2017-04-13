package com.example.hyunjeong.district132;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.database.Cursor;
        import android.widget.TextView;
        import android.widget.Toast;
        import android.content.Intent;
        import android.widget.Button;
        import android.view.View;
        import android.net.Uri;

        import org.w3c.dom.Text;



public class Displaydetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaydetails);
        Intent intent=getIntent();
        String ID=intent.getStringExtra("id");

        PostDBHandler db = new PostDBHandler(this, null, null, 1);

        String str="";
        Button btn=(Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://data.gov.sg/dataset/price-range-of-hdb-flats-offered"));
                startActivity(intent);
            }
        });


        Cursor cursor = db.getlocbyid(ID);
        if(cursor.moveToFirst()){
            String loc,id,size,price,desc,type,purpose,no_of_rooms,username,furnish;
            loc = cursor.getString(cursor.getColumnIndex("location"));
            id=cursor.getString(cursor.getColumnIndex("post_id"));
            price=cursor.getString(cursor.getColumnIndex("price"));
            size=cursor.getString(cursor.getColumnIndex("size"));
            desc=cursor.getString(cursor.getColumnIndex("desc"));
            type=cursor.getString(cursor.getColumnIndex("housetype"));
            purpose=cursor.getString(cursor.getColumnIndex("purpose"));
            no_of_rooms=cursor.getString(cursor.getColumnIndex("no_of_rooms"));
            username=cursor.getString(cursor.getColumnIndex("username"));
            furnish=cursor.getString(cursor.getColumnIndex("furnishing"));


            TextView locationtv=(TextView) findViewById(R.id.textView15);
            TextView pricetv=(TextView) findViewById(R.id.textView17);
            TextView sizetv=(TextView) findViewById(R.id.textView19);
            TextView idtv =(TextView) findViewById(R.id.textView9);
            TextView purposetv =(TextView) findViewById(R.id.textView26);
            TextView roomstv =(TextView) findViewById(R.id.textView25);
            TextView furnishtv =(TextView) findViewById(R.id.textView21);
            TextView desctv =(TextView) findViewById(R.id.textView23);
            TextView contacttv =(TextView) findViewById(R.id.textView29);


            locationtv.setText(loc);
            pricetv.setText(price);
            sizetv.setText(size);
            idtv.setText(id);
            purposetv.setText(purpose);
            roomstv.setText(no_of_rooms);
            furnishtv.setText(furnish);
            desctv.setText(desc);
            contacttv.setText(username);
            //Toast.makeText(this,str, Toast.LENGTH_LONG).show();
        }

        cursor.close();

    }
}

