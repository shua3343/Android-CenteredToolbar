[![](https://jitpack.io/v/shua3343/Android-GenericRecyclerAdapter.svg)](https://jitpack.io/#shua3343/Android-GenericRecyclerAdapter)

# Android Centered Toolbar

This library will allow you to use the usual androidx recycler view, but you dont have to worry about creating your own recycler view adapter, as long as you doesn't need something complex.
___

## Technologies
 This lib uses **Glide 4.9.0** and **AndroidX**.
 **minimum sdk 14**.
 
## How to use

First of all, you need to configure you recycler item layout according to your needs.
For that you should set the ```xml android:tag``` like the example bellow:

```xml
(R.layout.recycler_item)
    <TextView
        android:id="@+id/text_view"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:tag="contentMethod:getText"/>
```

Where ```xml android:tag="contentMethod:getText" ```, have the sintax:

```android:tag="[identifier word]:[method to be called in your class that will populate your recycler items]" ```.

And in the code all you should do is create an instance of the ```GenericAdapter``` passing the following arguments:

``` 
GenericAdapter(
	[the id of the layout to be used as your recycler item layout], 
	[the list of objects that will provide the data for your adapter]
)
```

just like that:
```java
List<GenericData> genericDataList = new ArrayList<GenericData>();
list.add(new GenericData("Text 1"));
list.add(new GenericData("Text 2"));
list.add(new GenericData("Text 3"));

GenericAdapter genericAdapter = new GenericAdapter(R.layout.recycler_item, genericDataList);

RecycleView recyclerView = findViewById(R.id.my_generic_recycler);
recyclerView.setAdapter(genericAdapter);
```

And just to make sure that you didn't forget, for this example to work, our ```GenericData``` class, should be like this:
```java
class GenericData {
	private String text;
	
	public GenericData(String text){
		this.text = text;
	}
	
	/**Notice that this is the same method that we used after the [contentMethod]
	identifier in the TextView of our recycler_item layout, that is we need that method for our 
	GenericAdapter to work.*/
	public String getText(){
		return text;
	}
}
```

## Adding in your project

### Maven

```xml
    <dependency>
          <groupId>com.github.shua3343</groupId>
          <artifactId>Android-GenericRecyclerAdapter</artifactId>
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
          implementation 'com.github.shua3343:Android-GenericRecyclerAdapter:1.0.0'
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
