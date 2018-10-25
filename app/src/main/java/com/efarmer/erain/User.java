package com.efarmer.erain;

public class User
{
    //Declare Variables
    int u_id;
    String u_name;
    String u_surname;
    String u_email;
    String u_password;

    //Constructor
    public User()
    {

    }

    public User(String u_name, String u_surname, String u_email, String u_password)
    {
        this.u_name = u_name;
        this.u_surname = u_surname;
        this.u_email = u_email;
        this.u_password = u_password;
    }

    public User(int u_id, String u_name, String u_surname, String u_email, String u_password)
    {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_surname = u_surname;
        this.u_email = u_email;
        this.u_password = u_password;
    }

    //ID get-set-method
    public int getU_id()
    {
        return u_id;
    }

    public void setU_id(int u_id)
    {
        this.u_id = u_id;
    }

    //name get-set-method
    public String getU_name()
    {
        return u_name;
    }

    public void setU_name(String u_name)
    {
        this.u_name = u_name;
    }

    //surname get-set-method
    public String getU_surname()
    {
        return u_surname;
    }

    public void setU_surname(String u_surname)
    {
        this.u_surname = u_surname;
    }

    //email get-set-method
    public String getU_email()
    {
        return u_email;
    }

    public void setU_email(String u_emai1)
    {
        this.u_email = u_emai1;
    }

    //password get-set-method
    public String getU_password()
    {
        return u_password;
    }

    public void setU_password(String u_password)
    {
        this.u_password = u_password;
    }
}
