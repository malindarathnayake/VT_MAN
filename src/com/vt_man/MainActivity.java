package com.vt_man;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.IOException;

import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;
/**
 * @author Malinda
 *
 */

public class MainActivity extends Activity {
	protected static final String Vomerintd = "/system/etc/init.d/01VomerTweaks";
	protected static final String filesrc = "/system/etc/init.d/01VomerTweaks";
	protected static final String filedst = "/system/etc/init.d/01VomerTweaks";
	private ToggleButton button1;
	private Button UPbutton2;
	//private boolean suaccess;
	
	//private Button rbtbutton3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button1 = (ToggleButton) findViewById(R.id.toggleButton2);
		UPbutton2 =(Button) findViewById(R.id.UPbutton1);
		//suaccess=(boolean) Shell.SU.available()
		//rbtbutton3 =(Button) findViewById(R.id.rbbutton3);
		//Setting initial values
		File f = new File("/system/etc/init.d/01VomerTweaks");
		   if(f.exists())
		   { 
			   button1.setChecked(true);
		   }
		   else
		   {
			   button1.setChecked(false);
		   }
		   
			//Toggle button
		   button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			    @Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked) {
						Log.i("info", "VT initd added!");
		
				                Process p=null;
				                try {
				                    p = new ProcessBuilder()
				                    .command("/data/vomer/VT_COPY.sh")
				                    .start();
				                } catch (IOException e) {
				                    e.printStackTrace();
				                } finally {
				                    if(p!=null) p.destroy();
				                }
						

					} else {
						Log.i("info", "VT initd removed!");
						File file = new File(Vomerintd);
						if(file.exists())
						  file.delete();
					}
			    }
			});		   
		   
		   //VT Update button
		   
		   UPbutton2.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	                // Perform action on click
	            	Log.i("info", "VT Script Update");
	                Process p=null;
	                try {
	                    p = new ProcessBuilder()
	                    .command("/data/vomer/VT_update.sh")
	                    .start();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } finally {
	                    if(p!=null) p.destroy();
	                }
	            	
	            }
	        });  
		   
		   
		   //Reboot button

	}
		   
 }
