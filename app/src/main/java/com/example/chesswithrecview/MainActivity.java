package com.example.chesswithrecview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements StoneAdapter.ItemSelected {
    private Button button;
    private RecyclerView recyclerView;
    private StoneAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Stone> stones;
    private int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initImgArray();
        initStonesArray();
        myAdapter=new StoneAdapter(MainActivity.this,stones);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setAdapter(myAdapter);
            }
        });
    }
//
    private void initImgArray() {
        images=new int[6];
        images[0]=R.drawable.d;
        images[1]=R.drawable.y;
        images[2]=R.drawable.t;
        images[3]=R.drawable.zz;
        images[4]=R.drawable.z;
        images[5]=R.drawable.g;
    }

    private void initViews() {
        button=findViewById(R.id.btnShowList);
        recyclerView=findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initStonesArray() {
        stones=new ArrayList<>();
        String[] st=getResources().getStringArray(R.array.stones);
        for (String s:st)
              {
            stones.add(new Stone(s));
        }
        for (int i=0;i<images.length;i++
             ) {
            stones.get(i).setImg(images[i]);
        }

    }

    @Override
    public void onItemClicked(int Index) {

    if(Index==0){
        Intent intent = new Intent(this, Daimond.class);
        startActivity(intent);}
    if(Index==1){
        Intent intent = new Intent(this, Yaqot.class);
        startActivity(intent);}
    if(Index==2){
        Intent intent = new Intent(this, Tobaz.class);
        startActivity(intent);}
    if(Index==3){
        Intent intent = new Intent(this, Zafer.class);
        startActivity(intent);}
    if(Index==4){
        Intent intent = new Intent(this, Zomorod.class);
        startActivity(intent);}
    if(Index==5){
        Intent intent = new Intent(this, Gem.class);
        startActivity(intent);}
    }
    }