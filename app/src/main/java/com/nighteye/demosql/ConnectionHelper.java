package com.nighteye.demosql;

import android.annotation.SuppressLint;
import android.database.SQLException;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

class ConnectionHelper {

    @SuppressLint("NewApi")
    Connection connectionClass()
    {
        String server = "<your server name/IP address>";
        String database = "<name of database>";
        String user = "<username for sql server login>";
        String password = "<passwod for sql server login>";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            ConnectionURL = "jdbc:jtds:sqlserver://" + server + "/" + database + ";user=" + user+ ";password=" + password + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", Objects.requireNonNull(se.getMessage()));
        }
        catch (ClassNotFoundException ce)
        {
            Log.e("error here 2 : ", Objects.requireNonNull(ce.getMessage()));
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", Objects.requireNonNull(e.getMessage()));
        }
        return connection;
    }
}
