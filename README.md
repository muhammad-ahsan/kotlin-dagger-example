# How to incorporate Dagger 2 into Kotlin based backend with Gradle
In this example there is an interface **Scrapper** which has 2 implementations - **FileScrapper** and **WebScrapper**. This sample project will demonstrate how dagger 2 can be configured to use one of the configured implementation.
 
Dagger 2 generates Java code which is used by Kotlin without any problem. In order to generate that code using gradle as build tool, the project MUST support both Kotlin and Java as defined in **build.gradle** file 

### Step 1:
In **build.gradle** file, apply the **kapt** and Java plugin

```groovy
plugins {
    id 'java'
    id 'org.jetbrains.kotlin.kapt' version '1.3.70'
}
```` 
### Step 2:
In **build.gradle** file, add dependencies such as  
- Dagger 2 **api**
- **kapt** plugin for gradle
- Annotation Processor

```groovy
dependencies {
    api 'com.google.dagger:dagger:2.26'
    kapt 'com.google.dagger:dagger-compiler:2.26'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.26'
}
````

### Step 3:
Create **Scrapper** interface along with implementations.The implementation must include empty contrutor with **@Inject** annotation 
```kotlin
interface Scrapper {
    fun scrape(): Boolean
}
```
File based implementation as
```kotlin
import javax.inject.Inject

class FileScrapper @Inject constructor() : Scrapper {

    override fun scrape(): Boolean {
        println("This is file based scrapper")
        return false
    }
}
```
Web based implementation as
```kotlin
import javax.inject.Inject

class WebScrapper @Inject constructor() : Scrapper {

    override fun scrape(): Boolean {
        println("This is Web based scrapper")
        return true
    }
}
```

### Step 4:
Create a module which informs dagger to use the appropriate implementation. 
```kotlin
import dagger.Module
import dagger.Provides

@Module
class ScrapperModule {
    @Provides
    fun provideScrapper(): Scrapper? {
        val impl = FileScrapper()
        println("Dagger is configured to provide " + impl.javaClass )
        return impl
    }
}
```

### Step 5:
Create a component which is used by dagger to generate implementation automatically.
Annotation data provides info about module where dagger must find appropriate implementation for **Scrapper** interface.


```Kotlin
import dagger.Component
import org.jetbrains.annotations.Nullable
import javax.inject.Singleton

@Component(modules = [ScrapperModule::class])
@Singleton
interface ScrapperComponent {
    @Nullable
    fun provideScrapper(): Scrapper
} 
```
### Step 6:
Now dagger is ready to generate code. Use the gradle to build the source code which will create implementation of **ScrapperComponent** with **DaggerScrapperComponent** which is used to inject the implementation. Now use the main function/other place to get instance of Scrapper without direct instantiation

```Kotlin
fun main() {
    val scrapperComponent = DaggerScrapperComponent.create()
    val scrapper = scrapperComponent.provideScrapper()
    println("Dagger has initiate scrapper in main function with " + scrapper.javaClass)
}
```


   