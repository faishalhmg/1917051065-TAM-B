package com.fhmg.myrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 private RecyclerView rvCategory;
 private ArrayList<President> list = new ArrayList<>();

    private void showSelectedPresident(President president){
         Toast.makeText(this, "Kamu memilih "+president.getName(), Toast.LENGTH_SHORT).show();
         }

         @Override
 protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         rvCategory = findViewById(R.id.rv_category);
         rvCategory.setHasFixedSize(true);

         list.addAll(PresidentData.getListData());
        showRecyclerList();
         }
    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rvCategory.setAdapter(gridPresidentAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
 @Override
 public void onItemClicked(RecyclerView recyclerView
                    , int position, View v) {
                 showSelectedPresident(list.get(position));
                 }
 });

    }
        private void showRecyclerCardView(){
             rvCategory.setLayoutManager(new LinearLayoutManager(this));
             CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
             cardViewPresidentAdapter.setListPresident(list);
             rvCategory.setAdapter(cardViewPresidentAdapter);
             }


         private void showRecyclerList(){
         rvCategory.setLayoutManager(new LinearLayoutManager(this));
         ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
         listPresidentAdapter.setListPresident(list);
         rvCategory.setAdapter(listPresidentAdapter);
             ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
 @Override
 public void onItemClicked(RecyclerView recyclerView
                         , int position, View v) {
                     showSelectedPresident(list.get(position));
                      }
 });
         }

    @Override
 public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_main, menu);
         return super.onCreateOptionsMenu(menu);
         }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_grid:
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}