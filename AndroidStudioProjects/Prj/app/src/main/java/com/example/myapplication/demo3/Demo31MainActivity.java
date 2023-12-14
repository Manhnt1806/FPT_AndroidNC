package com.example.myapplication.demo3;

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

public class Demo31MainActivity extends AppCompatActivity {
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo31_main);
        listView=findViewById(R.id.demo31Listview);
        xinQuyenNguoiDung();
        getContacts();
    }
    Context context=this;
    public boolean xinQuyenNguoiDung()
    {
        if(Build.VERSION.SDK_INT>=23)//version cao
        {
            if(checkSelfPermission(Manifest.permission.READ_CONTACTS)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(Manifest.permission.WRITE_CONTACTS)==
                    PackageManager.PERMISSION_GRANTED)
            {
                return true;//nhan duoc quyen
            }
            else //neu chua co quyen thi thong bao nguyoi dung cap quyen
            {
                ActivityCompat.requestPermissions(Demo31MainActivity.this,
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
        Uri uri = Uri.parse("content://com.android.contacts/contacts");//duong dan
        ArrayList list=new ArrayList();//luu ket qua doc
        //tao con tro doc du lieu
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        //kiem tra xem danh ba co du lieu khong
        if(cursor.getCount()>0)//neu co du lieu
        {
            cursor.moveToFirst();//di chuyen con tro ve van ghi dau tien
            while (!cursor.isAfterLast())//neu khong phai ban ghi cuoi cung, thi tiep tuc doc
            {
                //lay ve so thu tu trong danh ba
                @SuppressLint("Range")
                String thutu=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                //lay ve ten ban ghi
                @SuppressLint("Range")
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                //khai bao con tro cot
                Cursor cursorNumber=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" =? AND "+
                        ContactsContract.CommonDataKinds.Phone.TYPE+" = "+
                        ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,new String[]{thutu},null);
                String contactNumber="";
                if(cursorNumber.moveToFirst())//di chuyen con tro cot ve cot dau tien
                {
                    contactNumber=cursorNumber.getString(
                            cursorNumber.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                cursorNumber.close();//dong contro cot
                //noi cac ket qua
                String thutu_ten=thutu+" - "+name+" - "+contactNumber;
                //them vao arraylist
                list.add(thutu_ten);
                cursor.moveToNext();//di chuyen sang ban ghi tiep theo
            }
            cursor.close();
        }
        //dua du lieu len Listview
        ArrayAdapter<String> arrayAdapter
                =new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
    }

}