package manhntph29583.baithi.lab5_nc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

public class MainActivity extends AppCompatActivity {
    ListView lv;
    List<String> listLink =new ArrayList<>();
    List<String> listTitle =new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        new MyAsyn().execute("https://ngoisao.vnexpress.net/rss/showbiz.rss");
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listTitle);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String link = listLink.get(i);
                intent = new Intent(MainActivity.this, MainWeb.class);
                intent.putExtra("linksent", link);
                startActivity(intent);
            }
        });

    }

    public class MyAsyn extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder =new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader =new BufferedReader(reader);
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            FileXML fileXML = new FileXML();
            try {
                Document document = fileXML.getDocument(s);
                NodeList nodeList = document.getElementsByTagName("item");
                String title = "";
                String link = "";
                for(int i=0; i<nodeList.getLength(); i++){
                    Element element = (Element) nodeList.item(i);
                    title = fileXML.getValue(element, "title");
                    listTitle.add(title);
                    link = fileXML.getValue(element, "link");
                    listLink.add(link);
                }
                arrayAdapter.notifyDataSetChanged();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}