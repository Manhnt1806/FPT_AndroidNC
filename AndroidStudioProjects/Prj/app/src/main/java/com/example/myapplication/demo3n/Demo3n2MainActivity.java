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
import java.util.List;

public class Demo3n2MainActivity extends AppCompatActivity {
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3n2_main);
        listView=findViewById(R.id.demo3n2Listview);
        xinQuyenNguoiDung();
        getContacts();
    }
    Context context=this;
    public boolean xinQuyenNguoiDung()
    {
        if(Build.VERSION.SDK_INT>=23)//version cao
        {
            //neu quyen read phone state da duoc gan
            //neu quyen read phone number da duoc gan
            if(checkSelfPermission(Manifest.permission.READ_CONTACTS)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.WRITE_CONTACTS)==
                    PackageManager.PERMISSION_GRANTED)
            {
                return true;//nhan duoc quyen
            }
            else //neu chua co quyen thi thong bao nguyoi dung cap quyen
            {
                ActivityCompat.requestPermissions(Demo3n2MainActivity.this,
                        new String[]{Manifest.permission.READ_CONTACTS,
                                Manifest.permission.WRITE_CONTACTS},1);
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
        List list=new ArrayList();//chua du lieu doc duoc
        Uri uri=Uri.parse("content://com.android.contacts/contacts");//duong dan
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        if(cursor.getCount()>0)//neu co du lieu
        {
            cursor.moveToFirst();//di chuyen ve ban ghi dau tien
            while (!cursor.isAfterLast())//neu khong phai ban ghi cuoi cung thi tiep tuc doc
            {
                //Lay ve ID
                @SuppressLint("Range")
                String id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                //lay ve name
                @SuppressLint("Range")
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                //doc so dien thoai
                Cursor cursorNumber=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER} ,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" =? AND "+
                        ContactsContract.CommonDataKinds.Phone.TYPE+" = "+
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,
                        new String[]{id},null);
                String contactNumber="";
                if(cursorNumber.moveToFirst())
                {
                    contactNumber=
                    cursorNumber.getString(
                            cursorNumber.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                cursorNumber.close();
                //them
                String them=id+" - "+name+" - "+contactNumber;
                //dua vao list
                list.add(them);
                cursor.moveToNext();
            }
            cursor.close();//dong con tro
            ArrayAdapter arrayAdapter
                    =new ArrayAdapter(Demo3n2MainActivity.this, android.R.layout.simple_list_item_1,list);
            listView.setAdapter(arrayAdapter);
        }

    }
}