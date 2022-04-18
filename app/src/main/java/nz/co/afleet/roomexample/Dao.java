package nz.co.afleet.roomexample;

import androidx.room.Insert;

@androidx.room.Dao
public interface Dao {
    @Insert
    public void addCustomer(Customer cust);
}
