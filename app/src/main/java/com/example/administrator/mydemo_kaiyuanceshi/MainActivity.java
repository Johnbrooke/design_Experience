package com.example.administrator.mydemo_kaiyuanceshi;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (NavigationView) findViewById(R.id.navi_view);
        //让图片恢复到原来的色彩
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id =item.getItemId();

                if (id == R.id.one){
                    startActivity(new Intent(MainActivity.this,TabActivity.class));
                }else if (id == R.id.two){
                    startActivity(new Intent(MainActivity.this,Collapsingtoolbar_Acty.class));
                }else if (id == R.id.three){
                    startActivity(new Intent(MainActivity.this,TextInput_Acty.class));
                }else if (id == R.id.four){
                    Toast.makeText(MainActivity.this,"第四次",Toast.LENGTH_SHORT).show();
                }else if (id == R.id.five){
                    Toast.makeText(MainActivity.this,"第五次",Toast.LENGTH_SHORT).show();
                }
                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
}
