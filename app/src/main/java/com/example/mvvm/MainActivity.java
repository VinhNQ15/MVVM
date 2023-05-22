package com.example.mvvm;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnitemclickListener {
    RecyclerView recyclerView;// hiển thị danh sách note lên
    NoteAdapter noteAdapter; //1

    ArrayList<Note> noteData;//  danh sách các note

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

    }


    private void anhxa() {
        recyclerView = findViewById(R.id.recycler_view);
        Button button= findViewById(R.id.add_item);
        noteData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            noteData.add(new Note("Note" + i, "This is description " + i));

        }
        noteAdapter = new NoteAdapter(noteData, this);//1
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);//khoi tao
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(noteAdapter);
    }

    @Override
    public void onItemClick(Note note) {
//        showToast("you click" +note.getTitle());
    }

    @Override
    public void insert(Note note) {
        Button button= findViewById(R.id.add_item);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
                alertdialog.setTitle("thông báo");
                alertdialog.setIcon(R.drawable.ic_launcher_background);
                alertdialog.setMessage("bạn muốn thêm items không");
                alertdialog.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        noteData.add(note);
                        noteAdapter.notifyDataSetChanged();
                    }
                });
                alertdialog.setNegativeButton("không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertdialog.show();
            }
        });

    }

    @Override
    public void delete(Note note) {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
        alertdialog.setTitle("thông báo");
        alertdialog.setIcon(R.drawable.ic_launcher_background);
        alertdialog.setMessage("bạn muốn xóa items không");
        alertdialog.setPositiveButton("có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                noteData.remove(note);
                noteAdapter.notifyDataSetChanged();
            }
        });
        alertdialog.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertdialog.show();
//        noteData.remove(note);
//        noteAdapter.notifyItemRemoved(noteData);
    }




}