# Android Permission Check Library

### Status
<br>
[![Build Status](https://travis-ci.org/drilonreqica/Android-Permission-Check-Library.svg?branch=develop)](https://travis-ci.org/drilonreqica/Android-Permission-Check-Library) [ ![Download](https://api.bintray.com/packages/drilonreqica/maven/android-permission-check-library/images/download.svg) ](https://bintray.com/drilonreqica/maven/android-permission-check-library/_latestVersion)
<br>
[![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9)
#### Adding the library as depndency

Add library dependency using gradle:
```golang
compile 'com.reqica.drilon:android-permission-check-library:2.0.0'
```
Add library dependency using maven:
```maven
<dependency>
  <groupId>com.reqica.drilon</groupId>
  <artifactId>android-permission-check-library</artifactId>
  <version>2.0.0</version>
  <type>pom</type>
</dependency>
```
Add library dependency using ivy:
```ivy
<dependency org='com.reqica.drilon' name='android-permission-check-library' rev='2.0.0'>
  <artifact name='android-permission-check-library' ext='pom' ></artifact>
</dependency>
```

#### Usage

Initialize Class CheckPermission:
```java
CheckPermission checkPermission = new CheckPermission(context);
```

If you want to check and ask for a Single permission, call:
```java
checkPermission.checkOne(@NonNull final String permission, @Nullable final String dialogMessage)
```
The 1st parameter is the actual permission, and the 2nd one is an optional Dialog Message that you can show to the user as an extra dialog, for better explanation/reason of the permission asked.

<br>

If you want to check and ask for Multiple permissions at once, call:
```java
checkPermission.checkMultiple(@NonNull final String[] permissions, @Nullable final String dialogMessage)
```
The 1st parameter is the actual permission, and the 2nd one is an optional Dialog Message that you can show to the user as an extra dialog, for better explanation/reason of the permissions asked.

<br>

If you want to go to the settings screen and see which permission are Granted and which ones are not, call:
```java
checkPermission.openPermissionsSettings(@NonNull String packageName) {
```
The parameter you need to give here is the actual root packageName of the app.

#### General Knowledge

To be able to check/ask for the permissions you first need to declare them in your projects AndroidManifest.xml

