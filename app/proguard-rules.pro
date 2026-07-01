# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# signingConfig, minify, and enableResourceShrinking flags in buildTypes.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Minecraft & Game Related
-keep class net.minecraft.** { *; }
-keep class com.mojang.** { *; }
-keep class optifine.** { *; }

# Keep all classes in our package
-keep class com.xl.launcher.** { *; }
-keep interface com.xl.launcher.** { *; }

# Room
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-keepclassmembers class * extends androidx.room.RoomDatabase {
 public *;
}

# Hilt
-keep class dagger.hilt.** { *; }
-keep @dagger.hilt.** class * { *; }
