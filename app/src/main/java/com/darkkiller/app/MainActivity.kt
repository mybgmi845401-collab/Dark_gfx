package com.darkkiller.app

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Binding UI buttons from activity_main.xml
        val btnApplyMod = findViewById<Button>(R.id.btnApplyMod)
        val btnRemoveMod = findViewById<Button>(R.id.btnRemoveMod)

        // Apply Mod Button Click Listener
        btnApplyMod.setOnClickListener {
            // Check Shizuku permission and apply .pak file to BGMI/PUBG directory
            applyFullBrutalPak()
        }

        // Remove Mod Button Click Listener
        btnRemoveMod.setOnClickListener {
            removePakMods()
        }
    }

    private fun applyFullBrutalPak() {
        try {
            // Shizuku command execution stub for copying .pak file to game directory
            // Target path typically: /storage/emulated/0/Android/data/com.tencent.ig/files/UE4Game/ShadowTrackerExtra/ShadowTrackerExtra/Saved/Paks/
            Toast.makeText(this, "Applying Full Brutal .pak via Shizuku...", Toast.LENGTH_SHORT).show()
            
            // Example Shizuku shell execution command format:
            // Shizuku.newProcess(arrayOf("sh", "-c", "cp /path/to/mod.pak /sdcard/Android/data/com.tencent.ig/..."), null, null)
            
        } catch (e: Exception) {
            Toast.makeText(this, "Error: Shizuku not active or permission denied", Toast.LENGTH_LONG).show()
        }
    }

    private fun removePakMods() {
        Toast.makeText(this, "Cleaning up .pak modifications...", Toast.LENGTH_SHORT).show()
        // Add Shizuku deletion commands here if needed
    }
}
