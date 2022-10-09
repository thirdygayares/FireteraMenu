
package com.example.fireteramenu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;

public class WebContainer extends AppCompatActivity {
    String forward = "";
    WebView myWebView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_container);
        intent = getIntent();
        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(intent.getStringExtra("Link"));
    }

    //onoptionMenu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.webmenu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.home:
                forward = "file:///android_asset/java/java/default.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);

                return true;
            case R.id.intro:
                forward = "file:///android_asset/java/java/java_intro.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.started:
                forward = "file:///android_asset/java/java/java_getstarted.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.syntax:
                forward = "file:///android_asset/java/java/java_syntax.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.comments:
                forward = "file:///android_asset/java/java/java_comments.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.variables:
                forward = "file:///android_asset/java/java/java_variables.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.datatypes:
                forward = "file:///android_asset/java/java/java_data_types.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.casting:
                forward = "file:///android_asset/java/java/java_type_casting.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;

            case R.id.operators:
                forward = "file:///android_asset/java/java/java_operators.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.strings:
                forward = "file:///android_asset/java/java/java_strings.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;

            case R.id.math:
                forward = "file:///android_asset/java/java/java_math.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.booleans:
                forward = "file:///android_asset/java/java/java_booleans.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.ifelse:
                forward = "file:///android_asset/java/java/java_conditions.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.switches:
                forward = "file:///android_asset/java/java/java_switch.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.whileloop:
                forward = "file:///android_asset/java/java/java_while_loop.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            case R.id.forloop:
                forward = "file:///android_asset/java/java/java_for_loop.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;

            case R.id.breakcontinue:
                forward = "file:///android_asset/java/java/java_break.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;

            case R.id.arrays:
                forward = "file:///android_asset/java/java/java_arrays.html";
                intent = new Intent(WebContainer.this, WebContainer.class);
                intent.putExtra("Link", forward);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}