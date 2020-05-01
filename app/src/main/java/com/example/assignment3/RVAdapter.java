package com.example.assignment3;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    Context context;
    ArrayList <BookDetails> booksArray;
    String baseUrl = "https://raw.githubusercontent.com/revolunet/PythonBooks/master/";


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
            book_image = itemView.findViewById(R.id.cover);
            book_title = itemView.findViewById(R.id.title);
            book_level = itemView.findViewById(R.id.level);
            book_description = itemView.findViewById(R.id.description);
            book_btn = itemView.findViewById(R.id.btn);
        }

    }

    @NonNull
    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View bookRow= LayoutInflater.from(context).inflate(R.layout.book_row ,parent, false);
        return new ViewHolder(bookRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        // picasso.setLoggingEnabled(true);
        Picasso.get().load(baseUrl+ booksArray.get(position).book_cover_url).placeholder(R.drawable.loading).into(holder.book_image);

        holder.book_title.setText(booksArray.get(position).book_title);
        holder.book_level.setText(booksArray.get(position).book_level);
        holder.book_description.setText(booksArray.get(position).book_description);
        String file_url[] = booksArray.get(position).book_url.split("\\.");
        String file_extension = file_url[file_url.length - 1];
        Log.d("Extension","#" + file_extension);
        final String download_url = booksArray.get(position).book_url;
        if(file_extension.equals("zip") || file_extension.equals("pdf")){
            holder.book_btn.setText("DOWNLOAD");

            holder.book_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DownloadManager downloadManager = (DownloadManager)context.getSystemService(context.DOWNLOAD_SERVICE);
                    Uri uri = Uri.parse(download_url);
                    DownloadManager.Request download_request = new DownloadManager.Request(uri);
                    download_request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    downloadManager.enqueue(download_request);
                }
            });
        }
        else{
                holder.book_btn.setText("READ ONLINE");
                holder.book_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(download_url));
                    ContextCompat.startActivity(context, intent, null);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return booksArray.size();
    }

}
