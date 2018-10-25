package com.efarmer.erain;
//Imports
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper
{
    //Declare DB Version & Name variables
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "E_Rain";

    //USER
    private static String TABLE_USER = "user";
    private static String KEY_ID = "u_id";
    private static String KEY_NAME = "u_name";
    private static String KEY_SURNAME = "u_surname";
    private static String KEY_EMAIL = "u_email";
    private static String KEY_PASSWORD = "u_password";

    //SEED
    private static String TABLE_SEED = "seed";
    private static String KEY_S_ID = "s_id";
    private static String KEY_S_NAME = "s_name";
    private static String KEY_S_PREF_MONTH = "s_preferable_months_of_season";
    private static String KEY_S_MIN_H2O = "s_h2o_min_req";
    private static String KEY_S_MAX_H2O = "s_h2o_max_req";
    private static String KEY_S_H2O_W_SEED = "s_weekly_h2o_seed";
    private static String KEY_S_H2O_W_CROP = "s_weekly_h2o_crop";
    private static String KEY_S_MIN_ETA_SPROUT = "s_eta_sprout_min";
    private static String KEY_S_MAX_ETA_SPROUT = "s_eta_sprout_max";
    private static String KEY_S_MIN_ETH = "s_eth_min";
    private static String KEY_S_MAX_ETH = "s_eth_max";

    //PLANTED
    private static String TABLE_PLANTED = "planted";
    private static String KEY_P_ID = "p_id";
    private static String KEY_P_NAME = "p_name";
    private static String KEY_P_EXPECTED_WEEKLY_RAIN = "p_expected_weekly_rain";
    private static String KEY_P_WEEKLY_H2O_TOP_UP = "p_weekly_h2o_top_up_req";
    private static String KEY_P_PLANTED_DATE = "p_planted_date";
    private static String KEY_P_DAYS_OLD = "p_days_old";

    //WEATHER
    private static String TABLE_WEATHER = "weather";
    private static String KEY_W_ID = "w_id";
    private static String KEY_W_WIND_SPEED = "w_wind_speed";
    private static String KEY_W_HUMIDITY = "w_humidity";
    private static String KEY_W_RAINFALL = "w_rainfall";
    private static String KEY_W_TEMPERATURE = "w_temperature";
    private static String KEY_W_DATE= "w_date";

    //DB Name & Version
    public DatabaseHelper(Context u_context)  {
        super(u_context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create User Table
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_NAME + " TEXT,"
                + KEY_SURNAME + " TEXT," + KEY_EMAIL  + " TEXT UNIQUE," + KEY_PASSWORD + " TEXT"
                +")";
        db.execSQL(CREATE_USER_TABLE);

        //Create Seed Table
        String CREATE_SEED_TABLE = "CREATE TABLE " + TABLE_SEED + "("
                + KEY_S_ID + " INTEGER PRIMARY KEY,"+ KEY_S_NAME + " TEXT UNIQUE,"
                + KEY_S_PREF_MONTH + " TEXT," + KEY_S_MIN_H2O + " INTEGER," + KEY_S_MAX_H2O + " INTEGER,"
                + KEY_S_H2O_W_SEED + " INTEGER," + KEY_S_H2O_W_CROP + " INTEGER," +KEY_S_MIN_ETA_SPROUT + " INTEGER,"
                + KEY_S_MAX_ETA_SPROUT + " INTEGER," + KEY_S_MIN_ETH + " INTEGER," +KEY_S_MAX_ETH + " INTEGER"
                +")";
        db.execSQL(CREATE_SEED_TABLE);

        //Create Planted Table
        String CREATE_PLANTED_TABLE = "CREATE TABLE " + TABLE_PLANTED + "("
                + KEY_P_ID + " INTEGER PRIMARY KEY,"+ KEY_P_NAME + " TEXT,"
                + KEY_P_EXPECTED_WEEKLY_RAIN + " INTEGER," + KEY_P_WEEKLY_H2O_TOP_UP + " INTEGER,"
                + KEY_P_PLANTED_DATE + " TEXT," + KEY_P_DAYS_OLD + " INTEGER"
                +")";
        db.execSQL(CREATE_PLANTED_TABLE);

        //Create Weather Table
        String CREATE_WEATHER_TABLE = "CREATE TABLE " + TABLE_WEATHER + "("
                + KEY_W_ID + " INTEGER PRIMARY KEY,"+ KEY_W_WIND_SPEED + " TEXT,"
                + KEY_W_HUMIDITY + " TEXT," + KEY_W_RAINFALL + " TEXT,"
                + KEY_W_TEMPERATURE + " TEXT"
                + KEY_W_DATE + "TEXT"
                +")";
        db.execSQL(CREATE_WEATHER_TABLE);
    }

    //Drop Table if exists in DB
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)  {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEED);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANTED);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEATHER);
        onCreate(db);

    }

    //Add User Method
    public void addUser(User user)  {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getU_name());
        values.put(KEY_SURNAME, user.getU_surname());
        values.put(KEY_EMAIL, user.getU_email());
        values.put(KEY_PASSWORD, user.getU_password());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    //Get User by user ID method
    public User getUser(int u_id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor u_cursor = db.query(TABLE_USER, new String[] {KEY_ID, KEY_NAME, KEY_SURNAME, KEY_EMAIL, KEY_PASSWORD},
                KEY_ID + "=?", new String[]{String.valueOf(u_id)}, null, null, null, null);

        if (u_cursor != null)
        {
            u_cursor.moveToFirst();
        }

        User user = new User(Integer.parseInt(u_cursor.getString(0)), u_cursor.getString(1),
                u_cursor.getString(2), u_cursor.getString(3), u_cursor.getString(4));

        return user;
    }

    //Get all Users method
    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_USER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor u_cursor = db.rawQuery(selectQuery, null);

        if(u_cursor.moveToFirst())
        {
            do
            {
                User user = new User();
                user.setU_id(Integer.parseInt(u_cursor.getString(0)));
                user.setU_name(u_cursor.getString(1));
                user.setU_surname(u_cursor.getString(2));
                user.setU_email(u_cursor.getString(3));
                user.setU_password(u_cursor.getString(4));

                userList.add(user);
            } while (u_cursor.moveToNext());
        }

        return userList;
    }

    //Update User by id method
    public int updateUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getU_name());
        values.put(KEY_SURNAME, user.getU_surname());
        values.put(KEY_EMAIL, user.getU_email());
        values.put(KEY_PASSWORD, user.getU_password());

        return db.update(TABLE_USER, values, KEY_ID + "=?",
                new String[]{String.valueOf(user.getU_id())});
    }

    //Delete User by id method
    public void deleteUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_ID + "=?",
                new String[] {String.valueOf(user.getU_id())});
        db.close();
    }

    //User Count method
    public int getUserCount() {

        String countQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor u_cursor = db.rawQuery(countQuery, null);
        u_cursor.close();

        return u_cursor.getCount();
    }

    //Add Seed Method
    public void addSeed(Seed seed) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_S_NAME, seed.getS_name());
        values.put(KEY_S_PREF_MONTH, seed.getS_PrefMonth());
        values.put(KEY_S_MIN_H2O, seed.getS_minH2oReq());
        values.put(KEY_S_MAX_H2O, seed.getS_maxH2oReq());
        values.put(KEY_S_H2O_W_SEED, seed.getS_weeklyH2oSeed());
        values.put(KEY_S_H2O_W_CROP, seed.getS_weeklyH2oCrop());
        values.put(KEY_S_MIN_ETA_SPROUT, seed.getS_etaSproutMin());
        values.put(KEY_S_MAX_ETA_SPROUT, seed.getS_etaSproutMax());
        values.put(KEY_S_MIN_ETH, seed.getS_ethMin());
        values.put(KEY_S_MAX_ETH, seed.getS_ethMax());

        db.insert(TABLE_SEED, null, values);
        db.close();
    }

    //Get Seed by seed ID method
    public Seed getSeed(int s_id) {

        SQLiteDatabase s_db = this.getReadableDatabase();

        Cursor s_cursor = s_db.query(TABLE_SEED, new String[] {KEY_S_ID, KEY_S_NAME, KEY_S_PREF_MONTH, KEY_S_MIN_H2O, KEY_S_MAX_H2O, KEY_S_H2O_W_SEED, KEY_S_H2O_W_CROP, KEY_S_MIN_ETA_SPROUT, KEY_S_MAX_ETA_SPROUT, KEY_S_MIN_ETH, KEY_S_MAX_ETH},
                KEY_S_ID + "=?", new String[]{String.valueOf(s_id)}, null, null, null, null);

        if (s_cursor != null)
        {
            s_cursor.moveToFirst();
        }

        Seed seed = new Seed(Integer.parseInt(s_cursor.getString(0)), s_cursor.getString(1), s_cursor.getString(2),
                Integer.parseInt(s_cursor.getString(3)), Integer.parseInt(s_cursor.getString(4)), Integer.parseInt(s_cursor.getString(5)), Integer.parseInt(s_cursor.getString(6)),
                Integer.parseInt(s_cursor.getString(7)), Integer.parseInt(s_cursor.getString(8)), Integer.parseInt(s_cursor.getString(9)), Integer.parseInt(s_cursor.getString(10)));

        return seed;
    }

    //Get all Seeds method
    public List<Seed> getAllSeeds() {
        List<Seed> seedList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_SEED;

        SQLiteDatabase s_db = this.getWritableDatabase();
        Cursor s_cursor = s_db.rawQuery(selectQuery, null);

        if(s_cursor.moveToFirst())
        {
            do
            {
                Seed seed = new Seed();
                seed.setS_id(Integer.parseInt(s_cursor.getString(0)));
                seed.setS_name(s_cursor.getString(1));
                seed.setS_PrefMonth(s_cursor.getString(2));
                seed.setS_minH2oReq(Integer.parseInt(s_cursor.getString(3)));
                seed.setS_maxH2oReq(Integer.parseInt(s_cursor.getString(4)));
                seed.setS_weeklyH2oSeed(Integer.parseInt(s_cursor.getString(5)));
                seed.setS_weeklyH2oCrop(Integer.parseInt(s_cursor.getString(6)));
                seed.setS_etaSproutMin(Integer.parseInt(s_cursor.getString(7)));
                seed.setS_etaSproutMax(Integer.parseInt(s_cursor.getString(8)));
                seed.setS_ethMin(Integer.parseInt(s_cursor.getString(9)));
                seed.setS_ethMax(Integer.parseInt(s_cursor.getString(10)));

                seedList.add(seed);
            } while (s_cursor.moveToNext());
        }

        return seedList;
    }

    //Update Seed by id method
    public int updateSeed(Seed seed) {
        SQLiteDatabase s_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_S_NAME, seed.getS_name());
        values.put(KEY_S_PREF_MONTH, seed.getS_PrefMonth());
        values.put(KEY_S_MIN_H2O, seed.getS_minH2oReq());
        values.put(KEY_S_MAX_H2O, seed.getS_maxH2oReq());
        values.put(KEY_S_H2O_W_SEED, seed.getS_weeklyH2oSeed());
        values.put(KEY_S_H2O_W_CROP, seed.getS_weeklyH2oCrop());
        values.put(KEY_S_MIN_ETA_SPROUT, seed.getS_etaSproutMin());
        values.put(KEY_S_MAX_ETA_SPROUT, seed.getS_etaSproutMax());
        values.put(KEY_S_MIN_ETH, seed.getS_ethMin());
        values.put(KEY_S_MAX_ETH, seed.getS_ethMax());
        return s_db.update(TABLE_SEED, values, KEY_S_ID + "=?",
                new String[]{String.valueOf(seed.getS_id())});
    }

    //Delete Seed by id method
    public void deleteSeed(Seed seed) {
        SQLiteDatabase s_db = this.getWritableDatabase();
        s_db.delete(TABLE_SEED, KEY_S_ID + "=?",
                new String[] {String.valueOf(seed.getS_id())});
        s_db.close();
    }

    //Seed Count method
    public int getSeedCount() {
        String countQuery = "SELECT * FROM " + TABLE_SEED;
        SQLiteDatabase s_db = this.getReadableDatabase();
        Cursor s_cursor = s_db.rawQuery(countQuery, null);
        s_cursor.close();

        return s_cursor.getCount();
    }

    //Add Planted Method
    public void addPlant(Planted planted) {
        SQLiteDatabase p_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_P_NAME, planted.getP_name());
        values.put(KEY_P_EXPECTED_WEEKLY_RAIN, planted.getP_ExpectedWeeklyRain());
        values.put(KEY_P_WEEKLY_H2O_TOP_UP, planted.getP_weeklyH2oTopUpReq());
        values.put(KEY_P_PLANTED_DATE, planted.getP_plantDate());
        values.put(KEY_P_DAYS_OLD, planted.getP_daysOld());

        p_db.insert(TABLE_PLANTED, null, values);
        p_db.close();
    }

    //Get Planted by seed ID method
    public Planted getPlanted(int p_id) {
        SQLiteDatabase p_db = this.getReadableDatabase();

        Cursor p_cursor = p_db.query(TABLE_PLANTED, new String[] {KEY_P_ID, KEY_P_NAME, KEY_P_EXPECTED_WEEKLY_RAIN, KEY_P_WEEKLY_H2O_TOP_UP, KEY_P_PLANTED_DATE, KEY_P_DAYS_OLD},
                KEY_P_ID + "=?", new String[]{String.valueOf(p_db)}, null, null, null, null);

        if (p_cursor != null)
        {
            p_cursor.moveToFirst();
        }

        Planted planted = new Planted(Integer.parseInt(p_cursor.getString(0)), p_cursor.getString(1), Integer.parseInt(p_cursor.getString(2)),
                Integer.parseInt(p_cursor.getString(3)),  p_cursor.getString(4), Integer.parseInt(p_cursor.getString(5)));

        return planted;
    }

    //Get all Planted method
    public List<Planted> getAllPlanted() {
        List<Planted> plantedList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_PLANTED;

        SQLiteDatabase p_db = this.getWritableDatabase();
        Cursor p_cursor = p_db.rawQuery(selectQuery, null);

        if(p_cursor.moveToFirst())
        {
            do
            {
                Planted planted = new Planted();
                planted.setP_id(Integer.parseInt(p_cursor.getString(0)));
                planted.setP_name(p_cursor.getString(1));
                planted.setP_ExpectedWeeklyRain(Integer.parseInt(p_cursor.getString(2)));
                planted.setP_weeklyH2oTopUpReq(Integer.parseInt(p_cursor.getString(3)));
                planted.setP_plantDate(p_cursor.getString(4));
                planted.setP_daysOld(Integer.parseInt(p_cursor.getString(5)));

                plantedList.add(planted);
            } while (p_cursor.moveToNext());
        }

        return plantedList;
    }

    //Update Planted by id method
    public int updatePlanted(Planted planted) {
        SQLiteDatabase p_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_P_NAME, planted.getP_name());
        values.put(KEY_P_EXPECTED_WEEKLY_RAIN, planted.getP_ExpectedWeeklyRain());
        values.put(KEY_P_WEEKLY_H2O_TOP_UP, planted.getP_weeklyH2oTopUpReq());
        values.put(KEY_P_PLANTED_DATE, planted.getP_plantDate());
        values.put(KEY_P_DAYS_OLD, planted.getP_daysOld());
        return p_db.update(TABLE_PLANTED, values, KEY_P_ID + "=?",
                new String[]{String.valueOf(planted.getP_id())});
    }

    //Delete Planted by id method
    public void deletePlanted(Planted planted) {
        SQLiteDatabase p_db = this.getWritableDatabase();
        p_db.delete(TABLE_PLANTED, KEY_P_ID + "=?",
                new String[] {String.valueOf(planted.getP_id())});
        p_db.close();
    }

    //Planted Count method
    public int getPlantedCount() {
        String countQuery = "SELECT * FROM " + TABLE_PLANTED;
        SQLiteDatabase p_db = this.getReadableDatabase();
        Cursor p_cursor = p_db.rawQuery(countQuery, null);
        p_cursor.close();

        return p_cursor.getCount();
    }

    //Add Weather Method
    public void addWeather(Weather weather) {
        SQLiteDatabase w_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_W_WIND_SPEED, weather.getW_windSpeed());
        values.put(KEY_W_HUMIDITY, weather.getW_humidity());
        values.put(KEY_W_RAINFALL, weather.getW_rainfall());
        values.put(KEY_W_TEMPERATURE, weather.getW_temperature());
        values.put(KEY_W_DATE, weather.getW_date());

        w_db.insert(TABLE_WEATHER, null, values);
        w_db.close();
    }

    //Get Weather by weather ID method
    public Weather getWeather(int w_id) {
        SQLiteDatabase w_db = this.getReadableDatabase();

        Cursor w_cursor = w_db.query(TABLE_WEATHER, new String[] {KEY_W_ID, KEY_W_WIND_SPEED, KEY_W_HUMIDITY, KEY_W_RAINFALL, KEY_W_TEMPERATURE, KEY_W_DATE},
                KEY_W_ID + "=?", new String[]{String.valueOf(w_id)}, null, null, null, null);

        if (w_cursor != null)
        {
            w_cursor.moveToFirst();
        }

        Weather weather = new Weather(Integer.parseInt(w_cursor.getString(0)), w_cursor.getString(1), w_cursor.getString(2), w_cursor.getString(3), w_cursor.getString(4), w_cursor.getString(5));

        return weather;
    }

    //Get all Weather method
    public List<Weather> getAllWeatherEntries() {
        List<Weather> weatherList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_WEATHER;

        SQLiteDatabase w_db = this.getWritableDatabase();
        Cursor w_cursor = w_db.rawQuery(selectQuery, null);

        if(w_cursor.moveToFirst())
        {
            do
            {
                Weather weather = new Weather();
                weather.setW_id(Integer.parseInt(w_cursor.getString(0)));
                weather.setW_windSpeed(w_cursor.getString(1));
                weather.setW_humidity(w_cursor.getString(2));
                weather.setW_rainfall(w_cursor.getString(3));
                weather.setW_temperature(w_cursor.getString(4));
                weather.setW_date(w_cursor.getString(5));

                weatherList.add(weather);
            } while (w_cursor.moveToNext());
        }

        return weatherList;
    }

    //Update Weather by id method
    public int updateWeather(Weather weather) {
        SQLiteDatabase w_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_W_WIND_SPEED, weather.getW_windSpeed());
        values.put(KEY_W_HUMIDITY, weather.getW_humidity());
        values.put(KEY_W_RAINFALL, weather.getW_rainfall());
        values.put(KEY_W_TEMPERATURE, weather.getW_temperature());
        values.put(KEY_W_DATE, weather.getW_date());

        return w_db.update(TABLE_WEATHER, values, KEY_W_ID + "=?",
                new String[]{String.valueOf(weather.getW_id())});
    }

    //Delete Weather by id method
    public void deleteWeather(Weather weather) {
        SQLiteDatabase w_db = this.getWritableDatabase();
        w_db.delete(TABLE_WEATHER, KEY_W_ID + "=?",
                new String[] {String.valueOf(weather.getW_id())});
        w_db.close();
    }

    //Weather Count method
    public int getWeatherCount() {
        String countQuery = "SELECT * FROM " + TABLE_WEATHER;
        SQLiteDatabase w_db = this.getReadableDatabase();
        Cursor w_cursor = w_db.rawQuery(countQuery, null);
        w_cursor.close();

        return w_cursor.getCount();
    }
}

