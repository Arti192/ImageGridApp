
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

________________________________________

🛠 Tech Stack                                                                                                                                                                          
•	Language: Kotlin                                                                                                                                             
•	UI: Jetpack Compose                                                                                                                                                
•	Architecture: Clean Architecture + MVVM                                                                                                                                           
•	Networking: Retrofit (API only)                                                                                                            
•	Image Loading: Custom implementation                                                                                                                                                
•	Concurrency: Kotlin Coroutines                                                                                                                                           
•	Caching: LruCache (memory) + file-based disk cache      

🚀 How to Run the Project                                                                                                                                               
1.	Open the project in Android Studio Otter 🦦 2 Feature Drop                                                                                                                      
2.	Wait for Gradle Sync to complete                                                                                                                              
3.	Ensure an emulator or physical device has internet access                                                                                      
4.	Click ▶ Run                                                                                                                                    
⚠️ If using an emulator, ensure the Android Emulator is updated and the virtual device uses Android 35 (API 35) as the maximum supported version, compatible with Android Studio Otter 🦦 2 Feature Drop.

⚙️ Android Configuration                                            
Minimum SDK: 24                                                
Target SDK: 35                                                                                         

<img width="250" height="600" alt="Screenshot_20251225_221459" src="https://github.com/user-attachments/assets/030b457a-f583-4f25-8f6e-7a2c4b762e1d" />
