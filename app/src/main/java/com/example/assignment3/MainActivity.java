package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = getResources().openRawResource(R.raw.issues);
        byte[] issuesData ;
        ArrayList<BookDetails> issues_books = new ArrayList<>(); //to store books data
        try {
            issuesData= new byte[inputStream.available()];
            while (inputStream.read (issuesData) != -1){ //read issues.json
            }
            JSONObject json_object = new JSONObject(new String (issuesData));
            JSONArray books_json = json_object.getJSONArray ("books");
            for (int i = 0; i < books_json.length (); i++) {
                BookDetails books_details= new BookDetails();
                JSONObject bookObject = books_json.getJSONObject (i);

                books_details.book_cover_url =  (bookObject.getString ("cover"));
                books_details.book_title = (bookObject.getString ("title"));
                books_details.book_level = (bookObject.getString ("level"));
                books_details.book_description = (bookObject.getString ("info"));
                books_details.book_url = (bookObject.getString ("url"));
                issues_books.add(books_details);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        RVAdapter adapter = new RVAdapter(this,issues_books);
        rv.setAdapter(adapter);
        rv.setLayoutManager(llm);

    }
}
