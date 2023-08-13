package com.sach.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepo noteRepo;
    private LiveData<List<Note>> notelist;
    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRepo=new NoteRepo(application);
        notelist=noteRepo.getAllData();
    }
    public void insert(Note note){
       noteRepo.insertData(note);
    }
    public void Update(Note note){
       noteRepo.updateData(note);
    }
    public void delete(Note note){
       noteRepo.deletData(note);
    }
    public LiveData<List<Note>> getallNotes(){
        return notelist;
    }
}
