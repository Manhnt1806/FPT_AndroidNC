package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String filename="QR.xlsx";
        //String pdfFile = "android.resource://" + getPackageName() + "/"+R.raw.qr;
        //String localFile="file:///android_asset/qr.xlsx";
        //======start

        //====end
//        File pdfFile = new File("file:///android_asset/qr.xlsx");
//        Uri path = Uri.fromFile(pdfFile);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        intent.setDataAndType(path, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//
//        startActivity(intent);
//
//        Uri pdfUri = Uri.parse("file:///android_asset/qr.pdf");
//        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
//                .setText("Share PDF doc")
//                .setType("application/pdf")
//                .setStream(pdfUri)
//                .getIntent()
//                .setPackage("com.google.android.apps.docs");
//        startActivity(shareIntent);
    }
    private boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public void generate(View view) {


            PackageManager pm = getApplicationContext().getPackageManager();
            boolean isInstalled = isPackageInstalled("com.google.android.apps.docs.editors.sheets", pm);
            if(isInstalled)
            {
                //String localFile = "https://docs.google.com/spreadsheets/d/1xnjjasqUYK7h_zkUkfmxryEJ1g_Y1BUKcYrwjAeT00I/edit#gid=0";
                String localFile = "https://docs.google.com/spreadsheets/d/1tj-LokfoC08P91mNUD_hUur-dCwRoBOqyCT23aEbZn8/edit#gid=0";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(localFile));
                browserIntent.addCategory(Intent.CATEGORY_DEFAULT);
                browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(browserIntent);
            }
            //----
            else
            {
                String appPackageName = "com.google.android.apps.docs.editors.sheets";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(
                        "https://play.google.com/store/apps/details?id=" + appPackageName));

                startActivity(intent);
            }


    }

//    public void openCopiedFile(View view) {
//        String[] mimeTypes =
//                {"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"};
//
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//        intent.addCategory(Intent.CATEGORY_OPENABLE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            intent.setType(mimeTypes.length == 1 ? mimeTypes[0] : "*/*");
//            if (mimeTypes.length > 0) {
//                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
//            }
//        } else {
//            String mimeTypesStr = "";
//            for (String mimeType : mimeTypes) {
//                mimeTypesStr += mimeType + "|";
//            }
//            intent.setType(mimeTypesStr.substring(0,mimeTypesStr.length() - 1));
//        }
//        startActivityForResult(Intent.createChooser(intent,"ChooseFile"), 0);
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//
//
//            case 0: {
//
//                if (resultCode == RESULT_OK) {
//
//
//                    // Get the Uri of the selected file
//                    Uri uri = data.getData();
//                    Log.d("TAG", "File Uri: " + uri.toString());
//                    // Get the path
//                    String path = null;
//                    try {
//                        File myFile = new File(uri.getPath());
//                        String filePath = myFile.getAbsolutePath();
//                        String localFile =filePath;// "https://docs.google.com/spreadsheets/d/1xnjjasqUYK7h_zkUkfmxryEJ1g_Y1BUKcYrwjAeT00I/edit#gid=0";
//                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
//                        browserIntent.setData(Uri.parse(localFile));
//                        browserIntent.addCategory(Intent.CATEGORY_DEFAULT);
//                        browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);
//                        startActivity(browserIntent);
//                    } catch (Exception e ) {
//                        e.printStackTrace();
//                    }
//                    Log.d("TAG", "File Path: " + path);
//
//                }
//            }
//
//        }
//    }
}
