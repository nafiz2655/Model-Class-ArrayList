package com.example.modelclassarraylist;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    ArrayList<ModelClass> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerview = findViewById(R.id.recyclerview);

        MakeData();


        My_adapter myAdapter = new My_adapter();
        recyclerview.setAdapter(myAdapter);


    }
    public class My_adapter extends RecyclerView.Adapter<My_adapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item_layout,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String image = arrayList.get(position).getImage();
            String name = arrayList.get(position).getName();

            holder.imageView.setImageResource(Integer.parseInt(image));
            holder.name.setText(name);





        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            CircleImageView imageView;
            TextView name;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.profile);
                name = itemView.findViewById(R.id.name);
            }
        }
    }

    public void MakeData(){

        arrayList.add(new ModelClass("Julker nime",""+R.drawable.por6));
        arrayList.add(new ModelClass("Rakib Shah",""+R.drawable.pro2));
        arrayList.add(new ModelClass("Joni khan",""+R.drawable.pro10));
        arrayList.add(new ModelClass("Sumon Khan",""+R.drawable.pro3));
        arrayList.add(new ModelClass("Rabbil Rupom",""+R.drawable.por7));
        arrayList.add(new ModelClass("Julker nime",""+R.drawable.por6));
        arrayList.add(new ModelClass("Rakib Shah",""+R.drawable.pro2));
        arrayList.add(new ModelClass("Joni khan",""+R.drawable.pro10));
        arrayList.add(new ModelClass("Sumon Khan",""+R.drawable.pro3));
        arrayList.add(new ModelClass("Rabbil Rupom",""+R.drawable.por7));
    }
}