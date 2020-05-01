package com.example.assignment3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import androidx.annotation.NonNull;
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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // picasso.setLoggingEnabled(true);
        Picasso.get().load(baseUrl+ "img/cover_how_to_make_mistakes_in_python.gif").placeholder(R.drawable.loading).into(holder.book_image);

        holder.book_title.setText("BOOK");
        holder.book_level.setText("Beginner");
        holder.book_description.setText("BOOK Description. BOOK Description BOOK Description");
//        String str = booksUrls[position].substring(booksUrls[position].length() - 4);
//        if(str.equals(".zip") || str.equals(".pdf")){
//            // change the text of button to "DOWNLOAD"
        holder.book_btn.setText("Read Online");
        // set click event on Button and then start downloading file through download manger
//            holder.tv_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String url = booksUrls[position];
//                    DownloadManager downloadManager = (DownloadManager)context.getSystemService(context.DOWNLOAD_SERVICE);
//                    Uri uri = Uri.parse(url);
//                    DownloadManager.Request request = new DownloadManager.Request(uri);
//                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//                    Long ref = downloadManager.enqueue(request);
//                }
//            });
//        }
//        else{
//            holder.tv_btn.setText("READ ONLINE");
//            //set click event on Button and then move to google chorme to read book online
//            holder.tv_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String url = booksUrls[position];
//                    Intent intent = new Intent(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(url));
//                    ContextCompat.startActivity(context, intent, null);
//                }
//            });
//    }
    }


    @Override
    public int getItemCount() {
        return 1;
    }

}
