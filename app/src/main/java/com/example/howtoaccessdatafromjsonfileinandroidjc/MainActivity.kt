package com.example.howtoaccessdatafromjsonfileinandroidjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.howtoaccessdatafromjsonfileinandroidjc.ui.theme.HowToAccessDataFromJsonFileInAndroidJCTheme
class MainActivity : ComponentActivity() {
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Load JSON data
        personList = JsonUtil.loadJsonFromAsset(this) ?: emptyList()

        setContent {
            HowToAccessDataFromJsonFileInAndroidJCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(
                        modifier = Modifier.padding(innerPadding),
                        personList = personList
                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier, personList: List<Person>) {
    var searchQuery by remember { mutableStateOf("") }

    // Filter the personList based on searchQuery
    val filteredList = remember(personList, searchQuery) {
        search(personList, searchQuery)
    }

    // Display the filteredList
    Text(
        text = buildString {
            filteredList.forEach { person ->
                append("${person.name} (${person.age})\n")
            }
        },
        modifier = Modifier.padding(29.dp)
    )
}

private fun search(personList: List<Person>, query: String): List<Person> {
    return personList.filter {
        it.name.contains(query, ignoreCase = true)
    }
}
