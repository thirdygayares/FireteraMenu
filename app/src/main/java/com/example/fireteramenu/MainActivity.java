package com.example.fireteramenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    ListView firetea;
    ArrayList < String > Link = new ArrayList < > ();
    ArrayList < String > TitleList = new ArrayList < > ();
    static int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firetea = findViewById(R.id.firetea);
        TitleList.add("Java Home");
        Link.add("file:///android_asset/java/java/default.html");
        TitleList.add("Java Intro");
        Link.add("file:///android_asset/java/java/java_intro.html");
        TitleList.add("Java Get Started");
        Link.add("file:///android_asset/java/java/java_getstarted.html");
        TitleList.add("Java Syntax");
        Link.add("file:///android_asset/java/java/java_syntax.html");
        TitleList.add("Java Comments");
        Link.add("file:///android_asset/java/java/java_comments.html");
        TitleList.add("Java Variables");
        Link.add("file:///android_asset/java/java/java_variables.html");
        TitleList.add("Java Data Types");
        Link.add("file:///android_asset/java/java/java_data_types.html");
        TitleList.add("Java Type Casting");
        Link.add("file:///android_asset/java/java/java_type_casting.html");
        TitleList.add("Java Operators");
        Link.add("file:///android_asset/java/java/java_operators.html");
        TitleList.add("Java Strings");
        Link.add("file:///android_asset/java/java/java_strings.html");
        TitleList.add("Java Math");
        Link.add("file:///android_asset/java/java/java_math.html");
        TitleList.add("Java Booleans");
        Link.add("file:///android_asset/java/java/java_booleans.html");
        TitleList.add("Java If.else");
        Link.add("file:///android_asset/java/java/java_conditions.html");
        TitleList.add("Java Switch");
        Link.add("file:///android_asset/java/java/java_switch.html");
        TitleList.add("Java While Loop");
        Link.add("file:///android_asset/java/java/java_while_loop.html");
        TitleList.add("Java For Loop");
        Link.add("file:///android_asset/java/java/java_for_loop.html");
        TitleList.add("Java Break/Continue");
        Link.add("file:///android_asset/java/java/java_break.html");
        TitleList.add("Java Arrays");
        Link.add("file:///android_asset/java/java/java_arrays.html");

        CustomAdapter customAdapter = new CustomAdapter();
        firetea.setAdapter(customAdapter);

        firetea.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView< ? > parent, View view, int position, long id) {
                pos = position;
                PopupMenu popup = new PopupMenu(MainActivity.this, view);
                popup.setOnMenuItemClickListener(MainActivity.this);
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
                Intent intent = new Intent(MainActivity.this, WebContainer.class);
                intent.putExtra("Link", String.valueOf(Link.get(pos)));
                startActivity(intent);
                return true;
            case R.id.save:
                // do your code
            TutorialModel tutorialModel;
                try {
                    tutorialModel = new TutorialModel(TitleList.get(pos), Link.get(pos));
                    DatabaseHelper databaseHelper = new DatabaseHelper(this);
                    boolean success = databaseHelper.save(tutorialModel);
                    Toast.makeText(this, "Saved Succesfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(this, "Please Insert All Data", Toast.LENGTH_SHORT).show();
                }

                return true;
            default:
                return false;
        }
    }

    //onoptionMenu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.view:
              startActivity(new Intent(this, saved.class));
                return true;
            case R.id.exit:
                finishAndRemoveTask();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}