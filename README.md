# Android M Permission Check Library

[ ![Download](https://api.bintray.com/packages/drilonreqica/maven/anroid-m-permission-check-library/images/download.svg) ](https://bintray.com/drilonreqica/maven/anroid-m-permission-check-library/_latestVersion)

This tool was created by me for the sole purpose of over-simplifying the process of showing an alert to the user and then allowing the user to accept or not a single or multiple System Permissions in Android M (as specified by Google Guidelines).

## Project set-up

#### Android M Permission Check Library currently supports API LEVEL 14+

If you're using a Gradle-based project, then you can add "AMPC" library as a dependency directly:

```
compile 'com.reqica.drilon:androidmpermissioncheck:1.1.0'
```
To be able to use it you also have to add this snippet to your app module's build.gradle:
```
repositories {
    maven {
        url 'https://dl.bintray.com/drilonreqica/maven/'
    }
}
```
If you're using Maven (but not Gradle), you can add the APKlib as a dependency:
```
<dependency>
  <groupId>com.reqica.drilon</groupId>
  <artifactId>androidmpermissioncheck</artifactId>
  <version>1.1.0</version>
  <type>pom</type>
</dependency>
```

If you're using a standard project without either Maven or Gradle, you'll have to download the project, and the add the library manually to your project.

## Usage

To use the AMPC Library you have to follow a few simple steps, so bear with me.

First you need to add the permission you will need in your app like always in tha AndroidManifest.xml file.

Then you need to create an Instance of the CreatePermissionDialog class:
```
CreatePermissionDialog createPermissionDialog = new CreatePermissionDialog(currentActivity.this , currentActivity.this);
```
Replace currentActivity with the name of the main activity of your project.
Then you need to call the method which shows the dialog for the specific permission you need:
```
createPermissionDialog.checkMPermission(PERMISSIONS.WRITE_EXTERNAL_STORAGE , "You need to give External Storage permission!");
```
So the first parameter used is the actual permission and the second is the Title of the Dialog which will be shown to the user, see Pictures at bottom of page.
###### I have create a list of the permissions that need to be used through this library, and you can call them under PERMISSION.NAME_OF_PERMISSION.
###### Note "You can use this method for any permission you want, just change this part PERMISSION.NAME_OF_PERMISSION , and also type the title you want the user to see for that specific Permission."
###### You can also use this for multiple permissions, just call the method for each permission and give the actual permission and dialog title as a parameter and you're done.

If you have any issues, question or simply want to add better features, contact me or even better contribute to the project.
<github@drilon.reqica.com>

License
----

**Free Software, Hell Yeah!**

```
        MIT License
        
        Copyright (c) [2016] [Drilon Reçica]

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
```
