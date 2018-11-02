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
    private static String KEY_CITY = "u_city";
    private static String KEY_SUBURB = "u_suburb";
    private static String KEY_PROVINCE = "u_province";

    //PLANTS
    private static String TABLE_PLANTS = "plants";
    private static String KEY_P_ID = "p_id";
    private static String KEY_P_NAME = "p_name";
    private static String KEY_P_PREF_MONTH = "p_preferable_months_of_season";
    private static String KEY_P_MIN_H2O = "p_h2o_min_req";
    private static String KEY_P_MAX_H2O = "p_h2o_max_req";
    private static String KEY_P_H2O_W_SEED = "p_weekly_h2o_seed";
    private static String KEY_P_H2O_W_CROP = "p_weekly_h2o_crop";
    private static String KEY_P_MIN_ETA_SPROUT = "p_eta_sprout_min";
    private static String KEY_P_MAX_ETA_SPROUT = "p_eta_sprout_max";
    private static String KEY_P_MIN_ETH = "p_eth_min";
    private static String KEY_P_MAX_ETH = "p_eth_max";

    //CROPS
    private static String TABLE_CROPS = "crops";
    private static String KEY_C_ID = "c_id";
    private static String KEY_C_NAME = "c_name";
    private static String KEY_C_EXPECTED_WEEKLY_RAIN = "c_expected_weekly_rain";
    private static String KEY_C_WEEKLY_H2O_TOP_UP = "c_weekly_h2o_top_up_req";
    private static String KEY_C_PLANTED_DATE = "c_planted_date";
    private static String KEY_C_DAYS_OLD = "c_days_old";

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
                + KEY_SURNAME + " TEXT," + KEY_EMAIL  + " TEXT UNIQUE," + KEY_PASSWORD + " TEXT,"
                + KEY_CITY + " TEXT," + KEY_SUBURB  + " TEXT," + KEY_PROVINCE + " TEXT"
                +")";
        db.execSQL(CREATE_USER_TABLE);

        //Create Plants Table
        String CREATE_PLANTS_TABLE = "CREATE TABLE " + TABLE_PLANTS + "("
                + KEY_P_ID + " INTEGER PRIMARY KEY,"+ KEY_P_NAME + " TEXT UNIQUE,"
                + KEY_P_PREF_MONTH + " TEXT," + KEY_P_MIN_H2O + " INTEGER," + KEY_P_MAX_H2O + " INTEGER,"
                + KEY_P_H2O_W_SEED + " INTEGER," + KEY_P_H2O_W_CROP + " INTEGER," +KEY_P_MIN_ETA_SPROUT + " INTEGER,"
                + KEY_P_MAX_ETA_SPROUT + " INTEGER," + KEY_P_MIN_ETH + " INTEGER," +KEY_P_MAX_ETH + " INTEGER"
                +")";
        db.execSQL(CREATE_PLANTS_TABLE);

        //Create RecyclerCrops Table
        String CREATE_CROPS_TABLE = "CREATE TABLE " + TABLE_CROPS + "("
                + KEY_C_ID + " INTEGER PRIMARY KEY,"+ KEY_C_NAME + " TEXT,"
                + KEY_C_EXPECTED_WEEKLY_RAIN + " INTEGER," + KEY_C_WEEKLY_H2O_TOP_UP + " INTEGER,"
                + KEY_C_PLANTED_DATE + " TEXT," + KEY_C_DAYS_OLD + " INTEGER"
                +")";
        db.execSQL(CREATE_CROPS_TABLE);

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

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLANTS);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CROPS);
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
        values.put(KEY_CITY, user.getU_city());
        values.put(KEY_SUBURB, user.getU_suburb());
        values.put(KEY_PROVINCE, user.getU_province());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    //Get User by user ID method
    public User getUser(int u_id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor u_cursor = db.query(TABLE_USER, new String[] {KEY_ID, KEY_NAME, KEY_SURNAME, KEY_EMAIL, KEY_PASSWORD, KEY_CITY, KEY_SUBURB, KEY_PROVINCE},
                KEY_ID + "=?", new String[]{String.valueOf(u_id)}, null, null, null, null);

        if (u_cursor != null)
        {
            u_cursor.moveToFirst();
        }

        User user = new User(Integer.parseInt(u_cursor.getString(0)), u_cursor.getString(1),
                u_cursor.getString(2), u_cursor.getString(3), u_cursor.getString(4),
                u_cursor.getString(5), u_cursor.getString(6), u_cursor.getString(7));

        return user;
    }

    //Get User by Email method
    public User getUserByEmail(String u_email) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor u_cursor = db.query(TABLE_USER, new String[] {KEY_ID, KEY_NAME, KEY_SURNAME, KEY_EMAIL, KEY_PASSWORD, KEY_CITY, KEY_SUBURB, KEY_PROVINCE},
                KEY_EMAIL + "=?", new String[]{u_email}, null, null, null, "1");

        if (u_cursor != null)
        {
            u_cursor.moveToFirst();
        }

        User user = new User(Integer.parseInt(u_cursor.getString(0)), u_cursor.getString(1),
                u_cursor.getString(2), u_cursor.getString(3), u_cursor.getString(4),
                u_cursor.getString(5), u_cursor.getString(6), u_cursor.getString(7));
        u_cursor.close();
        db.close();
        return user;
    }

    //Check if email exists
    public Boolean checkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(true, TABLE_USER,
                new String[]{KEY_EMAIL} , KEY_EMAIL + "= ?"  , new String[]{email}, null, null, null, "1");
        return cursor.getCount() > 0;
    }

    //Login method
    public Boolean queryUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(true,TABLE_USER, new String[]{KEY_EMAIL, KEY_PASSWORD},
                KEY_EMAIL + "= ? and " + KEY_PASSWORD + "= ?", new String[]{email, password}, null, null, null, "1");
        return cursor.getCount() > 0;

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
                user.setU_city(u_cursor.getString(5));
                user.setU_suburb(u_cursor.getString(6));
                user.setU_province(u_cursor.getString(7));

                userList.add(user);
            } while (u_cursor.moveToNext());
        }

        return userList;
    }

    //Get all RecyclerPlants method
    public void deleteAllUsers() {
        SQLiteDatabase u_db = this.getWritableDatabase();
        List<User> userList = new ArrayList<>();
        userList = getAllUsers();

        for (User u : userList) {
            int id = u.getU_id();
            u_db.delete(TABLE_USER, KEY_ID + "=?", new String[]{String.valueOf(id)});
        }
        u_db.close();
    }

    //Update User by id method
    public int updateUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, user.getU_name());
        values.put(KEY_SURNAME, user.getU_surname());
        values.put(KEY_EMAIL, user.getU_email());
        values.put(KEY_PASSWORD, user.getU_password());
        values.put(KEY_CITY, user.getU_city());
        values.put(KEY_SUBURB, user.getU_suburb());
        values.put(KEY_PROVINCE, user.getU_province());

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

    //Add RecyclerPlants Method
    public void addPlant(Plants plants) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_P_NAME, plants.getP_name());
        values.put(KEY_P_PREF_MONTH, plants.getP_PrefMonth());
        values.put(KEY_P_MIN_H2O, plants.getP_minH2oReq());
        values.put(KEY_P_MAX_H2O, plants.getP_maxH2oReq());
        values.put(KEY_P_H2O_W_SEED, plants.getP_weeklyH2oSeed());
        values.put(KEY_P_H2O_W_CROP, plants.getP_weeklyH2oCrop());
        values.put(KEY_P_MIN_ETA_SPROUT, plants.getP_etaSproutMin());
        values.put(KEY_P_MAX_ETA_SPROUT, plants.getP_etaSproutMax());
        values.put(KEY_P_MIN_ETH, plants.getP_ethMin());
        values.put(KEY_P_MAX_ETH, plants.getP_ethMax());

        db.insert(TABLE_PLANTS, null, values);
        db.close();
    }

    //Get SeedInformation by seed ID method
    public Plants getPlant(int p_id) {

        SQLiteDatabase p_db = this.getReadableDatabase();

        Cursor p_cursor = p_db.query(TABLE_PLANTS, new String[] {KEY_P_ID, KEY_P_NAME, KEY_P_PREF_MONTH, KEY_P_MIN_H2O, KEY_P_MAX_H2O, KEY_P_H2O_W_SEED, KEY_P_H2O_W_CROP, KEY_P_MIN_ETA_SPROUT, KEY_P_MAX_ETA_SPROUT, KEY_P_MIN_ETH, KEY_P_MAX_ETH},
                KEY_P_ID + "=?", new String[]{String.valueOf(p_id)}, null, null, null, null);

        if (p_cursor != null)
        {
            p_cursor.moveToFirst();
        }

        Plants plants = new Plants(Integer.parseInt(p_cursor.getString(0)), p_cursor.getString(1), p_cursor.getString(2),
                Integer.parseInt(p_cursor.getString(3)), Integer.parseInt(p_cursor.getString(4)), Integer.parseInt(p_cursor.getString(5)), Integer.parseInt(p_cursor.getString(6)),
                Integer.parseInt(p_cursor.getString(7)), Integer.parseInt(p_cursor.getString(8)), Integer.parseInt(p_cursor.getString(9)), Integer.parseInt(p_cursor.getString(10)));

        return plants;
    }

    //Get all RecyclerPlants method
    public List<Plants> getAllPlants() {
        List<Plants> plantsList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_PLANTS;

        SQLiteDatabase p_db = this.getWritableDatabase();
        Cursor p_cursor = p_db.rawQuery(selectQuery, null);

        if(p_cursor.moveToFirst())
        {
            do
            {
                Plants plants = new Plants();
                plants.setP_id(Integer.parseInt(p_cursor.getString(0)));
                plants.setP_name(p_cursor.getString(1));
                plants.setP_PrefMonth(p_cursor.getString(2));
                plants.setP_minH2oReq(Integer.parseInt(p_cursor.getString(3)));
                plants.setP_maxH2oReq(Integer.parseInt(p_cursor.getString(4)));
                plants.setP_weeklyH2oSeed(Integer.parseInt(p_cursor.getString(5)));
                plants.setP_weeklyH2oCrop(Integer.parseInt(p_cursor.getString(6)));
                plants.setP_etaSproutMin(Integer.parseInt(p_cursor.getString(7)));
                plants.setP_etaSproutMax(Integer.parseInt(p_cursor.getString(8)));
                plants.setP_ethMin(Integer.parseInt(p_cursor.getString(9)));
                plants.setP_ethMax(Integer.parseInt(p_cursor.getString(10)));

                plantsList.add(plants);
            } while (p_cursor.moveToNext());
        }

        return plantsList;
    }

    //Delete all plants method
    public void deleteAllPlants() {
        SQLiteDatabase p_db = this.getWritableDatabase();
        List<Plants> plantsList = new ArrayList<>();
        plantsList = getAllPlants();

        for (Plants p : plantsList) {
            int id = p.getP_id();
            p_db.delete(TABLE_PLANTS, KEY_P_ID + "=?", new String[]{String.valueOf(id)});
        }
        p_db.close();
    }


    //Update RecyclerPlants by id method
    public int updatePlant(Plants plants) {
        SQLiteDatabase p_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_P_NAME, plants.getP_name());
        values.put(KEY_P_PREF_MONTH, plants.getP_PrefMonth());
        values.put(KEY_P_MIN_H2O, plants.getP_minH2oReq());
        values.put(KEY_P_MAX_H2O, plants.getP_maxH2oReq());
        values.put(KEY_P_H2O_W_SEED, plants.getP_weeklyH2oSeed());
        values.put(KEY_P_H2O_W_CROP, plants.getP_weeklyH2oCrop());
        values.put(KEY_P_MIN_ETA_SPROUT, plants.getP_etaSproutMin());
        values.put(KEY_P_MAX_ETA_SPROUT, plants.getP_etaSproutMax());
        values.put(KEY_P_MIN_ETH, plants.getP_ethMin());
        values.put(KEY_P_MAX_ETH, plants.getP_ethMax());
        return p_db.update(TABLE_PLANTS, values, KEY_P_ID + "=?",
                new String[]{String.valueOf(plants.getP_id())});
    }

    //Delete Plant by id method
    public void deletePlant(Plants plants) {
        SQLiteDatabase p_db = this.getWritableDatabase();
        p_db.delete(TABLE_PLANTS, KEY_P_ID + "=?",
                new String[] {String.valueOf(plants.getP_id())});
        p_db.close();
    }

    //Plant Count method
    public int getPlantCount() {
        String countQuery = "SELECT * FROM " + TABLE_PLANTS;
        SQLiteDatabase p_db = this.getReadableDatabase();
        Cursor p_cursor = p_db.rawQuery(countQuery, null);
        p_cursor.close();

        return p_cursor.getCount();
    }

    //Add RecyclerCrops Method
    public void addCrop(Crops crops) {
        SQLiteDatabase c_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_C_NAME, crops.getC_name());
        values.put(KEY_C_EXPECTED_WEEKLY_RAIN, crops.getC_ExpectedWeeklyRain());
        values.put(KEY_C_WEEKLY_H2O_TOP_UP, crops.getC_weeklyH2oTopUpReq());
        values.put(KEY_C_PLANTED_DATE, crops.getC_plantDate());
        values.put(KEY_C_DAYS_OLD, crops.getC_daysOld());

        c_db.insert(TABLE_CROPS, null, values);
        c_db.close();
    }

    //Get RecyclerCrops by seed ID method
    public Crops getCrop(int c_id) {
        SQLiteDatabase c_db = this.getReadableDatabase();

        Cursor c_cursor = c_db.query(TABLE_CROPS, new String[] {KEY_C_ID, KEY_C_NAME, KEY_C_EXPECTED_WEEKLY_RAIN, KEY_C_WEEKLY_H2O_TOP_UP, KEY_C_PLANTED_DATE, KEY_C_DAYS_OLD},
                KEY_C_ID + "=?", new String[]{String.valueOf(c_db)}, null, null, null, null);

        if (c_cursor != null)
        {
            c_cursor.moveToFirst();
        }

        Crops crops = new Crops(Integer.parseInt(c_cursor.getString(0)), c_cursor.getString(1), Integer.parseInt(c_cursor.getString(2)),
                Integer.parseInt(c_cursor.getString(3)),  c_cursor.getString(4), Integer.parseInt(c_cursor.getString(5)));

        return crops;
    }

    //Get all RecyclerCrops method
    public List<Crops> getAllCrops() {
        List<Crops> cropsList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_CROPS;

        SQLiteDatabase c_db = this.getWritableDatabase();
        Cursor c_cursor = c_db.rawQuery(selectQuery, null);

        if(c_cursor.moveToFirst())
        {
            do
            {
                Crops crops = new Crops();
                crops.setC_id(Integer.parseInt(c_cursor.getString(0)));
                crops.setC_name(c_cursor.getString(1));
                crops.setC_ExpectedWeeklyRain(Integer.parseInt(c_cursor.getString(2)));
                crops.setC_weeklyH2oTopUpReq(Integer.parseInt(c_cursor.getString(3)));
                crops.setC_plantDate(c_cursor.getString(4));
                crops.setC_daysOld(Integer.parseInt(c_cursor.getString(5)));

                cropsList.add(crops);
            } while (c_cursor.moveToNext());
        }

        return cropsList;
    }


    //delete all crops method
    public void deleteAllCrops() {
        SQLiteDatabase c_db = this.getWritableDatabase();
        List<Crops> cropsList = new ArrayList<>();
        cropsList = getAllCrops();

        for (Crops c : cropsList) {
            int id = c.getC_id();
            c_db.delete(TABLE_CROPS, KEY_C_ID + "=?", new String[]{String.valueOf(id)});
        }
        c_db.close();
    }

    //Update RecyclerCrops by id method
    public int updateCrops(Crops crops) {
        SQLiteDatabase c_db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_C_NAME, crops.getC_name());
        values.put(KEY_C_EXPECTED_WEEKLY_RAIN, crops.getC_ExpectedWeeklyRain());
        values.put(KEY_C_WEEKLY_H2O_TOP_UP, crops.getC_weeklyH2oTopUpReq());
        values.put(KEY_C_PLANTED_DATE, crops.getC_plantDate());
        values.put(KEY_C_DAYS_OLD, crops.getC_daysOld());
        return c_db.update(TABLE_CROPS, values, KEY_C_ID + "=?",
                new String[]{String.valueOf(crops.getC_id())});
    }

    //Delete RecyclerCrops by id method
    public void deleteCrops(Crops crops) {
        SQLiteDatabase c_db = this.getWritableDatabase();
        c_db.delete(TABLE_CROPS, KEY_C_ID + "=?",
                new String[] {String.valueOf(crops.getC_id())});
        c_db.close();
    }

    //RecyclerCrops Count method
    public int getCropsCount() {
        String countQuery = "SELECT * FROM " + TABLE_CROPS;
        SQLiteDatabase c_db = this.getReadableDatabase();
        Cursor c_cursor = c_db.rawQuery(countQuery, null);
        c_cursor.close();

        return c_cursor.getCount();
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

    //delete all crops method
    public void deleteAllWeatherEntries() {
        SQLiteDatabase w_db = this.getWritableDatabase();
        List<Weather> weatherList = new ArrayList<>();
        weatherList = getAllWeatherEntries();

        for (Weather w : weatherList) {
            int id = w.getW_id();
            w_db.delete(TABLE_WEATHER, KEY_W_ID + "=?", new String[]{String.valueOf(id)});
        }
        w_db.close();
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

