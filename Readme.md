Photo Notes
=========

Overview 
=========

In this homework assignment, you will create a simple note-taking app that allows you to take a photo and associate a caption for each picture.

This homework will give familiarity with SQLite storage, file storage, and the camera.

Activities 
===========

The app has 3 activities:

1. List activity 
-----------------

The list activity should display the list of saved notes. Each row can be represented with a simple of piece of text (a simple ListAdapter or BaseAdaptor will suffice).

The ActionBar should have a button for adding a new photo, which launches the "Add Photo Activity" (described below).

Bonus feature is to add thumbnail pictures to each row and make sure long sized caption is properly [*ellipsized.*](http://developer.android.com/reference/android/widget/TextView.html#attr_android:ellipsize)[ ](http://developer.android.com/reference/android/widget/TextView.html#attr_android:ellipsize)

**2. View Photo Activity **

This activity is simple: it displays the photo and the caption that was clicked on in the List Activity.

3. Add Photo Activity 
----------------------

This activity should have at least 3 fields:

-   EditText field for the caption

-   Button for taking the photo. This should launch the camera intent.

-   Save button. This should return to the list activity (use the finish()method).

.

SQLite 
=======

This app should use SQLite. You should have a table with at least two fields:

-   Caption field - This is a user-specified text field.

-   Path field - This holds the absolute path to the photo.

The photos and thumbnail files (if any) should be stored on external storage. To work around Android 6.0 run-time permission, it is OK to set targetSDK to 22 in your app build.gradle file.

Notes 
======

-   It's not possible to view internal storage through adb/sqlite3 on a physical Android device (unless it's rooted, which I don't recommend doing). This technique only works on the emulator.

-   You don't need to have capabilities for updating or deleting photo notes.

-   You're not required to use a CursorAdapter for the ListView. You can do a simpler implementation if you want.

-   Displaying large bitmaps may cause your app to run out of memory. You should load bitmaps from the filesystem with the following to avoid OutOfMemoryErrors:

> BitmapFactory.Options options = new BitmapFactory.Options(); options.inSampleSize = 8; // Experiment with different sizes
>
> Bitmap b = BitmapFactory.decodeFile(filePath, options);
