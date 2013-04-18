package cmu.circle.insider;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity {

	Button fetch, post;
	EditText nameInput, detailInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fetch = (Button) findViewById(R.id.get);
        post = (Button) findViewById(R.id.post);
        nameInput = (EditText) findViewById(R.id.name_input);
        detailInput = (EditText) findViewById(R.id.detail_input);
        fetch.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				new GetAllCircles(1).execute();
			}
		});
        
        post.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = nameInput.getText().toString();
				String detail = detailInput.getText().toString();
				new CreateNewCircle(name, detail).execute();
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    
}
