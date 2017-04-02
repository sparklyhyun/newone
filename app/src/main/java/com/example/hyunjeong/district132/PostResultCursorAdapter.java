package com.example.hyunjeong.district132;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Liew on 1/4/2017.
 */

public class PostResultCursorAdapter extends CursorAdapter {
    public PostResultCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_search_results, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView textViewID = (TextView) view.findViewById(R.id.postID);
        TextView textViewHouseType = (TextView) view.findViewById(R.id.postHouseType);
        TextView textViewLocation = (TextView) view.findViewById(R.id.postLocation);
        TextView textViewPurpose = (TextView) view.findViewById(R.id.postPurpose);

        // Extract properties from cursor
        String id = cursor.getString( cursor.getColumnIndex( PostDBHandler.COLUMN_POST_ID ));
        String hse = cursor.getString( cursor.getColumnIndex( PostDBHandler.COLUMN_HOUSETYPE ));
        String loc = cursor.getString( cursor.getColumnIndex( PostDBHandler.COLUMN_LOCATION ));
        String purp = cursor.getString( cursor.getColumnIndex( PostDBHandler.COLUMN_PURPOSE ));

        // Populate fields with extracted properties
        textViewID.setText(id);
        textViewHouseType.setText(hse);
        textViewLocation.setText(loc);
        textViewPurpose.setText(purp);
    }
}
