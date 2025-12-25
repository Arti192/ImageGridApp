# ImageGridApp
An Android application that loads and displays images in a responsive, scrollable grid using Jetpack Compose, Clean MVVM architecture, and a custom image loader (no third-party image loading libraries).
Images are fetched dynamically from the Acharya Prashant public API and loaded efficiently with lazy loading, memory & disk caching, and automatic cancellation to ensure smooth scrolling.

✨ Key Features                                                                                                                                                             
•	Responsive grid layout (phones, tablets, large screens)                                                                                            
•	Square, center-cropped images                                                                                                                                         
•	Lazy loading with smooth scrolling (200+ images)                                                                                                                     
•	Custom image loader (no Glide / Coil / Picasso)                                                                                                                      
•	Memory + disk caching                                                                                                                                                  
•	Cancellation of off-screen image requests                                                                                                                                                                                                                                                                     
•	Retrofit used only for API calls                                                                                                                                            
•	Clean MVVM + Repository architecture                                                                                                                                       
•	Jetpack Compose UI                                                                                                                                                        

🛠 Tech Stack                                                                                                                                                                                                                                                                      
•	Language: Kotlin
•	UI: Jetpack Compose                                                                                  
•	Architecture: Clean Architecture + MVVM                                                                                                           
•	Networking: Retrofit (API only)                                                                                                             
•	Image Loading: Custom implementation                                                                                                               
•	Concurrency: Kotlin Coroutines                                                                                                                                
•	Caching: LruCache (memory) + file-based disk cache                                                                                                                 

🚀 How to Run the Project                                                                                                                                           
Open the project in Android Studio Otter 🦦 2 Feature Drop                                                                                                                 
Wait for Gradle Sync to complete                                                                                                                                     
Ensure an emulator or physical device has internet access                                                                                                           
Click ▶ Run                                                                                                                                                           
⚠️ If using an emulator, ensure the Android Emulator version is updated (as required by Otter 2 Feature Drop).                                                               


