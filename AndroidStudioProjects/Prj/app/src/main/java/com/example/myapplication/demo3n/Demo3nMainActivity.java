package com.example.myapplication.demo3n;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;
import com.example.myapplication.demo2.Demo21MainActivity;

import java.util.ArrayList;

public class Demo3nMainActivity extends AppCompatActivity {
    ListView listView;
    Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3n_main);
        listView=findViewById(R.id.demo3nListview);
        xinQuyenNguoiDung();
        getContacts();
    }
    public boolean xinQuyenNguoiDung()
    {
        if(Build.VERSION.SDK_INT>=23)//version cao
        {
            //neu quyen read phone state da duoc gan
            //neu quyen read phone number da duoc gan
            if(checkSelfPermission(Manifest.permission.WRITE_CONTACTS)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.READ_CONTACTS)==
                    PackageManager.PERMISSION_GRANTED)
            {
                return true;//nhan duoc quyen
            }
            else //neu chua co quyen thi thong bao nguyoi dung cap quyen
            {
                ActivityCompat.requestPermissions(Demo3nMainActivity.this,
                        new String[]{Manifest.permission.WRITE_CONTACTS,
                                Manifest.permission.READ_CONTACTS},1);
                return false;
            }
        }
        else
        {
            Log.d("Phan quyen","Quyen da duoc gan");
            return true;
        }
    }
    @SuppressLint("Range")
    void getContacts()
    {
        ArrayList list=new ArrayList();//list chua du lieu
        Uri uri = Uri.parse("content://com.android.contacts/contacts");
        //khai bao con tro dongf
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        if(cursor.getCount()>0)//neu co du lieu
        {
            cursor.moveToFirst();//di chuyen ve ban ghi dau tien
            while (!cursor.isAfterLast())//neu khong phai ban ghi cuoi cung thi tiep tuc doc
            {
                //lay ve (ID)
                @SuppressLint("Range")
                String thutu=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                //lay ve Name
                @SuppressLint("Range")
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                //tao con tro cot
                Cursor cursorNumber=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" =? AND "+
                        ContactsContract.CommonDataKinds.Phone.TYPE+" = "+
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,
                        new String[]{thutu},null);
                //tien hanh doc du lieu cot
                String contactNumber="";
                if(cursorNumber.moveToFirst())//di chuyen ve ban ghi dau tien
                {
                    //doc so dien thoai
                    contactNumber=
                    cursorNumber.getString(cursorNumber.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                cursorNumber.close();//doc xong thi dong con tro
                //ghep ten va sdt
                String thutu_ten=thutu+" - "+name+" - "+contactNumber;
                list.add(thutu_ten);//dua vao list
                cursor.moveToNext();//di chuyen ban ghi tiep theo
            }
            cursor.close();//doc xong thi dong con tro
            //dua len arraylist
            ArrayAdapter<String> arrayAdapter
                    =new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
            listView.setAdapter(arrayAdapter);
        }

    }
}