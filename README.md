Step 1: Create the JSON File
1.Create a res/raw directory:

   Right-click on the res folder -> New -> Android Resource Directory.
   Set the Resource Type to raw and name the directory raw.
   
2.Add JSON file:

   Create a JSON file (e.g., data.json) in the res/raw directory.
   Example content for data.json:
   data.json
   [
  {"id": 1, "name": "Alice", "age": 30},
  {"id": 2, "name": "Bob", "age": 25},
  {"id": 3, "name": "Charlie", "age": 35}
  ]

  #ADD DEPENDENCIES
  1. Go to Gradle Scripts -> build.gradles.kts -> dependencies
  2.  implementation(libs.gson) --> in jetpack Compose format
  3.   implementation 'com.google.code.gson:gson:2.8.6' -> in Xml format
