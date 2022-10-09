package com.example.fireteramenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class saved extends AppCompatActivity  implements PopupMenu.OnMenuItemClickListener{
    static int pos = 0;
    ListView firetea;
    ArrayList< String > Link = new ArrayList < > ();
    ArrayList < String > TitleList = new ArrayList < > ();
    ArrayList<TutorialModel> tutorialModels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        firetea = findViewById(R.id.firetea);

        CustomAdapter customAdapter = new CustomAdapter();
        firetea.setAdapter(customAdapter);


        DatabaseHelper myDB = new DatabaseHelper(this);
        Cursor data = myDB.getTutorial();

        if(data.getCount() == 0 ){

            Toast.makeText(this,"The database was empty", Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()) {
                TitleList.add(data.getString(1));
                Link.add(data.getString(2));
            }
        }

        for(int i=0; i<TitleList.size(); i++){
            tutorialModels.add(new TutorialModel( TitleList.get(i),Link.get(i)
            ));
        }


        firetea.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                pos = position;
                PopupMenu popup = new PopupMenu(saved.this, view);
                popup.setOnMenuItemClickListener(saved.this);
                popup.inflate(R.menu.menu_main);
                popup.show();
            }
        });
    }


    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return TitleList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View viewl = getLayoutInflater().inflate(R.layout.listview_main, null);
            TextView title = viewl.findViewById(R.id.title);
            title.setText(TitleList.get(position));
            return viewl;
        }
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.view:
                Intent intent = new Intent(saved.this, WebContainer.class);
                intent.putExtra("Link", String.valueOf(Link.get(pos)));
                startActivity(intent);
                return true;

            default:
                return false;
        }
    }
}