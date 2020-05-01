package com.example.assignment3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    Context context;
    ArrayList <BookDetails> booksArray;


    public RVAdapter(Context context, ArrayList<BookDetails> booksArray)
    {
        this.context = context;
        this.booksArray = booksArray;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView book_image;
        TextView book_title;
        TextView book_level;
        TextView book_description;
        Button book_btn;
        public ViewHolder(View itemView)
        {
            super(itemView);
        }

    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return booksArray.size();
    }

}
