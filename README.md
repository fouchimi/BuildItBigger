# BuildItBigger

This is an application developed using GCE (Google cloud Endpoints) to fetch jokes from the cloud and made them accessible on both phone and tablets devices through a custom java library.

<h2>Install</h2>
$git clone https://github.com/fouchimi/BuildItBigger.git

On Linux and Mac OS, you can open the project on Android Studio and run <b>./gradlew assembleDebug</b> and <b>adb -d install app/{path-to-your-apk}</b> which is often <b>app/build/outputs/apk/{apk_file}</b>. 

On Windows, you can run this command instead <b>gradle.bat assembleDebug</b> and <b>adb -d install app/{path-to-your-apk}</b>

Alternatively you can simply click on the run button of the IDE and those steps will be ran automatically and load the application on your mobile or virtual device.
