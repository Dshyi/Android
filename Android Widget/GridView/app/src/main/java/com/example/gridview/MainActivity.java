package com.example.gridview;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("网格视图");
        GridView gv = (GridView) findViewById(R.id.activity_main);
        gv.setAdapter(new ImageAdapter(this));

    }

    public class ImageAdapter extends BaseAdapter {

        private Context mContext;
        public ImageAdapter(Context c) {
            mContext = c;
        }

        private Integer[] mThumbIds = { R.drawable.grid_view_01,
                R.drawable.grid_view_02, R.drawable.grid_view_03,
                R.drawable.grid_view_04, R.drawable.grid_view_05,
                R.drawable.grid_view_06, R.drawable.grid_view_07,
                R.drawable.grid_view_08, R.drawable.grid_view_09,
                R.drawable.grid_view_10, R.drawable.grid_view_11,
                R.drawable.grid_view_12, R.drawable.grid_view_13,
                R.drawable.grid_view_14, R.drawable.grid_view_15,
                R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6,
                R.drawable.sample_7 };

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(130, 130));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

    }
}
