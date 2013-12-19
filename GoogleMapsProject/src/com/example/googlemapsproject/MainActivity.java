package com.example.googlemapsproject;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity implements OnMarkerClickListener{

	//create the Google Map object
	private GoogleMap mMap;

	//The latitude and longitude for the venues in Glasgow
	public final LatLng GLASGOW = new LatLng(55.8580, -4.2590);
	public final LatLng SECC = new LatLng(55.8607, -4.2871);
	public final LatLng BARRY_BUDDON_SHOOTING = new LatLng(56.499, -2.7543);
	public final LatLng PARKHEAD = new LatLng(55.8497, -4.2055);
	public final LatLng CATHKIN_BRAES = new LatLng(55.79434, -4.2193);
	public final LatLng INTERNATIONAL_HOCKEY = new LatLng(55.8447, -4.236);
	public final LatLng HAMPDEN = new LatLng(55.8255, -4.2520);
	public final LatLng IBROX = new LatLng(55.853, -4.309);
	public final LatLng KELVINGROVE_BOWLS = new LatLng(55.867, -4.2871);
	public final LatLng SCOTSTOUN = new LatLng(55.8813, -4.3405);
	public final LatLng STRATHCLYDE = new LatLng(55.7971971, -4.0342997);
	//The lattitude and longitude for the previous venues
	public final LatLng EDINBURGH = new LatLng(55.939, -3.172);
	public final LatLng DEHLI = new LatLng(28.704, 77.102);
	public final LatLng MELBOURNE = new LatLng(-37.814107, 144.963280);
	public final LatLng MANCHESTER = new LatLng(-37.814107, 144.963280);
	public final LatLng KUALA_LUMPUR = new LatLng(3.139003, 101.686855);
	public final LatLng VICTORIA = new LatLng(48.428421, -123.365644);
	public final LatLng AUCKLAND = new LatLng(-36.848460, 174.763332);
	public final LatLng BRISBANE = new LatLng(-27.471011, 153.023449);
	public final LatLng EDMONTON = new LatLng(53.544389, -113.490927);

	//The markers that will be created 
	Marker glasgow, secc, barry_buddon_shooting, parkhead,cathkin_braes, international_hockey, hampden, ibrox, kelvingrove_bowls, scotstoun, strathclyde;
	Marker dehli, melbourne, manchester, edinburgh, auckland, kuala_lumpur, victoria, edminton, brisbane;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Gets the map fragment from the main_activity.xml
		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		
		
		//Checks to see if a marker has been pressed
		 mMap.setOnMarkerClickListener((OnMarkerClickListener) this);
		 
		 //Adds a marker to the screen, references the lat/lng of a venue and draws an icon from the res folder
		glasgow = mMap.addMarker(new MarkerOptions().position(GLASGOW).icon(BitmapDescriptorFactory.fromResource(R.drawable.app_logo)));
		
		 secc = mMap.addMarker(new MarkerOptions().position(SECC).icon(BitmapDescriptorFactory.fromResource(R.drawable.wrestling)));

		barry_buddon_shooting = mMap
				.addMarker(new MarkerOptions().position(BARRY_BUDDON_SHOOTING).icon(BitmapDescriptorFactory.fromResource(R.drawable.shooting)));

		parkhead = mMap.addMarker(new MarkerOptions().position(PARKHEAD));

		cathkin_braes = mMap.addMarker(new MarkerOptions().position(
				CATHKIN_BRAES).icon(BitmapDescriptorFactory.fromResource(R.drawable.cycling)));

		international_hockey = mMap.addMarker(new MarkerOptions()
				.position(INTERNATIONAL_HOCKEY).icon(BitmapDescriptorFactory.fromResource(R.drawable.hockey)));

		hampden = mMap.addMarker(new MarkerOptions().position(HAMPDEN).icon(BitmapDescriptorFactory.fromResource(R.drawable.athletics)));

		ibrox = mMap.addMarker(new MarkerOptions().position(IBROX).icon(BitmapDescriptorFactory.fromResource(R.drawable.rugby)));

		kelvingrove_bowls = mMap.addMarker(new MarkerOptions().position(
				KELVINGROVE_BOWLS).icon(BitmapDescriptorFactory.fromResource(R.drawable.lawn_bowls)));

		scotstoun = mMap.addMarker(new MarkerOptions().position(
				SCOTSTOUN).icon(BitmapDescriptorFactory.fromResource(R.drawable.table_tennis)));

		strathclyde = mMap.addMarker(new MarkerOptions().position(
				STRATHCLYDE).icon(BitmapDescriptorFactory.fromResource(R.drawable.triathalon)));

		edinburgh = mMap.addMarker(new MarkerOptions().position(
				EDINBURGH));

		dehli = mMap.addMarker(new MarkerOptions().position(DEHLI));

		melbourne = mMap.addMarker(new MarkerOptions().position(
				MELBOURNE));

		manchester = mMap.addMarker(new MarkerOptions().position(
				MANCHESTER));

		kuala_lumpur = mMap.addMarker(new MarkerOptions().position(
				KUALA_LUMPUR));

		victoria = mMap.addMarker(new MarkerOptions().position(VICTORIA));

		auckland = mMap.addMarker(new MarkerOptions().position(AUCKLAND));

		brisbane = mMap.addMarker(new MarkerOptions().position(BRISBANE));

		edminton = mMap.addMarker(new MarkerOptions().position(EDMONTON));

	}

	//Creates the options menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_items, menu);
		return true;
	}

	//Checks the options from the options menu that are available in the menu_items.xml
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.item1:
			changeMapView(); //when option 1 is selected it uses the changeMapView method
			break;
		case R.id.item2:
			onVenueSelect(); //When option 2 is selected it uses the onVenueSelect method
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
		return false;
	}
    
    public void onVenueSelect()
	  {
			String [] previousVenues = getResources().getStringArray(R.array.games_array); //Brings in the information from the games.xml file which hold the previous venues name and year
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);//Creates an alert dialog box
			builder.setTitle("Choose a previous venue");//Sets the title of the alert dialog
			builder.setItems(previousVenues, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int pos) {
					// TODO Auto-generated method stub
					switch (pos) {
					case 0://checks the position in the array
						mMap.moveCamera(CameraUpdateFactory.newLatLng(GLASGOW));//When tapped in the alert dialog the screen moves to the selected venue
						break;
					case 1:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(DEHLI));
						break;
					case 2:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(MELBOURNE));
						break;
					case 3:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(MANCHESTER));
						break;
					case 4:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(KUALA_LUMPUR));
						break;
					case 5:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(VICTORIA));
						break;
					case 6:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(AUCKLAND));
						break;
					case 7:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(EDINBURGH));
						break;
					case 8:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(BRISBANE));
						break;
					case 9:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(EDMONTON));
						break;
					default:
						mMap.moveCamera(CameraUpdateFactory.newLatLng(GLASGOW));
						break;
					}
				}
			});
			builder.show();
			}
    
    public void changeMapView()
    {
    	String [] mapView = getResources().getStringArray(R.array.mapViews_array);//brings in the values from the mapview.xml
		AlertDialog.Builder builder2 = new AlertDialog.Builder(this);//creates an alert dialog 
		builder2.setTitle("Change map type");//sets the title 
		builder2.setItems(mapView, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog2, int pos2) {
				// TODO Auto-generated method stub
				switch (pos2) {
				case 0://checks the position in the array
					mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);//changes the map type depending on which option is selected
					break;
				case 1:
					mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
					break;
				case 2: 
					mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
					break;
					default:
						mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);//sets the default to normal 
						break;
					}
				}
			});
			builder2.show();
    }
    
    @SuppressWarnings("deprecation")
	public boolean onMarkerClick ( Marker marker)
    {
    	//this is created if the user taps on a marker an alert dialog box pops up with venue info 
    	AlertDialog ad = new AlertDialog.Builder(this).create(); 
    	ad.setCancelable(true);//allows the user to close the dialog box
    	if(marker.equals(glasgow))//checks to see which marker is selected
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GLASGOW, 13));//moves the camera so that the venue is centred 
    		ad.setTitle("Glasgow");//sets the dialog box's title
    		ad.setMessage("Host of the 2014 Commonwealth Games");  //inserts the message which includes sport that the venue hosts and address 
    	}

       	if(marker.equals(barry_buddon_shooting))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BARRY_BUDDON_SHOOTING, 13));
    		ad.setTitle("Barry Buddon Shooting Centre");
    		ad.setMessage("Sport - Shooting \n\n" +
    				"Address - Carnoustie DD7 7RY");  
    	}
    	if(marker.equals(cathkin_braes))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CATHKIN_BRAES, 13));
    		ad.setTitle("Cathkin Braes Mountain Bike Trails");
    		ad.setMessage("Sport - Mountain Biking \n\n" +
    				"Address - Cathkin Road G45");  
    	}
    	if(marker.equals(parkhead))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PARKHEAD, 13));
    		ad.setTitle("Parkhead");
    		ad.setMessage("Venue for the Opening Ceremony \n\n" +
    				"Address - Glasgow G40 3RE");  
    	}
    	if(marker.equals(international_hockey))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(INTERNATIONAL_HOCKEY, 13));
    		ad.setTitle("National Hockey Centre");
    		ad.setMessage("Sport - Hockey \n\n" +
    				"Address - Glasgow Green G40 1HB");  
    	}
    	if(marker.equals(hampden))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMPDEN, 13));
    		ad.setTitle("Hampden Park");
    		ad.setMessage("Sport - Athletics \n\n" +
    				"Address - Letherby Drive G42 9BA");  
    	}
    	if(marker.equals(ibrox))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(IBROX, 13));
    		ad.setTitle("Ibrox Stadium");
    		ad.setMessage("Sport - Rugby \n\n" +
    				"Address - 130 Edmiston Drive G51 2XD");  
    	}
    	if(marker.equals(kelvingrove_bowls))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KELVINGROVE_BOWLS, 13));
    		ad.setTitle("Kelvingrove Lawn Bowls Centre");
    		ad.setMessage("Sport - Bowls \n\n" +
    				"Address - Kelvin Way G3 7TA");  
    	}
    	if(marker.equals(secc))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SECC, 13));
    		ad.setTitle("SECC Precinct");
    		ad.setMessage("Sports - Boxing, Gymnastics, Judo, Netball, Wrestling & Weightlifting \n\n" +
    				"Address - Exhibition Way G3 8YW");  
    	}
    	if(marker.equals(scotstoun))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SCOTSTOUN, 13));
    		ad.setTitle("Scotstoun Sports Campus");
    		ad.setMessage("Sports - Squash & Table Tennis \n\n" +
    				"Address - 72 Danes Drive G14 9HD");  
    	}
    	if(marker.equals(strathclyde))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(STRATHCLYDE, 13));
    		ad.setTitle("Strathclyde Country Park");
    		ad.setMessage("Sport - Triathalon \n\n" +
    				"Address - Hamilton Road ML1 3ED");  
    	}
    	//alert dialogs for the previous venues 
    	if(marker.equals(dehli))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DEHLI, 13));
    		ad.setTitle("Delhi (2010)");
    		ad.setMessage("Scotland won 9 gold, 10 silver and 7 bronze");  //shows how many medals Scotland won that year
    	}
    	if(marker.equals(melbourne))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MELBOURNE, 13));
    		ad.setTitle("Melbourne (2006)");
    		ad.setMessage("Scotland won 11 gold, 7 silver and 11 bronze");  
    	}
    	if(marker.equals(manchester))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MANCHESTER, 13));
    		ad.setTitle("Manchester (2002)");
    		ad.setMessage("Scotland won 6 gold, 8 silver and 15 bronze");  
    	}
    	if(marker.equals(kuala_lumpur))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KUALA_LUMPUR, 13));
    		ad.setTitle("Kuala Lumpur (1998)");
    		ad.setMessage("Scotland won 3 gold, 2 silver and 7 bronze");  
    	}
    	if(marker.equals(victoria))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(VICTORIA, 13));
    		ad.setTitle("Victoria (1994)");
    		ad.setMessage("Scotland won 6 gold, 3 silver and 11 bronze");  
    	}
    	if(marker.equals(auckland))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AUCKLAND, 13));
    		ad.setTitle("Auckland (1990)");
    		ad.setMessage("Scotland won 5 gold, 7 silver, 10 bronze");  
    	}
    	if(marker.equals(edinburgh))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(EDINBURGH, 13));
    		ad.setTitle("Edinburgh (1986)");
    		ad.setMessage("Scotland won 3 gold, 12 silver and 18 bronze");  
    	}
    	if(marker.equals(brisbane))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BRISBANE, 13));
    		ad.setTitle("Brisbane (1982)");
    		ad.setMessage("Scotland won 8 gold, 6 silver and 12 bronze");  
    	}
    	if(marker.equals(edminton))
    	{
    		mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(EDMONTON, 13));
    		ad.setTitle("Edminton (1978)");
    		ad.setMessage("Scotland won 3 gold, 6 silver, 5 bronze");  
    	}
    	ad.setButton("Close", new DialogInterface.OnClickListener()
    	{  
		    @Override  
		    public void onClick(DialogInterface dialog, int which) 
		    {  
		        dialog.dismiss(); 
		        //allows the user to close the dialog box
		    }  
		    
		});  
		ad.show();  
		return true;
    }
}
