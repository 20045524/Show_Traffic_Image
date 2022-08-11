package sg.edu.rp.c346.id20045524.showtrafficimage;

public class TrafficImage {
    private String trafficImage;
    private double latitude;
    private double longtitude;
    private int cameraID;

    public TrafficImage(String trafficImage, double latitude, double longtitude, int cameraID) {
        this.trafficImage = trafficImage;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.cameraID = cameraID;

    }

    public String getTrafficImage() {
        return trafficImage;
    }

    public int getCameraID() {
        return cameraID;
    }

    public double getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "TrafficImage{" +
                "trafficImage='" + trafficImage + '\'' +
                ", latitude=" + latitude +
                ", longtitude=" + longtitude +
                ", cameraID=" + cameraID +
                '}';
    }

    public double getLongtitude() {
        return longtitude;
    }
}
