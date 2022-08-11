package sg.edu.rp.c346.id20045524.showtrafficimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrafficImageAdapter extends ArrayAdapter<TrafficImage> {

    Context parent_context;
    int layout_id;
    ArrayList<TrafficImage> al;

    public TrafficImageAdapter(Context context, int resource, ArrayList<TrafficImage> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        al = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvLat = rowView.findViewById(R.id.tvLat);
        TextView tvLong = rowView.findViewById(R.id.tvLong);
        TextView tvCamID = rowView.findViewById(R.id.tvCamId);
        ImageView ivTraffic = rowView.findViewById(R.id.ivTraffic);

        // Obtain the Android Version information based on the position
        TrafficImage currentItem = al.get(position);

        // Set values to the TextView to display the corresponding information

        tvLat.setText("Latitude: " + currentItem.getLatitude());
        tvLong.setText("Longitude: " + currentItem.getLongtitude());
        tvCamID.setText("Camera Id: " + currentItem.getCameraID());
        Picasso.get().load(currentItem.getTrafficImage()).into(ivTraffic);

        return rowView;
    }

}
