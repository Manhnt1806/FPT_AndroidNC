package manhntph29583.baithi.lab3_nc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv_listview);
        xinQuyenNguoiDung();
        getContacts();
    }
    Context context=this;
    public boolean xinQuyenNguoiDung()
    {
        if(Build.VERSION.SDK_INT>=24)
        {
            if(checkSelfPermission(android.Manifest.permission.READ_CONTACTS)==
                    PackageManager.PERMISSION_GRANTED
                    && checkSelfPermission(android.Manifest.permission.WRITE_CONTACTS)==
                    PackageManager.PERMISSION_GRANTED)
            {
                return true;
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{android.Manifest.permission.READ_CONTACTS,
                                android.Manifest.permission.WRITE_CONTACTS},1);
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
        Uri uri = Uri.parse("content://com.android.contacts/contacts");
        ArrayList list=new ArrayList();
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                @SuppressLint("Range")
                String thutu=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                @SuppressLint("Range")
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Cursor cursorNumber=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" =? AND "+
                                ContactsContract.CommonDataKinds.Phone.TYPE+" = "+
                                ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,new String[]{thutu},null);
                String contactNumber="";
                if(cursorNumber.moveToFirst())
                {
                    contactNumber=cursorNumber.getString(
                            cursorNumber.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                cursorNumber.close();
                String thutu_ten=thutu+" - "+name+" - "+contactNumber;
                list.add(thutu_ten);
                cursor.moveToNext();
            }
            cursor.close();
        }
        ArrayAdapter<String> arrayAdapter
                =new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);
    }
}