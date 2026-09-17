package com.darkkiller.app

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.widget.Toast
import org.json.JSONObject
import java.net.URL
import kotlin.concurrent.thread

class UpdateHelper(private val context: Context) {

    // TODO: Yahan aapko apne GitHub Repo ki update.json file ka raw link daalna hai
    private val updateJsonUrl = "https://raw.githubusercontent.com/YOUR_GITHUB_USERNAME/YOUR_REPO/main/update.json"
    private val currentVersion = "3.1" // Current DARKKILLER Version

    fun checkForUpdates() {
        thread {
            try {
                // Background me JSON fetch karna
                val response = URL(updateJsonUrl).readText()
                val jsonObject = JSONObject(response)
                
                val latestVersion = jsonObject.getString("latestVersion")
                val downloadLink = jsonObject.getString("downloadUrl")
                val releaseNotes = jsonObject.getString("releaseNotes")

                // Agar naya version hai, toh update popup dikhao
                if (latestVersion != currentVersion) {
                    (context as androidx.appcompat.app.AppCompatActivity).runOnUiThread {
                        showDarkNeonUpdateDialog(latestVersion, releaseNotes, downloadLink)
                    }
                } else {
                    (context as androidx.appcompat.app.AppCompatActivity).runOnUiThread {
                        Toast.makeText(context, "DARKKILLER is up to date! (V$currentVersion)", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Agar internet nahi hai ya URL galat hai toh silent raho
            }
        }
    }

    private fun showDarkNeonUpdateDialog(latestVersion: String, notes: String, downloadUrl: String) {
        val builder = AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Dialog_Alert)
        builder.setTitle("🔥 NEW UPDATE V$latestVersion")
        builder.setMessage("A new brutal update is available!\n\nWhat's new:\n$notes")
        
        builder.setPositiveButton("UPDATE NOW") { _, _ ->
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(downloadUrl))
            context.startActivity(browserIntent)
        }
        builder.setNegativeButton("IGNORE", null)
        
        val dialog = builder.create()
        dialog.show()
        
        // Dark-Neon Cyberpunk styling for buttons
        dialog.getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(Color.parseColor("#00FF66")) // Neon Green
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE)?.setTextColor(Color.parseColor("#FF3366")) // Neon Pink/Red
    }
}
