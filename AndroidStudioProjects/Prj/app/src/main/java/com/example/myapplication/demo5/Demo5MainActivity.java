package com.example.myapplication.demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Demo5MainActivity extends AppCompatActivity {
    ListView listView;
    List<String> lsTitle=new ArrayList<>();
    List<String> lsLink=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Intent intent;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5_main);
        listView=findViewById(R.id.demo5Lv);
        //goi link server
        new MyAsync().execute("https://ngoisao.vnexpress.net/rss/chau-a.rss");
        arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,lsTitle);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String link=lsLink.get(i);//lay ve link vua click
                intent=new Intent(Demo5MainActivity.this,
                        Demo5DetailMainActivity.class);
                intent.putExtra("linksent",link);
                startActivity(intent);
            }
        });
    }
    //dinh nghia lop ket noi voi internet
    public class MyAsync extends AsyncTask<String,Void,String>
    {
        //doc du lieu tu server
        @Override
        protected String doInBackground(String... strings) {
            //Tao bo chua du lieu
            StringBuilder stringBuilder=new StringBuilder();
            try {
                URL url=new URL(strings[0]);//lay duong link du lieu
                //tao luong doc du lieu
                InputStreamReader reader
                        =new InputStreamReader(url.openConnection().getInputStream());
                //tao bo dem
                BufferedReader bufferedReader=new BufferedReader(reader);
                //doc tung dong du lieu
                String line="";
                while ((line=bufferedReader.readLine())!=null)//neu khong phai dong cuoi dung thi van doc
                {
                    stringBuilder.append(line);//dua dong doc duoc vao bo chua du lieu
                }
                return stringBuilder.toString();//tra ve ket qua
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        //tra ve ket qua
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLPar xmlPar=new XMLPar();//goi doi tuong nhan du lieu
            try {
                Document document=xmlPar.getDocument(s);//lay tai lieu do server gui den
                //lay ve cac item trong tai lieu
                NodeList nodeList=document.getElementsByTagName("item");
                //lay ve title va link
                String link="";
                String title="";
                for(int i=0;i<nodeList.getLength();i++)
                {
                    //lay ve tung thanh phan
                    Element element=(Element) nodeList.item(i);
                    //lay ve gia tri cua tung thank phan
                    title=xmlPar.getValue(element,"title");
                    lsTitle.add(title);//them vao list title
                    link=xmlPar.getValue(element,"link");
                    lsLink.add(link);//them vao list link
                }
                arrayAdapter.notifyDataSetChanged();//cap nhat thay doi du lieu
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}