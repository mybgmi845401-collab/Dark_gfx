package com.darkkiller.app

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.view.Gravity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creating a dynamic Dark-Neon UI Layout for DARKKILLER V3.1
        val rootLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#0B0F19")) // Dark Cyberpunk Theme Background
            setPadding(40, 60, 40, 40)
            gravity = Gravity.CENTER_HORIZONTAL
        }

        // Header Branding
        val titleTextView = TextView(this).apply {
            text = "DARKKILLER"
            textSize = 28f
            setTextColor(Color.parseColor("#00FF66")) // Neon Green
            setTypeface(null, android.graphics.Typeface.BOLD)
            gravity = Gravity.CENTER
        }

        val subtitleTextView = TextView(this).apply {
            text = "GAMING NETWORK • GFX & TUNNEL CORE"
            textSize = 12f
            setTextColor(Color.parseColor("#00E5FF")) // Cyan Neon
            setPadding(0, 0, 0, 40)
            gravity = Gravity.CENTER
        }

        // GFX Preset Card Section Title
        val cardTitle = TextView(this).apply {
            text = "🔥 FULL BRUTAL FILE (.PAK) MODIFIER"
            textSize = 14f
            setTextColor(Color.parseColor("#FFFFFF"))
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(0, 20, 0, 20)
        }

        // Apply Mod Button (Shizuku & Game Integration Hook)
        val btnApplyMod = Button(this).apply {
            text = "APPLY MOD (BGMI / PUBG)"
            setBackgroundColor(Color.parseColor("#00FF66"))
            setTextColor(Color.parseColor("#000000"))
            setPadding(20, 20, 20, 20)
            setOnClickListener {
                // TODO: Insert Shizuku binder IPC / .pak file copy logic here to target directory
                Toast.makeText(this@MainActivity, "Applying Full Brutal .pak via Shizuku...", Toast.LENGTH_SHORT).show()
            }
        }

        // Remove Mod Button
        val btnRemoveMod = Button(this).apply {
            text = "REMOVE MOD"
            setBackgroundColor(Color.parseColor("#FF3366")) // Neon Red/Pink
            setTextColor(Color.parseColor("#FFFFFF"))
            setPadding(20, 20, 20, 20)
            setOnClickListener {
                Toast.makeText(this@MainActivity, "Removing .pak modifications...", Toast.LENGTH_SHORT).show()
            }
        }

        // Adding views to the layout hierarchy
        rootLayout.addView(titleTextView)
        rootLayout.addView(subtitleTextView)
        rootLayout.addView(cardTitle)
        rootLayout.addView(btnApplyMod)
        
        // Add some spacing between buttons
        val spacer = TextView(this).apply { height = 30 }
        rootLayout.addView(spacer)
        
        rootLayout.addView(btnRemoveMod)

        setContentView(rootLayout)
    }
}
