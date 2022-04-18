package nz.co.afleet.roomexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "customerdb").allowMainThreadQueries().build();

        final EditText editName = findViewById(R.id.editName);
        final EditText editSurname = findViewById(R.id.editSurname);
        final EditText editEmail = findViewById(R.id.editEmail);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonRefresh = findViewById(R.id.buttonRefresh);
        TextView textOutput = findViewById(R.id.textOutput);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Obtain data from the interface
                String name = editName.getText().toString();
                String surname = editSurname.getText().toString();
                String email = editEmail.getText().toString();

                // Create new customer object
                Customer cust = new Customer();
                cust.setFirstName(name);
                cust.setSurname(surname);
                cust.setEmail(email);

                // Insert customer into database
                myDatabase.dao().addCustomer(cust);

                // Display a message
                Toast.makeText(getBaseContext(),"Customer added successfully!", Toast.LENGTH_SHORT).show();

                // Clear the text
                editName.setText("");
                editSurname.setText("");
                editEmail.setText("");
            }
        });

        buttonRefresh.setOnClickListener(view -> {

        });
    }
}