[![](https://jitpack.io/v/shua3343/Android-CenteredToolbar.svg)](https://jitpack.io/#shua3343/Android-CenteredToolbar)

# Android Centered Toolbar

This library will allow you to use the usual androidx toolbar with title or logo centralized.
___

## How to use

You can use this toolbar like you are used to, or like the example below.
```xml
    <com.example.centeredtoolbar.CenteredToolbar
                android:layout_width="0dp"
                android:layout_height="?actionBarSize"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"/>
```
and you can also use the attribute <code>titleFontFamily</code> to set a font for your toolbar title, just like below.
```xml
    <com.example.centeredtoolbar.CenteredToolbar
                android:layout_width="0dp"
                android:layout_height="?actionBarSize"
                app:layout_constraintTop_toTopOf="parent"
                app:layout_constraintLeft_toLeftOf="parent"
                app:layout_constraintRight_toRightOf="parent"
                app:titleFontFamily="@font/poppins"/>
```

## Adding in your project

### Maven

```xml
    <dependency>
          <groupId>com.github.shua3343</groupId>
          <artifactId>Android-CenteredToolbar</artifactId>
          <version>1.0.0</version>
    </dependency>
``` 
#### To use with Maven
```xml
    <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

### Gradle

```groovy
    dependencies {
          implementation 'com.github.shua3343:Android-CenteredToolbar:1.0.0'
    }
```
#### To use with Gradle
```groovy
    allprojects {
        repositories {
          maven { url 'https://jitpack.io' }
        }
      }
```

# Current Version
##### 1.0.0
