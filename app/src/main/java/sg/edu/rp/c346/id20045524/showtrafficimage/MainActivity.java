package sg.edu.rp.c346.id20045524.showtrafficimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvTrafficImage;
    AsyncHttpClient client;
    ArrayList<TrafficImage> alTrafficImage;
    TrafficImageAdapter aaTrafficImage;
    ArrayAdapter aaTI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTrafficImage = findViewById(R.id.lvTrafficImage);
        client = new AsyncHttpClient();

    }

    @Override
    protected void onResume() {
        super.onResume();

        alTrafficImage = new ArrayList<TrafficImage>();
        aaTrafficImage = new TrafficImageAdapter(MainActivity.this, R.layout.row, alTrafficImage);
        lvTrafficImage.setAdapter(aaTrafficImage);

        client.get("https://api.data.gov.sg/v1/transport/traffic-images", new JsonHttpResponseHandler() {

            String img;
            double latitude;
            double longitude;
            int cameraId;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrCameras = firstObj.getJSONArray("cameras");

                    for(int i = 0; i < jsonArrCameras.length(); i++) {
                        JSONObject jsonObjCameras = jsonArrCameras.getJSONObject(i);
                        img = jsonObjCameras.getString("image");
                        cameraId = jsonObjCameras.getInt("camera_id");

                        JSONObject jsonObjLocation = jsonObjCameras.getJSONObject("location");
                        latitude = jsonObjLocation.getDouble("latitude");
                        longitude = jsonObjLocation.getDouble("longitude");

                        TrafficImage trafficImage = new TrafficImage(img, latitude,
                                longitude, cameraId);
                        alTrafficImage.add(trafficImage);

                        Log.i("Adding", "Adding");
                    }
                }
                catch(JSONException e){
                    Log.i("Error", "Adding");
                    e.printStackTrace();
                }

                //POINT X – Code to display List View
                aaTrafficImage.notifyDataSetChanged();



            }//end onSuccess
        });
    }//end onResume

    private void loadSpinner() {

    }

}