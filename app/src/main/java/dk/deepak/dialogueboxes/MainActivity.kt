package dk.deepak.dialogueboxes

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import dk.deepak.dialogueboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var dialog :Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dialog=Dialog(this)
        dialog.setContentView(R.layout.custom)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.back_dialoge))

        binding.button.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure ")
            builder1.setMessage("Do you want to close this app")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->

                finish()
            })
            builder1.setNegativeButton("NO",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder1.show()
        }

        binding.button2.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            val options = arrayOf("Study","Circket","Hockey")
            builder1.setTitle("Which is  your Favourate ")
            builder1.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            })
            builder1.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this,"Submit",Toast.LENGTH_SHORT).show()
            })
            builder1.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Decline",Toast.LENGTH_SHORT).show()
            })
            builder1.show()
        }
        binding.button3.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            val options = arrayOf("Study","Circket","Hockey")
            builder1.setTitle("Which is  your Favourate ")

            builder1.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                Toast.makeText(this,"You clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
            })
            builder1.setPositiveButton("Submit",DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this,"Submit",Toast.LENGTH_SHORT).show()
            })
            builder1.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Decline",Toast.LENGTH_SHORT).show()
            })
            builder1.show()
        }
        val Done = dialog.findViewById<Button>(R.id.btn)
        Done.setOnClickListener {
         dialog.dismiss()
        }
        binding.button4.setOnClickListener {
            dialog.show()
        }
    }
}