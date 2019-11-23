# EasyRate Android
[![](https://jitpack.io/v/grezzled/EasyRate.svg)](https://jitpack.io/#grezzled/EasyRate)

EasyRate is an Android library for dealing with app ratings & feedbacks.
In simple words, it shows a modern and well-designed to engage users to rate the app in Google Play. To avoid bad ratings, the CTA Button changes according to the user's review as Follow : 
- Write Feedback: if review between 1 & 3 Stars
- Rate: if a review is 4 or 5 Stars 

<img src="https://raw.githubusercontent.com/grezzled/EasyRate/master/Screenshot_2019-11-23-22-52-27-294_com.oxylabs.easyrate_example.png" width = "360"/> 

## Getting Started
Add to your root build.gradle at the end of repositories:
```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency

```java
implementation 'com.github.grezzled:EasyRate:1.0.1'
```

## Basic Usage
Show dialog
```java
EasyRate.init(MainActivity.this)
        .setMailingContact("YOUR_EMAIL@email.com","write a subject","write a description")
        .show();
```
Initiate to show dialog at an appropriate timig
```java
EasyRate.init(MainActivity.this)
        .setMailingContact("YOUR_EMAIL@email.com","write a subject","write a description")
        .build();
```


## Advanced Usage
In default, the dialog will be shown when the following conditions is satisfied.
- App is launched more than 3 times
- App is launched more than 3 days later than installation.
```java
        EasyRate.init(MainActivity.this)
                .setMailingContact("YOUR_EMAIL@email.com","write a subject","write a description")
                .setLaunchesDelay(10) // App Launched more than 10 times
                .setDaysDelay(7) // App is launched more than 7 days later than installation.
                .setOnCloseClickListener(new EasyRate.OnCloseClick() {
                    @Override
                    public void onCloseClickListener() {
                        // Set what to do when close button clicked!
                    }
                })
                .setOnFeedbackClickListener(new EasyRate.OnFeedbackClick() {
                    @Override
                    public void onFeedBackClickListener() {
                      /* By Overriding this Listener, Feedback by email will be ignored 
                        * and "setMailingContact()" won't be necessary anymore.
                        * You can call a feedback activity, open a link, your Instagram account or whatever you want
                       */
                    }
                })
                .build();
```
Reset Count of launches and days to 0
```java
EasyRate.resetDelay(context); 
```
Prevent the dialog from showing again
```java
EasyRate.dontShowAgain(true,context);
```
## Contributing
If you want to contribute this project, please send pull request. In present, I need contributors who can translate resources from English into other languages.
For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update the tests as appropriate.

## License
```
Copyright 2019 Grezzled

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

Author
Grezzled - lotub.llc@gmail.com
