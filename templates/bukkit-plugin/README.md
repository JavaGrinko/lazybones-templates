New MineCraft plugin for Bukkit.

Project structure:

|   build.gradle
|   gradlew
|   gradlew.bat
|   README.md
|   settings.gradle
|---gradle
|   |---wrapper
|           gradle-wrapper.jar
|           gradle-wrapper.properties
|---src
    |---main
        |---java
        |   |---com
        |       |---test
        |               Config.java - config class
        |               Plugin.java - main plugin class
        |---resources
                config.yml - plugin parameters
                language.yml - strings
                plugin.yml - Bukkit config
                
How to build and start plugin:
 * type "./gradlew jar" in console
 * copy build/libs/*.jar to folder call "plugins" on the server.
 
 Finally, if all ok you should see this message in admin console:
 [20:16:56 INFO]: [TestPlugin] Enabling TestPlugin v1.0.0
 [20:16:56 INFO]: [TestPlugin] Hello World