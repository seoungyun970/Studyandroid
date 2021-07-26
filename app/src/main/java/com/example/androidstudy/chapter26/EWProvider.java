package com.example.androidstudy.chapter26;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.androidstudy.DBHelper.WordDBHelper;

public class EWProvider extends ContentProvider {
    static final Uri CONTENT_URI = Uri.parse("content://andexam.ver6.English/word");
    static final int ALLWORD = 1;
    static final int ONEWORD = 2;

    static final UriMatcher matcher;
    static {
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI("andexam.ver6.EnglishWord","word",ALLWORD);
        matcher.addURI("andexam.ver6.EnglishWord","word/*",ONEWORD);
    }
    SQLiteDatabase mDB;

    @Override
    public boolean onCreate() {
        WordDBHelper helper = new WordDBHelper(getContext());
        mDB = helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        if (matcher.match(uri) == ALLWORD) {

        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
