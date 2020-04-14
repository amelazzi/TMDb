package com.example.iwatch.Activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.iwatch.Dialogs.ChangePassword
import com.example.iwatch.Entities.User
import com.example.iwatch.R
import kotlinx.android.synthetic.main.activity_edit_profile.*

import org.json.JSONArray
import java.net.URL


class EditProfile : AppCompatActivity(), ChangePassword.ChangePasswordDialogListener{

    private var user: User?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        edit_profile_toolbar.title = "Edit Profile"
        setSupportActionBar(edit_profile_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //get user information
        user = intent.getSerializableExtra("user") as User

        edit_first_name.setText(user?.firstName)
        edit_last_name.setText(user?.lastName)
        edit_email.setText(user?.email)
        edit_phone_number.setText(user?.mobile)
        edit_address.setText(user?.adresse)

        change_pwd.setOnClickListener {
            openDialog()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.profile_settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        else if(item.itemId == R.id.menu_save_profile){
            //faire ici les modifications pour sauvegarder les changements
        }
        return super.onOptionsItemSelected(item)
    }

    fun openDialog() {
        val exampleDialog = ChangePassword()
        exampleDialog.show(supportFragmentManager, "example dialog")
    }

    override fun applyTexts(oldPassword: String?, newPassword: String?, confirmPassword: String?) {
        if (newPassword==confirmPassword){


            Post("http://scirusiwatch.herokuapp.com/changepass/" + user?.id + "/" + confirmPassword)

            Toast.makeText(
                applicationContext,
                "mot de passe a été bien changé",
                Toast.LENGTH_SHORT
            ).show()
        }
        else{
            Toast.makeText(
                applicationContext,
                "confirm password is not correct!!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun Post(url: String): JSONArray {

        val x = try {
            URL(url)
                .openStream()
                .bufferedReader()
                .use { it.readText() }
        } catch (e: Exception) {
            System.out.println(e)
        }
        try {
            if (!x.toString().isNullOrEmpty() && x.toString() != "null" && x.toString() != "[]") {
                return JSONArray(x.toString())

            }
            return JSONArray()
        }catch(e: Exception){
            System.out.println(e)
            return JSONArray()
        }
    }

}