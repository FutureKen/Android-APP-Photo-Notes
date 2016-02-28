package com.example.kenneth.photonotes;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class NotesCursorAdaptor extends CursorAdapter {

    private LayoutInflater cursorInflater;


    public NotesCursorAdaptor(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return cursorInflater.inflate(R.layout.custom_row, parent, false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
            // Find fields to populate in inflated template
            TextView path = (TextView) view.findViewById(R.id.label);
            // Extract properties from cursor
            String img = cursor.getString(cursor.getColumnIndex("path"));
            String words = cursor.getString(cursor.getColumnIndex("caption"));
            // Populate fields with extracted properties

            path.setText(words);
            String filepath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/photonotes.kenneth/" + img;

            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 16; // Experiment with different sizes
                Bitmap bitmap = BitmapFactory.decodeFile(filepath, options);
                ImageView imageView = (ImageView) view.findViewById(R.id.icon);

                imageView.setImageBitmap(bitmap);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
