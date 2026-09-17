package com.darkkiller.app

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Trigger Auto-Update JSON Check on Startup
        try {
            val updateHelper = UpdateHelper(this)
            updateHelper.checkForUpdates()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // 2. Binding UI buttons from activity_main.xml
        val btnApplyMod = findViewById<Button>(R.id.btnApplyMod)
        val btnRemoveMod = findViewById<Button>(R.id.btnRemoveMod)

        // Apply Mod Button Click Listener
        btnApplyMod.setOnClickListener {
            applyFullBrutalPak()
        }

        // Remove Mod Button Click Listener
        btnRemoveMod.setOnClickListener {
            removePakMods()
        }
    }

    private fun applyFullBrutalPak() {
        try {
            // Shizuku command execution stub for copying .pak file to BGMI/PUBG directory
            Toast.makeText(this, "Applying Full Brutal .pak via Shizuku...", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "Error: Shizuku not active or permission denied", Toast.LENGTH_LONG).show()
        }
    }

    private fun removePakMods() {
        Toast.makeText(this, "Cleaning up .pak modifications...", Toast.LENGTH_SHORT).show()
    }
}
