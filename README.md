# android-animated-vector-drawable
Android Animated Vector Drawable Sample

## Start a new Android Studio project
- Empty Activity
- Minimum API Level **API 21**: Android 5.0 (Lollipop)

## Create the vector 
New Drawable resource file **vector_drawable.xml**

    <?xml version="1.0" encoding="utf-8"?>
    <vector xmlns:android="http://schemas.android.com/apk/res/android"
        android:width="64dp"
        android:height="64dp"
        android:viewportWidth="600"
        android:viewportHeight="600">
        <group
            android:name="rotationGroup"
            android:pivotX="300.0"
            android:pivotY="300.0"
            android:rotation="0.0">
            <path
                android:name="vectorPath"
                android:fillColor="#000000"
                android:pathData="M300,70 l 0,-70 70,70 0,0 -70,70z" />
        </group>
    </vector>

## Create the animations
- Create New Android Resource Directory **anim**.
- In app/src/main/res/anim create **path_morph.xml**.
    
    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <objectAnimator
            android:duration="6000"
            android:propertyName="pathData"
            android:valueFrom="M300,70 l 0,-70 70,70 0,0 -70,70z"
            android:valueTo="M300,70 l 0,-70 70,0  0,140 -70,0 z"
            android:valueType="pathType" />
    </set>

- In app/src/main/res/anim create **rotation.xml**.

    <?xml version="1.0" encoding="utf-8"?>
    <set xmlns:android="http://schemas.android.com/apk/res/android">
        <objectAnimator
            android:duration="6000"
            android:propertyName="rotation"
            android:valueFrom="0"
            android:valueTo="360" />
    </set>


## Create the animated-vector
In app/src/main/res/drawable create **animated_vector_drawable.xml**.

    <?xml version="1.0" encoding="utf-8"?>
    <animated-vector xmlns:android="http://schemas.android.com/apk/res/android"
        android:drawable="@drawable/vector_drawable">
        <target
            android:name="rotationGroup"
            android:animation="@anim/rotation" />
        <target
            android:name="vectorPath"
            android:animation="@anim/path_morph" />
    </animated-vector>

## Add ImageView and Button to layout
Modify **activity_main.xml**.

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:padding="16dp"
        tools:context=".MainActivity">

        <ImageView
            android:id="@+id/animatableImageView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:src="@drawable/animated_vector_drawable" />

        <Button
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Animate"
            android:onClick="onClickAnimate"/>

    </LinearLayout>

## Create button click handler
Add **onClickAnimat**e method to **MainActivity** class.

    public class MainActivity extends AppCompatActivity {

        ...
        
        public void onClickAnimate(View view) {
            ImageView iv = findViewById(R.id.animatableImageView);
            AnimatedVectorDrawable avd = (AnimatedVectorDrawable) iv.getDrawable();
            avd.start();
        }
    }

That's it. Run your app.
